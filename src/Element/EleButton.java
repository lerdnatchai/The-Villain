/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Element;

import java.awt.Color;
import javax.swing.JButton;

public class EleButton extends JButton{

	private static final long serialVersionUID = 1L;

		public EleButton(String title,int size,int x,int y,int width,int height) {
			super(title);
			this.setBackground(new Color(2, 117, 216));
			this.setForeground(Color.white);
			this.setFont(Element.getFont(size));
			this.setBounds(x, y, width, height);
		}
		
}