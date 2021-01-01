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
import android.widget.Chronometer;
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
    private TextView tv;
    private TextView tv2;
    private ImageView  iv4;
    private RadioGroup rg;
    private TextView tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sol);

        rb1 = (RadioButton) findViewById(R.id.radioButtonVL);
        rb2 = (RadioButton) findViewById(R.id.radioButtonMV);
        pb = (ProgressBar) findViewById(R.id.progressBarSol);
        tv = (TextView) findViewById(R.id.viajandoSol);
        rg = (RadioGroup) findViewById(R.id.radioGroupSol);
        tv3 = (TextView) findViewById(R.id.KM_R);

    }

    public void Calcular(View view) {
        //499 segundos tardariamos en llegar al Sol desde la tierra a la velocidad de la luz.
        /*
        27 000 KM/h
        149 000 000
        149000000/27000=5518Hrs*60=33100*60=19,864,800
        */

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
        String S_distance;

        @Override
        protected String doInBackground(String... strings) {

        if (rb1.isChecked() == true) {

           for (j = 0; j <= 100; j++) {
              jota = String.valueOf(j);

               if (j == 0) {
                   runOnUiThread(new Runnable() {
                       public void run() {
                           tv.setText("Traveling . . .");
                           rg.setVisibility(View.GONE);
                       }
                   });
               }


              SystemClock.sleep(5000);


               runOnUiThread(new Runnable() {
                   public void run() {
                            distance=distance-1495978;
                            S_distance = String.valueOf(distance);
                            tv3.setText(S_distance+" km");
                       }
               });

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
                           tv.setText("Venus, the most earth-like planet in the solar system.");
                           ImageView imageView = (ImageView)findViewById(R.id.imageView4);
                           imageView.setImageResource(R.drawable.venus);


                           }
                           else{
                               Toast.makeText(Sol.this, "Estas Llegando a Venus", Toast.LENGTH_LONG).show();
                               tv.setText("Venus, El planeta mas parecido a la tierra en el sistema solar.");
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