package mobai;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    System.out.println("服务端已启动，等待客户端连接");
    try (ServerSocket server = new ServerSocket(8080)) {
      while (true) {
        Socket socket = server.accept();
        System.out.println("接收到来自客户端的连接：" + socket.getInetAddress() + ":" + socket.getPort());
        new Handler(socket).start();
        // 创建一个线程对象，将socket传入并启动线程
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class Handler extends Thread {
  private Socket socket;

  public Handler(Socket socket) {
    this.socket = socket;
  }

  // 创建Thread对象，重写run方法
  @Override
  public void run() {
    try {
      solve(socket);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void solve(Socket socket) throws IOException {
    InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();
    int len;
    byte[] bytes = new byte[1024];
    while ((len = in.read(bytes)) > 0) {
      System.out.println("接收到客户端数据：" + new String(bytes, 0, len));
      out.write(("服务端已收到长度为" + len + "字节的数据").getBytes());
    }
  }
}