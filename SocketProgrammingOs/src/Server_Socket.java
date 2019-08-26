import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Socket {
    public static void main(String[] args) {

        try
        {
            ServerSocket sersocket = new ServerSocket(9999);
            Socket sock = sersocket.accept();

            BufferedReader buf = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String tmp = buf.readLine();
            System.out.print("Recieved :"+tmp);

        }
        catch(Exception ex){

        }
    }
}
