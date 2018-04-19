package com.jsoftworks.pitchtracker;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TeamTabPanel extends JPanel {
	
	private JLabel nameLabel;
	
	public TeamTabPanel(int width, int height) {
		// super(width, height);
		setPreferredSize(new Dimension(width, height));
		nameLabel = new JLabel();
	}
	
	public TeamTabPanel(String teamName, int width, int height) {
		this(width, height);
		nameLabel.setText(teamName);
	}
	
	

}
