/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charactor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class player{
	public int x ;
	public int y;
	public int health=180;
	public static int speed=90;
	
	public player() {
		
	}
	
	public player(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public void moveUp(){
            this.y -= 50;
            if(y<100){y=100;}
        }
    
        public void moveDown(){
            this.y += 50;
            if(y>500){y=500;}
        }
	
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("pics\\demonlord.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
}