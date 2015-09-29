package com.pure.lpedia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter_CardItem_100 extends ArrayAdapter<Item_CardList_100> {

    Context context;
    int resLayout;
    List<Item_CardList_100> listCardItems;

    public Adapter_CardItem_100(Context context, int resLayout, List<Item_CardList_100> listCardItems) {
        super(context, resLayout, listCardItems);

        this.context = context;
        this.resLayout = resLayout;
        this.listCardItems = listCardItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, resLayout, null);

        TextView title = (TextView) v.findViewById(R.id.card_title);
        TextView Name = (TextView) v.findViewById(R.id.card_name);
        TextView Date = (TextView) v.findViewById(R.id.card_date);

        Item_CardList_100 cardItem = listCardItems.get(position);

        title.setText(cardItem.getCardTitle());
        Name.setText(cardItem.getCardName());
        Date.setText(cardItem.getCardDate());

        return v;
    }
}