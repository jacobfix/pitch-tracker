package com.jsoftworks.pitchtracker;

import java.util.List;

public class Inning {
	
	private int number;
	private String awayTeam;
	private String homeTeam;
	private List<AtBat> top;
	private List<AtBat> bottom;

	public Inning(int number, String awayTeam, String homeTeam, 
			List<AtBat> top, List<AtBat> bottom) {
		this.number = number;
		this.awayTeam = awayTeam;
		this.homeTeam = homeTeam;
		this.top = top;
		this.bottom = bottom;
	}
}
