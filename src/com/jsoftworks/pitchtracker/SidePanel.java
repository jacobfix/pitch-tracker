package com.jsoftworks.pitchtracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SidePanel extends JPanel {

    // private TeamContainerPanel awayTeamContainer;
    // private TeamContainerPanel homeTeamContainer;
    private JTabbedPane tabbedPane;
    private TeamTabPanel awayTabPanel;
    private TeamTabPanel homeTabPanel;

    // Inning selection

    // At bat selection

    private static final Color BG_GRAY = new Color(0xdddddd);

    public SidePanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());
        setBackground(BG_GRAY);

        awayTabPanel = new TeamTabPanel("Baltimore Orioles", width / 2, height);
        homeTabPanel = new TeamTabPanel("Los Angeles Angels", width / 2, height);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab(null, new JPanel());
        tabbedPane.addTab(null, new JPanel());

        JLabel label = new JLabel("Oakland Athletics");
        JLabel label2 = new JLabel("Baltimore Orioles");
        // label.setPreferredSize(new Dimension(width / 2, height));
        // tabbedPane.setTabComponentAt(0, label);
        // tabbedPane.setTabComponentAt(1, label2);

        // int teamContainerWidth = width / 2;
        // int teamContainerHeight = height / 3;
        // awayTeamContainer = new TeamContainerPanel(teamContainerWidth,
        // teamContainerHeight);
        // homeTeamContainer = new TeamContainerPanel(teamContainerWidth,
        // teamContainerHeight);
        //
        // /* Container for the team containers. */
        // JPanel upperContainer = new JPanel(new BorderLayout());
        // int upperContainerWidth = width;
        // int upperContainerHeight = (int) (0.35 * height);
        // upperContainer.setPreferredSize(new Dimension(upperContainerWidth,
        // upperContainerHeight));
        // upperContainer.add(awayTeamContainer, BorderLayout.WEST);
        // upperContainer.add(homeTeamContainer, BorderLayout.EAST);
        // add(upperContainer, BorderLayout.NORTH);
        //
        // // add(awayTeamContainer, BorderLayout.WEST);
        // // add(homeTeamContainer, BorderLayout.EAST);
        //
        // awayTeamContainer.update("Los Angeles", "Angels");
        // homeTeamContainer.update("Seattle", "Mariners");

        // JPanel tabComponent = new JPanel(new BorderLayout());
        // tabComponent.setPreferredSize(new Dimension(width / 2, height));
        // tabComponent.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        // // tabComponent.setBorder(new EmptyBorder(5, 5, 5, 5));
        // JLabel label = new JLabel("Baltimore Orioles");
        // try {
        // BufferedImage image = ImageIO.read(new File("res/rockies.png"));
        // // label.setIcon(new ImageIcon(image));
        // // label.setHorizontalTextPosition(JLabel.CENTER);
        // // label.setVerticalTextPosition(JLabel.BOTTOM);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // try {
        // Font font = Font.createFont(Font.TRUETYPE_FONT, new
        // File("res/fonts/DejaVuSans.ttf"));
        // font = font.deriveFont(14.0f);
        // label.setFont(font);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // tabComponent.add(label, BorderLayout.CENTER);

        // tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        // tabbedPane.addTab(null, new JPanel());
        // tabbedPane.setTabComponentAt(0, tabComponent);

        // tabbedPane.addTab(null, new JPanel());
        // tabbedPane.setTabComponentAt(1, tabComponent);

        add(tabbedPane);
    }

    private JPanel buildTabPanel() {
        JPanel tabPanel = new JPanel();

        return tabPanel;
    }

    // Pass in something here
    public void update() {

    }
}
