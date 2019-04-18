package com.example.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent i = getIntent();

        String[] info = i.getStringArrayExtra("info");

        TextView tv1 = findViewById(R.id.summary1);
        TextView tv2 = findViewById(R.id.summary2);
        TextView tv3 = findViewById(R.id.summary3);
        TextView tv4 = findViewById(R.id.summary4);

        tv1.setText("Read up on materials before class?: " + info[0]);
        tv2.setText("Arrive on time so as not to miss important part of the lesson?: " + info[1]);
        tv3.setText("Attempt the problem myself?: " + info[2]);
        tv4.setText("My personal reflection today: " + info[3]);

        Button close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
