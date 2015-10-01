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
 * Time: 4:19:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Translate extends JFrame {

    public Translate(String name) {
        super(name);

        JPanel listPane = new JPanel();
        listPane.setLayout(new GridLayout(0, 1));
        this.add(listPane, BorderLayout.CENTER);

        //2. Optional: What happens when the frame closes?
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.

        JLabel originalLabel = new JLabel("Original text:");
        listPane.add(originalLabel);

        final JTextField translationText = new JTextField("");
        translationText.setHorizontalAlignment(SwingConstants.CENTER);
        translationText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.translate();
            }
        });
        listPane.add(translationText);

        JLabel translatedLabel = new JLabel("Translated text:");
        listPane.add(translatedLabel);

        final JLabel translated = new JLabel("xxx");
        translated.setHorizontalAlignment(SwingConstants.CENTER);
        translated.setFont(new Font("Serif", Font.BOLD, 20));
        translated.setForeground(Color.blue);
        translated.setVisible(false);
        listPane.add(translated);

        JLabel directionLabel = new JLabel("Translation direction:");
        listPane.add(directionLabel);

        ButtonGroup group1 = new ButtonGroup();

        JRadioButton englishChinese = new JRadioButton("English -> Chinese");
        englishChinese.setHorizontalAlignment(SwingConstants.CENTER);
        //easy.setFont(new Font("Serif", Font.BOLD, 20));
        englishChinese.setForeground(Color.blue);
        englishChinese.setSelected(true);
        group1.add(englishChinese);
        listPane.add(englishChinese);

        JRadioButton chineseEnglish = new JRadioButton("Chinese -> English");
        chineseEnglish.setHorizontalAlignment(SwingConstants.CENTER);
        //chineseEnglish.setFont(new Font("Serif", Font.BOLD, 20));
        chineseEnglish.setForeground(Color.blue);
        group1.add(chineseEnglish);
        listPane.add(chineseEnglish);

        JButton translate = new JButton("Translate");
        translate.setHorizontalAlignment(SwingConstants.CENTER);
        translate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                translated.setText(Controller.translateWord(translationText.getText()));
                translated.setVisible(true);
            }
        });
        listPane.add(translate);

        JButton exit = new JButton("Close");
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.login();
            }
        });
        listPane.add(exit);

        //4. Size the frame.
        this.setSize(640, 480);
        //this.pack();

        //5. Show it.
        this.setVisible(true);

    }
}
