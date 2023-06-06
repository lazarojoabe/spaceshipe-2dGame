/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuJogo;

import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import meuJogo.modelo.Fase;

/**
 *
 * @author User
 */
public class Container extends JFrame{

    public Container() {
        add(new Fase());
        setTitle("Meu Jogo");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
        
    }
    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
        new Container(); 
    }
}
   
    
