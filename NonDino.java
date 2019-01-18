public abstract class NonDino{
  /**
  * Allows the user to know whether or not they are still alive.
  */
  public boolean status;
  // ORIGINAL GAMESTATUS VARIABLE IS IN ABSTRACT CLASS NOW
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
  public int timepass;

  /**
  * Creates the obstacle in the terminal and run them across the terminal.
  * @param col is the "x-value" of the head of the pterodactyl.
  * @param millis is a time variable.
  * @param tg is a variable used for the duckhead method.
  */
  public void spawn(int row, int space, long millis, TextGraphics tg) {
    if (millis >= temptime + (30 * timepass)) {
        undraw(xcor,row,tg);
        xcor -= space;
        draw(xcor,row,tg);
        timepass += 1;
    }
    if (xcor <= 3) {
      drawn = false;
      undraw(xcor,row,tg);
    }
  }

  /**
  * Checks if there are any characters where it is placed.
  * If there are any, it sets the game status to false, ending the game.
  * Otherwise, characters remain to be placed.
  * @param col is the "x-value" of a specific character.
  * @param row is the "y-value" of a specific character.
  * @param char is the character we need to set something to.
  * @param tg is an instance from TextGraphics.
  */
  private void placeCharacter(int col, int row, char character, TextGraphics tg) {
    if (tg.getCharacter(col,row).getCharacter() != ' ') {
      status = false;
    }
    else {
      tg.setCharacter(col,row,character);
    }
  }
}
