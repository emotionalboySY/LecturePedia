package com.pure.lpedia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter_CardItem_Snu extends ArrayAdapter<Item_CardList_Snu> {

    Context context;
    int resLayout;
    List<Item_CardList_Snu> listCardItems;

    public Adapter_CardItem_Snu(Context context, int resLayout, List<Item_CardList_Snu> listCardItems) {
        super(context, resLayout, listCardItems);

        this.context = context;
        this.resLayout = resLayout;
        this.listCardItems = listCardItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, resLayout, null);

        TextView title = (TextView) v.findViewById(R.id.card_title_snu);

        Item_CardList_Snu cardItem = listCardItems.get(position);

        title.setText(cardItem.getCardTitle());

        return v;
    }
}