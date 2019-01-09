import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.io.IOException;
import java.awt.Color;


public class World {

	public static void putString(int x, int y, Screen screen, String str) {
		for (int i = 0; i < str.length(); ++i) {
			screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
		}
	}

	public static void main(String[] args) throws IOException {

		Screen screen = new DefaultTerminalFactory().createScreen();
		screen.startScreen();

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;
		long temptime = 0;

		Dinosaur dino = new Dinosaur(1,1);
		boolean pauseInput = false;

		// Draws Floor
		TerminalSize size = screen.getTerminalSize();
		TextGraphics tg = screen.newTextGraphics();
		tg.drawLine(0,size.getRows()-1,size.getColumns()-1,size.getRows()-1,'\u2571');
		tg.drawLine(0,size.getRows()-2,size.getColumns()-1,size.getRows()-2,'\u2571');
		tg.drawLine(0,size.getRows()-3,size.getColumns()-1,size.getRows()-3,'\u2581');

		while (true) {

			// Score Keeping
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			putString(1, 2, screen, "Score: "+ millis / 100);
			screen.doResizeIfNecessary();
			screen.refresh();

			// Resize World and Game
			TerminalSize testsize = screen.getTerminalSize();
			if (testsize.getRows() != size.getRows() || testsize.getColumns() != size.getColumns()) {
				screen.clear();
				size = testsize;
				tg.drawLine(0,size.getRows()-1,size.getColumns()-1,size.getRows()-1,'\u2571');
				tg.drawLine(0,size.getRows()-2,size.getColumns()-1,size.getRows()-2,'\u2571');
				tg.drawLine(0,size.getRows()-3,size.getColumns()-1,size.getRows()-3,'\u2581');
			}

			// User Input
			KeyStroke key = screen.pollInput();
			if (key != null) {
				if (key.getKeyType() == KeyType.Escape) break;

				if (key.getKeyType() == KeyType.ArrowUp && !pauseInput) {
					dino.jump();
					pauseInput = false;
					temptime = millis / 100;
				}
			}

			// Time check for jump
			if (millis / 100 >= temptime + 15) pauseInput = true;

			// Note: jump changes drawn position, has to keep drawing it at certain position for certain time.
			//       block user input while jump in progress.

			// Draws Dinosaur (gotta change location of this later to take into account jump time)
			dino.draw(10,size.getRows()-3,tg);
		}
		screen.stopScreen();
	}

}
