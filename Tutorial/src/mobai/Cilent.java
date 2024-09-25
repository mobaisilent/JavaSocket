package mobai;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cilent {
  public static void main(String[] args) {
    try (Socket sock = new Socket("localhost", 8080)) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("客户端已启动，已连接到服务端");
      InputStream in = sock.getInputStream();
      OutputStream out = sock.getOutputStream();
      // 创建socket的输入输出获取流
      while (true) {
        System.out.print("请输入你想要输入的信息：");
        String msg = scanner.nextLine();
        if(msg.equals("exit")) {
          break;
        }
        out.write(msg.getBytes());
        // 将输入的信息转换为字节流
        int len;
        byte[] buffer = new byte[1024];
        len = in.read(buffer);  // 获取服务端返回的信息，存入到buffer数组中，下面则是打印出来
        System.out.println(new String(buffer, 0, len));
        // 客户端将服务端返回的信息转换为字符串输出
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}