import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Pterodactyl extends NonDino implements Drawable {
  /*
  VARIABLES THAT ARE NOW IN NONDINO ABSTRACT CLASS:
  1. public boolean status (used to be gamestatus)
  2. public boolean drawn
  3. public int xcor
  4. public long temptime
  5. private int timepass
  */

  /**
  * Creates a pterodactyl with a set speed and set height.
  * Speed is initialized to a default 3 spaces/sec.
  * Height is initialized to a default 5 spaces above the dinosaur's running surface.
  */
  public Pterodactyl(){
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

  /**
  * Undraws a default pterodactyl.
  * @param col is the "x-value" of the head of the pterodactyl.
  * @param row is the "y-value" of the bottom wing of the pterodactyl.
  * @param tg is an instance from TextGraphics.
  */
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
