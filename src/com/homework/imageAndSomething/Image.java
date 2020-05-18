package com.homework.imageAndSomething;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Image {
    BufferedImage image;
    String name;
    double pictureSize;
    double averageRed;
    double averageGreen;
    double averageBlue;

    public Image(BufferedImage img, double pictureSize, String name){
        image = img;
        this.name = name;
        this.pictureSize = pictureSize;

        averageRed = 0;
        averageGreen = 0;
        averageBlue = 0;
        for (int i = 0; i < img.getHeight(); i++){
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = new Color(img.getRGB(j, i));
                averageRed += color.getRed();
                averageGreen += color.getGreen();
                averageBlue += color.getBlue();
            }
        }
        averageRed /= img.getHeight()*img.getWidth();
        averageGreen /= img.getHeight()*img.getWidth();
        averageBlue /= img.getHeight()*img.getWidth();
    }

    public double getAverageRed(){
        return  averageRed;
    }

    public double getAverageGreen() {
        return averageGreen;
    }

    public double getAverageBlue() {
        return averageBlue;
    }

    public double getPictureSize() {
        return pictureSize;
    }

    public String getName(){
        return name;
    }
}
