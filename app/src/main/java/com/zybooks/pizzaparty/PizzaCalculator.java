package com.zybooks.pizzaparty;

import static com.zybooks.pizzaparty.MainActivity.slices;

public class PizzaCalculator {

    public enum HungerLevel {
        LIGHT, MEDIUM, RAVENOUS
    }

    public final static int SLICES_PER_PIZZA = 8;

    private HungerLevel mHungerLevel;
    private int mPartySize;
    private int mPizzaSize;

    public PizzaCalculator(int partySize, HungerLevel level, int pizzaSize) {
        setHungerLevel(level);
        setPartySize(partySize);
        setPizzaSize(pizzaSize);
    }

    public HungerLevel getHungerLevel() {
        return mHungerLevel;
    }

    public void setHungerLevel(HungerLevel level) {
        mHungerLevel = level;
    }

    public int getPartySize() {
        return mPartySize;
    }

    public void setPartySize(int partySize) {
        if (partySize >= 0) {
            mPartySize = partySize;
        }
    }

    public void setPizzaSize(int pizzaSize) {
        pizzaSize = slices;
    }

    public int getPizzaSize() {
        return mPizzaSize;
    }

    public int getTotalPizzas() {
        int slicesPerPerson;
        if (mHungerLevel == HungerLevel.LIGHT) {
            slicesPerPerson = 2;
        }
        else if (mHungerLevel == HungerLevel.MEDIUM) {
            slicesPerPerson = 3;
        }
        else {
            slicesPerPerson = 4;
        }
        return (int) Math.ceil((mPartySize * slicesPerPerson) / (double) slices);
    }
}