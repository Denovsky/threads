package com.example.threads2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Button myRunnable1, myThread1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myRunnable1 = findViewById(R.id.myRunnable);
        myThread1 = findViewById(R.id.myThread);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myRunnable:
                    new MyRunnable();
        }
    }

    class MyRunnable implements Runnable {
        Thread thread;

        MyRunnable() {
            thread = new Thread();
            thread.start();
        }


        @Override
        public void run() {

        }
    }
}
