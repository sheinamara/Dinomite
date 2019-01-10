import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Pterodactyl{
  /**
  * Represents how fast a pterodactyl is.
  * The speed of a pterodactyl will remain constant because it is an obstacle.
  */
  private int speed;

  /**
  * Represents how high up for the dinosaur's running surface a pterodactyl is.
  * One unit is equivalent to one new line.
  */
  private int height;

  /**
  * Creates a pterodactyl with a set speed and set height.
  * Speed is initialized to a default 3 spaces/sec.
  * Height is initialized to a default 5 spaces above the dinosaur's running surface.
  */
  public Pterodactyl(){
    speed = 3;
    height = 5;
  }

  /**
  * Gets the speed of a pterodactyl at any given time.
  * @return the speed of a pterodactyl.
  */
  public int getSpeed(){
    return speed;
  }
  
  /**
  * Gets the height of a pterodactyl at any given time.
  * @return the height of a pterodactyl.
  */
  public int getHeight(){
    return height;
  } 

  /**
  * Draws a default pterodactyl.
  * @param col is the "x-value" of the head of the pterodactyl.
  * @param row is the "y-value" of the bottom wing of the pterodactyl.
  * @param tg is an instance from TextGraphics.
  */
  public void draw(int col, int row, TextGraphics tg){
    // middle row
    tg.setCharacter(col,row-1,'<');
    tg.setCharacter(col+1,row-1,'=');
    tg.setCharacter(col+2,row-1,'_');
    tg.setCharacter(col+3,row-1,'_');
    tg.setCharacter(col+4,row-1,'_');
    tg.setCharacter(col+5,row-1,'_');
    tg.setCharacter(col+8,row-1,'_');
    tg.setCharacter(col+9,row-1,'_');
    tg.setCharacter(col+10,row-1,'_');    
    tg.setCharacter(col+11,row-1,'<');
    
    // bottom row
    tg.setCharacter(col+6,row,'\\');
    tg.setCharacter(col+7,row,'/');

    // top row
    tg.setCharacter(col+2,row-2,'_');
    tg.setCharacter(col+3,row-2,'_');
    tg.setCharacter(col+4,row-2,'_'); 
    tg.setCharacter(col+5,row-2,'/');
    tg.setCharacter(col+6,row-2,'\\');
    tg.setCharacter(col+7,row-2,'_');
    tg.setCharacter(col+8,row-2,'_');
    tg.setCharacter(col+9,row-2,'_'); 
    tg.setCharacter(col+10,row-2,'_');
    tg.setCharacter(col+11,row-2,'_'); 
  }     
}
