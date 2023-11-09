/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package display;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Charactor.*;
import Element.Element;
import event.Event;

public class Game extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	private static int speed = 50,playerSize = 100 ,waveHeight = 50;
	private static int xStart = 1000;
	private long point = 0,lastPress=0;
	
	private player p = new player(100,300);
	static Display display;
//	------------------Wave SIze ----------------------------
	private Wave[] waveSet = makeWave(10);
	
		public Game(){
		this.setBounds(0,0,1000,600);
		this.addKeyListener(this);
		this.setLayout(null);
		this.setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
			try {
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				this.drawBackground(g2);
                                g2.drawImage(ImageIO.read(new File("pics\\BG.PNG")), 0, 0,1000,600, null);
				//---POINT----
				g2.setFont(Element.getFont(6000));
				g2.setColor(Color.white);
				g2.drawString("Point : "+point,800,70);
				//--- dog --
				g2.setColor(Color.RED);
				drawDogHealth(g2);
                                //g2.drawRect(p.x,p.y,playerSize,playerSize);
				g2.drawImage(p.getImage(),p.x,p.y,playerSize,playerSize, null);
				//----Wave----
				for(Wave item : waveSet) {
                                        //g2.drawRect(item.x,item.y-50,10,waveHeight);
					drawWave(item,g2);
				}
				this.point+=1;
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	private void drawBackground(Graphics2D g2) throws IOException {
			g2.drawImage(ImageIO.read(new File("pics\\BG1.jpg")),0,0,1000,600, null);
	}
	
	private void drawDogHealth(Graphics2D g2) {
		try {
			g2.drawImage(ImageIO.read(new File("pics\\hearth(0).png")),10,10, 100,100,null);
			g2.setStroke(new BasicStroke(18.0f));
			g2.setColor(Color.RED);
			g2.drawLine(110, 60,110+p.health,60);	
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(6.0f));
			g2.drawRect(100,50, 200,20);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Wave[] makeWave(int size) {
		Wave[] waveSet = new Wave[size];
		int far = 500;
		for(int i=0;i<size;i++) {
			waveSet[i] = new Wave(xStart+far, (int) Math.floor(Math.random()*500)+100,speed,this);
			far+=500;
		}
		return waveSet;
	}
        
	
	
	private void drawWave(Wave wave,Graphics2D g2) {
			g2.drawImage(wave.getImage(),wave.x ,(wave.y-waveHeight),60,waveHeight+10,null);
			if(Event.checkHit(p,wave,playerSize,waveHeight)){
					g2.setColor(new Color(241, 98, 69));
					g2.fillRect(0, 0,1000,1000);			
					p.health-=1;
					if(p.health<=0) {
						display.endGame(this.point);
						p.health = new player().health;
						this.point = 0;	
					}
			}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==87||e.getKeyCode()==38){
                    p.moveUp();
                    this.repaint();
                }
                else if(e.getKeyCode()==83||e.getKeyCode()==40){
                    p.moveDown();
                    this.repaint();
                }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//---
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//---
	}
	
	public static void main(String[] arg) throws IOException {
		 display = new Display();
	}
}