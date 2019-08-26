import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client_Socket {
    public static void main(String[] args) {

        try
        {
            Socket s = new Socket("localhost",9999);

            PrintStream pr = new PrintStream(s.getOutputStream());

            System.out.print("Enter Something : ");

            InputStreamReader read = new InputStreamReader(System.in);
            BufferedReader bd = new BufferedReader(read);

            String str = bd.readLine();

            pr.println(str);

            BufferedReader buff = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String str1 = buff.readLine();
            System.out.print(str1);

        }
        catch(Exception ex)
        {

        }
    }
}
