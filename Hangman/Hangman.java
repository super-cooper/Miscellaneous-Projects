/**
*
*@author Adam Cooper
*@version 1.0
*
* Estimated Completion Time: 2 hours 30 minutes
* Actual Completion Time: 16 years
*
*/

import org.kussmaul.simplegraphics.*;
import org.kussmaul.simplegraphics.item.CompoundItem;
import org.kussmaul.simplegraphics.item.SimpleItem;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

import java.awt.Color;

public class Hangman
{
	//class fields
	Scanner scan = new Scanner(System.in);
	SimpleGraphics sg = new SimpleGraphics();
	Random rand = new Random();
	String guess;              //the current guess of the user
	boolean gameOver = false;  //to know if the game is over
	boolean win = false;       //to know if the user won
	int correctGuesses = 0;    //amount of letters correctly guessed
	int bodyPart = 0;          //amount of body parts currently drawn
	String word;               //the word the player is trying to guess
	ArrayList<String> chosenLetters = new ArrayList<String>();  //all of the letters that have been chosen so far
	String[] words = {"protest", "agony", "mystical", "greed", "esoteric", "agent"}; //taken from a random word generator online
	static Hangman hangman = new Hangman(); //makes it so everything doesn't have to be static
	
	
	
	/**
	 * constructor
	 */
	public Hangman() {} 
	
	
	
	
	/**
	 * plays game
	 * 
	 * @param args arguments to pass to command line
	 */
	public static void main(String[] args)
	{
		hangman.play();
	}
	
	
	
	
	/**
	 * draws different parts of gallows as well as the blanks for the word
	 */
	public void drawGallows()
	{
		sg.setDrawColor();
		SimpleItem floor = sg.drawLine(400, 400, 500, 400);
		SimpleItem pole  = sg.drawLine(450, 400, 450, 200);
		SimpleItem top   = sg.drawLine(450, 200, 400, 200);
		SimpleItem rope  = sg.drawLine(400, 200, 400, 220);
		
		for (int i = 0; i < word.length(); i++)
		{
			int distanceCoef = (i * 40) + 300; //constant used to determine variable line distance
			SimpleItem line = sg.drawLine(distanceCoef, 500, distanceCoef + 30, 500);
		}
	}
	
	
	
	
	/**
	 * gets the next move from the user and won't stop asking until it gets a valid input
	 * @return the input as a lowercase String
	 * 
	 * yes, I got that ridiculous regEX formula online. I am not ashamed. 
	 */
	public String nextMove()
	{
		while (true)
		{
			System.out.print("Please enter a single letter: ");
			//scans for input getting rid of all whitespace and symbols
			String input = scan.nextLine().replaceAll("\\W", "").toLowerCase(); 
		
			//checks to make sure the string is only a single letter and not a number or null or empty, and hasn't been used
			if (input != null && input.length() == 1 && !input.matches("-?\\d+(\\.\\d+)?") && !chosenLetters.contains(input))
			{
				chosenLetters.add(input);
				return input;
			}	
			else
				return nextMove();
		}//end while-loop
	}//end method
	
	
	
	/**
	 * checks to see what body part needs to be drawn and then draws the appropriate part
	 * I recognize that doing this without the added methods would be easier, but I'm following the assignment
	 */
	public void drawNextBodyPart()
	{
		switch (bodyPart)
		{
			case 0: drawHead();
					break;
			case 1: drawBody();
					break;
			case 2: drawLegL();
					break;
			case 3: drawLegR();
					break;
			case 4: drawArmL();
					break;
			case 5: drawArmR();
					break;
		   default: break;
		}
	}//end method
	
	
	
	
	/**
	 * sets field world to one of the random words in the array of words. word.
	 */
	public void setWord()
	{
		word = words[rand.nextInt(6)];
	}
	
	
	
	
	/**
	 * manages flow of game
	 */
	public void play()
	{
		setWord();
		drawGallows();
		
		while (true) //infinite loop that checks if nextMove is in the secret word, breaks when gameOver is true
		{
			if (gameOver) //if the game is over, run the endgame sequence
			{
				runEndGameSequence();
				break;
			}
			//shows the user which letters have been used already
			if (!chosenLetters.isEmpty())
				drawUsedLetters();
			
			guess = nextMove();        //saves the users next move as a manipulatable object
			
			if (!word.contains(guess)) //if wrong, add body part
				drawNextBodyPart();
			else                       //if correct, draw letters. Do not add body part
				drawLetters();
		}
	}//end method
	
	
	
	
	/**
	 * 
	 */
	public void runEndGameSequence()
	{
		if (win)
		{
			System.out.println("You won. Big whoop.");
			if (playAgain()) //if user typed "y" with minor error cushion
				startNewGame();
		}
		else
		{
			System.out.println("Looks like you lost, nerd.");
			if (playAgain())
				startNewGame();
		}
	}
	
	
	
	
	/**
	 * asks the user if they want to play again
	 * @return true if user responds "y", false otherwise
	 */
	public boolean playAgain()
	{
		System.out.print("Play again? y/n: ");
		return scan.nextLine().toLowerCase().replaceAll("\\W", "").equals("y"); //user input with minor error padding
	}
	
	
	
	
	/**
	 * resets important fields and starts a new game
	 */
	public void startNewGame()
	{
		sg.clear();       //clear board
		gameOver = false; //reset fields
		win = false;
		correctGuesses = 0;
		bodyPart = 0;
		chosenLetters.clear();
		hangman.play();   //start new game
	}
	
	
	
	
	/**
	 * draws out any correct letters. This would be way easier to do in Python.
	 */
	public void drawLetters()
	{
		SimpleItem toScreen;
		char[] splitWord = word.toCharArray(); //stores the word as a char array to make parsing easier
		for (int i = 0; i < splitWord.length; i++)
		{
			if (splitWord[i] == guess.charAt(0)) //if index i in word == thisMove
			{
				toScreen = sg.drawString(i * 40 + 310, 495, splitWord[i]); //draw letter above line
				correctGuesses++;
			}
		}
		if (correctGuesses == word.length()) //checks if all letters have been found
		{
			gameOver = true;
			win = true;
		}
	}//end method
	
	
	
	
	/**
	 * draws a string item in the top left corner to tell the user which letters they've used
	 */
	public void drawUsedLetters()
	{
		SimpleItem toScreen;
		String used = "";
		for (String i : chosenLetters) //adds all used letters to a string
			used += i + ", ";
		toScreen = sg.drawString(10, 10, "Used Letters: " + used); //displays used letters as a DrawStringItem
	}
	
	
	
	
	/**
	 * draws the man's head, increments bodyPart
	 */
	public void drawHead()
	{
		SimpleItem head = sg.drawOval(375, 220, 50);
		bodyPart++;
	}
	
	
	
	
	/**
	 * draws the man's body, increments bodyPart
	 */
	public void drawBody()
	{
		SimpleItem body = sg.drawLine(400, 270, 400, 330);
		bodyPart++;
	}
	
	
	
	
	/**
	 * draws the man's left leg, increments bodyPart
	 */
	public void drawLegL()
	{
		SimpleItem legL = sg.drawLine(400, 330, 375, 355);;
		bodyPart++;
	}
	
	
	
	
	/**
	 * draws the man's right leg, increments bodyPart
	 */
	public void drawLegR()
	{
		SimpleItem legR = sg.drawLine(400, 330, 425, 355);
		bodyPart++;
	}
	
	
	
	
	/**
	 * draws the man's left arm, increments bodyPart
	 */
	public void drawArmL()
	{
		SimpleItem armL = sg.drawLine(400, 300, 375, 275);
		bodyPart++;
	}
	
	
	
	
	/**
	 * draws the man's right arm, sets gameOver to true
	 */
	public void drawArmR()
	{
		SimpleItem armR = sg.drawLine(400, 300, 425, 325);
		gameOver = true;
	}
}//end class