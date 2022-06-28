package com.jeu;

import com.objects.Pipe;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Scene extends JPanel {

    // VARIABLES
    private ImageIcon icoBackBottom;
    private Image imgBackBottom;

    public Pipe highPipe1;
    public Pipe lowPipe1;
    public Pipe highPipe2;
    public Pipe lowPipe2;
    public Pipe highPipe3;
    public Pipe lowPipe3;

    private final int weightBackBottom = 140;

    private final int distancePipe = 250;
    private final int pipeGap = 120;

    public int xFond;
    private int dxPipe;
    private int xPipe;

    private Random random;


    // CONSTRUCTEUR
    public Scene(){
        super();
        this.icoBackBottom = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/bandeFondEcran.png")));
        this.imgBackBottom = this.icoBackBottom.getImage();

        this.xFond = 0;
        this.xPipe = 100;
        this.dxPipe = 0;

        this.highPipe1 = new Pipe(this.xPipe, -150, "/images/tuyauHaut.png");
        this.lowPipe1 = new Pipe(this.xPipe, 250, "/images/tuyauBas.png");
        this.highPipe2 = new Pipe(this.xPipe + this.distancePipe, -100, "/images/tuyauHaut.png");
        this.lowPipe2 = new Pipe(this.xPipe + this.distancePipe, 300, "/images/tuyauBas.png");
        this.highPipe3 = new Pipe(this.xPipe + this.distancePipe * 2, -120, "/images/tuyauHaut.png");
        this.lowPipe3 = new Pipe(this.xPipe + this.distancePipe * 2, 280, "/images/tuyauBas.png");

        random = new Random();

        Thread timerScreen = new Thread(new Timer());
        timerScreen.start();
    }

    // METHODES
    private void bottomDisplacement(Graphics g){
        if (this.xFond == -this.weightBackBottom){this.xFond = 0;}
        g.drawImage(this.imgBackBottom, this.xFond, 0, null);
        g.drawImage(this.imgBackBottom, this.xFond + this.weightBackBottom, 0, null);
        g.drawImage(this.imgBackBottom, this.xFond + this.weightBackBottom * 2, 0, null);
        g.drawImage(this.imgBackBottom, this.xFond + this.weightBackBottom * 3, 0, null);
    }

    private void pipeDisplacement(Graphics g){
       // Tuyau 1
        this.highPipe1.setX(this.highPipe1.getX() -1);
        this.lowPipe1.setX(this.highPipe1.getX());

        if (this.highPipe1.getX() == -100){
            this.highPipe1.setX(this.highPipe3.getX() + this.distancePipe);
            this.highPipe1.setY(-100 -10 * this.random.nextInt(18));
            this.lowPipe1.setY(this.highPipe1.getY() + this.highPipe1.getHeight() + this.pipeGap);
        }
        g.drawImage(this.highPipe1.getImgPipe(), this.highPipe1.getX(), this.highPipe1.getY(), null);
        g.drawImage(this.lowPipe1.getImgPipe(), this.lowPipe1.getX(), this.lowPipe1.getY(), null);

        // Tuyau 2
        this.highPipe2.setX(this.highPipe2.getX() -1);
        this.lowPipe2.setX(this.highPipe2.getX());

        if (this.highPipe2.getX() == -100){
            this.highPipe2.setX(this.highPipe1.getX() + this.distancePipe);
            this.highPipe2.setY(-100 - 10 * this.random.nextInt(18));
            this.lowPipe2.setY(this.highPipe2.getY() + this.highPipe2.getHeight() + this.pipeGap);
        }
        g.drawImage(this.highPipe2.getImgPipe(), this.highPipe2.getX(), this.highPipe2.getY(), null);
        g.drawImage(this.lowPipe2.getImgPipe(), this.lowPipe2.getX(), this.lowPipe2.getY(), null);

        // Tuyau 3
        this.highPipe3.setX(this.highPipe3.getX() - 1);
        this.lowPipe3.setX(this.highPipe3.getX());

        if (this.highPipe3.getX() == -100){
            this.highPipe3.setX(this.highPipe2.getX() + this.distancePipe);
            this.highPipe3.setY(-100 - 10 * this.random.nextInt(18));
            this.lowPipe3.setY(this.highPipe3.getY() + this.highPipe3.getHeight() + this.pipeGap);
        }
        g.drawImage(this.highPipe3.getImgPipe(), this.highPipe3.getX(), this.highPipe3.getY(), null);
        g.drawImage(this.lowPipe3.getImgPipe(), this.lowPipe3.getX(), this.lowPipe3.getY(), null);
    }

    public void paintComponent(Graphics g){
        this.bottomDisplacement(g);
        this.pipeDisplacement(g);
    }
}
