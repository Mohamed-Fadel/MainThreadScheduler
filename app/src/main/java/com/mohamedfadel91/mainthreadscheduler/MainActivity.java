package com.mohamedfadel91.mainthreadscheduler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.mohamedfadel91.mainthreadschedulerlib.MainThreadScheduler;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edt_email);

        MainThreadScheduler.scheduleWhenIdle(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,
                        " " + edtEmail.getWidth(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
