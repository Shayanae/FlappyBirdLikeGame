package com.jeu;

public class Timer  implements Runnable{
    private final int pause = 7;

    @Override
    public void run() {
        while (!Main.scene.endOfGame){ // Boucle infinie
            Main.scene.xFond--;
            Main.scene.repaint();
            try{Thread.sleep(pause);}
            catch (InterruptedException e){}
        }
    }
}
