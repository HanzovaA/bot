package com.skolakrizik.testohm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputVoltage, inputCurrent, inputResistance;
    private TextView resultText;
    private Button buttonCalculate, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputVoltage = findViewById(R.id.input_voltage);
        inputCurrent = findViewById(R.id.input_current);
        inputResistance = findViewById(R.id.input_resistance);
      //  resultText = findViewById(R.id.result_text);
        buttonCalculate = findViewById(R.id.button_calculate);
        buttonReset = findViewById(R.id.button_reset);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateOhmsLaw();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               resetFields();
            }
        });
    }

    private void calculateOhmsLaw() {
        String voltageStr = inputVoltage.getText().toString();
        String currentStr = inputCurrent.getText().toString();
        String resistanceStr = inputResistance.getText().toString();

        double voltage = voltageStr.isEmpty() ? Double.NaN : Double.parseDouble(voltageStr);
        double current = currentStr.isEmpty() ? Double.NaN : Double.parseDouble(currentStr);
        double resistance = resistanceStr.isEmpty() ? Double.NaN : Double.parseDouble(resistanceStr);

        if (Double.isNaN(voltage)) {
            if (!Double.isNaN(current) && !Double.isNaN(resistance)) {
                voltage = current * resistance;
                inputVoltage.setText(String.valueOf(voltage)+" V");
            }
        } else if (Double.isNaN(current)) {
            if (!Double.isNaN(voltage) && !Double.isNaN(resistance)) {
                current = voltage / resistance;
                inputCurrent.setText(String.valueOf(current)+" A");
            }
        } else if (Double.isNaN(resistance)) {
            if (!Double.isNaN(voltage) && !Double.isNaN(current)) {10
                resistance = voltage / current;
                inputResistance.setText(String.valueOf(resistance)+" Ω");
            }
        }

       /* resultText.setText("Napětí: " + voltage + " V\n" +
                "Proud: " + current + " A\n" +
                "Odpor: " + resistance + " Ω");*/
    }

    private void resetFields() {
        inputVoltage.setText("");
        inputCurrent.setText("");
        inputResistance.setText("");
        /*resultText.setText("Výsledek se zobrazí zde");*/
    }
}