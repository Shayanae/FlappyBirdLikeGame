package com.characters;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FlappyBird implements Runnable{

    // VARIABLES
    private int weight;
    private int height;
    private int x;
    private int y;
    private int dy;
    private String strImage;
    private ImageIcon icoBird;
    private Image imgBird;

    private final int pause = 10;

    // CONSTRUCTEUR

    public FlappyBird(int x, int y, String strImage){
        this.weight = 34;
        this.height = 24;
        this.x = x;
        this.y = y;
        this.icoBird = new ImageIcon(Objects.requireNonNull(getClass().getResource(strImage)));
        this.imgBird = this.icoBird.getImage();

        Thread wingsTimer = new Thread(this);
        wingsTimer.start();
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

    public void up(){this.dy = 50;}

    private void flying(int dy){
        if (dy > 10){
            this.icoBird = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/oiseau2.png")));
            this.imgBird = this.icoBird.getImage();
            this.y = this.y - 3;
        } else if (dy > 5) {this.y = this.y - 2;}
        else if (dy > 1) {this.y = this.y - 1;}
        else if(dy == 1) {
            this.icoBird = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/oiseau1.png")));
            this.imgBird = this.icoBird.getImage();
        }
    }

    @Override
    public void run() {
        while (true){
            this.flying(dy);
            this.dy--;
            try{Thread.sleep(pause);}
            catch (InterruptedException e){}
        }
    }
}
