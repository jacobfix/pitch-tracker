package com.jsoftworks.pitchtracker;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class StrikeZonePanel extends JPanel {

    private static final Color WHITE = new Color(0xffffff);

    public StrikeZonePanel() {
        setBackground(WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
