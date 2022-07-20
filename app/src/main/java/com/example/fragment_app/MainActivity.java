package com.example.fragment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start,stop,nextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=(Button) findViewById(R.id.buttonStart);
        stop=(Button) findViewById(R.id.buttonStop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        nextPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view== start){
            startService(new Intent(this,PlayerService.class));
        }else if(view ==stop){
            stopService(new Intent(this,PlayerService.class));
        }else if(view ==nextPage){
            Intent i=new Intent(getBaseContext(),MainActivity2.class);
            startActivity(i);
        }
    }
}