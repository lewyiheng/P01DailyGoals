package com.example.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn;
        btn = findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup grp1 = findViewById(R.id.radioGroup1);
                RadioGroup grp2 = findViewById(R.id.radioGroup2);
                RadioGroup grp3 = findViewById(R.id.radioGroup3);
                EditText reflect = findViewById(R.id.reflection);

                //Get checked ID
                int selectedButtonId1 = grp1.getCheckedRadioButtonId();
                int selectedButtonId2 = grp2.getCheckedRadioButtonId();
                int selectedButtonId3 = grp3.getCheckedRadioButtonId();

                RadioButton rb1 = findViewById(selectedButtonId1);
                RadioButton rb2 = findViewById(selectedButtonId2);
                RadioButton rb3 = findViewById(selectedButtonId3);

                //Array
                String[] info = {rb1.getText().toString(), rb2.getText().toString(), rb3.getText().toString(), reflect.getText().toString()};
                //Parse info to summary.java
                Intent i = new Intent(MainActivity.this,Summary.class);

                i.putExtra("info",info);

                startActivity(i);

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("radio1", grp1.getCheckedRadioButtonId());
                editor.putInt("radio2", grp2.getCheckedRadioButtonId());
                editor.putInt("radio3", grp3.getCheckedRadioButtonId());
                editor.putString("reflection",reflect.getText().toString());
                editor.commit();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        int radio1 = prefs.getInt("radio1",1);
        int radio2 = prefs.getInt("radio2",1);
        int radio3 = prefs.getInt("radio3", 1);
        String reflect1 = prefs.getString("reflection","");

        RadioGroup grp1 = findViewById(R.id.radioGroup1);
        RadioGroup grp2 = findViewById(R.id.radioGroup2);
        RadioGroup grp3 = findViewById(R.id.radioGroup3);
        EditText reflect = findViewById(R.id.reflection);

        grp1.check(radio1);
        grp2.check(radio2);
        grp3.check(radio3);
        reflect.setText(reflect1);
    }
}



