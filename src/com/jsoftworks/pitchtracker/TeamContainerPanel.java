package com.jsoftworks.pitchtracker;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 * Component of SidePanel that displays the team's logo, the team's name, and a list of pitchers.
 */
@SuppressWarnings("serial")
public class TeamContainerPanel extends JPanel {
	
	private ImagePanel teamLogo;
	
	private JLabel teamLocaleLabel;
	private JLabel teamNameLabel;
	
	private DefaultListModel<String> pitcherListModel;
	private JList<?> pitcherList;
	
	private Font defaultFont;
	
	private static final String FONT_FILENAME = "res/fonts/DejaVuSans-Bold.ttf";
	private static final float FONT_SIZE = 16.0f;
	
	private static final Color TEAM_NAME_COLOR = new Color(0x000000);
	
	public TeamContainerPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		teamLogo = new ImagePanel();
		teamLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
		teamLogo.setAlignmentY(Component.CENTER_ALIGNMENT);
		teamLogo.setImage("res/orioles.png");
		
		teamLocaleLabel = new JLabel();
		teamLocaleLabel.setForeground(TEAM_NAME_COLOR);
		teamLocaleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		teamNameLabel = new JLabel();
		teamNameLabel.setForeground(TEAM_NAME_COLOR);
		teamNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel teamNamePanel = new JPanel();
		teamNamePanel.setLayout(new BoxLayout(teamNamePanel, BoxLayout.PAGE_AXIS));
		teamNamePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		teamNamePanel.add(teamLocaleLabel);
		teamNamePanel.add(teamNameLabel);
		
		pitcherListModel = new DefaultListModel<>();
		pitcherList = new JList<>(pitcherListModel);
		pitcherList.setLayoutOrientation(JList.VERTICAL);
		pitcherList.setSelectionMode(ListSelectionModel
				.SINGLE_INTERVAL_SELECTION);
		pitcherList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pitcherList.setFixedCellWidth(width);
		pitcherList.setForeground(TEAM_NAME_COLOR);
		
		JPanel pitcherListPanel = new JPanel();
		pitcherListPanel.setLayout(new BoxLayout(pitcherListPanel, BoxLayout.PAGE_AXIS));
		pitcherListPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel pitchersLabel = new JLabel("Pitchers:");
		pitchersLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		pitcherListPanel.add(pitchersLabel);
		pitcherListPanel.add(pitcherList);
		
		try {
			Font teamLabelFont = Font.createFont(Font.TRUETYPE_FONT, new File(FONT_FILENAME));
			teamLabelFont = teamLabelFont.deriveFont(16.0f);
			
			Font pitcherNameFont = Font.createFont(Font.TRUETYPE_FONT,  new File(FONT_FILENAME));
			pitcherNameFont = pitcherNameFont.deriveFont(12.0f);
			
			teamLocaleLabel.setFont(teamLabelFont);
			teamNameLabel.setFont(teamLabelFont);
			pitcherList.setFont(pitcherNameFont);
		} catch (Exception e) {
			/* Just use the default font. */
			defaultFont = null;
			e.printStackTrace();
		}
		
		if (defaultFont != null) {
			teamLocaleLabel.setFont(defaultFont);
			teamNameLabel.setFont(defaultFont);
			pitcherList.setFont(defaultFont);
		}
		
		/* Components are stacked vertically. */
		// add(teamLogo);
		add(Box.createVerticalGlue());
		add(teamNamePanel);
		add(pitcherListPanel);
		add(Box.createVerticalGlue());
	}
	
	public void update(String teamLocale, String teamName) {
		teamLocaleLabel.setText(teamLocale);
		teamNameLabel.setText(teamName);
		pitcherListModel.addElement("Aroldis Chapman");
		pitcherListModel.addElement("Garrett Richards");
	}
}
