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

  public void draw(int col, int row, TextGraphics tg) {
    tg.setCharacter(col,row,'\u058E');
  }

  public void jump(){
  }
}
