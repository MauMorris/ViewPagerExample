package com.example.mauriciogodinez.pi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class InicioApp extends AppCompatActivity {

    private static final int UI_ANIMATION_SHOW_BARS_DELAY = 1200;
    private static final int NEXT_LAYOUT_DELAY_MILLIS = 150;
    private final Handler mShowHandler = new Handler();
    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inicio_app);
        mContentView = findViewById(R.id.fullscreen_inicio_app);

        mContentView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        delayedShow(UI_ANIMATION_SHOW_BARS_DELAY);
    }

    private void delayedShow(int delayMillis) {
        mShowHandler.removeCallbacks(mShowRunnable);
        mShowHandler.postDelayed(mShowRunnable, delayMillis);
    }

    private final Runnable mShowRunnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            mContentView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

            mShowHandler.removeCallbacks(mShowRunnable);
            mShowHandler.postDelayed(mIntentRunnable, NEXT_LAYOUT_DELAY_MILLIS);
        }
    };

    private final Runnable mIntentRunnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            Intent portada1 = new Intent(getApplicationContext(), PortadasTabActivity.class);
            startActivity(portada1);
            finish();
        }
    };
}
