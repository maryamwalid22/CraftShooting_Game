/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maryamcraftshooting;

import javax.swing.JFrame;

/**
 *
 * @author ALMWUSHOOR
 */
public class MaryamCraftShooting extends JFrame {

    public MaryamCraftShooting(){
        add(new Board());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(900,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
      MaryamCraftShooting maryamcraftshooting=new MaryamCraftShooting();
    }
  
}
