package com.example.mauriciogodinez.pi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreandoRed extends AppCompatActivity {

    private Handler creandoRed = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creando_red);

    }

    @Override
    protected void onStart() {
        super.onStart();

        delayedProgress(2000);
    }

    private void delayedProgress(int delayMillis) {
        creandoRed.removeCallbacks(ProgressRed);
        creandoRed.postDelayed(ProgressRed, delayMillis);
    }

    private final Runnable ProgressRed = new Runnable() {
        @Override
        public void run() {
            final ProgressDialog configurandoRed = new ProgressDialog(CreandoRed.this);

            configurandoRed.setTitle(R.string.configurando_red_titulo);
            configurandoRed.setMessage(getResources().getString(R.string.configurando_red_texto));
            configurandoRed.setCancelable(false);
            configurandoRed.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            configurandoRed.setProgress(0);
            configurandoRed.setMax(100);

            configurandoRed.show();

            final Thread t = new Thread() {
                @Override
                public void run() {
                    int jumpTime = 0;

                    while (jumpTime < configurandoRed.getMax()) {
                        try {
                            sleep(70);
                            jumpTime += 1;
                            configurandoRed.setProgress(jumpTime);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                        configurandoRed.dismiss();
                        Intent redCreada = new Intent(getApplicationContext(), RedCreada.class);
                        startActivity(redCreada);
                        finishAffinity();
                }
            };
            t.start();
        }
    };
}