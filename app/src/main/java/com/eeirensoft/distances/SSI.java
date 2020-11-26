package com.eeirensoft.distances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SSI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_s_i);
    }

    public void Sol(View view){

        Intent intent_Sol = new Intent(this,Sol.class);
        startActivity(intent_Sol);
    }


}