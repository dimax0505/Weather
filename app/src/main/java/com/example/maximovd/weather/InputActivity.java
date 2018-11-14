package com.example.maximovd.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    private EditText editText;
    private Button saveBtn;

    static String dataKey = "dataForInputActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        initViews();
        setOnClickBtnBehaviour();
    }

    private void initViews() {
        editText = findViewById(R.id.inputEditText);
        saveBtn = findViewById(R.id.saveBtn);
    }

    private void setOnClickBtnBehaviour() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(dataKey, text);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
