package com.example.mauriciogodinez.pi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class InnerPageFragment extends Fragment {

    public InnerPageFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_portadas_tab, container, false);

        ImageView im = (ImageView) rootView.findViewById(R.id.iv_zigbee_tab);
        TextView tvt = (TextView) rootView.findViewById(R.id.tv_zigbee_titulo_tab);
        TextView tvst = (TextView) rootView.findViewById(R.id.tv_zigbee_ayuda_tab);

        im.setImageResource(this.getArguments().getInt("image_message"));
        tvt.setText(getString(this.getArguments().getInt("title_message")));
        tvst.setText(getString(this.getArguments().getInt("subtitle_message")));

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}