/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuJogo.modelo;

import java.awt.Image;
import java.awt.List;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Enemy1 {
    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean visivel;
    
    
    public static final int LARGURA = 938;
    private static int VELOCIDADE = 4;
    
    public Enemy1(int x, int y){
       this.x = x;
       this.y = y;
       visivel = true;
       
    }
    
    public void load(){
        ImageIcon referencia = new ImageIcon("res\\inimigo1.png");
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }
    
    
    
    public void update(){
        this.x -= VELOCIDADE;
        //if(this.x > LARGURA){
           // visivel = false;
      // }
    }

    public Rectangle getBound(){
        return new Rectangle(x, y, largura, altura);
    }
    
    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
    
    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        Enemy1.VELOCIDADE = VELOCIDADE;
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
    
    
}
