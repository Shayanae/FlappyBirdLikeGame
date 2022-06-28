package com.jeu;

public class Timer  implements Runnable{
    private final int pause = 5;

    @Override
    public void run() {
        while (true){ // Boucle infinie
            Main.scene.xFond--;
            Main.scene.repaint();
            try{Thread.sleep(pause);}
            catch (InterruptedException e){}
        }
    }
}
