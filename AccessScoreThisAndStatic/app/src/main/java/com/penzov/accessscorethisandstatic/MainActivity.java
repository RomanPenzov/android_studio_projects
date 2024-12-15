package com.penzov.accessscorethisandstatic;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AlienShip girlShip = new AlienShip();
        AlienShip boyShip = new AlienShip();

        Log.i("numShips", " " + AlienShip.getNumShips());
        girlShip.shipName = "Corrine Yu";
        boyShip.shipName = "Andre LaMothe";

        Log.i("girl shield: ", " " + girlShip.getShieldStrength());
        Log.i("boy shield: ", " " + boyShip.getShieldStrength());

        girlShip.hitDetected();
        Log.i("girl shield: ", " " + girlShip.getShieldStrength());
        Log.i("boy shield: ", " " + boyShip.getShieldStrength());

        boyShip.hitDetected();
        boyShip.hitDetected();
        boyShip.hitDetected();
        Log.i("girl shield: ", " " + girlShip.getShieldStrength());
        Log.i("boy shield: ", " " + boyShip.getShieldStrength());

        boyShip.hitDetected();
        Log.i("girl shield: ", " " + girlShip.getShieldStrength());
        Log.i("boy shield: ", " " + boyShip.getShieldStrength());

        Log.i("numShips: ", " " + AlienShip.getNumShips());



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}