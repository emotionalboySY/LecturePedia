package com.pure.lpedia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_CardItem extends ArrayAdapter<Item_CardList> {

    Context context;
    int resLayout;
    List<Item_CardList> listCardItems;

    public Adapter_CardItem(Context context, int resLayout, List<Item_CardList> listCardItems) {
        super(context, resLayout, listCardItems);

        this.context = context;
        this.resLayout = resLayout;
        this.listCardItems = listCardItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, resLayout, null);

        TextView tv1 = (TextView) v.findViewById(R.id.card_title);
        TextView tv2 = (TextView) v.findViewById(R.id.card_speaker);
        TextView tv3 = (TextView) v.findViewById(R.id.card_content);

        Item_CardList cardItem = listCardItems.get(position);

        tv1.setText(cardItem.getCardTitle());
        tv2.setText(cardItem.getCardSpeaker());
        tv3.setText(cardItem.getCardContent());

        return v;
    }
}