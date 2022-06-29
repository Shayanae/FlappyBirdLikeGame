package com.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !Main.scene.endOfGame){
            Main.scene.flappyBird.up();
            Audio.playSound("/audio/battementAile.wav");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
