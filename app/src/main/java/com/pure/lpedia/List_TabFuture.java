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

public class List_TabFuture extends Fragment {

    ListView mListView;
    List<Item_CardList> listCardItems;

    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tab2fragment, container, false);

        mListView = (ListView) v.findViewById(R.id.future_list);

        Bundle args = new Bundle();
        args = getArguments();
        int position = args.getInt("final position");

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

        return v;
    }
}
