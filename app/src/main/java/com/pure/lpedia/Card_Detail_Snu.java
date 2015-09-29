package com.pure.lpedia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Card_Detail_Snu extends ActionBarActivity {

    View v;
    Bundle args;
    int category, carditem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_detail_oomx);
    }
}