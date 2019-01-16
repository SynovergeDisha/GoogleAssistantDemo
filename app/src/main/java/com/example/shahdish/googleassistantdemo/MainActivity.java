package com.example.shahdish.googleassistantdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnOpen;
    private EditText etEnterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnOpen = (Button) findViewById(R.id.act_main_btn);
        etEnterText = (EditText) findViewById(R.id.act_main_enter_text);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etEnterText.getText().length() > 0) {
                    String command = etEnterText.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.setClassName("com.google.android.googlequicksearchbox", "com.google.android.googlequicksearchbox.SearchActivity");
                    intent.putExtra("query", command);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //necessary if launching from Service
                    startActivity(intent);
                } else {
                    Intent launchIntent = new Intent(Intent.ACTION_VOICE_COMMAND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(launchIntent);
                }
            }
        });
    }
}
