package connection;

import controller.Receiver;
import ui.LoginWindow;

import java.io.*;
import java.net.*;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 2, 2011
 * Time: 2:54:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Connection extends Thread {

    private static PrintWriter output;
    private static BufferedReader input;
    private static Connection connection;

    public void run() {

        while(true) {
            try {
                Receiver.process(input.readLine());
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }

    public static void send(String message){

        if (output==null) {
            System.out.println("Not connected");
            LoginWindow.setText("Not connected");
            connect("localhost", 18560);
            return;
        }

        output.println(message);
        System.out.println("Sending message: "+message);
        output.flush();
    }

    public static void connect(String address, int port) {

// Create a socket with a timeout
        try {
            InetAddress addr = InetAddress.getByName(address);
            SocketAddress sockaddr = new InetSocketAddress(addr, port);

            // Create an unbound socket
            Socket sock = new Socket();

            // This method will block no more than timeoutMs.
            // If the timeout occurs, SocketTimeoutException is thrown.
            int timeoutMs = 2000;   // 2 seconds
            sock.connect(sockaddr, timeoutMs);

            output = new PrintWriter(new OutputStreamWriter(sock.getOutputStream(),"UTF-8"));

            input = new BufferedReader(new InputStreamReader(sock.getInputStream(),"UTF-8"));

            connection = new Connection();
            connection.start();

        } catch (UnknownHostException e) {
            System.out.println("Error1");
        } catch (SocketTimeoutException e) {
            System.out.println("Error2");
        } catch (IOException e) {
            System.out.println("Error3");
        }
    }
}
