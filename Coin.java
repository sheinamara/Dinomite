import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Coin{
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
  * A multiple that is multipled by an increasing integer to keep track of time passing.
  */
  private int timepass;

  /**
  * Default constructor for a Powerup.
  */
  public Coin(){
    drawn = false;
    timepass = 0;
  }

  
}
