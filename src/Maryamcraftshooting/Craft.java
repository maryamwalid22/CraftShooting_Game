
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Maryamcraftshooting;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
 
 
import javax.swing.ImageIcon;

/**
 *
 * @author ALMWUSHOOR
 */

public class Craft {
    private int x, y,x1;
    private int Dx, Dy;
    private Image image;
    private int width, height,w,h;
    private boolean visible;
    private ArrayList<Missile> missiles;
    

    public Craft() {
        ImageIcon i = new ImageIcon("craft.png");
        image = i.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        x = 100;
        y = 100;
        visible = true;
        missiles = new ArrayList<>();
    }
    
public void move(){
    x += Dx;
    y += Dy;
    
    if(x<0)
    x=0;
    
     if(y<0)
    y=0;
    
      if(x>919)
    x=919;
    
     if(y>606)
    y=606;
    
}
    public int getx(){
        return x;
    }
    
     public int gety(){
        return y;
    }
     
    
   public Image getImage(){
       return image;
   }
   
   public ArrayList<Missile> getMissiles() {
    return missiles;
   }

     public void setVisible(boolean visible) {
       this.visible = visible;
      }

    public boolean isVisible() {
       return visible;
    } 
//colision
   public Rectangle getBounds() {
       return new Rectangle(x, y, width, height);
    }
     public Rectangle getBounds2() {
       return new Rectangle(x1, y, w, h);
    }

    public void fire() {
        missiles.add(new Missile(x + width, y + height/2));
        
    }
     public void fire2() {
        missiles.add(new Missile(x1 + w, y + h/2));
        
    }

   
  //for missil 
 public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_LEFT) {
        Dx = -1;
    }
    if (key == KeyEvent.VK_RIGHT) {
        Dx = 1;
    }
    if (key == KeyEvent.VK_UP) {
        Dy = -1;
    }
    if (key == KeyEvent.VK_DOWN) {
        Dy = 1;
    }
    if (key == KeyEvent.VK_SPACE) {
        fire();
    }
     if (key == KeyEvent.VK_1) {
        fire2();
    }
    
}

 
//for craft
     public void keyReleased(KeyEvent e){
   int key=e.getKeyCode();
       if (key == KeyEvent.VK_LEFT) {
           Dx=0;    
       }
       if (key == KeyEvent.VK_RIGHT) {
           Dx=0;    
       }
       if (key == KeyEvent.VK_UP) {
           Dy=0;    
       }
       if (key == KeyEvent.VK_DOWN) {
           Dy=0;    
       }
   }
    
}
