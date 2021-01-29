package com.example.threads2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.AsyncTask;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button start_treads1, another_activity1, start_timer1;
    TextView timer_block1;
    ConstraintLayout lay1;
    Timer mTimer;
    MyTimerTask mMyTimerTask;
    Random random;
    MyTask mTask;
    String count_str;
    int count, num;
    int colors[] = {Color.RED, Color.BLUE, Color.GREEN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // кнопки
        start_treads1 = findViewById(R.id.start_treads);
        another_activity1 = findViewById(R.id.another_activity);
        start_timer1 = findViewById(R.id.start_timer);
        // текстовый блок
        timer_block1 = findViewById(R.id.timer_block);
        // фон
        lay1 = findViewById(R.id.lay);
        // клики
        start_treads1.setOnClickListener(this);
        another_activity1.setOnClickListener(this);
        start_timer1.setOnClickListener(this);
    }

    // функции кнопок
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_timer:
                if (mTimer != null) {
                    mTimer.cancel();
                    count = 0;
                    mTimer = null;
                    timer_block1.setText("Таймер: " + count);
                    lay1.setBackgroundColor(Color.WHITE);
                }
                else {
                    mTimer = new Timer();
                    mMyTimerTask = new MyTimerTask();
                    mTimer.schedule(mMyTimerTask, 1000, 1000);
                }
                break;
            case R.id.start_treads:
                mTask = new MyTask();
                mTask.execute();
                break;
            case R.id.another_activity:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }

    // действия таймера
    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            random = new Random();
            num = random.nextInt(3);
            count = count + 1;
            count_str = Integer.toString(count);

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    timer_block1.setText("Таймер: " + count);
                    if (count % 3 == 0){
                        lay1.setBackgroundColor(colors[num]);
                    }
                    else {
                        lay1.setBackgroundColor(Color.WHITE);
                    }
                }
            });
        }
    }

    class MyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // space
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // space
        }
    }
}


