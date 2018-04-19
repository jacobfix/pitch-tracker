package com.jsoftworks.pitchtracker;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private BufferedImage image;
    private double scaleFactor = 1.0;

    public ImagePanel() {
        super();
    }

    public ImagePanel(String filename) {
        this();
        setImage(filename);
    }

    public void setImage(String filename) {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int componentWidth = (int) (scaleFactor * image.getWidth());
        int componentHeight = (int) (scaleFactor * image.getHeight());
        System.out.println("Image: " + image.getWidth() + ", " + image.getHeight());
        System.out.println("Component: " + componentWidth + ", " + componentHeight);
        setPreferredSize(new Dimension(componentWidth, componentHeight));
        // setMinimumSize(new Dimension(componentWidth, componentHeight));
        // setMaximumSize(new Dimension(componentWidth, componentHeight));
    }

    public void scaleToFitWidth(int desiredWidth) {
        if (image == null)
            return;
        scaleFactor = desiredWidth / image.getWidth();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.scale(scaleFactor, scaleFactor);
        g2d.drawImage(image, 0, 0, null);

        g2d.dispose();
    }
}