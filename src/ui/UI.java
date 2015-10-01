package ui;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 3, 2011
 * Time: 12:54:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class UI {

    private static JFrame currentWindow;

    public static void setWindow(JFrame newWindow) {
        if (currentWindow!=null) {
            currentWindow.dispose();
        }
        currentWindow = newWindow;
    }

}
