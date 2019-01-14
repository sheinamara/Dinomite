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
1/8: Edited user input timing in World class.
1/9: Edits made in World class for user input.
1/10: Made huge progress. Created working user input pause and dinosaur drawing and undrawing. Crucial for game. Also edited Cactus class and implemented to World.
## Amara's Development Log
1/3: Created three classes.
1/4: Added javadoc to three classes and made the variables for each class. Began working on Dinosaur.java and completed the constructor and get methods.
1/7: Focusing on Dinosaur.java. Trying to draw the dinosaur via ASCII.
1/8: Successfully made the drawing method in the Dinosaur class. Dinosaur appears on terminal screen! Made a ducking method that needs to be tested and an unducking method that may or may not come into handy.
1/9: Started making Cactus class.
1/10: Finished drawing method for Pterodactyl. 
1/13: Adding documentation for all methods and making this README look pretty :))
 


