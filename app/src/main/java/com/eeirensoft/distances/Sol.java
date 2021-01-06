package com.eeirensoft.distances;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewManager;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.Locale;

public class Sol extends AppCompatActivity {

    private RadioButton rb1, rb2;
    private ProgressBar pb;
    private RadioGroup rg;
    private TextView tv3, tv4, tv_ds, tv_dm, tv_dv;
    private Button btn;
    private pl.droidsonroids.gif.GifImageView gif1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sol);

        rb1 = (RadioButton) findViewById(R.id.radioButtonVL);
        rb2 = (RadioButton) findViewById(R.id.radioButtonMV);
        pb = (ProgressBar) findViewById(R.id.progressBarSol);
        rg = (RadioGroup) findViewById(R.id.radioGroupSol);
        tv3 = (TextView) findViewById(R.id.KM_R);
        tv_ds = (TextView) findViewById(R.id.tv_descSol);
        tv4 = (TextView) findViewById(R.id.selectVeloc);
        //tv_dm = (TextView) findViewById(R.id.tv_descMercury);
        //tv_dv = (TextView) findViewById(R.id.tv_descVen);
        btn = (Button)findViewById(R.id.irSol);
        gif1 = (pl.droidsonroids.gif.GifImageView) findViewById(R.id.traGif);

        //tv_dm.setVisibility(View.GONE);
        //tv_dv.setVisibility(View.GONE);
        gif1.setVisibility(View.GONE);
        tv_ds.setVisibility(View.GONE);

    }

    public void Calcular(View view) {

        Trayecto trayecto = new Trayecto();
        trayecto.execute();

    }


    //Clase que se encarga de ir llenado el progress bar dependiendo del tiempo que tarden en llegar.
    public class Trayecto extends AsyncTask<String, Void, String> {

        int j = 0;
        String jota;
        boolean flag = false;
        private ProgressDialog progreso;
        int distance=149597870;
        String S_distance, S_distance2;

        @Override
        protected String doInBackground(String... strings) {

        if (rb1.isChecked() == true) {

           for (j = 0; j <= 100; j++) {

              jota = String.valueOf(j);

               if (j == 0) {
                   runOnUiThread(new Runnable() {
                       public void run() {

                           tv4.setVisibility(View.GONE);
                           rg.setVisibility(View.GONE);
                           btn.setVisibility(View.GONE);
                       }
                   });
               }


               runOnUiThread(new Runnable() {
                   public void run() {
                       distance=distance-1495978;
                       S_distance2 = String.valueOf(distance);
                       S_distance = String.format("%,d", Integer.parseInt(S_distance2));
                       tv3.setText("Remaining Kilometers: "+S_distance);
                       gif1.setVisibility(View.VISIBLE);

                   }
               });

                SystemClock.sleep(5000);




                System.out.println("Ahora vales :: " + j);
                pb.setProgress(j);

               if (j == 1) {
                   runOnUiThread(new Runnable() {
                       public void run() {
                           //View v = (View) findViewById(R.id.radioGroupSol);
                           //((ViewManager)v.getParent()).removeView(v);
                           Toast.makeText(Sol.this, "Leaving the Earth", Toast.LENGTH_LONG).show();
                       }
                   });
               }

               if (j == 3) {
                   runOnUiThread(new Runnable() {
                       public void run() {
                           Toast.makeText(Sol.this, "Reaching full speed, the next Venus", Toast.LENGTH_LONG).show();
                       }
                   });
               }

                //Llegando a  138
               if (j == 5) {
                   runOnUiThread(new Runnable() {
                       public void run() {

                           if (Locale.getDefault().getDisplayLanguage() != "Spanish"){
                           Toast.makeText(Sol.this, "You're Reaching Venus", Toast.LENGTH_LONG).show();
                           //ImageView imageView = (ImageView)findViewById(R.id.imageView4);
                           //imageView.setImageResource(R.drawable.venus);


                           }
                           else{
                               Toast.makeText(Sol.this, "Estas Llegando a Venus", Toast.LENGTH_LONG).show();
                           }
                       }
                   });
               }

               //Llegando a Mercurio 308
               if (j == 308) {
                   runOnUiThread(new Runnable() {
                       public void run() {

                           if (Locale.getDefault().getDisplayLanguage() != "Spanish"){
                               Toast.makeText(Sol.this, "You're Reaching Mercury", Toast.LENGTH_SHORT).show();
                           }
                           else{
                               Toast.makeText(Sol.this, "Estas Llegando a Mercurio", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
               
               //lenado al Sol 499
               if (j == 499) {
                   runOnUiThread(new Runnable() {
                       public void run() {

                           if (Locale.getDefault().getDisplayLanguage() != "Spanish"){
                               Toast.makeText(Sol.this, "You're Reaching Sun", Toast.LENGTH_SHORT).show();
                           }
                           else{
                               Toast.makeText(Sol.this, "Estas Llegando al Sol", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }

           }
        }
        System.out.println("Tarea Finalizada. . . ");

        return null;
        }

        }

}