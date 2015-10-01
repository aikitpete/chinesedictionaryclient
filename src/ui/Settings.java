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
 * Time: 4:11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class Settings extends JFrame {

    public Settings(String name) {
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

        JLabel title1 = new JLabel("Select difficulty:");
        listPane.add(title1);

        //Group the radio buttons.
        final ButtonGroup group1 = new ButtonGroup();

        JRadioButton easy = new JRadioButton("Easy");
        easy.setSelected(true);
        easy.setActionCommand("1");
        group1.add(easy);
        listPane.add(easy);

        JRadioButton medium = new JRadioButton("Medium");
        medium.setActionCommand("2");
        group1.add(medium);
        listPane.add(medium);

        JRadioButton hard = new JRadioButton("Hard");
        hard.setActionCommand("3");
        group1.add(hard);
        listPane.add(hard);

        JLabel title2 = new JLabel("Select direction:");
        listPane.add(title2);

        //Group the radio buttons.
        final ButtonGroup group2 = new ButtonGroup();

        JRadioButton chineseEnglish = new JRadioButton("Chinese -> English");
        chineseEnglish.setActionCommand("1");
        chineseEnglish.setSelected(true);
        group2.add(chineseEnglish);
        listPane.add(chineseEnglish);

        JRadioButton englishChinese = new JRadioButton("English -> Chinese");
        englishChinese.setActionCommand("2");
        group2.add(englishChinese);
        listPane.add(englishChinese);

        JButton proceed = new JButton("Proceed");
        proceed.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            Controller.practice2(group1.getSelection().getActionCommand(),group2.getSelection().getActionCommand());
	    }});
        listPane.add(proceed);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            Controller.login();
	    }});
        listPane.add(cancel);

        //4. Size the frame.
        this.setSize(640,480);
        //this.pack();

        //5. Show it.
        this.setVisible(true);
    }
}
