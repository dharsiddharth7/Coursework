import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Write a description of class Server here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Server
{
    ServerSocket serverSocket;
    Socket socket;

    public static void main(String[] args) throws IOException, InfoNotFoundException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(1573);
            System.out.println ("Server waiting for connection");

        }
        catch (IOException e) {
            System.err.println("Could not listen on port.");
            System.exit(1);
        }

        Socket socket = null;

        try {
            socket = serverSocket.accept();
        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        System.out.println ("Connection is successful");
        System.out.println ("Waiting for input.....");

        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String fileName = in.readLine();
        String userName = in.readLine();

        String folderPath = "/Users/siddharthdhar/Desktop/cs180/lab11/Server/";

        System.out.println("Filename: " + fileName);
        System.out.println("Username: " + userName);


        if (fileName.equals("Exit"))
            System.exit(1);


        File blah = new File(folderPath + fileName);
        System.out.println(blah.getAbsoluteFile());


        try {
            BufferedReader reader = new BufferedReader(new FileReader(blah));
            String line;
            String line1[] = null;
            int count = 0; //for the line number
            int count1 = 0;

            while ((line = reader.readLine()) != null) {
                if (count > 0) {
                    line1 = line.split(";");
                    if (userName.equals(line1[1])) {
                        count1++;
                        if(line1[2] != null || line1[3] != null || line1[4] != null) {
                            String lastName = (line1[2]);
                            String firstName = (line1[3]);
                            String marks = (line1[4]);
                        }
                        else
                            break;
                    }
                }
                count++;
            }
            if(count1 == 0)
            {
                pw.println("InfoNotFoundException");
            }

            String lastName = (line1[2]);
            String firstName = (line1[3]);
            String marks = (line1[4]);

            System.out.println("Last Name: " + lastName);
            System.out.println("First Name: " + firstName);
            System.out.println("Marks: " + marks);

        } catch (IOException e) {
            e.printStackTrace();
            pw.println("FileNotFoundException");
        }

        finally {
            if (serverSocket != null)
                serverSocket.close();
            if (socket != null)
                socket.close();
            if (pw != null)
                pw.close();
            if (in != null)
                in.close();
        }

        pw.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

}
