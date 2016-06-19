/**
*
1*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 2 days 
* Actual Completion Time: Way too long
*
*/

import org.kussmaul.simplegraphics.*;
import java.awt.*;
import java.util.Random;

public class Picture
{
	
	
	//class fields 
	static Random rand = new Random();
	static SimpleGraphics sg = new SimpleGraphics();
	
	
	public static void main(String[] args)
	{
		
		sg.drawString(10, 50, "I will now draw a picture of the starship enterprise crashing into a random planet, as well as a Pokéball of random color.");
		drawStarship(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		drawPokeball(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		
	}//end main method

	
	
	
	/**
	 * draws the starship enterprise crashing into a planet of random color
	 * 
	 * @param r value of red
	 * @param g value of green
	 * @param b value of blue
	 */
	public static void drawStarship(int r, int g, int b)
	{ 
		sg.drawString(10, 80, "Make sure to maximize the window to see everything!"); //tells the user to maximize the window
		sg.setDrawColor(223, 223, 225); //draws the starship enterprise
		sg.fillOval(500, 600, 100);
		sg.fillRect(565, 635, 100, 30);
		sg.fillRect(650, 615, 30, 70);
		sg.fillTriangle(650, 615, 750, 615, 650, 570);
		sg.fillTriangle(650, 680, 750, 680, 650, 720);
		sg.setDrawColor(r, g, b); //draws the planet
		sg.fillOval(0, 450, 500);
		
	}//end method
	
	
	
	
	/** 
	 * draws a pokeball of random color
	 * 
	 * @param r value of red
	 * @param g value of green
	 * @param b value of blue
	 */
	public static void drawPokeball(int r, int g, int b)
	{ 
		
		sg.setDrawColor();
		sg.fillOval(100, 100, 100); //draws black outline
		
		sg.setDrawColor(r, g, b); //creates top shell of pokeball in random color
		sg.fillOval(105, 105, 90);
		
		sg.setDrawColor(255, 255, 255); //creates bottom shell of pokeball in white
		sg.fillArc(105, 105, 90, 180, 180); 
		
		sg.setDrawColor(); //resets draw color to black and draws the crease
		sg.fillRect(102.5, 148, 95, 5);
		
		sg.fillOval(140, 140, 20); //draws the button
		sg.setDrawColor(255, 255, 255); 
		sg.fillOval(145, 145, 10);
		sg.setDrawColor();
		sg.drawLine(110, 150, 170, 150);
		
	    /*drawRandomPokeballShape(); I originally had a method to draw a random shape of random color on the top of the ball, 
		 * but it only worked half the time, even if the code was unchanged between running. I think it was race conditions. Not sure, though.
		 */
		
	}//end method
	
}//end class



