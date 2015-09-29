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

public class DefaultPage extends Fragment {

    ListView mListView;
    List<Item_CardList_100> listCardItems;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.default_page, container, false);

        mListView = (ListView) v.findViewById(R.id.card_default);

        listCardItems = new ArrayList<Item_CardList_100>();

        Adapter_CardItem_100 cardItemAdapter = new Adapter_CardItem_100(getActivity().getApplicationContext(), R.layout.card_item_100, listCardItems);

        mListView.setAdapter(cardItemAdapter);

        return v;
    }
}
