package com.eeirensoft.distances;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Sol extends AppCompatActivity {

    private RadioButton rb1, rb2;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sol);

        rb1 = (RadioButton)findViewById(R.id.radioButtonVL);
        rb2 = (RadioButton)findViewById(R.id.radioButtonMV);
        pb = (ProgressBar)findViewById(R.id.progressBarSol);

    }

    public void Calcular (View view) {

        //499 segundos tardariamos en llegar al Sol desde la tierra a la velocidad de la luz.
        /*
        27 000 KM/h
        149 000 000
        149000000/27000=5518Hrs*60=33100*60=19,864,800
        */

        Trayecto trayecto =  new Trayecto();
        trayecto.execute();
    }


    //Clase que se encarga de ir llenado el progress bar dependiendo del tiempo que tarden en llegar.
    public class Trayecto extends AsyncTask <String, Void, String>{

        int j=0;
        String jota;

        @Override
        protected String doInBackground(String... strings) {

            if (rb1.isChecked()==true) {

                for (j=0; j<=50; j++){
                    jota = String.valueOf(j);
                    SystemClock.sleep(1000);
                    System.out.println("Ahora vales :: " +j);
                    pb.setProgress(j);
                }

                System.out.println("Tarea Finalizada. . . ");
                //Toast.makeText(this,"RB1",Toast.LENGTH_SHORT).show();
            }
            return null;
        }
    }


}