/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Element;

import javax.swing.JLabel;

public class EleLabel extends JLabel {

	private static final long serialVersionUID = 1L;
		
		public EleLabel(String title,int size,int x,int y,int w,int h) {
			 super(title);
			 setFont(Element.getFont(size));
			 setBounds(x,y,w,h);
		}
}