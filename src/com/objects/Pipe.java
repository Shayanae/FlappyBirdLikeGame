package com.objects;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Pipe {

    // VARIABLES
    private int weight;
    private int height;
    private int x;
    private int y;
    private String strImage;
    private ImageIcon icoPipe;
    private Image imgPipe;

    // CONSTRUCTEUR

    public Pipe(int x, int y, String strImage){
        this.weight = 50;
        this.height = 300;
        this.x = x;
        this.y = y;
        this.strImage = strImage;

        this.icoPipe = new ImageIcon(Objects.requireNonNull(getClass().getResource(this.strImage)));
        this.imgPipe = this.icoPipe.getImage();

    }

    // GETTERS


    public int getWeight() {return weight;}

    public int getHeight() {return height;}

    public int getX() {return x;}

    public int getY() {return y;}

    public Image getImgPipe() {return imgPipe;}

    // SETTERS


    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}
}
