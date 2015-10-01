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
 * Time: 3:43:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainMenu extends JFrame {

    public MainMenu(String name) {
        super(name);

        JPanel listPane = new JPanel();
        listPane.setLayout(new GridLayout(0,1));
        this.add(listPane, BorderLayout.CENTER);

        JPanel imagePane = new JPanel();
        imagePane.setLayout(new GridLayout(0,1));
        this.add(imagePane, BorderLayout.WEST);

        //2. Optional: What happens when the frame closes?
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        ImageIcon image = new ImageIcon("./menu.jpeg");
        JLabel imageLabel = new JLabel(image);
        imagePane.add(imageLabel);

        JButton practice = new JButton("Practice");
        practice.setFont(new Font("Serif", Font.BOLD, 20));
        practice.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            Controller.practice1();
	    }});
        listPane.add(practice);

        JButton translate = new JButton("Translate");
        translate.setFont(new Font("Serif", Font.BOLD, 20));
        translate.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            Controller.translate();
	    }});
        listPane.add(translate);

        JButton statistics = new JButton("Statistics");
        statistics.setFont(new Font("Serif", Font.BOLD, 20));
        practice.setFont(new Font("Serif", Font.BOLD, 20));
        statistics.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            Controller.statistics();
	    }});
        listPane.add(statistics);

        JButton logout = new JButton("Logout");
        logout.setFont(new Font("Serif", Font.BOLD, 20));
        logout.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            Controller.logout();
	    }});
        listPane.add(logout);

        //4. Size the frame.
        this.setSize(640,480);
        //this.pack();

        //5. Show it.
        this.setVisible(true);
    }
}

