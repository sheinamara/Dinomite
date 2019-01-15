import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.awt.Color;

public interface Drawable{
  /**
  * Draws a shape from a specified reference frame that will depend based on preference.
  * @param col is the "x-value" of a specified character of said shape.
  * @param row is the "y-value" of a specified character of said shape
  * @param tg is an instance from TextGraphics.
  */
  void draw(int col, int row, TextGraphics tg);

  /**
  * Undraws a shape from a specified reference frame that will depend based on preference.
  * @param col is the "x-value" of a specified character of said shape.
  * @param row is the "y-value" of a specified character of said shape
  * @param tg is an instance from TextGraphics.
  */
  void undraw(int col, int row, TextGraphics tg);

}
