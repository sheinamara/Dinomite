import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Coin extends NonDino implements Drawable {
  /*
  VARIABLES THAT ARE NOW IN NONDINO ABSTRACT CLASS:
  1. public boolean status (used to be gamestatus)
  2. public boolean drawn
  3. public int xcor
  4. public long temptime
  5. private int timepass
  */

  /**
  * Default constructor for a Powerup.
  */
  public Coin(){
    drawn = false;
    timepass = 0;
  }

  /*
  METHODS THAT ARE NOW IN NONDINO ABSTRACT CLASS:
  1. public void spawn(int, int, long, TextGraphics)
  2. public void placeCharacter(int, int, char, TextGraphics)
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
