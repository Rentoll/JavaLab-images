package com.homework.imageAndSomething;

import java.util.Comparator;

class CompareImagesByName implements Comparator<Image> {
    @Override
    public int compare(Image p1, Image p2){
        return p1.getName().compareTo(p2.getName());
    }
}

class CompareImagesBySize implements Comparator<Image> {
    @Override
    public int compare(Image p1, Image p2) {
        if (p1.getPictureSize() < p2.getPictureSize()) {
            return -1;
        }
        if (p1.getPictureSize() > p2.getPictureSize()) {
            return 1;
        }
        return 0;
    }
}

class CompareImagesByRed implements Comparator<Image> {
    @Override
    public int compare(Image p1, Image p2) {
        if (p1.getAverageRed() < p2.getAverageRed()) {
            return -1;
        }
        if (p1.getAverageRed() > p2.getAverageRed()) {
            return 1;
        }
        return 0;
    }
}

class CompareImagesByGreen implements Comparator<Image> {
    @Override
    public int compare(Image p1, Image p2) {
        if (p1.getAverageGreen() < p2.getAverageGreen()) {
            return -1;
        }
        if (p1.getAverageGreen() > p2.getAverageGreen()) {
            return 1;
        }
        return 0;
    }
}

class CompareImagesByBlue implements Comparator<Image> {
    @Override
    public int compare(Image p1, Image p2) {
        if (p1.getAverageBlue() < p2.getAverageBlue()) {
            return -1;
        }
        if (p1.getAverageBlue() > p2.getAverageBlue()) {
            return 1;
        }
        return 0;
    }
}
