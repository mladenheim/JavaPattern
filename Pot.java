package com.company;

import java.util.ArrayList;

public class Pot implements Subject {
    public int getCoins() {
        return coins;
    }

    public void acceptCoin() {
        coins++;
    }

    public int yieldHalf() {
        int half = coins / 2;
        coins -= half;
        return half;
    }

    public int yieldAll() {
        int all = coins;
        coins = 0;
        anteUp();
        return all;
    }

    public void anteUp() {
        notifyObservers();
    }

    int coins = 40;
    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
