package com.vampires;

/**
 *
 * @author adamp
 */
public class Move {

    int north = 0;
    int south = 0;
    int east = 0;
    int west = 0;

    public Move(String command) {

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            String s=Character.toString(c);

            if (s.equals("w")){
                north++;
            }
            if (s.equals("a")){
                west++;
            }
            if (s.equals("s")){
                south++;
            }
            if (s.equals("d")){
                east++;
            }
        }
    }
}
