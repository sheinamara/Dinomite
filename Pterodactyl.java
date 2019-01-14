import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Pterodactyl{
  public boolean gamestatus;
  public boolean drawn;
  public int xcor;
  public long temptime;
  private int timepass;

  /**
  * Creates a pterodactyl with a set speed and set height.
  * Speed is initialized to a default 3 spaces/sec.
  * Height is initialized to a default 5 spaces above the dinosaur's running surface.
  */
  public Pterodactyl(){
    drawn =  false;
    timepass = 0;
    gamestatus = true;
  }

  public void spawn(int row, long millis, TextGraphics tg) {
    if (millis >= temptime + (30 * timepass)) {
        undraw(xcor,row,tg);
        xcor -= 2;
        draw(xcor,row,tg);
        timepass += 1;
    }
    if (xcor <= 3) {
      drawn = false;
      undraw(xcor,row,tg);
    }
  }

  private void placeCharacter(int col, int row, char character, TextGraphics tg) {
    if (tg.getCharacter(col,row).getCharacter() != ' ') {
      gamestatus = false;
    }
    else {
      tg.setCharacter(col,row,character);
    }
  }

  /**
  * Draws a default pterodactyl.
  * @param col is the "x-value" of the head of the pterodactyl.
  * @param row is the "y-value" of the bottom wing of the pterodactyl.
  * @param tg is an instance from TextGraphics.
  */
  public void draw(int col, int row, TextGraphics tg){
    // top row
    placeCharacter(col+2,row-2,'_',tg);
    placeCharacter(col+3,row-2,'_',tg);
    placeCharacter(col+4,row-2,'_',tg);
    placeCharacter(col+5,row-2,'/',tg);
    placeCharacter(col+6,row-2,'\\',tg);
    placeCharacter(col+7,row-2,'_',tg);
    placeCharacter(col+8,row-2,'_',tg);
    placeCharacter(col+9,row-2,'_',tg);
    placeCharacter(col+10,row-2,'_',tg);
    placeCharacter(col+11,row-2,'_',tg);

    // middle row
    placeCharacter(col,row-1,'<',tg);
    placeCharacter(col+1,row-1,'=',tg);
    placeCharacter(col+2,row-1,'_',tg);
    placeCharacter(col+3,row-1,'_',tg);
    placeCharacter(col+4,row-1,'_',tg);
    placeCharacter(col+5,row-1,'_',tg);
    placeCharacter(col+8,row-1,'_',tg);
    placeCharacter(col+9,row-1,'_',tg);
    placeCharacter(col+10,row-1,'_',tg);
    placeCharacter(col+11,row-1,'<',tg);

    // bottom row
    placeCharacter(col+6,row,'\\',tg);
    placeCharacter(col+7,row,'/',tg);
  }

  public void undraw(int col, int row, TextGraphics tg){
    // top row
    tg.setCharacter(col+2,row-2,' ');
    tg.setCharacter(col+3,row-2,' ');
    tg.setCharacter(col+4,row-2,' ');
    tg.setCharacter(col+5,row-2,' ');
    tg.setCharacter(col+6,row-2,' ');
    tg.setCharacter(col+7,row-2,' ');
    tg.setCharacter(col+8,row-2,' ');
    tg.setCharacter(col+9,row-2,' ');
    tg.setCharacter(col+10,row-2,' ');
    tg.setCharacter(col+11,row-2,' ');

    // middle row
    tg.setCharacter(col,row-1,' ');
    tg.setCharacter(col+1,row-1,' ');
    tg.setCharacter(col+2,row-1,' ');
    tg.setCharacter(col+3,row-1,' ');
    tg.setCharacter(col+4,row-1,' ');
    tg.setCharacter(col+5,row-1,' ');
    tg.setCharacter(col+8,row-1,' ');
    tg.setCharacter(col+9,row-1,' ');
    tg.setCharacter(col+10,row-1,' ');
    tg.setCharacter(col+11,row-1,' ');

    // bottom row
    tg.setCharacter(col+6,row,' ');
    tg.setCharacter(col+7,row,' ');
  }
}
