package com.vicky.recursivebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int n = 1;
    protected LinearLayout linearLayout;
    public final Locale locale = new Locale("es", "ES");
    private final Random random = new Random();

    private int randomColor() {
        return random.nextInt(0xffffff + 1) + 0xff000000;
    }

    protected void onButtonClick() {
        Button newButton = new Button(this);

        int next = n++;
        switch (next) {
            case 1:
                newButton.setText("UNO!");
                break;
            case 23:
                newButton.setText("Oh no...");
                break;
            case 66:
                newButton.setText("Execute order 66");
                break;
            case 69:
                newButton.setText("Nice!");
                break;
            default:
                newButton.setText(String.format(locale, "Button %d", next));
        }

        if (next == 66) {
            newButton.setOnClickListener(v -> finish());
        } else {
            newButton.setOnClickListener(v -> onButtonClick());
        }

        newButton.getBackground().setColorFilter(randomColor(), PorterDuff.Mode.MULTIPLY);

        linearLayout.addView(newButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);

        onButtonClick();
    }
}