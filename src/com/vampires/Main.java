package com.vampires;

import java.util.Scanner;




public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        new Dungeon(15,8,9,14,true).run();

        String commands = reader.nextLine();

    }
}

