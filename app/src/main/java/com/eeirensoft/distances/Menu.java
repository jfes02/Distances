package com.eeirensoft.distances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void SistemaSolarInterior(View view){

        Intent intent_SSI = new Intent(Menu.this,SSI.class);
        startActivity(intent_SSI);
    }

}