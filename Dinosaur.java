import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Dinosaur{
  /**
  * Represents how much health a dinosaur has.
  * Colliding with an obstacle will make the health zero.
  * Zero health will cause the game to terminate.
  */
  private int health;

  /**
  * Represents how fast a dinosaur is.
  * Gradually, the speed will increase with time to increase the difficulty of the game.
  */
  private double speed;

  /**
  * Creates a dinosaur and intializes its health and speed.
  * @param health_ is a dinosaur's health.
  * @param speed_ is a dinosaur's speed.
  */
  public Dinosaur(int health_, double speed_){
    health = health_;
    speed = speed_;
  }

  /**
  * Gets the health of a dinosaur at any given time.
  * @return the health of a dinosaur.
  */
  public int getHealth(){
    return health;
  }

  /**
  * Gets the speed of a dinosaur at any given time.
  * @return the speed of a dinosaur.
  */
  public double getSpeed(){
    return speed;
  }

  /**
  * Draws a default diagram on the terminal from the head of a dinosaur.
  * @param col is the "x-value" of the first character of the dinosaur head in a standard coordinate system.
  * @param row is the "y-value" of the first character of the dinosaur head in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */
  public void draw(int col, int row, TextGraphics tg){
    // head
    tg.setCharacter(col,row,'[');
    tg.setCharacter(col+2,row,'-');
    tg.setCharacter(col+3,row,']');
    // neck
    tg.setCharacter(col,row-1,'/');
    tg.setCharacter(col+1,row-1,'/');
    // upper body
    tg.setCharacter(col-6,row-2,'\\');
    tg.setCharacter(col-5,row-2,'\\');
    tg.setCharacter(col-4,row-2,'[');
    tg.setCharacter(col-3,row-2,'-');
    tg.setCharacter(col-2,row-2,'-');
    tg.setCharacter(col-1,row-2,'-');
    tg.setCharacter(col,row-2,'-');
    tg.setCharacter(col+1,row-2,']');
    tg.setCharacter(col+2,row-2,'=');
    // lower body
    tg.setCharacter(col-4,row-3,'[');
    tg.setCharacter(col-3,row-3,'-');
    tg.setCharacter(col-2,row-3,'-');
    tg.setCharacter(col-1,row-3,'-');
    tg.setCharacter(col,row-3,'-');
    tg.setCharacter(col+1,row-3,']');
    // legs
    tg.setCharacter(col-3,row-4,'|');
    tg.setCharacter(col,row-4,'|');
  }

  public void jump(){
    
  }
}


