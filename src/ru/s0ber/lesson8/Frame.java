package ru.s0ber.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private Map map;

    public Frame(Map map) {
        this.map = map;
        setSize(500,545);
        setLocation(600,200);
        setTitle("Tic tac toe");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel jpBottom = new JPanel(new GridLayout());

        jpBottom.setBackground(Color.lightGray);
        add(map, BorderLayout.CENTER);
        add(jpBottom, BorderLayout.SOUTH);

        JButton jbStart = new JButton("Start new game");
        jpBottom.add(jbStart);

        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.init();
            }
        });

        JButton jbExit = new JButton("Exit");
        jpBottom.add(jbExit);
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void gameEndWindow() {
        //
    }
}
