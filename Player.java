package com.company;

import java.util.Comparator;

public class Player implements Comparable<Player>, Observer{
    public Player(Pot p) {
        pot = p;
        coins = 10;
        p.registerObserver(this);
    }
    public int getCoins() {
        return coins;
    }

    public void contributeCoin() {
        if (coins > 0) {
            pot.acceptCoin();
            coins--;
        }
    }

    public void collectHalf() {
        coins += pot.yieldHalf();
    }

    public void collectAll() {
        coins += pot.yieldAll();
    }

    int coins;
    Pot pot;

    @Override
    public int compareTo(Player other) {
        if (coins  < other.coins)
            return -1;
        else if (coins > other.coins)
            return 1;
        else
            return 0;
    }

    @Override
    public void update() {
        contributeCoin();
    }
}
