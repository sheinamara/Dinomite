import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Cactus{

  public boolean drawn;
  public int xcor;
  public long temptime;
  public int type;
  private int timepass;

  public Cactus(int type_){
    type = type_;
    drawn =  false;
    timepass = 0;
  }

  /**
  * Draws a cactus that will vary in size based on the constructed cactus.
  * @param col is the "x-value" of the left character of the cactus's base in a standard coordinate system.
  * @param row is the "y-value" of the left character of the cactus's legs in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */

  public void spawn(int row, long millis, TextGraphics tg) {
    if (millis >= temptime + (30 * timepass)) {
        undraw(xcor,row,tg);
        xcor -= 1;
        draw(xcor,row,tg);
        timepass += 1;
    }
    if (xcor == -5) drawn = false;
  }

  public void draw(int col, int row, TextGraphics tg){
    if (type == 1){
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

    if (type == 2) {
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
