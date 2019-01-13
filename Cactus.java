import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Cactus{
  /**
  * Represents how tall a cactus is.
  * One unit is equivalent to one new line.
  */
  private int height;

  /**
  * Represents how wide a cactus is.
  * One unit is equivalent to one space.
  */
  private int width;

  public Cactus(int type){
    if (type == 1) {
      height = 3;
      width = 8;
    }
    if (type == 2) {
      height = 2;
      width = 6;
    }
  }

  /**
  * Gets the height of a cactus at any given time.
  * @return the height of a cactus.
  */
  public int getHeight(){
    return height;
  }

  /**
  * Gets the width of a cactus at any given time.
  * @return the width of a cactus.
  */
  public int getWidth(){
    return width;
  }

  /**
  * Draws a cactus that will vary in size based on the constructed cactus.
  * @param col is the "x-value" of the left character of the cactus's base in a standard coordinate system.
  * @param row is the "y-value" of the left character of the cactus's legs in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */
  public void draw(int col, int row, TextGraphics tg){
    if (height == 3 && width == 8){
      tg.setCharacter(col-3,row-2,'\\');
      tg.setCharacter(col-1,row-2,'|');
      tg.setCharacter(col,row-2,'|');
      tg.setCharacter(col+1,row-2,'|');
      tg.setCharacter(col+2,row-2,'|');
      tg.setCharacter(col+4,row-2,'/');

      tg.setCharacter(col-2,row-1,'|');
      tg.setCharacter(col-1,row-1,'_');
      tg.setCharacter(col,row-1,'|');
      tg.setCharacter(col+1,row-1,'|');
      tg.setCharacter(col+2,row-1,'_');
      tg.setCharacter(col+3,row-1,'|');

      tg.setCharacter(col,row,'|');
      tg.setCharacter(col+1,row,'|');
    }

    if (height == 2 && width == 6) {
      tg.setCharacter(col-2,row-1,'|');
      tg.setCharacter(col-1,row-1,'_');
      tg.setCharacter(col,row-1,'|');
      tg.setCharacter(col+1,row-1,'|');
      tg.setCharacter(col+2,row-1,'_');
      tg.setCharacter(col+3,row-1,'|');

      tg.setCharacter(col,row,'|');
      tg.setCharacter(col+1,row,'|');
    }
  }

  public void undraw(int col, int row, TextGraphics tg){
    if (height == 3 && width == 8){
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

      tg.setCharacter(col,row,' ');
      tg.setCharacter(col+1,row,' ');
    }

    if (height == 2 && width == 6) {
      tg.setCharacter(col-2,row-1,' ');
      tg.setCharacter(col-1,row-1,' ');
      tg.setCharacter(col,row-1,' ');
      tg.setCharacter(col+1,row-1,' ');
      tg.setCharacter(col+2,row-1,' ');
      tg.setCharacter(col+3,row-1,' ');

      tg.setCharacter(col,row,' ');
      tg.setCharacter(col+1,row,' ');
    }
  }


}
