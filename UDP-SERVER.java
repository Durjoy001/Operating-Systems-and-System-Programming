package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
        DatagramSocket serverSocket = new DatagramSocket(9876);
        Scanner sc = new Scanner(System.in);
        while(true)
        {
             byte[] receivebuffer = new byte[1024];
          byte[] sendbuffer  = new byte[1024];
          DatagramPacket recvdpkt = new DatagramPacket(receivebuffer, receivebuffer.length);
                    serverSocket.receive(recvdpkt);
          InetAddress IP = recvdpkt.getAddress();
          int portno = recvdpkt.getPort();
           String clientdata = new String(recvdpkt.getData());
          System.out.println("\nClient : "+ clientdata);
          System.out.print("\nServer : ");
          String serverdata = sc.nextLine();
          sendbuffer = serverdata.getBytes();
          DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP,portno);
          serverSocket.send(sendPacket);
          
        }
        //serverSocket.close();
    }
    
}
