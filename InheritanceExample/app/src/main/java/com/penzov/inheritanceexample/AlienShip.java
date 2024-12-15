package com.penzov.inheritanceexample;

import android.util.Log;

public abstract class AlienShip {
    private static int numShips;
    private int shieldStrenght;
    public String shipName;

    public AlienShip(int shieldStrenght) {
        Log.i("Location", "AlienShip constructor");
        numShips++;
        setShieldStrenght(shieldStrenght);
    }

    public abstract void fireWeapon();

    public static int getNumShips() {
        return numShips;
    }

    private void setShieldStrenght(int shieldStrenght) {
        this.shieldStrenght = shieldStrenght;
    }

    public int getShieldStrenght() {
        return this.shieldStrenght;
    }

    public void hitDetected() {
        shieldStrenght -= 25;
        Log.i("Incomiming: ", "Bam!!");
        if (shieldStrenght == 0) {
            destroyShip();
        }
    }

    private void destroyShip() {
        numShips--;
        Log.i("Explosion: ", "" + this.shipName + " destroyed");
    }
}
