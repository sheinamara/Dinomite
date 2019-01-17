import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Coin implements Drawable extends NonDino{
  // ORIGINAL GAMESTATUS VARIABLE IS IN ABSTRACT CLASS NOW

  /**
  * Allows the user to know whether or not the current instance is being drawn in the game.
  */
  public boolean drawn;

  /**
  * Gives the x-coordinate of the obstacle.
  */
  public int xcor;

  /**
  * The initial time input that is used as reference when timing the distance it travels or what happens to the obstacle.
  */
  public long temptime;

  /**
  * A multiple that is multipled by an increasing integer to keep track of time passing.
  */
  private int timepass;

  /**
  * Default constructor for a Powerup.
  */
  public Coin(){
    drawn = false;
    timepass = 0;
  }

/*
  /**
  * Checks if there are any characters where it is placed.
  * If there are any, it sets the game status to false, ending the game.
  * Otherwise, characters remain to be placed.
  * @param col is the "x-value" of a specific character.
  * @param row is the "y-value" of a specific character.
  * @param char is the character we need to set something to.
  * @param tg is an instance from TextGraphics.
  */
  private void placeCharacter(int col, int row, char character, TextGraphics tg) {
    if (tg.getCharacter(col,row).getCharacter() != ' ') {
      gamestatus = false;
    }
    else {
      tg.setCharacter(col,row,character);
    }
  }
*/

  /**
  * Draws a default coin.
  * @param col is the "x-value" of the coin.
  * @param row is the "y-value" of the coin.
  * @param tg is an instance from TextGraphics.
  */
  public void draw(int col, int row, TextGraphics tg){
    placeCharacter(col,row,'+',tg);
  }

  /**
  * Undraws a default coin.
  * @param col is the "x-value" of the coin.
  * @param row is the "y-value" of the coin.
  * @param tg is an instance from TextGraphics.
  */
  public void undraw(int col, int row, TextGraphics tg){
    tg.setCharacter(col,row,' ');
  }
}
