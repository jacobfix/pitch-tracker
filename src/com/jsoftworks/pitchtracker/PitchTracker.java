package com.jsoftworks.pitchtracker;

import java.util.List;

import javax.swing.JFrame;

public class PitchTracker {
	
	private List<Inning> innings;
	
	public PitchTracker(List<Inning> innings) {
		this.innings = innings;
		buildGUI();
	}
	
	private void buildGUI() {
		JFrame frame = new JFrame("Pitch Tracker");
		frame.setContentPane(new MainPanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Error: Must provide an appropriately structured XML file");
			return;
		}
		
		List<Inning> allInnings;
		try {
			allInnings = GamedayXMLParser.parseAllInningsFile(args[1]);
		} catch (Exception e) {
			System.err.println("Error: There was a problem parsing the provided file");
			return;
		}
		
		PitchTracker pt = new PitchTracker(allInnings);
	}
}
