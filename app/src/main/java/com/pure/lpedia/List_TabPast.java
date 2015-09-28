package com.pure.lpedia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class List_TabPast extends Fragment {

    ListView mListView;
    List<Item_CardList> listCardItems;

    View v;
    Bundle args;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tab1fragment, container, false);

        mListView = (ListView) v.findViewById(R.id.past_list);

        args = getArguments();
        int position = args.getInt("final position");

        listCardItems = new ArrayList<Item_CardList>();
        switch(position) {
            case 0:
            break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

        Adapter_CardItem cardItemAdapter = new Adapter_CardItem(getActivity().getApplicationContext(), R.layout.card_item, listCardItems);
        mListView.setAdapter(cardItemAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment f = new Card_Detail();

                args.putInt("detail position", position);
                f.setArguments(args);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, f);
            }
        });

        return v;
    }
}