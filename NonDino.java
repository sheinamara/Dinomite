public abstract class NonDino{
  /**
  * Allows the user to know whether or not they are still alive.
  */
  public boolean status;

// NEED TO GENERALIZE THESE METHODS 
  /**
  * Creates the obstacle in the terminal and run them across the terminal.
  * @param col is the "x-value" of the head of the pterodactyl.
  * @param millis is a time variable.
  * @param tg is a variable used for the duckhead method.
  */
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
      gamestatus = false;
    }
    else {
      tg.setCharacter(col,row,character);
    }
  }
}
