package com.ahmetozdemir.countdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        //onCreate altında app başladığı gibi sayaç başlar.
        new CountDownTimer(10000, 1000) //Bir saniye 1000 milisaniye olur. Yani bu sayaç 10'dan geriye saniyede 1 sayar.
        {
            //Bu iki metod CountDownTimer'ın içinde kesinlikle her zaman olmalı!
            @Override
            public void onTick(long millisUntilFinished) //Her 1000 milisaniyede ne yapayım? Hangi saniyedeyiz = millisUntilFinished
            {
                 textView.setText("Left : " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() //Sayaç sona erdiğinde ne yapayım?
            {
                Toast.makeText(getApplicationContext(), "DONE!", Toast.LENGTH_LONG).show();
                textView.setText("Time is up means time is up Essmaa!\n\n" + "~ Coşkun Yaşar");
            }
        }.start();
    }
}