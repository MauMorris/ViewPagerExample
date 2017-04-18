package com.example.mauriciogodinez.pi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PortadasTabActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portadas_tab);

        PortadaAdapter mAdapter = new PortadaAdapter(this, getSupportFragmentManager());

        Button omitir = (Button) findViewById(R.id.boton_omitir);
        ImageButton siguiente = (ImageButton) findViewById(R.id.boton_siguiente_actividad);

        Button b = (Button) findViewById(R.id.boton_crear_red);
        b.setVisibility(Button.INVISIBLE);

        omitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(3, true);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CreandoRed.class);
                startActivity(i);
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Integer pos = position;
                View divider = findViewById(R.id.divisor_view);
                ButtonBarLayout buttonBar = (ButtonBarLayout) findViewById(R.id.boton_barra);
                Button b = (Button) findViewById(R.id.boton_crear_red);

                switch (pos) {
                    case 0:
                        buttonBar.setVisibility(ButtonBarLayout.VISIBLE);
                        divider.setVisibility(View.VISIBLE);
                        b.setVisibility(Button.INVISIBLE);
                        break;
                    case 1:
                        buttonBar.setVisibility(ButtonBarLayout.VISIBLE);
                        divider.setVisibility(View.VISIBLE);
                        b.setVisibility(Button.INVISIBLE);
                        break;
                    case 2:
                        buttonBar.setVisibility(ButtonBarLayout.INVISIBLE);
                        divider.setVisibility(View.INVISIBLE);
                        b.setVisibility(Button.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
