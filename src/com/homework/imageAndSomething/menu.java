package com.homework.imageAndSomething;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class menu {
    private Scanner in = new Scanner(System.in);
    private Comparator compareName = new CompareImagesByName();
    private Comparator compareSize = new CompareImagesBySize();
    private Comparator compareRed = new CompareImagesByRed();
    private Comparator compareGreen = new CompareImagesByGreen();
    private Comparator compareBlue = new CompareImagesByBlue();
    private  ArrayList<Image> collection = new ArrayList<>();

    public void openMenu() {
        Boolean consoleOutput = true;
        String userCommand;

        while (consoleOutput == true) {
            System.out.println("Enter number to choose command:\n" +
                    "1) Add image to collection\n" +
                    "2) Print all collection in current order\n" +
                    "3) Remove image by name\n" +
                    "4) Sort collection\n" +
                    "5) Calculate similarity coefficients\n" +
                    "6) Exit the program");
            userCommand = in.nextLine();
            switch (userCommand) {
                case "1":
                    addImage();
                case "2":
                    printImages();
                    break;
                case "3":
                    removeImage();
                    break;
                case "4":
                    sortImages();
                    break;
                case "5":
                    calculateDistance();
                    break;
                case "6":
                    System.out.println("Good bye.");
                    consoleOutput = false;
                    break;
                default:
                    System.out.println("WRONG command!11! Please, try again.");
                    break;
            }
        }
    }

    private void addImage() {
        System.out.println("Enter path to image");
        String path = in.nextLine();
        File file;
        BufferedImage image;
        try {
            file = new File(path);
            image = ImageIO.read(file);
            collection.add(new Image(image, file.length(), file.getName()));
        } catch (IOException e) {
            System.out.println("Error while file reading");
        }
    }

    private void printImages() {
        System.out.println(collection.size() + " images detected");
        for (Image p : collection) {
            System.out.println(p.getName() + " size: " + p.getPictureSize()
                    + " aR: " + p.getAverageRed()
                    + " aG: " + p.getAverageGreen()
                    + " aB: " + p.getAverageBlue());
        }
    }

    private void removeImage() {
        System.out.print("Enter name to remove\n");
        String name = in.nextLine();
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getName().equals(name)) {
                collection.remove(i);
                i--;
            }
        }
    }

    private void sortImages() {
        System.out.println("Chose type of sort by entering number:\n" +
                "1) Sort collection by names of pictures\n" +
                "2) Sort collection by sizes of pictures\n" +
                "3) Sort collection by average red value\n" +
                "4) Sort collection by average green value\n" +
                "5) Sort collection by average blue value");
        String sortType = in.nextLine();
        switch (sortType){
            case "1":
                collection.sort(compareName);
                break;
            case "2":
                collection.sort(compareSize);
                break;
            case "3":
                collection.sort(compareRed);
                break;
            case "4":
                collection.sort(compareGreen);
                break;
            case "5":
                collection.sort(compareBlue);
                break;
            default:
                System.out.println("WRONG command!11! Please, try again.");
                break;
        }
    }

    private void calculateDistance() {
        System.out.println("Enter name to calculate");
        String nameToCalculate = in.nextLine();
        int index = -1;
        for (int i = 0; i < collection.size(); i++){
            if (collection.get(i).getName().equals(nameToCalculate)){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("Name was not found");
            return;
        }
        for (int i = 0; i < collection.size(); i++){
            if (i != index) {
                System.out.println(collection.get(i).getName() + " " + (float)1/(1 + Math.abs(i - index)) );
            }
            else {
                System.out.println(collection.get(i).getName() + " 1");
            }
        }
    }

}
