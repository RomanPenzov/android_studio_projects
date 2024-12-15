package com.penzov.accessscorethisandstatic;

import android.util.Log;

public class AlienShip {
    private static int numShips;
    private int shieldStrength;
    public String shipName;

    public AlienShip() {
        numShips++;
        this.setShieldStrength(100);
    }

    public static int getNumShips() {
        return numShips;
    }

    private void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public int getShieldStrength() {
        return this.shieldStrength;
    }

    public void hitDetected() {
        shieldStrength -= 25;
        Log.i("Incomiming", "Bam!!");
        if (shieldStrength == 0) {
            destroyShip();
        }
    }

    private void destroyShip() {
        numShips--;
        Log.i("Explosion: ", " " + this.shipName + "destroyed");
    }
}
