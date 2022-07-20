package com.example.fragment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextInput=findViewById(R.id.input);


    }

    public void startService(View v){
        String input =editTextInput.getText().toString();

        Intent serviceIntent=new Intent(this,NotificationService.class);
        serviceIntent.putExtra("EXTRA_INPUT",input);

        startService(serviceIntent);

    }
    public void stopService(View v){

        Intent serviceIntent=new Intent(this,NotificationService.class);
        stopService(serviceIntent);
    }
}