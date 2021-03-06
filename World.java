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
		int gameinterface = 0;

		// Display
		Screen screen = new DefaultTerminalFactory().createScreen();
		screen.startScreen();
		TerminalSize size = screen.getTerminalSize();
		TextGraphics tg = screen.newTextGraphics();

		// Random
		int num = (int)(Math.random() * 10000);
		Random randgen = new Random(num);

		// Start Menu
		while (gameinterface == 0) {
			TerminalSize testsize = screen.getTerminalSize();
			if (testsize.getRows() != size.getRows() || testsize.getColumns() != size.getColumns()) {
				screen.clear();
				size = testsize;
			}
			putString(size.getColumns() / 2 - 14, size.getRows() / 2 - 3, screen, "WELCOME TO DESERT DINO DASH!");
			putString(size.getColumns() / 2 - 12, size.getRows() / 2 - 1, screen, "A TERMINAL-BASED GAME BY:");
			putString(size.getColumns() / 2 - 11, size.getRows() / 2, screen, "JEFF LIN & AMARA SHEIN");
			putString(size.getColumns() / 2 - 11, size.getRows() / 2 + 3, screen, "PRESS ANY KEY TO BEGIN");
			KeyStroke key = screen.pollInput();
			if (key != null) {
				if (key.getKeyType() == KeyType.Escape) {
					screen.clear();
					gameinterface = 2;
				}
				else {
					gameinterface = 1;
					screen.clear();
				}
			}
			screen.doResizeIfNecessary();
			screen.refresh();
		}

		while (gameinterface != 3) {

			// Score
			long score = 0;
			long extra = 0;

			// Clock
			long tStart = System.currentTimeMillis();
			long temptime = 0;
			long tempend = 0;
			long delay = 2000;

			// Dinosaur data
			int dinotype = Math.abs(randgen.nextInt() % 2);
			Dinosaur dino = new Dinosaur(dinotype + 1);
			boolean jumping = false;
			boolean ducking = false;

			// Cacti data
			Cactus cacto1 = new Cactus(1);
			Cactus cacto2 = new Cactus(2);
			Cactus cacto3 = new Cactus(1);
			Cactus cacto4 = new Cactus(2);
			Cactus cacto5 = new Cactus(1);
			Cactus cacto6 = new Cactus(2);
			Cactus[] cacti = new Cactus[6];
			cacti[0] = cacto1;
			cacti[1] = cacto2;
			cacti[2] = cacto3;
			cacti[3] = cacto4;
			cacti[4] = cacto5;
			cacti[5] = cacto6;

			// Pterodactyls data
			Pterodactyl flyboi1 = new Pterodactyl();
			Pterodactyl flyboi2 = new Pterodactyl();
			Pterodactyl flyboi3 = new Pterodactyl();
			Pterodactyl[] flyers = new Pterodactyl[3];
			flyers[0] = flyboi1;
			flyers[1] = flyboi2;
			flyers[2] = flyboi3;

			// Coin data
			Coin bling = new Coin();

			// Draws Floor
			tg.drawLine(0,size.getRows()-1,size.getColumns()-1,size.getRows()-1,'\u2571');
			tg.drawLine(0,size.getRows()-2,size.getColumns()-1,size.getRows()-2,'\u2571');
			tg.drawLine(0,size.getRows()-3,size.getColumns()-1,size.getRows()-3,'\u2581');

			while (gameinterface == 1) {

				// Score Keeping
				long tEnd = System.currentTimeMillis();
				long millis = tEnd - tStart;
				score = millis / 100;
				putString(1, 2, screen, "Score: " + (score + extra));
				/*
				putString(1, 3, screen, "temptime: " + temptime);
				putString(1, 4, screen, "tempend: " + tempend);
				putString(1, 5, screen, "jumping: " + jumping);
				putString(1, 6, screen, "ducking: " + ducking);
				*/

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
					if (key.getKeyType() == KeyType.Escape) gameinterface = 2;

					if ((key.getKeyType() == KeyType.ArrowUp) && !jumping && !ducking) {
						jumping = true;
						temptime = millis;
						tempend = temptime + 910;
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

				// Obstacle spawning
				int choice1 = Math.abs(randgen.nextInt() % 3);
				int choice2 = Math.abs(randgen.nextInt() % 6);
				int choice3 = Math.abs(randgen.nextInt() % 3);
				if (choice1 > 0) {
					Cactus drawthis = cacti[choice2];
					if (millis > delay && !drawthis.drawn) {
						drawthis.drawn = true;
						drawthis.temptime = millis;
						drawthis.xcor = size.getColumns()-5;
						delay = millis + 3000;
					}
					if (drawthis.drawn) {
						drawthis.spawn(size.getRows()-3,1,millis,tg);
						if (!drawthis.status) gameinterface = 2;
					}
				}
				if (choice1 == 0) {
					if (Math.abs(randgen.nextInt() % 4) == 0) {
						if (millis > delay && !bling.drawn) {
							bling.drawn = true;
							bling.temptime = millis;
							bling.xcor = size.getColumns()-5;
							delay = millis + 3000;
						}
						if (bling.drawn) {
							bling.spawn(size.getRows()-6,1,millis,tg);
							if (!bling.status) {
								bling.drawn = false;
								extra += 100;
							}
						}
					}
					else {
						Pterodactyl drawthis = flyers[choice3];
						if (millis > delay && !drawthis.drawn) {
							drawthis.drawn = true;
							drawthis.temptime = millis;
							drawthis.xcor = size.getColumns()-15;
							delay = millis + 3000;
						}
						if (drawthis.drawn) {
							drawthis.spawn(size.getRows()-6,2,millis,tg);
							if (!drawthis.status) gameinterface = 2;
						}
					}
				}

				screen.doResizeIfNecessary();
				screen.refresh();
			}

			screen.clear();

			// End Menu
			while (gameinterface == 2) {
				TerminalSize testsize = screen.getTerminalSize();
				if (testsize.getRows() != size.getRows() || testsize.getColumns() != size.getColumns()) {
					screen.clear();
					size = testsize;
				}

				String scorestring = "SCORE: " + score;
				putString(size.getColumns() / 2 - 4, size.getRows() / 2 - 3, screen, "GAME OVER");
				putString(size.getColumns() / 2 - scorestring.length() / 2, size.getRows() / 2 - 1, screen, scorestring);

				putString(size.getColumns() / 2 - 8, size.getRows() / 2 + 4, screen, "PRESS ESC TO QUIT");

				KeyStroke key = screen.pollInput();
				if (key != null) {
					if (key.getKeyType() == KeyType.Escape) System.exit(0);
					else {
						screen.clear();
						gameinterface = 1;
					}
				}

				screen.doResizeIfNecessary();
				screen.refresh();
			}
		}

		screen.stopScreen();
	}
}
