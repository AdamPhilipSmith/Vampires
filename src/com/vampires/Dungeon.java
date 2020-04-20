
package com.vampires;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author adamp
 */
public class Dungeon {

    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private boolean isUnique = false;
    Player player = new Player(moves, 0, 0);
    int remainingVampires = vampires;


    ArrayList<Vampire> vampireStartList = new ArrayList<Vampire>();
    Boolean print = false;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVampires() {
        return vampires;
    }

    public void setVampires(int vampires) {
        this.vampires = vampires;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public boolean isVampiresMove() {
        return vampiresMove;
    }

    public void setVampiresMove(boolean vampiresMove) {
        this.vampiresMove = vampiresMove;
    }

    public void run() {
        vampireStartList.clear();
        double xRand = Math.random();
        double yRand = Math.random();
        Random ran = new Random();

        for (int i = 0; i < vampires; i++) {
            int randomX = ran.nextInt(length);
            int randomY = ran.nextInt(height);

            Vampire vampire = new Vampire(randomX, randomY);

            do {


                isUnique = true;

                if (vampire.getX() == 0 && vampire.getY() == 0) {
                    randomX = ran.nextInt(length);
                    randomY = ran.nextInt(height);
                    vampire.setX(randomX);
                    vampire.setY(randomY);
                }

                for (Vampire vampire2 : vampireStartList) {

                    if (vampire2.equals(vampire) || (vampire.getX() == 0 && vampire.getY() == 0)) {

                        randomX = ran.nextInt(length);
                        randomY = ran.nextInt(height);
                        vampire.setX(randomX);
                        vampire.setY(randomY);
                        isUnique = false;
                    }
                }
            } while (!isUnique);
            vampireStartList.add(vampire);
        }

        map();

    }

    public void map() {
        remainingVampires = vampires;
        Scanner reader = new Scanner(System.in);

        while (true) {
            if (vampireStartList.isEmpty()){
                System.out.println("YOU WIN");
                break;
            }
            if(moves== 0){
                System.out.println("YOU LOSE");
                break;
            }



            System.out.println("Torches Remaining:" + moves + "\n");

            System.out.println("Vampires Remaining:" + remainingVampires + "\n");

            //System.out.println("@ " + player.getX() + " " + player.getY());

            //for (Vampire vampire : vampireStartList) {
                //System.out.println("Vampi " + vampire.getX() + " " + vampire.getY());
            //}
            //System.out.println("");

            for (int x = 0; x < height; x++) {

                for (int y = 0; y < length; y++) {
                    print = true;
                    if (player.getY() == x && player.getX() == y) {
                        System.out.print("@");
                        print = false;

                    } else {
                        for (Vampire vampire : vampireStartList) {
                            if (vampire.getY() == x && vampire.getX() == y) {
                                System.out.print("v");
                                print = false;

                            }
                        }
                    }

                    if (print == true) {
                        System.out.print(".");

                    }

                }
                System.out.print("\n");
            }
            System.out.println("You are the '@' symbol. Move him with 'w, a, s or d' and then hit return.");
            String commands = reader.nextLine();
            move(commands);


        }


    }

    public void move(String command) {
        moves--;
        ArrayList<Vampire> dead = new ArrayList<Vampire>();
        Random ran = new Random();
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            String s = Character.toString(c);

            if (s.equals("w")) {
                if (player.getY() > 0) {
                    player.setY(player.getY() - 1);
                }
            }
            if (s.equals("a")) {
                if (player.getX() > 0) {
                    player.setX(player.getX() - 1);
                }
            }
            if (s.equals("s")) {
                if (player.getY() < height - 1) {
                    player.setY(player.getY() + 1);
                }
            }
            if (s.equals("d")) {
                if (player.getX() < length - 1) {
                    player.setX(player.getX() + 1);
                }
            }

            for (Vampire vampire : vampireStartList) {

                int direction = ran.nextInt(3);

                if (vampiresMove==true){
                    if (direction == 0 && vampire.getY() > 0) {
                        vampire.setY(vampire.getY() - 1);
                    }
                    if (direction == 1 && vampire.getX() > 0) {
                        vampire.setX(vampire.getX() - 1);
                    }
                    if (direction == 2 && vampire.getY() < height - 1) {
                        vampire.setY(vampire.getY() + 1);
                    }
                    if (direction == 3 && vampire.getX() < length - 1) {
                        vampire.setX(vampire.getX() + 1);
                    }
                }
                int playerX = player.getX();
                int playerY = player.getY();

                int vampX = vampire.getX();
                int vampY = vampire.getY();



                if (vampX == playerX && vampY == playerY){
                    dead.add(vampire);
                    remainingVampires --;
                }
            }



            vampireStartList.removeAll(dead);

        }

    }

    public void vampMove() {
        Random ran = new Random();


        for (Vampire vampire : vampireStartList) {

            int direction = ran.nextInt(3);


            if (direction == 0 && vampire.getY() > 0) {
                vampire.setY(vampire.getY() - 1);
            }
            if (direction == 1 && vampire.getX() > 0) {
                vampire.setX(vampire.getX() - 1);
            }
            if (direction == 2 && vampire.getY() < height - 1) {
                vampire.setY(vampire.getY() + 1);
            }
            if (direction == 3 && vampire.getX() < length - 1) {
                vampire.setX(vampire.getX() + 1);
            }



        }
    }
}
