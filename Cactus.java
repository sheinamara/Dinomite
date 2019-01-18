import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Cactus extends NonDino implements Drawable {
  /*
  VARIABLES THAT ARE NOW IN NONDINO ABSTRACT CLASS:
  1. public boolean status (used to be gamestatus)
  2. public boolean drawn
  3. public int xcor
  4. public long temptime
  5. private int timepass
  */

  /**
  * There are two types of cacti: 1 indicates a big one while 2 indicates a small one.
  */
  private int type;

  /**
  * The default constructor for a cactus.
  * @param type_ indicates the type of cactus.
  */
  public Cactus(int type_){
    type = type_;
    drawn =  false;
    timepass = 0;
    status = true;
  }

  /*
  METHODS THAT ARE NOW IN NONDINO ABSTRACT CLASS:
  1. public void spawn(int, int, long, TextGraphics)
  2. public void placeCharacter(int, int, char, TextGraphics)
  */

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
