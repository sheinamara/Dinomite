import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.io.IOException;
import java.awt.Color;
import java.util.*;
import java.io.*;


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

		// Dinosaur data
		Dinosaur dino = new Dinosaur(1,1);
		boolean jumping = false;
		boolean ducking = false;

		// Cacti data
		Cactus cacto1 = new Cactus(1);
		Cactus cacto2 = new Cactus(2);
		Cactus cacto3 = cacto1;
		Cactus cacto4 = cacto2;
		Object[] obstacles = new Object[4];
		obstacles[0] = cacto1;
		obstacles[1] = cacto2;
		obstacles[2] = cacto3;
		obstacles[3] = cacto4;

		int num = (int)(Math.random() * 10000);
		Random randgen = new Random(num);

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
			putString(1, 6, screen, "ducking: " + ducking);
			putString(1, 7, screen, "random: " + num);

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

				if ((key.getKeyType() == KeyType.ArrowUp) && !jumping && !ducking) {
					jumping = true;
					temptime = millis;
					tempend = temptime + 810;
					dino.temptime = temptime;
				}

				if ((key.getKeyType() == KeyType.ArrowDown) && !jumping && !ducking) {
					ducking = true;
					temptime = millis;
					tempend = temptime + 810;
					dino.temptime = temptime;
				}
			}

			// Check motion of dinosaur
			if (!jumping && !ducking) dino.draw(15,size.getRows()-3,tg);
			else {
				if (jumping) {
					dino.jump(15,size.getRows()-3,millis,tg);
					if (millis >= tempend) {
						jumping = false;
					}
				}
				if (ducking) {
					dino.duck(15,size.getRows()-3,millis,tg);
					if (millis >= tempend) {
						ducking = false;
					}
				}
			}

			int choice = Math.abs(randgen.nextInt() % 2);

			
			if (!cacto1.drawn) {
				cacto1.drawn = true;
				cacto1.temptime = millis;
				cacto1.xcor = 70;
			}
			if (cacto1.drawn) {
				cacto1.spawn(size.getRows()-3,millis,tg);
			}


			screen.doResizeIfNecessary();
			screen.refresh();
		}
		screen.stopScreen();
	}

}
