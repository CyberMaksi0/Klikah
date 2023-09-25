package com.example.klikah;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private boolean isNegativeMode = false;
    private TextView counterTextView;
    private Button incrementButton;
    private Button resetButton;
    private Switch switchMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counterTextView);
        incrementButton = findViewById(R.id.incrementButton);
        resetButton = findViewById(R.id.resetButton);
        switchMode = findViewById(R.id.switchMode);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNegativeMode) {
                    counter--;
                } else {
                    counter++;
                }
                updateCounterText();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                updateCounterText();
            }
        });

        switchMode.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNegativeMode = isChecked;
                updateCounterText();
                if (isChecked) {
                    switchMode.setText("Tryb ujemny");
                } else {
                    switchMode.setText("Tryb dodatni");
                }
            }
        });
    }

    private void updateCounterText() {
        counterTextView.setText(String.valueOf(counter));
    }
}
