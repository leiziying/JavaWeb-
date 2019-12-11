package udp.echo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpClientSocket = new DatagramSocket();
        Scanner scanner=new Scanner(System.in);
          while (true) {
              String message = scanner.nextLine();
              byte[] sendBuffer = message.getBytes("UTF-8");
              //192.168.0.101
              byte[] serverIp = new byte[4];
              serverIp[0] = (byte) 127;
              serverIp[1] = (byte) 0;
              serverIp[2] = (byte) 0;
              serverIp[3] = (byte) 1;
              InetAddress serverAddress = InetAddress.getByAddress(serverIp);//拿到服务启动器的ip地址
              DatagramPacket sendPacket = new DatagramPacket(
                      sendBuffer,
                      sendBuffer.length,
                      serverAddress,
                      9898);
              udpClientSocket.send(sendPacket);
              byte[] receiveBuffer = new byte[1024];
              DatagramPacket receivePacket = new DatagramPacket(
                      receiveBuffer,
                      receiveBuffer.length
              );
              udpClientSocket.receive(receivePacket);
              String responseMessage = new String(
                      receivePacket.getData(),
                      0,
                      receivePacket.getLength(),
                      "UTF-8"
              );
              System.out.println(responseMessage);
          }


    }
}
