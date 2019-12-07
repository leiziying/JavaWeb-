package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpClientSocket = new DatagramSocket();
        String message = "hello";
        byte[] sendBuffer = message.getBytes("UTF-8");
        // 127.0.0.1
        byte[] serverIP = new byte[4];
        serverIP[0] = (byte)127;
        serverIP[1] = (byte)0;
        serverIP[2] = (byte)0;
        serverIP[3] = (byte)1;
        InetAddress serverAddress = InetAddress.getByAddress(serverIP);
        DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                serverAddress,
                9898
        );
        udpClientSocket.send(sendPacket);
        //接受对方回应的
        udpClientSocket.close();
    }
}