package com.jsoftworks.pitchtracker;

import java.util.List;

public class AtBat {
	
	private String pitcherId;
	private String batterId;
	private int[] count;
	private String description;
	private String event;
	private List<Pitch> pitches;
	
	public AtBat(String pitcherId, String batterId, int[] count, String description, String event, 
			List<Pitch> pitches) {
		this.pitcherId = pitcherId;
		this.batterId = batterId;
		this.count = count;
		this.description = description;
		this.event = event;
		this.pitches = pitches;
	}

}
