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

public class List_TabFuture extends Fragment {

    ListView mListView;
    List<Item_CardList> listCardItems;

    View v;
    Bundle args;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tab2fragment, container, false);

        mListView = (ListView) v.findViewById(R.id.future_list);

        args = getArguments();
        int pos = args.getInt("final position");

        switch(pos) {
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
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }

        listCardItems = new ArrayList<Item_CardList>();
        listCardItems.add(new Item_CardList(R.drawable.lec_icon_100_200, "사람이 고프다", "강연자 : 박인", "밥을 먹으면서 공통의 관심사를 공유하는 모임인 소셜다이닝 ‘집밥’의 대표..."));

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
