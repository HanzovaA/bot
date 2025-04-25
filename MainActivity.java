
package com.example.pocitadlo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView counterText = findViewById(R.id.counterText);
        Button plusBtn = findViewById(R.id.plusButton);
        Button minusBtn = findViewById(R.id.minusButton);
        Button resetBtn = findViewById(R.id.resetButton);

        plusBtn.setOnClickListener(v -> counterText.setText(String.valueOf(++counter)));
        minusBtn.setOnClickListener(v -> counterText.setText(String.valueOf(--counter)));
        resetBtn.setOnClickListener(v -> {
            counter = 0;
            counterText.setText(String.valueOf(counter));
        });
    }
}
