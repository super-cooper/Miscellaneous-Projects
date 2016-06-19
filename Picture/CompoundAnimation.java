/**
*
*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 1 days 
* Actual Completion Time: like a week
*
*Notes: Sorry for all the static. Does not work as intended due to the way rotation works with SimpleGraphics. 
*Animation is also choppy and many shapes disappear
*/

import org.kussmaul.simplegraphics.*;
import org.kussmaul.simplegraphics.item.*;
import java.awt.*;
import java.util.Random;


public class CompoundAnimation
{
	//class fields 
	static SimpleGraphics sg = new SimpleGraphics();
	static Random         rand = new Random();
	static CompoundItem   car = new CompoundItem(sg, 100, 100),
	                      man = new CompoundItem(sg, 100, 100);
	static SimpleItem     frame,
	                      cab,
	                      tireF,
	                      tireB,
	                      wheelF,
	                      wheelB,
	                      windshield,
	                      backWindow,
	                      window,
	                      cabOutline,
	                      headlights,
	                      head,
	                      body,
	                      armL,
	                      armR,
	                      legL,
	                      legR;
	
	
	/**
	 * executes the animation
	 * @param args arguments to pass to the C command line
	 */
	public static void main(String[] args)
	{
		
		drawCar(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		drive();
		drawMan();
		reverseCar();
		makeManMove();
		startFinalChase();
		
	}//end main method
	
	
	
	
	/**
	 * draws the car CompoundItem using a random color
	 * @param r red value
	 * @param g green value
	 * @param b blue value
	 * rgb values used in deciding frame color
	 */
	public static void drawCar(int r, int g, int b) 
	{ 

		car.setDrawColor(r, g, b); //random rgb value
		cab = car.fillRect(1100, 300, 200, 200); 
		
		car.setDrawColor(128, 255, 255); //kind of turquoise
		windshield = car.fillRect(1100, 320, 10, 80); 
		backWindow = car.fillRect(1290, 320, 10, 80); 
		window = car.fillRect(1125, 320, 150, 80); 
		car.setDrawColor(); //black
		cabOutline = car.drawRect(1100, 300, 200, 100); 
		
		car.setDrawColor(r, g, b); //same rgb value as the cab base
		frame = car.fillRect(1000, 400, 400, 100); 
		
		car.setDrawColor(Color.YELLOW);
		headlights = car.fillArc(980, 400, 40, 270, 180);
		
		car.setDrawColor(Color.DARK_GRAY);
		tireF = car.fillOval(1050, 450, 72);
		tireB = car.fillOval(1275, 450, 72);
		
		car.setDrawColor(Color.LIGHT_GRAY);
		wheelF = car.fillOval(1068, 468, 36);
		wheelB = car.fillOval(1293, 468, 36);
		
	}//end method
	
	
	
	
	public static void drive() 
	{ 
		SimpleGraphics.sleep(5000);
		while (car.getX() > -800)
		{ 
			car.offset(-10, 0);
			SimpleGraphics.sleep(50);
		}
	}//end method
	
	
	
	
	/**
	 * 
	 * @param r value of red
	 * @param g value of green
	 * @param b value of blue
	 * 
	 * when the man moves, he just falls apart. I do not know how to stop this.
	 */
	public static void drawMan()
	{ 
		SimpleGraphics.sleep(1000);
		
		man.setDrawColor();//reset to black
		head = man.fillOval(300, 300, 50); 
		
		body = man.fillRect(315, 330, 20, 110);
		
		armL = man.fillRect(320, 340, 10, 100);
		armL.rotate(45, 340, 360);
		
		armR = man.fillRect(320, 360, 100, 10);
		armR.rotate(45, 340, 360);
		
		legL = man.fillRect(320, 420, 10, 100);
		legL.rotate(25, 320, 420);
		
		legR = man.fillRect(330, 420, 100, 10);
		legR.rotate(65, 330, 420);
	}//end method
	
	
	
	
	public static void makeManMove()
	{ 
		SimpleGraphics.sleep(1000);
		while (man.getX() < 800)
		{ 
			man.offset(10, 0);
			SimpleGraphics.sleep(50);
		}
	}//end method
	
	
	
	
	/**
	 * reverses the car back to its original position
	 */
	public static void reverseCar()
	{ 
		SimpleGraphics.sleep(2000);
		while (car.getX() < 800) 
		{ 
			SimpleGraphics.sleep(50);
			car.offset(10, 0);
		}
	}//end method
	
	
	
	
	/**
	 * last phase of the animation. The car chases the man. Man continues to fall apart for some reason.
	 */
	public static void startFinalChase()
	{
		while (car.getX() > -200)
		{ 
			SimpleGraphics.sleep(50);
			car.offset(-10, 0);
		}
		while (car.getX() > -1000)
		{ 
			SimpleGraphics.sleep(50);
			man.offset(-10, 0);
			car.offset(-10, 0);
		}
	}//end method
	
}//end class

