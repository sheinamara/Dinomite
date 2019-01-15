import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Cactus implements Drawable{
  /**
  * Allows the user to know whether or not they are still alive.
  */
  public boolean gamestatus;

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
  * There are two types of cacti: 1 indicates a big one while 2 indicates a small one.
  */
  private int type;

  /**
  * A multiple that is multipled by an increasing integer to keep track of time passing.
  */
  private int timepass;

  /**
  * The default constructor for a cactus.
  * @param type_ indicates the type of cactus.
  */
  public Cactus(int type_){
    type = type_;
    drawn =  false;
    timepass = 0;
    gamestatus = true;
  }

  /**
  * Creates the obstacle in the terminal and run them across the terminal.
  * @param col is the "x-value" of the left character of the cactus's base in a standard coordinate system.
  * @param millis is a time variable.
  * @param tg is a variable used for the duckhead method.
  */
  public void spawn(int row, long millis, TextGraphics tg) {
    if (millis >= temptime + (30 * timepass)) {
        undraw(xcor,row,tg);
        xcor -= 1;
        draw(xcor,row,tg);
        timepass += 1;
    }
    if (xcor == 3) {
      drawn = false;
      undraw(xcor,row,tg);
    }
  }

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

  /**
  * Draws a cactus that will vary in size based on the constructed cactus.
  * @param col is the "x-value" of the left character of the cactus's base in a standard coordinate system.
  * @param row is the "y-value" of the left character of the cactus's legs in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */
  public void draw(int col, int row, TextGraphics tg) {
    if (type == 1) {
      placeCharacter(col-3,row-2,'\\',tg);
      placeCharacter(col-1,row-2,'|',tg);
      placeCharacter(col,row-2,'|',tg);
      placeCharacter(col+1,row-2,'|',tg);
      placeCharacter(col+2,row-2,'|',tg);
      placeCharacter(col+4,row-2,'/',tg);

      tg.setCharacter(col-2,row-1,'|');
      tg.setCharacter(col-1,row-1,'_');
      tg.setCharacter(col,row-1,'|');
      tg.setCharacter(col+1,row-1,'|');
      tg.setCharacter(col+2,row-1,'_');
      tg.setCharacter(col+3,row-1,'|');

      tg.setCharacter(col,row,'|');
      tg.setCharacter(col+1,row,'|');
    }

    if (type == 2) {
      placeCharacter(col-2,row-1,'|',tg);
      placeCharacter(col-1,row-1,'_',tg);
      placeCharacter(col,row-1,'|',tg);
      placeCharacter(col+1,row-1,'|',tg);
      placeCharacter(col+2,row-1,'_',tg);
      placeCharacter(col+3,row-1,'|',tg);

      tg.setCharacter(col,row,'|');
      tg.setCharacter(col+1,row,'|');
    }
  }

  /**
  * Undraws a cactus that will vary in size based on the constructed cactus.
  * @param col is the "x-value" of the left character of the cactus's base in a standard coordinate system.
  * @param row is the "y-value" of the left character of the cactus's legs in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */
  public void undraw(int col, int row, TextGraphics tg){
    if (type == 1){
      tg.setCharacter(col-3,row-2,' ');
      tg.setCharacter(col-1,row-2,' ');
      tg.setCharacter(col,row-2,' ');
      tg.setCharacter(col+1,row-2,' ');
      tg.setCharacter(col+2,row-2,' ');
      tg.setCharacter(col+4,row-2,' ');

      tg.setCharacter(col-2,row-1,' ');
      tg.setCharacter(col-1,row-1,' ');
      tg.setCharacter(col,row-1,' ');
      tg.setCharacter(col+1,row-1,' ');
      tg.setCharacter(col+2,row-1,' ');
      tg.setCharacter(col+3,row-1,' ');

      tg.setCharacter(col,row,'\u2581');
      tg.setCharacter(col+1,row,'\u2581');
    }

    if (type == 2) {
      tg.setCharacter(col-2,row-1,' ');
      tg.setCharacter(col-1,row-1,' ');
      tg.setCharacter(col,row-1,' ');
      tg.setCharacter(col+1,row-1,' ');
      tg.setCharacter(col+2,row-1,' ');
      tg.setCharacter(col+3,row-1,' ');

      tg.setCharacter(col,row,'\u2581');
      tg.setCharacter(col+1,row,'\u2581');
    }
  }
}
