/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maryamcraftshooting;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author mohammad
 */
public class Missile {
    private int x,y,x1;
    private int width,height,w,h;
    private Image image;
       private Image image2;
    private boolean visible;
    private int board_width=850,missile_speed=2;//,ms2=4;
    Craft c=new Craft();
    
    public Missile(int x, int y) {
        ImageIcon i = new ImageIcon("missile.png");
       
        image = i.getImage();
       
        visible = true;
        width = 30;
        height = 40;
         
        this.x = x;
        this.y = y;
        
     
         ImageIcon j = new ImageIcon("missile2.jpg");
           visible = true;
          image2 = j.getImage();
        w=20;
        h=30;
         
         this.x1=x1;
       
        this.y = y;
        
        
    }
    
    
    
    public int getx() {
        return x;
    }
    
    public int gety() {
        return y;
    }
    public int getx1(){
        return x1;
    }
    public Image getImage() {
        return image;
    }
    /*
     public Image getImage2() {
        return image2;
    }*/
    
    
    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
     public Rectangle getBounds2() {
        return new Rectangle(x1, y, w, h);
    }
    
    
    public void move() {
        x += missile_speed;
       // x1+=ms2;
        if (x > board_width ){//&& x1 > board_width) {
            visible = false;
        }
    }
}
