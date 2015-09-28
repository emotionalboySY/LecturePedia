package com.pure.lpedia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class List_TabPast extends Fragment {

    ListView mListView;
    List<Item_CardList> listCardItems;

    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tab1fragment, container, false);

        mListView = (ListView) v.findViewById(R.id.past_list);

        listCardItems = new ArrayList<Item_CardList>();

        Adapter_CardItem cardItemAdapter = new Adapter_CardItem(getActivity().getApplicationContext(), R.layout.card_item, listCardItems);

        mListView.setAdapter(cardItemAdapter);

        return v;
    }
}