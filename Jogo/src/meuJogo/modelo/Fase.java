/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuJogo.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author User
 */


public class Fase extends JPanel implements ActionListener{
    private Image fundo;
    private Image nebulosa;
    private Player player;
    private Timer timer;
    private List<Enemy1> enemy1;
    private List<Nebula> nebulas;
    private boolean emJogo;
    
    
    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);
        
        ImageIcon referencia = new ImageIcon("res\\background.jpg");
        fundo = referencia.getImage();
        
        System.out.println("Criar Player");
        player = new Player();
        player.load();
        
        addKeyListener(new TecladoAdapter());
        
        timer = new Timer(5, this);
        timer.start();
        
        inicializaInimigos();
        emJogo = true;
    }
    
    public void inicializaInimigos(){
        int cordenadas[] = new int [40];
        enemy1 = new ArrayList<Enemy1>();
        for(int i = 0; i < cordenadas.length; i++){
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            enemy1.add(new Enemy1(x, y));
        }
    }
    
    
    public void paintComponent(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        if(emJogo == true){
           graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
            List<Tiro> tiros = player.getTiros();
            for(int i = 0; i < tiros.size(); i++){
            Tiro m = tiros.get(i);
            m.load();
            graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
         }
         for(int j = 0; j < enemy1.size(); j++){
             Enemy1 in = enemy1.get(j);
             in.load();
             graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
         } 
        } else {
            ImageIcon fimJogo = new ImageIcon("res\\fimdejogo.png");
            graficos.drawImage(fimJogo.getImage(), 0, 0, 1920, 1080, this);
        }
        g.dispose();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         player.update();
     
         List<Tiro> tiros = player.getTiros();
         for(int i = 0; i < tiros.size(); i++){
             Tiro m = tiros.get(i);
             if(m.isVisivel()){
                 m.update();
             } else {
                 tiros.remove(i);
             }
         }
         for(int j = 0; j < enemy1.size(); j++){
             Enemy1 in  = enemy1.get(j);
             if(in.isVisivel()){
                 in.update();
             } else {
                 enemy1.remove(j);
             }
         }
         checarColisoes();
         repaint();
    }

    public void checarColisoes(){
        Rectangle formaNave = player.getBound();
        Rectangle formaEnemy1;
        Rectangle formaTiro;
        
        for(int i = 0; i < enemy1.size(); i++){
            Enemy1 tempEnemy1 = enemy1.get(i);
            formaEnemy1 = tempEnemy1.getBound();
                if(formaNave.intersects(formaEnemy1)){
                    player.setIsVisivel(false);
                    tempEnemy1.setVisivel(false);
                    emJogo = false;
                }
        }
        List<Tiro> tiros = player.getTiros();
        for(int j = 0; j < tiros.size(); j++){
            Tiro tempTiro = tiros.get(j);
            formaTiro = tempTiro.getBound();
            for(int o = 0; o < enemy1.size(); o++){
                Enemy1 tempEnemy1 = enemy1.get(o);
                formaEnemy1 = tempEnemy1.getBound();
                if(formaTiro.intersects(formaEnemy1)){
                    tempEnemy1.setVisivel(false);
                    tempTiro.setVisivel(false);
                }
            }
        }
    }
    
    public class TecladoAdapter implements KeyListener{
        
       
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            try {
                player.keyPressed(ke);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Fase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Fase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Fase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            player.keyRelease(ke);
        }
    }
    
    
}
