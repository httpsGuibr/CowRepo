package qerwerwer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class test {
	
	public void blabla() {
	int delay = 1000; 
     int[] remainingTime = {30}; 

     Timer timer = new Timer(delay, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             remainingTime[0]--; 
             
             System.out.println("Tempo restante: " + remainingTime[0] + " segundos");

             
             
             if (remainingTime[0] <= 0) {
                 ((Timer) e.getSource()).stop(); 
                
                 new Thread(() -> {
                     AudioPlayer player = new AudioPlayer();
                     player.playSound("src/audio/morreu.wav");
                 }).start();
                 
                 try {
                    
                     
                     });
                 } catch (Exception e1) {
                     System.out.println(e1);
                 }

             }
         }
     });

     
     timer.start();
}
}