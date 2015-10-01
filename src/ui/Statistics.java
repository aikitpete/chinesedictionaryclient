package ui;

import com.google.api.translate.Language;
import com.googlecode.charts4j.*;
import com.googlecode.charts4j.Color;
import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: swyna
 * Date: Jun 2, 2011
 * Time: 3:43:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class Statistics extends JFrame {

    public Statistics(String name, String username, String successes, String total) {
        super(name);

        JPanel listPane = new JPanel();
        listPane.setLayout(new GridLayout(0, 1));
        this.add(listPane, BorderLayout.CENTER);

        //2. Optional: What happens when the frame closes?
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.

        JLabel originalLabel = new JLabel("Statistics for user "+username+":");
        this.add(originalLabel, BorderLayout.NORTH);

        final Slice s1 = Slice.newSlice(Integer.valueOf(successes), Color.GREEN, "Successes");
        final Slice s2 = Slice.newSlice(Integer.valueOf(total)-Integer.valueOf(successes), Color.RED, "Fails");
        PieChart chart = GCharts.newPieChart(s1, s2);
        chart.setSize(480,320);
        JLabel label = null;
        try {
            label = new JLabel(new ImageIcon(ImageIO.read(new URL(chart.toURLString()))));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        listPane.add(label);

        JButton exit = new JButton("Close");
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.login();
            }
        });
        this.add(exit, BorderLayout.SOUTH);

        //4. Size the frame.
        this.setSize(640, 480);
        //this.pack();

        //5. Show it.
        this.setVisible(true);
    }
}
