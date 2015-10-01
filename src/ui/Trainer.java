package ui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 2, 2011
 * Time: 3:43:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Trainer extends JFrame {


    private static JLabel title1 = new JLabel();
    private static JLabel title2 = new JLabel();

    private static JRadioButton easy = new JRadioButton();
    private static JRadioButton medium = new JRadioButton();
    private static JRadioButton hard = new JRadioButton();
    private static JLabel word11 = new JLabel();
    private static JLabel word12 = new JLabel();
    private static JLabel result = new JLabel();

    private static int direction;

    private static JPanel chinesePane;

    public Trainer(String name) {
        super(name);

        JPanel listPane = new JPanel();
        listPane.setLayout(new GridLayout(0, 1));
        this.add(listPane, BorderLayout.CENTER);

        //2. Optional: What happens when the frame closes?
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        JLabel resultTitle = new JLabel("Previous result:");
        resultTitle.setHorizontalAlignment(SwingConstants.CENTER);
        resultTitle.setFont(new Font("Serif", Font.BOLD, 15));
        resultTitle.setForeground(Color.black);
        listPane.add(resultTitle);

        result = new JLabel("");
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setFont(new Font("Serif", Font.BOLD, 20));
        result.setForeground(Color.black);
        listPane.add(result);

        //JLabel title1 = new JLabel();
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setFont(new Font("Serif", Font.BOLD, 20));
        title1.setForeground(Color.black);
        listPane.add(title1);

        //JPanel chinesePane = new JPanel();
        //chinesePane.setLayout(new GridLayout(0, 2));
        listPane.add(chinesePane);

        //JLabel word11 = new JLabel("");
        word11.setHorizontalAlignment(SwingConstants.CENTER);
        word11.setFont(new Font("Serif", Font.BOLD, 30));
        word11.setForeground(Color.blue);
        //chinesePane.add(word11);

        //JLabel word12 = new JLabel("");
        word12.setHorizontalAlignment(SwingConstants.CENTER);
        word12.setFont(new Font("Serif", Font.BOLD, 30));
        word12.setForeground(Color.blue);
        //chinesePane.add(word12);

        //JLabel title2 = new JLabel();
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setFont(new Font("Serif", Font.BOLD, 20));
        title2.setForeground(Color.black);
        listPane.add(title2);

        //JRadioButton easy = new JRadioButton("");
        easy.setHorizontalAlignment(SwingConstants.CENTER);
        easy.setFont(new Font("Serif", Font.BOLD, 30));
        easy.setForeground(Color.blue);
        easy.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            if (direction==1) {
                Controller.respond(":"+easy.getText()+":"+word11.getText()+":"+word12.getText());
            } else {
                Controller.respond(":"+word11.getText()+" "+easy.getText());
            }
	    }});
        listPane.add(easy);

        //JRadioButton medium = new JRadioButton("");
        medium.setHorizontalAlignment(SwingConstants.CENTER);
        medium.setFont(new Font("Serif", Font.BOLD, 30));
        medium.setForeground(Color.blue);
        medium.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            if (direction==1) {
                Controller.respond(":"+medium.getText()+":"+word11.getText()+":"+word12.getText());
            } else {
                Controller.respond(":"+word11.getText()+":"+medium.getText());
            }
	    }});
        listPane.add(medium);

        //JRadioButton hard = new JRadioButton("");
        hard.setHorizontalAlignment(SwingConstants.CENTER);
        hard.setFont(new Font("Serif", Font.BOLD, 30));
        hard.setForeground(Color.blue);
        hard.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            if (direction==1) {
                Controller.respond(":"+hard.getText()+":"+word11.getText()+":"+word12.getText());
            } else {
                Controller.respond(":"+word11.getText()+":"+hard.getText());
            }
	    }});
        listPane.add(hard);

        JButton exit = new JButton("Exit");
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

    public static void setDirection(String str) {
        chinesePane=new JPanel();
        chinesePane.add(word11);
        direction = Integer.valueOf(str);
        if (direction == 1) {
            chinesePane.setLayout(new GridLayout(0, 2));
            title1.setText("Chinese:");
            title2.setText("English:");
            chinesePane.add(word12);
        } else if (direction == 2) {
            chinesePane.setLayout(new GridLayout(0, 1));
            title1.setText("English:");
            title2.setText("Chinese:");

        }
    }

    public static void update(String[] messageData) {
        ArrayList<String[]> data = new ArrayList<String[]>();

        String s = messageData[0].split(" ")[1];
        if (!s.equals("null"))result.setText(messageData[0].split(" ")[1]);

        for (int i = 0; i<3; i++) {
            data.add(new String[]{messageData[i*3+1],messageData[(i*3)+2],messageData[(i*3)+3]});
        }

        if (data.size() == 3) {
            easy.setVisible(false);
            medium.setVisible(false);
            hard.setVisible(false);

            easy.setSelected(false);
            medium.setSelected(false);
            hard.setSelected(false);

            word11.setVisible(false);
            word12.setVisible(false);

            Random rand = new Random();
            int rnd = rand.nextInt(3);

            if (direction == 1) {

                if (rnd==0) {
                    word11.setText(data.get(0)[1]);
                    word12.setText(data.get(0)[2]);
                } else if (rnd==1) {
                    word11.setText(data.get(1)[1]);
                    word12.setText(data.get(1)[2]);
                } else if (rnd==2) {
                    word11.setText(data.get(2)[1]);
                    word12.setText(data.get(2)[2]);
                }

                easy.setText(data.get(0)[0]);
                medium.setText(data.get(1)[0]);
                hard.setText(data.get(2)[0]);



            } else {

                if (rnd==0) {
                    word11.setText(data.get(0)[0]);
                    word12.setText("");
                } else if (rnd==1) {
                    word11.setText(data.get(1)[0]);
                    word12.setText("");
                } else if (rnd==2) {
                    word11.setText(data.get(2)[0]);
                    word12.setText("");
                }

                easy.setText(data.get(0)[1]+":"+data.get(0)[2]);
                medium.setText(data.get(1)[1]+":"+data.get(1)[2]);
                hard.setText(data.get(2)[1]+":"+data.get(2)[2]);

            }

            data = new ArrayList<String[]>();

            word11.setVisible(true);
            word12.setVisible(true);

            easy.setVisible(true);
            medium.setVisible(true);
            hard.setVisible(true);
        }
    }
}
