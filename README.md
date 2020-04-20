# Vampires

<b>Summary:</b>
Simple text based game where you have to kill all the vampires before your torch runs out. 

![image](https://user-images.githubusercontent.com/47950278/79784770-a488ec00-833a-11ea-8e11-132e1036e3bf.png)

<b>Technologies Used:</b>
Coded in Java. 

<b>Status:</b>
In progress.

<b>To Do:</b>
Add menu functionality.
Add more games modes.
Refactor, maybe use Inheritance?

<b>To Run:</b>
Runs in any IDE that can run Java, simply run as a Java App and it runs from the console. Length and Height of the board can be chosen in the Main class where the new Dungeon() is called. Lives and number of vampires are also chosen here. Vampires can also be made stationary by choosing False in the final parameter.

<b>To Play:</b>
Your character is represented by '@'. Vampires are 'v'. To kill a vampire you need to move your character on top of one of them. The vampires move around the map at random. Moves are made by pressing w(up), s(down), a(left) and (d)right and then hitting Enter. Whenever you look at the map you use up a torch. If all torches run out, you die. You can move multiple times in a turn by queueing up a list of commands and then hitting Enter. This will still only count as one loss from your torch and any vampires you cross paths with during the move will die.
