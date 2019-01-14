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

  public long temptime;

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
  * Draws a default dinosaur that is five units tall and ten units wide.
  * @param col is the "x-value" of the left character of the dinosaur head in a standard coordinate system.
  * @param row is the "y-value" of the right leg of the dinosaur's legs in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */
  public void draw(int col, int row, TextGraphics tg){
    // head
    tg.setCharacter(col,row-4,'[');
    tg.setCharacter(col+2,row-4,'-');
    tg.setCharacter(col+3,row-4,']');
    // neck
    tg.setCharacter(col,row-3,'/');
    tg.setCharacter(col+1,row-3,'/');
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
    tg.setCharacter(col-4,row-1,'[');
    tg.setCharacter(col-3,row-1,'-');
    tg.setCharacter(col-2,row-1,'-');
    tg.setCharacter(col-1,row-1,'-');
    tg.setCharacter(col,row-1,'-');
    tg.setCharacter(col+1,row-1,']');
    // legs
    tg.setCharacter(col-3,row,'|');
    tg.setCharacter(col,row,'|');
  }

  public void undraw(int col, int row, TextGraphics tg){
    // head
    tg.setCharacter(col,row-4,' ');
    tg.setCharacter(col+2,row-4,' ');
    tg.setCharacter(col+3,row-4,' ');
    // neck
    tg.setCharacter(col,row-3,' ');
    tg.setCharacter(col+1,row-3,' ');
    // upper body
    tg.setCharacter(col-6,row-2,' ');
    tg.setCharacter(col-5,row-2,' ');
    tg.setCharacter(col-4,row-2,' ');
    tg.setCharacter(col-3,row-2,' ');
    tg.setCharacter(col-2,row-2,' ');
    tg.setCharacter(col-1,row-2,' ');
    tg.setCharacter(col,row-2,' ');
    tg.setCharacter(col+1,row-2,' ');
    tg.setCharacter(col+2,row-2,' ');
    // lower body
    tg.setCharacter(col-4,row-1,' ');
    tg.setCharacter(col-3,row-1,' ');
    tg.setCharacter(col-2,row-1,' ');
    tg.setCharacter(col-1,row-1,' ');
    tg.setCharacter(col,row-1,' ');
    tg.setCharacter(col+1,row-1,' ');
    // legs
    tg.setCharacter(col-3,row,' ');
    tg.setCharacter(col,row,' ');
  }

  public void duck(int col, int row, long millis, TextGraphics tg) {
    duckhead(col,row,tg);
    if (millis >= temptime + 800) {
      unduckhead(col,row,tg);
    }
  }

  public void duckhead(int col, int row, TextGraphics tg){
    // head DUCKED DOWN
    tg.setCharacter(col+4,row-2,'[');
    tg.setCharacter(col+5,row-2,'-');
    tg.setCharacter(col+6,row-2,']');
    // neck DUCKED DOWN
    tg.setCharacter(col+3,row-2,'=');
    // head original
    tg.setCharacter(col,row-4,' ');
    tg.setCharacter(col+2,row-4,' ');
    tg.setCharacter(col+3,row-4,' ');
    // neck original
    tg.setCharacter(col,row-3,' ');
    tg.setCharacter(col+1,row-3,' ');
  }

  public void unduckhead(int col, int row, TextGraphics tg){
    // head ducked down
    tg.setCharacter(col+4,row-2,' ');
    tg.setCharacter(col+5,row-2,' ');
    tg.setCharacter(col+6,row-2,' ');
    // neck ducked down
    tg.setCharacter(col+3,row-2,' ');
    // head original
    tg.setCharacter(col,row-4,'[');
    tg.setCharacter(col+2,row-4,'-');
    tg.setCharacter(col+3,row-4,']');
    // neck original
    tg.setCharacter(col,row-3,'/');
    tg.setCharacter(col+1,row-3,'/');
    // upper body
  }

  public void jump(int col, int row, long millis, TextGraphics tg) {
    if (millis >= temptime + 100 && millis <= temptime + 120) {
      undraw(col,row,tg);
      draw(col,row-4,tg);
    }
    if (millis >= temptime + 300 && millis <= temptime + 320) {
      undraw(col,row-4,tg);
      draw(col,row-7,tg);
    }
    if (millis >= temptime + 700 && millis <= temptime + 720) {
      undraw(col,row-7,tg);
      draw(col,row-4,tg);
    }
    if (millis >= temptime + 900) {
      undraw(col,row-4,tg);
      draw(col,row,tg);
    }
  }
}
