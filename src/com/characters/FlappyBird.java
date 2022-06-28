package com.characters;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FlappyBird {

    // VARIABLES
    private int weight;
    private int height;
    private int x;
    private int y;
    private int dy;
    private String strImage;
    private ImageIcon icoBird;
    private Image imgBird;

    // CONSTRUCTEUR

    public FlappyBird(int x, int y, String strImage){
        this.weight = 34;
        this.height = 24;
        this.x = x;
        this.y = y;
        this.icoBird = new ImageIcon(Objects.requireNonNull(getClass().getResource(strImage)));
        this.imgBird = this.icoBird.getImage();
    }

    // GETTERS

    public int getWeight() {return weight;}

    public int getHeight() {return height;}

    public int getX() {return x;}

    public int getY() {return y;}

    public Image getImgBird() {return imgBird;}

    // SETTERS


    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    // METHODES

    public void up(){
        this.dy = 50;
        this.y =this.y - this.dy;
    }
}
