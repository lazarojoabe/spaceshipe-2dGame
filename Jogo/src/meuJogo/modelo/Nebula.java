/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuJogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Nebula {
    private Image imagem;
    private int x, y;
    private int altura, largura;
    private boolean isVisivel;
    
    private static int VELOCIDADE = 1;
    
    public Nebula(int x, int y){
        this.x = x;
        this.y = y;
        isVisivel = true;
    }
    
    public void load(){
        ImageIcon referencia = new ImageIcon("res\\Nebula2.png");
        imagem = referencia.getImage();
        
        this.altura = imagem.getHeight(null);
        this.largura = imagem.getWidth(null);
    }
    
    public void update(){
        if(this.x < -(this.largura)){
            this.x = largura;
            Random a = new Random();
            int m = a.nextInt(500);
            this.x = m + 1024;
            
            Random r = new Random();
            int n = r.nextInt(768);
            this.y = n;
        } else {
            this.x -= VELOCIDADE;
        }
    }

    public Image getImagem() {
        return imagem;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isIsVisivel() {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        Nebula.VELOCIDADE = VELOCIDADE;
    }
    
    
}
