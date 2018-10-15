package com.example.maximovd.weather;

//        1. Запишите последовательности вызова методов при различных действиях пользователей: при запуске приложения, при переворачивании устройства, при нажатии кнопки «Домой»…
//        2. В activity погодного приложения создайте пользовательский интерфейс в виде вывода на экран погодных значений - просто захаркодить нужно какую-то погоду. Например, "Москва, 21 градус, ясно".
//        3. Запустите интерфейс на эмуляторе.
//        4. *Внесите изменения в приложение LifeCycle, чтобы сообщения о жизненном цикле выводились не только всплывающими сообщениями, но и в logcat.



import android.arch.lifecycle.Lifecycle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     private final String bundlekey = "bundle_key";
     TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);



        String instantState;
        if (savedInstanceState == null)
            instantState = getString(R.string.first_launch);
        else instantState = getString(R.string.relaunch);

        Toast.makeText(getApplicationContext(),instantState + " on Create", Toast.LENGTH_SHORT).show();
        Log.i("LifeCicle", "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
         Toast.makeText(getApplicationContext(),"on Start", Toast.LENGTH_SHORT).show();
        Log.i("LifeCicle", "onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(),"on RestoreInstanceState -  Повторный запуск.  " +
                "textView: " + savedInstanceState.getString(bundlekey,""), Toast.LENGTH_SHORT).show();
        Log.i("LifeCicle", "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
       Toast.makeText(getApplicationContext(),"on Resume", Toast.LENGTH_SHORT).show();
       Log.i("LifeCicle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"on Pause", Toast.LENGTH_SHORT).show();
        Log.i("LifeCicle", "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(bundlekey, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(),"on SaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.i("LifeCicle", "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"on Stop", Toast.LENGTH_SHORT).show();
        Log.i("LifeCicle", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"on Restart", Toast.LENGTH_SHORT).show();
        Log.i("LifeCicle", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"on Destroy", Toast.LENGTH_SHORT).show();
        Log.i("LifeCicle", "onDestroy");
    }
}
