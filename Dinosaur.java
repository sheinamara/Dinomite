import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public class Dinosaur implements Drawable{
  /**
  * The initial time input that is used as reference when timing the distance it travels or what happens to the obstacle.
  */
  public long temptime;

  /**
  * There are two types of dinosaurs: 1 indicates the default t-rex while 2 indicates a stegosaurus.
  */
  private int type;

  /**
  * The default constructor for a dinosaur.
  */
  public Dinosaur(int type_){
    type = type_;
  }

  /**
  * Draws a t-rex that is five units tall and ten units wide or a stegosaurus that is four units tall an eleven units wide.
  * @param col is the "x-value" of the left character of the dinosaur head in a standard coordinate system.
  * @param row is the "y-value" of the right leg of the dinosaur's legs in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */
  public void draw(int col, int row, TextGraphics tg){
    if (type == 1){
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
    if (type == 2){
      // legs
      tg.setCharacter(col+1,row,'|');
      tg.setCharacter(col,row,'_');
      tg.setCharacter(col-1,row,'|');
      tg.setCharacter(col-2,row,'|');
      tg.setCharacter(col-3,row,'_');
      tg.setCharacter(col-4,row,'|');
      // lower body
      tg.setCharacter(col-6,row-1,'/');
      tg.setCharacter(col-5,row-1,'(');
      tg.setCharacter(col-2,row-1,'(');
      tg.setCharacter(col+1,row-1,'|');
      // upper body
      tg.setCharacter(col+2,row-2,'/');
      tg.setCharacter(col+1,row-2,'/');
      tg.setCharacter(col,row-2,'_');
      tg.setCharacter(col-1,row-2,'_');
      tg.setCharacter(col-2,row-2,'_');
      tg.setCharacter(col-3,row-2,'_');
      tg.setCharacter(col-4,row-2,'_');
      tg.setCharacter(col-5,row-2,'_');
      // head
      tg.setCharacter(col+1,row-3,'/');
      tg.setCharacter(col+2,row-3,'-');
      tg.setCharacter(col+3,row-3,')');
    }
  }

  /**
  * Undraws a t-rex that is five units tall and ten units wide or a stegosaurus that is four units tall an eleven units wide.
  * @param col is the "x-value" of the left character of the dinosaur head in a standard coordinate system.
  * @param row is the "y-value" of the right leg of the dinosaur's legs in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */
  public void undraw(int col, int row, TextGraphics tg){
    if (type == 1){
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
    if (type == 2){
      // legs
      tg.setCharacter(col+1,row,' ');
      tg.setCharacter(col,row,' ');
      tg.setCharacter(col-1,row,' ');
      tg.setCharacter(col-2,row,' ');
      tg.setCharacter(col-3,row,' ');
      tg.setCharacter(col-4,row,' ');
      // lower body
      tg.setCharacter(col-6,row-1,' ');
      tg.setCharacter(col-5,row-1,' ');
      tg.setCharacter(col-2,row-1,' ');
      tg.setCharacter(col+1,row-1,' ');
      // upper body
      tg.setCharacter(col+2,row-2,' ');
      tg.setCharacter(col+1,row-2,' ');
      tg.setCharacter(col,row-2,' ');
      tg.setCharacter(col-1,row-2,' ');
      tg.setCharacter(col-2,row-2,' ');
      tg.setCharacter(col-3,row-2,' ');
      tg.setCharacter(col-4,row-2,' ');
      tg.setCharacter(col-5,row-2,' ');
      // head
      tg.setCharacter(col+1,row-3,' ');
      tg.setCharacter(col+2,row-3,' ');
      tg.setCharacter(col+3,row-3,' ');
    }
  }

  /**
  * Makes the dinosaur actually duck based on timing (0.8 second).
  * @param col is the "x-value" of the left character of the dinosaur head in a standard coordinate system.
  * @param row is the "y-value" of the right leg of the dinosaur's legs in a standard coordinate system.
  * @param millis is a time variable.
  * @param tg is an instance from TextGraphics.
  */
  public void duck(int col, int row, long millis, TextGraphics tg) {
    duckhead(col,row,tg);
    if (millis >= temptime + 800) {
      unduckhead(col,row,tg);
    }
  }

  /**
  * The drawing of a ducked dinosaur.
  * @param col is the "x-value" of the left character of the dinosaur head in a standard coordinate system.
  * @param row is the "y-value" of the right leg of the dinosaur's legs in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */
  public void duckhead(int col, int row, TextGraphics tg){
    if (type == 1){
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
    if (type == 2){
      // head DUCKED DOWN
      tg.setCharacter(col+3,row-1,'(');
      tg.setCharacter(col+4,row-1,'-');
      tg.setCharacter(col+5,row-1,')');
      // neck DUCKED DOWN
      tg.setCharacter(col+2,row-1,' ');
      // head original
      tg.setCharacter(col+1,row-3,' ');
      tg.setCharacter(col+2,row-3,' ');
      tg.setCharacter(col+3,row-3,' ');
      // neck original
      tg.setCharacter(col+2,row-2,' ');
      tg.setCharacter(col+1,row-2,' ');
    }
  }

  /**
  * The undraw of a ducked dinosaur.
  * @param col is the "x-value" of the left character of the dinosaur head in a standard coordinate system.
  * @param row is the "y-value" of the right leg of the dinosaur's legs in a standard coordinate system.
  * @param tg is an instance from TextGraphics.
  */
  public void unduckhead(int col, int row, TextGraphics tg){
    if (type == 1) {
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
    }
    if (type == 2) {
      // head DUCKED DOWN
      tg.setCharacter(col+3,row-1,' ');
      tg.setCharacter(col+4,row-1,' ');
      tg.setCharacter(col+5,row-1,' ');
      // neck DUCKED DOWN
      tg.setCharacter(col+2,row-1,' ');
      // head original
      tg.setCharacter(col+1,row-3,'/');
      tg.setCharacter(col+2,row-3,'-');
      tg.setCharacter(col+3,row-3,')');
      // neck original
      tg.setCharacter(col+2,row-2,'/');
      tg.setCharacter(col+1,row-2,'/');
    }
  }

  /**
  * Make the dinosaur actually jump based on time (0.9 second).
  * @param col is the "x-value" of the left character of the dinosaur head in a standard coordinate system.
  * @param row is the "y-value" of the right leg of the dinosaur's legs in a standard coordinate system.
  * @param millis is a time variable.
  * @param tg is an instance from TextGraphics.
  */
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
