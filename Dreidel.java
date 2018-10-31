package com.company;

import java.util.Random;

public enum Dreidel {
    NUN, GIMEL, HEH, SHIN;
    static Random r = new Random();
    static Dreidel []results = {NUN, GIMEL, HEH, SHIN};
    public static Dreidel spin() {
        return results[r.nextInt(4)];
    }
}