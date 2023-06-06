/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuJogo.modelo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author User
 */
public class Sounds {
    public void playSound(){
        URL url = getClass().getResource("res\\barulhoTiro.wav");
        AudioClip audio = Applet.newAudioClip(url);
        audio.play();
    }
}
