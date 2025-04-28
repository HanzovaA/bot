package com.example.myapplicationtest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputA, inputB, inputC;
    private Spinner spinnerOperator;
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        inputC = findViewById(R.id.inputC);
        spinnerOperator = findViewById(R.id.spinnerOperator);
        resultText = findViewById(R.id.resultText);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        Button btnReset = findViewById(R.id.btnReset);

        btnCalculate.setOnClickListener(v -> calculateQuadraticInequality());
        btnReset.setOnClickListener(v -> resetFields());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void calculateQuadraticInequality() {
        try {
            int a = Integer.parseInt(inputA.getText().toString());
            int b = Integer.parseInt(inputB.getText().toString());
            int c = Integer.parseInt(inputC.getText().toString());
            String operator = spinnerOperator.getSelectedItem().toString();

            double discriminant = b * b - 4 * a * c;
            String result;

            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2.0 * a);
                result = "Dvě kořenové intervaly: " + x1 + " a " + x2;
            } else if (discriminant == 0) {
                double x = -b / (2.0 * a);
                result = "Jeden kořen: " + x;
            } else {
                result = "Žádné reálné řešení";
            }

            resultText.setText(result);
        } catch (NumberFormatException e) {
            resultText.setText("Neplatné vstupy!");
        }
    }

    private void resetFields() {
        inputA.setText("");
        inputB.setText("");
        inputC.setText("");
        resultText.setText("Výsledek se zobrazí zde");
    }



}