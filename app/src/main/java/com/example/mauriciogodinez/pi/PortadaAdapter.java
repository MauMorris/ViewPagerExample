package com.example.mauriciogodinez.pi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PortadaAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public PortadaAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        InnerPageFragment fragI = new InnerPageFragment();

        switch (position) {
            case 0:
                bundle.putInt("image_message", R.drawable.zigbee_ejemplos);
                bundle.putInt("title_message", R.string.titulo_p1);
                bundle.putInt("subtitle_message", R.string.texto_p1);
                fragI.setArguments(bundle);
                return fragI;
            case 1:
                bundle.putInt("image_message", R.drawable.zigbee_connection_options);
                bundle.putInt("title_message", R.string.titulo_p2);
                bundle.putInt("subtitle_message", R.string.texto_p2);
                fragI.setArguments(bundle);
                return fragI;
            case 2:
                bundle.putInt("image_message", R.drawable.zigbee_sensor_nodes);
                bundle.putInt("title_message", R.string.titulo_p3);
                bundle.putInt("subtitle_message", R.string.texto_p3);
                fragI.setArguments(bundle);
                return fragI;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.title_activity_portada1);
            case 1:
                return mContext.getString(R.string.title_activity_portada2);
            case 2:
                return mContext.getString(R.string.title_activity_portada3);
        }
        return null;
    }
}
