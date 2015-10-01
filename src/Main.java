import connection.Connection;
import controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 1, 2011
 * Time: 7:31:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static final String address = "localhost";
    public static final int port = 18560;

    public static void main(String[] args) {
        Connection.connect(address, port);
        Controller.start();
    }

}
