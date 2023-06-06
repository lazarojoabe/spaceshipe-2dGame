/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuJogo.modelo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Rectangle;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Player extends Sounds {
    private int x, y;
    private int dx, dy;
    private int altura, largura;
    private Image imagem;
    private List<Tiro> tiros;
    private boolean isVisivel;
    private int contador = 100;
    
    public Player(){
        this.x = 100;
        this.y = 100;
        isVisivel = true;
        
        
        tiros = new ArrayList<Tiro>();
         
    }
    
    public void load(){
        ImageIcon referencia = new ImageIcon("res\\spaceship.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }
    
    public void update(){
        y += dy;
        x += dx;
        
        if(x > 1200){
            x = 1200;
        }
        if(x < 0){
            x = 1;
        }
        if(y > 650){
            y = 650;
        }   
        if(y < 0){
            y = 1;
        }
        
    }
    
    
    public void tiroSimples(){
        this.tiros.add(new Tiro(x + largura, y + (altura/2)));
    }
    
    public Rectangle getBound(){
        return new Rectangle(x, y, largura, altura);
    }
    
    public void keyPressed(KeyEvent tecla) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
       int codigo = tecla.getKeyCode();
       
       if(codigo == KeyEvent.VK_O){
           tiroSimples();
           
       }
       
       if(codigo == KeyEvent.VK_W){
           dy = -3;
       }
       
       if(codigo == KeyEvent.VK_S){
           dy = 3;
       }
       
       if(codigo == KeyEvent.VK_A){
           dx = -3;
       }
       
       if(codigo == KeyEvent.VK_D){
           dx = 3;
       }
    }
    
    public void keyRelease(KeyEvent tecla){
       int codigo = tecla.getKeyCode();
       
       if(codigo == KeyEvent.VK_W){
           dy = 0;
       }
       
       if(codigo == KeyEvent.VK_S){
           dy = 0;
       }
       
       if(codigo == KeyEvent.VK_A){
           dx = 0;
       }
       
       if(codigo == KeyEvent.VK_D){
           dx = 0;
     
        }
    
    }

    public boolean isIsVisivel() {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }
    
    
    
}
