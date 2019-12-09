package udp;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpClientSocket =new DatagramSocket();
        Scanner scanner=new Scanner(System.in);
        while(true){
            String message=scanner.nextLine();
            byte[] sendBuffer=message.getBytes("UTF-8");
            byte[] serverIp=new byte[4];
            serverIp[0]=(byte) 192;
            serverIp[1]=(byte) 168;
            serverIp[2]=(byte) 0;
            serverIp[3]=(byte) 124;
            InetAddress serverAddress=InetAddress.getByAddress(serverIp);
            DatagramPacket sendPacket=new DatagramPacket(
              sendBuffer,
              sendBuffer.length,
              serverAddress,
              9898
            );
            udpClientSocket.send(sendPacket);
            //接收对方回应的消息
            byte[] reciveBuffer=new byte[1024];
            DatagramPacket recivePacket=new DatagramPacket(
                    reciveBuffer,
                    reciveBuffer.length
            );
            udpClientSocket.receive(recivePacket);
            String responseMessge=new String(
                    recivePacket.getData(),
                    0,
                    recivePacket.getLength(),
                    "UTF-8"
            );
            System.out.println(responseMessge);
        }
    }
}
