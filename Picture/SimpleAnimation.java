/**
*
*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 2 hours 
* Actual Completion Time: 2 days
*
*/

import org.kussmaul.simplegraphics.*;
import org.kussmaul.simplegraphics.item.*;
import java.awt.*;
import java.util.Random;

public class SimpleAnimation
{
	//class fields 
	static Random rand = new Random();
	static SimpleGraphics sg = new SimpleGraphics();
	static SimpleItem face, eyeL, eyeR, mouth, eyebrowL, eyebrowR; 
	static CompoundItem smiley;
	
	
	public static void main(String[] args)
	{
		
		drawFace();
		makeFaceSad();
		makeFaceMad();
		shakeFace();
		
	}//end main method
	
	
	
	
	/** 
	 * draws the happy face and creates the face as a CompoundItem
	 */
	public static void drawFace() 
	{ 
		sg.setDrawColor(Color.YELLOW);
		face = sg.fillOval(0,  0,  500);
		sg.setDrawColor();
		eyeL = sg.fillOval(100, 100, 40);
		eyeR = sg.fillOval(360, 100, 40);
		mouth = sg.fillArc(100, 150, 300, 180, 180);
		eyebrowL = sg.fillRect(100, 70, 50, 10);
		eyebrowR = sg.fillRect(350, 70, 50, 10);
		
		smiley = makeSmiley(face, eyeL, eyeR, mouth, eyebrowL, eyebrowR);
		
	}//end method
	
	
	
	
	/** 
	 * makes the happy face sad
	 */
	public static void makeFaceSad() 
	{ 
		SimpleGraphics.sleep(2000); //pauses the thread to showcase the wonderful smiley
		
		eyebrowL.rotate(330, 125, 70); //rotates and displaces the eyebrows to make them look sad
		eyebrowL.setX(80); //current coords: (80, 70)
		eyebrowR.rotate(30, 375, 70); 
		eyebrowR.setX(370); //current coords: (370, 70)
		
		mouth.rotate(180, 250, 300); //turns that smile upside down
		mouth.setY(50);
		
	}//end method
	
	
	
	
	/** 
	 * makes the sad face mad
	 */
	public static void makeFaceMad() 
	{ 
		SimpleGraphics.sleep(2000);
		
		eyebrowL.rotate(30, 105, 70); //puts eyebrows back to normal
		eyebrowL.setX(100); //current coords: (100, 70)
		eyebrowR.rotate(330, 395, 70);
		eyebrowR.setX(350); //current coords: (350, 70)
		
		SimpleGraphics.sleep(2000); //waits for 2 seconds
		
		face.setColor(Color.ORANGE); //set face(ers) to orange
		
		eyebrowL.rotate(30, 125, 70); //makes eyebrows angry
		eyebrowR.rotate(330, 375, 70);
		
		SimpleGraphics.sleep(2000); //wait 2 seconds 
		
		face.setColor(Color.RED); //get all red in the face
		
	}//end method
	
	
	
	
	/**
	 * takes smiley and shakes it erratically
	 */
	public static void shakeFace()
	{ 
		//method fields called up here so they aren't re-declared during every cycle of the for-loop
		boolean affectingX;
		double r; 
		int modifyer;
		float shakeVal;
		
		for (int n = Integer.MIN_VALUE; n < Integer.MAX_VALUE; n++) //creates a for-loop that goes on for a very long time, but not indefinitely
		{ 
			SimpleGraphics.sleep(100); //very quick waiting period to ensure shaking is visual
			
			r = rand.nextDouble(); //random value for erratic shake
			modifyer = rand.nextInt(5) + 1; //modifies r to give the shake more variance
			affectingX = rand.nextBoolean(); //randomly decides the direction of the shake
			
			if (n % 2 == 0) //varies the direction of shake
				r *= -1;
			
			shakeVal = (float) (r * modifyer); //gets final value for shake amount
			
			if (affectingX) 
				smiley.offset(shakeVal, 0);
			else 
				smiley.offset(0, shakeVal);
			
		}//end for-loop
		
		smiley.remove();
		sg.drawString(50, 50, "boom"); //a little easter egg if you somehow sit through the duration of the shaking. Probably would take years.
	}//end method
	
	
	
	
	/** 
	 *        compounds all parameters into a single item. Specifically, a face.
	 * @param face
	 * @param eyeL
	 * @param eyeR
	 * @param mouth
	 * @param eyebrowL
	 * @param eyebrowR
	 * @return a face CompoundItem
	 */
	public static CompoundItem makeSmiley(SimpleItem face, SimpleItem eyeL, SimpleItem eyeR, SimpleItem mouth, SimpleItem eyebrowL, SimpleItem eyebrowR) 
	{ 
		CompoundItem end = new CompoundItem(sg, 500, 500); 
		end.add(face);
		end.add(eyeL); 
		end.add(eyeR);
		end.add(mouth);
		end.add(eyebrowL);
		end.add(eyebrowR);
		return end;
	}//end method

}//end class
