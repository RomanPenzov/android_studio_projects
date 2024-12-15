package com.penzov.widgetexploration;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.button);
        final TextClock tClock = findViewById(R.id.textClock);
        final CheckBox cbTransparency = findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint = findViewById(R.id.checkBoxTint);
        final CheckBox cbReSize = findViewById(R.id.checkBoxResize);
        final ImageView imageView = findViewById(R.id.imageView);
        Switch switch1 = findViewById(R.id.switch1);
        final TextView textView = findViewById(R.id.textView);

        //прячем TextView при запуске
        textView.setVisibility(View.INVISIBLE);

        // код по чекбоксам
        // слушаем нажатия на кнопку, на чекбоксы и радиокнопки

        //сначала устанавливаем чекбоксы с помощью аноноимного класса
        cbTransparency.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (cbTransparency.isChecked()) {
                            // устанавливаем прозрачность
                            imageView.setAlpha(.1f);
                        } else {
                            imageView.setAlpha(1f);
                        }

                    }
                }
        );

        // следующий чекбокс
        cbTint.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (cbTint.isChecked()) {
                            // при true даем цвет
                            imageView.setColorFilter(Color.argb(150, 255, 0, 0));
                        } else {
                            // цвет не нужен
                            imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                        }

                    }
                }
        );

        // по третьему чекбоксу изменение размера
        cbReSize.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (cbReSize.isChecked()) {
                            // увеличиваем
                            imageView.setScaleX(2);
                            imageView.setScaleY(2);
                        } else {
                            imageView.setScaleX(1);
                            imageView.setScaleY(1);
                        }

                    }
                }
        );

        // теперь радиокнопки
        // снимаем отметки со всех кнопок
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton rb = group.findViewById(checkedId);
                        if (rb.getId() == R.id.radioButtonLondon) {
                            tClock.setTimeZone("Europe/London");
                        } else if (rb.getId() == R.id.radioButtonBeijing) {
                            tClock.setTimeZone("Etc/GMT-8");
                        } else if (rb.getId() == R.id.radioButtonNewYork) {
                            tClock.setTimeZone("America/New_York");
                        }
                    }
                }
        );

        // теперь кнопка Button
        // слушаем нажатия кнопки через анонимный класс
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // без if-else или switch, т.к. кнопка одна - выбор не нужен
                        //изменяем текст в TextView на то, что в EditText
                        textView.setText(editText.getText());
                    }
                }
        );

        // теперь по Switch
        // показать/скрыть TextView
        switch1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            textView.setVisibility(View.VISIBLE);
                        } else {
                            textView.setVisibility(View.INVISIBLE);
                        }

                    }
                }
        );

        // теперь по виджету WebView
        // в файле manifest надо включить разрешение INTERNET
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("https://gamecodeschool.com");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}