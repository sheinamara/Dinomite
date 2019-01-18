# Dinomite
Based on the Google Chrome offline game, **Desert Dino Dash** is a single-player game that uses the arrow keys to have a dinosaur avoid obstacles. For our demo version, we have included all of the basic features of the original game. After the user compiles and runs the game, the score counting begins. The **T-Rex** is running on a horizontally scrolling screen and has to **jump** and/or **duck** to avoid **cacti** and **pterodactyls**. 
We used simple **ASCII** characters to recreate the figures needed. Because this is a terminal based game and we are using Java, we used **Lantera**, a library that allowed us to write easy semi-graphical user interfaces in a text-only environment.
## Instructions
### Linux and iOs 
1. Open your terminal.
2. Compile by using `javac -cp lanterna.jar:. World.java`.
3. Run by using `java -cp lanterna.jar:. World`.
4. Use your up arrow key to jump.
5. Use your down arrow key to duck.
6. Survive!
### Windows
1. Open your terminal.
2. Compile by using `javac -cp "lantera.jar;." World.java`.
3. Run by using `java -cp "lantera.jar;." World`.
4. Use your up arrow key to jump.
5. Use your down arrow key to duck.
6. Survive!
## Jeff's Development Log
1/3: Review terminal manipulation and make changes to fit our game.

1/6: Made class World implementing Lanterna 3.0. Created basic game interface, edited Dinosaur class, and implemented into World.

1/7: Edited World class's interaction with Dinosaur.

1/8: Started creating functioning of user input in World class.

1/9: Edited user input in World class.

1/10: HUGE PROGRESS: Finished user input and dinosaur drawing and undrawing. Edited Cactus class and implemented into World.

1/13: Finished functioning of Dinosaur, Cactus, Pterodactyl, and implemented all into World. Created start and end menus for presentability.

1/16: DEMO!!! Discussed next steps in class and the implementation of a NonDino abstract class.

1/17: Made edits to prototype and remade UML diagram for submission.

1/18: Rearranged methods and variables from classes to abstract superclass NonDino.

## Amara's Development Log
1/3: Created three classes.

1/4: Added javadoc to three classes and made the variables for each class. Began working on Dinosaur class and completed the constructor and get methods for all. 

1/7: Focusing on Dinosaur class before trying other classes. Trying to draw the dinosaur via ASCII.

1/8: Successfully made the drawing method in the Dinosaur class. Dinosaur appears on terminal screen! Made a ducking method that needs to be tested and an unducking method that may or may not come into handy.

1/9: Started making Cactus class. Figured out ASCII drawing for Cactus and Pterodactyl.

1/10: Finished Cactus class. Finished drawing method for Pterodactyl. 

1/13: Adding documentation for all methods and making this README look pretty :)) Finished javadoc for Dinosaur, Cactus, and Pterodactyl classes.

1/15: Created a Coin class and Drawable interface that was implemented by all current Drawable classes.

1/16: DEMO!!! Discussed next steps in class and the implementation of a NonDino abstract class.

1/17: Began creating and extending the abstract class that we discussed in detail from yesterday.
 


