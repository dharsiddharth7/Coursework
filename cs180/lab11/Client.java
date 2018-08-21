import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Client
{
    public static void main(String[] args) throws IOException, InfoNotFoundException {
        Scanner userInput = new Scanner(System.in);
        String serverHostname = "localhost";

        if (args.length > 0)
            serverHostname = args[0];
        System.out.println ("Attemping to connect to host " + serverHostname + " on port 3000.");

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
//            socket = new Socket(serverHostname, 1573);
            socket = new ServerSocket(4500).accept();
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
            System.exit(1);
        }


        String fileName;
        String userName;

        System.out.println("Enter Filename: ");
        fileName = userInput.nextLine();
        out.println(fileName);

        System.out.println("Enter Username: ");
        userName = userInput.nextLine();
        out.println(userName);

        int count = 0;
        String lastName = null;
        String firstName = null;
        String marks = null;
        while(true) {

            String message = in.readLine();
            if(message == null){
                break;
            }
            if (message.equals("FileNotFoundException")) {
                System.err.println("File does not exist.");
            }
            if (message.equals("InfoNotFoundException")) {
                throw new InfoNotFoundException("Your information is not in our files");
            }
            if(count == 0)
            {
                lastName = message;
            }
            if(count == 1) {
                firstName = message;
            }
            if(count == 2) {
                marks = message;
            }
            count++;
        }

        PrintWriter p = new PrintWriter(new FileWriter("final.txt", true));
        p.println(lastName + "\n" + firstName + "\n" + marks);

        userInput.close();

        p.close();
        out.close();
        in.close();
        socket.close();
    }
}
