/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maryamcraftshooting;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
    private Craft craft;
    private Timer timer;
    private ArrayList<Alien> aliens;
    private int cou=0;
    //Aliens
    private int[][] pos = {
        {1150, 29}, {1660, 59}, {1466, 89},
        {1744, 309}, {1420, 239}, {1609, 469},
        {1580, 199}, {740, 209}, {1700, 539},
        {1620, 159}, {1850, 450}, {1900, 550},
        {1380, 140}, {1240, 350}, {1964, 270},
        {1749, 370}, {1500, 500}, {1600, 420},
        {1700, 449}, {1940, 370}
    };
    
    //colision
    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;
    
    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        craft = new Craft();
        timer = new Timer(7, this);
        timer.start();
        initAliens(); 
        ingame=true;
        setSize(800,600);
    }
    public void addNotify(){
        super.addNotify();
         B_WIDTH=getWidth();
          B_HEIGHT=getHeight();
         
    }

    private void initAliens() {
        aliens = new ArrayList<>();

        for (int[] p : pos) {
            aliens.add(new Alien(p[0], p[1]));
        }
    }
    
 public void paint(Graphics g) {
     if(ingame){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(craft.getImage(), craft.getx(), craft.gety(), this);
        if(craft.isVisible())
        g2D.drawImage(craft.getImage(),craft.getx(),craft.gety(), this);
 

        ArrayList ms = craft.getMissiles();
        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);
            g2D.drawImage(m.getImage(), m.getx(), m.gety(), this);
           //g2D.drawImage(m.getImage2(), m.getx1(), m.gety(), this);
           
        }
        /*for(int c=0;c<ms.size();c++){
               if(cou==c)
                   cou++;
               }
            int v= cou;
                    String vs="the counter are "+v;
                   g.drawString(vs, v,cou);
                
              */

        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g2D.drawImage(alien.getImage(), alien.getx(), alien.gety(), this);
            }
        }

        g.dispose();
        
        g2D.setColor(Color.BLACK);
        g2D.drawString("Aliens left:"+ aliens.size(),5,15);
     }else{
         String msg="Game Over";
         Font small=new Font("Helvetica",Font.BOLD,14);
         FontMetrics metr=this.getFontMetrics(small);
         g.setColor(Color.BLACK);
         g.setFont(small);
         g.drawString(msg,(B_WIDTH-metr.stringWidth(msg))/2,B_WIDTH/2);
         
     }
    }

 
 public void actionPerformed(ActionEvent e) {
     if(aliens.size()==0){
         ingame=false;}
    craft.move();
    System.out.println("\t" + "x=" + craft.getx() + "\t" + ", y=" + craft.gety());

    // Move missiles
    ArrayList missiles = craft.getMissiles();
    for (int i = 0; i < missiles.size(); i++) {
        Missile m = (Missile) missiles.get(i);
        if (m.isVisible()) {
            m.move();
        } else {
            missiles.remove(i);
        }
    }

    // Move aliens
    for (int i = 0; i < aliens.size(); i++) {
        Alien a = aliens.get(i);
        if (a.isVisible()) {
            a.move();
        } else {
            aliens.remove(i);
        }
    }
   checkCollisions();
    repaint();
}
 //colision
 public void checkCollisions(){
     Rectangle r3=craft.getBounds();
     for(int j=0;j<aliens.size();j++){
         Alien a=(Alien) aliens.get(j);
     Rectangle r2=a.getBounds();
     if(r3.intersects(r2)){
         craft.setVisible(false);
         a.setVisible(false);
         ingame=false;
     }
     }
    ArrayList ms=craft.getMissiles();
    for(int i=0;i<ms.size();i++){
        Missile m=(Missile) ms.get(i);
        Rectangle r1=m.getBounds();
         for(int j=0;j<aliens.size();j++){
         Alien a=(Alien) aliens.get(j);
     Rectangle r2=a.getBounds();
     if(r1.intersects(r2)){
         m.setVisible(false);
         a.setVisible(false);
     }
         
     }
        
    }
 }
     private class TAdapter extends KeyAdapter{
        
    public void keyPressed(KeyEvent e) {
        craft.keyPressed(e);
    }
    
    public void keyReleased(KeyEvent e) {
        craft.keyReleased(e);
    }
}   
}
