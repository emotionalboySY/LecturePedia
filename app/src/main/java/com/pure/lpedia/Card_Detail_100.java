package com.pure.lpedia;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Card_Detail_100 extends ActionBarActivity {

    View v;
    Bundle args;
    int category, carditem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_detail);

        Fragment f = new Lec_3_100();
        args = f.getArguments();
        category = args.getInt("final position");
        carditem = args.getInt("detail position");
    }
}