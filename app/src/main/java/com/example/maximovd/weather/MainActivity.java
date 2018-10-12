package com.example.maximovd.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IGreetingStrings {
    private TextView greetengText;
    private TextView time;
   private GreetingStringBuilder builder = new GreetingStringBuilder(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGreeting();
        initTime();
        setTextByTime();
        showTime();
    }

    private void initGreeting() {
        greetengText = findViewById(R.id.timeGreeting);
    }

    private void initTime() {
        time = findViewById(R.id.timePrefix);
    }

    private void setTextByTime () {
       // GreetingStringBuilder builder = new GreetingStringBuilder(this);
        String text = builder.getText();
        greetengText.setText(text);

    }

    private void showTime () {
        String timeText = builder.getTime();
        time.setText(timeText);
    }

    @Override
    public String getTimePrefix() {
        return getString(R.string.timePrefix);
    }

    @Override
    public String getMorning() {
       return getString(R.string.helloMorning);
    }

    @Override
    public String getAfternoon() {
        return getString(R.string.helloDay);
    }

    @Override
    public String getEvening() {
        return getString(R.string.helloEvening);
    }

    @Override
    public String getNight() {
        return getString(R.string.helloNight);
    }
}
