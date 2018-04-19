package com.jsoftworks.pitchtracker;

public class Pitch {

    private String description;
    private String type;
    private double startSpeed;
    private double endSpeed;
    private double pfxX;
    private double pfxZ;
    private double pX;
    private double pZ;
    private double strikeZoneTop;
    private double strikeZoneBottom;
    private String pitchType;

    public Pitch(String description, String type, double startSpeed, double endSpeed, double pfxX, double pfxZ,
            double pX, double pZ, double strikeZoneTop, double strikeZoneBottom, String pitchType) {
        this.description = description;
        this.type = type;
        this.startSpeed = startSpeed;
        this.endSpeed = endSpeed;
        this.pfxX = pfxX;
        this.pfxZ = pfxZ;
        this.pX = pX;
        this.pZ = pZ;
        this.strikeZoneTop = strikeZoneTop;
        this.strikeZoneBottom = strikeZoneBottom;
        this.pitchType = pitchType;
    }
}
