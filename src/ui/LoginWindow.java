package ui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 2, 2011
 * Time: 2:53:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginWindow extends JFrame {

    public static JLabel emptyLabel2;

    public LoginWindow(String name) {
        super(name);

        JPanel listPane = new JPanel();
        listPane.setLayout(new GridLayout(0,2));
        this.add(listPane, BorderLayout.SOUTH);

        JPanel imagePane = new JPanel();
        imagePane.setLayout(new GridLayout(0,1));
        this.add(imagePane, BorderLayout.CENTER);

        //2. Optional: What happens when the frame closes?
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        ImageIcon image = new ImageIcon("./image.jpeg");
        JLabel imageLabel = new JLabel(image);
        imagePane.add(imageLabel);

        JLabel titleLabel = new JLabel("Please login:");
        listPane.add(titleLabel);

        JLabel emptyLabel1 = new JLabel("");
        listPane.add(emptyLabel1);

        JLabel usernameLabel = new JLabel("Username:");
        listPane.add(usernameLabel);

        final JTextField username = new JTextField();
        listPane.add(username);

        JLabel passwordLabel = new JLabel("Password:");
        listPane.add(passwordLabel);

        final JPasswordField password = new JPasswordField();
        listPane.add(password);

        emptyLabel2 = new JLabel("");
        emptyLabel2.setForeground(Color.RED);
        listPane.add(emptyLabel2);

        JButton create = new JButton("Create");
        create.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent
        e) {
            Controller.create(username.getText(), new String(password.getPassword()));
            username.setText("");
            password.setText("");
	    }});
        listPane.add(create);

        JLabel emptyLabel3 = new JLabel("");
        listPane.add(emptyLabel3);
        
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent
        e) {
            Controller.login(username.getText(), new String(password.getPassword()));
            username.setText("");
            password.setText("");
	    }});
        listPane.add(login);

        //String chinesesample = "\u4e00";
        //System.out.println(chinesesample);

        JLabel emptyLabel4 = new JLabel("©2011 Peter, John, Anna");
        listPane.add(emptyLabel4);

        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent
        e) {
            Controller.exit();
	    }});
        listPane.add(close);

        //4. Size the frame.
        //this.setSize(640,480);
        this.pack();

        //5. Show it.

        this.setVisible(true);
    }

    public static void setText(String s) {
        emptyLabel2.setText(s);
    }
}
