/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event;

import Charactor.*;

public class Event {
			public static boolean checkHit(player p,Wave f,int playerSize,int Height){
				if((p.x+playerSize > f.x)&&(p.y < f.y+Height-50)&&(p.y+playerSize>f.y-50)) {
                                    //System.out.println("hit");0
                                    return true;
                                }
                                else{
                                    return false;
                                }
			}
			
			public static void gameStop(Wave[] wave) {

			}

}