package com.jsoftworks.pitchtracker;

import java.awt.Dimension;

import javax.swing.JPanel;

public class PreferredSizePanel extends JPanel {

    public PreferredSizePanel(int width, int height) {
        if (width < 0) {
            width = getPreferredSize().width;
        }

        if (height < 0) {
            height = getPreferredSize().height;
        }

        System.out.println(getPreferredSize());
        System.out.println(width + ", " + height);
        setPreferredSize(new Dimension(width, height));
    }

}
