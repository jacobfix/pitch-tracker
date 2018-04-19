package com.jsoftworks.pitchtracker;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

    private SidePanel sidePanel;
    private StrikeZonePanel strikeZonePanel;

    public static final int WIDTH = 720;
    public static final int HEIGHT = 480;

    public MainPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());

        int sidePanelWidth = (int) (0.4 * WIDTH);
        int sidePanelHeight = HEIGHT;
        sidePanel = new SidePanel(sidePanelWidth, sidePanelHeight);
        // sidePanel.setPreferredSize(new Dimension(sidePanelWidth,
        // sidePanelHeight));
        add(sidePanel, BorderLayout.WEST);

        strikeZonePanel = new StrikeZonePanel();
        add(strikeZonePanel, BorderLayout.CENTER);
    }

}
