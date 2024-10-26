package com.example.sukkotproject;

import android.graphics.Color;
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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int i = 0;
        String[] x = {"! Wow!", "!", "?", "?!", "...", "...?", " this", "? Sure!", "? No", "? Yes", "? Maybe"};
        Random r = new Random();
        TextView txt = findViewById(R.id.textView);
        txt.setText("");
        EditText hint = findViewById(R.id.Hint);
        Button changeTxt = findViewById(R.id.button);
        Button clr = findViewById(R.id.button2);
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while(i<3)
                {
                if(i == 0)
                {
                    txt.setTextColor(Color.RED);
                }
                else if(i == 1)
                {
                    txt.setTextColor(Color.BLUE);
                }
                else if(i == 2)
                {
                    txt.setTextColor(Color.BLACK);
                }
                }
            }
        });
        changeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et = hint.getText().toString();
                String x2 = x[r.nextInt(11)];
                txt.setText(et + x2);
            }
        });


    }
}