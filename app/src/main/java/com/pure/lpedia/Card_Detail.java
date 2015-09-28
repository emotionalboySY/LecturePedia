package com.pure.lpedia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Card_Detail extends Fragment {

    View v;
    Bundle args;
    int category, carditem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        args = getArguments();
        category = args.getInt("final position");
        carditem = args.getInt("detail position");


        v = inflater.inflate(R.layout.card_detail, container, false);
        return v;
    }
}