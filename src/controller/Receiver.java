package controller;

import connection.Connection;
import ui.*;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 3, 2011
 * Time: 12:50:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class Receiver {

    public static void process(String message) {

        System.out.println("Received message: "+message);

        String[] messageData = message.split(" ");
        if (messageData[0].equals("create")) {
            create(messageData);
        } else if (messageData[0].equals("login")) {
            login(messageData);
        } else if (messageData[0].equals("start")) {
            start(messageData);
        } else if (messageData[0].equals("word")) {
            word(message.split(":"));
        } else if (messageData[0].equals("statistics")) {
            statistics(messageData);
        }
    }

    private static void statistics(String[] messageData) {
        JFrame statistics = new Statistics("Mandarin Vocabulary Trainer Statistics", messageData[1],messageData[2],messageData[3]);
        UI.setWindow(statistics);
    }

    private static void word(String[] messageData) {
        Trainer.update(messageData);
        /**
        if (message[1].equals("null")) {
            Trainer.
        } else if (message[1].equals("error")) {
            LoginWindow.setText("Login error");
            System.out.println("Login error");
        }
         **/
    }

    private static void start(String[] message) {
        if (message[1].equals("success")) {
            JFrame trainer = new Trainer("Mandarin Vocabulary Trainer");
            UI.setWindow(trainer);
        }
    }

    public static void login(String[] message) {
        if (message[1].equals("success")) {
            JFrame mainMenu = new MainMenu("Mandarin Vocabulary Login");
            UI.setWindow(mainMenu);
        } else if (message[1].equals("error")) {
            LoginWindow.setText("Login error");
            System.out.println("Login error");
        }
    }

    public static void create(String[] message) {
        if (message[1].equals("success")) {
            LoginWindow.setText("User "+message[2]+" created");
        } else if (message[1].equals("error")) {
            LoginWindow.setText("Create user error");
            System.out.println("Create user error");
        }
    }
}
