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
		long temptime = 0;
		long tempend = 0;

		Dinosaur dino = new Dinosaur(1,1);
		Cactus cacto = new Cactus(3,8);
		boolean jumping = false;

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
			putString(1, 2, screen, "Score: " + millis / 100);
			putString(1, 3, screen, "temptime: " + temptime);
			putString(1, 4, screen, "tempend: " + tempend);
			putString(1, 5, screen, "jumping: " + jumping);

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

				if ((key.getKeyType() == KeyType.ArrowUp) && !jumping) {
					jumping = true;
					temptime = millis;
					tempend = temptime + 810;
					dino.temptime = temptime;
				}
			}

			if (!jumping) dino.draw(10,size.getRows()-3,tg);
			else {
				dino.jump(10,size.getRows()-3,millis,tg);
				if (millis >= tempend) {
					jumping = false;
				}
			}

			
			// Note: jump changes drawn position, has to keep drawing it at certain position for certain time.
			//       block user input while jump in progress.

			// Draws Dinosaur (gotta change location of this later to take into account jump time)

			screen.doResizeIfNecessary();
			screen.refresh();
		}
		screen.stopScreen();
	}

}
