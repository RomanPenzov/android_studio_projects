package com.penzov.javameetui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View

        .OnClickListener {

    private int value = 0;

    private Button btnAdd;
    private Button btnTake;
    private TextView txtValue;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // свяжем объекты java с элементами xml-компоновки
        btnAdd = findViewById(R.id.btnAdd);
        btnTake = findViewById(R.id.btnTake);
        txtValue = findViewById(R.id.txtValue);
        btnGrow = findViewById(R.id.btnGrow);
        btnShrink = findViewById(R.id.btnShrink);
        btnReset = findViewById(R.id.btnReset);
        btnHide = findViewById(R.id.btnHide);

        // применим метод объекта java чтобы передать любые нажатия в метод onClick()
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        txtValue.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnHide.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        // здесь view родительский класс для Botton, TextView и ...
        float size;

        int id = view.getId();
        if (id == R.id.btnAdd) {
            value++;
            txtValue.setText("" + value);
        } else if (id == R.id.btnTake) {
            value--;
            txtValue.setText("" + value);
        } else if (id == R.id.btnReset) {
            value = 0;
            txtValue.setText("" + value);
        } else if (id == R.id.btnGrow) {
            size = txtValue.getTextScaleX(); // получаем горизон.масштаб текста
            txtValue.setTextScaleX(size + 1); // изменяем горизон.масштаб текста
        } else if (id == R.id.btnShrink) {
            size = txtValue.getTextScaleX(); // получаем горизон.масштаб текста
            txtValue.setTextScaleX(size - 1); // изменяем горизон.масштаб текста
        } else if (id == R.id.btnHide) {
            if (txtValue.getVisibility() == View.VISIBLE) {
                // в настоящее время текст виден, поэтому скройте его
                txtValue.setVisibility(View.INVISIBLE);

                // изменяет текст на кнопке
                btnHide.setText("SHOW");
            } else {
                // в настоящее время текст скрыт, поэтому покажите его
                txtValue.setVisibility(View.VISIBLE);

                // изменяет текст на кнопке
                btnHide.setText("HIDE");
            }
        }

//        // почему-то выходят ошибки на подобные ссылки R.id.btnAdd
//        switch (view.getId()) {
//            case R.id.btnAdd:
//                value++;
//                txtValue.setText("" + value);
//                break;
//
//            case R.id.btnTake:
//                value--;
//                txtValue.setText("" + value);
//                break;
//
//            case R.id.btnReset:
//                value = 0;
//                txtValue.setText("" + value);
//                break;
//
//            case R.id.btnGrow:
//                size = txtValue.getTextScaleX(); // получаем горизон.масштаб текста
//                txtValue.setTextScaleX(size + 1); // изменяем горизон.масштаб текста
//                break;
//
//            case R.id.btnShrink:
//                size = txtValue.getTextScaleX(); // получаем горизон.масштаб текста
//                txtValue.setTextScaleX(size - 1); // изменяем горизон.масштаб текста
//                break;
//
//            case R.id.btnHide:
//                if (txtValue.getVisibility() == View.VISIBLE) {
//                    // в настоящее время текст виден, поэтому скройте его
//                    txtValue.setVisibility(View.INVISIBLE);
//
//                    // изменяет текст на кнопке
//                    btnHide.setText("SHOW");
//                } else {
//                    // в настоящее время текст скрыт, поэтому покажите его
//                    txtValue.setVisibility(View.VISIBLE);
//
//                    // изменяет текст на кнопке
//                    btnHide.setText("HIDE");
//                }
//                break;
//
//        }
    }
}