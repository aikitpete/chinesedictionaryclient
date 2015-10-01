package controller;

import com.google.api.translate.Language;
import connection.Connection;
import ui.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 2, 2011
 * Time: 2:53:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class Controller {

    public static void start() {
        JFrame loginWindow = new LoginWindow("Mandarin Vocabulary Trainer Login");
        UI.setWindow(loginWindow);
    }

    public static void login(String username, String password) {
        Connection.send("login "+username+" "+password);

    }

    public static void login() {
        JFrame mainMenu = new MainMenu("Mandarin Vocabulary Trainer Menu");
        UI.setWindow(mainMenu);
    }

    public static void logout() {
        JFrame loginWindow = new LoginWindow("Mandarin Vocabulary Trainer Login");
        UI.setWindow(loginWindow);
    }

    public static void practice1() {
        JFrame settings = new Settings("Mandarin Vocabulary Trainer Settings");
        UI.setWindow(settings);
    }

    public static void translate() {
        JFrame translate = new Translate("Mandarin Vocabulary Trainer Translate");
        UI.setWindow(translate);
    }

    public static void statistics() {
        Connection.send("statistics");
    }

    public static void practice2(String difficulty, String direction) {
        Connection.send("start "+difficulty+" "+direction);
        Trainer.setDirection(direction);
        //JFrame trainer = new Trainer("Mandarin Vocabulary Trainer Practice");
        //UI.setWindow(trainer);
    }

    public static void exit() {
        UI.setWindow(null);
        System.exit(0);
    }

    public static String translateWord(String original) {
        com.google.api.translate.Translate.setHttpReferrer("www.seznam.cz");
        String translatedText = null;
        try {
            translatedText = com.google.api.translate.Translate.execute(original, Language.ENGLISH, Language.CHINESE_TRADITIONAL);
        } catch (Exception e) {

        }
        return translatedText;
    }

    public static void create(String username, String password) {
        Connection.send("create "+username+" "+password);
    }

    public static void respond(String s) {
        Connection.send("word "+s);
    }
}
