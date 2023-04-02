package ru.skillbox;

public class Dimensions {

    private final int height;
    private final int width;
    private final int length;

    public int getVolume() {
        int volume  = height * width * length;
        return volume;
    }

    public Dimensions(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Dimensions setHeight(int height){
        return new Dimensions(height, width, length);
    }
    public Dimensions setWidth(int width){
        return new Dimensions(height, width, length);
    }
    public Dimensions setLength(int length){
        return new Dimensions(height, width, length);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }


}
