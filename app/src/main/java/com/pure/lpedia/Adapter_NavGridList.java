package com.pure.lpedia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_NavGridList extends ArrayAdapter<Item_NavList> {

    Context context;
    int resLayout;
    List<Item_NavList> listNavItems;

    public Adapter_NavGridList(Context context, int resLayout, List<Item_NavList> listNavItems) {
        super(context, resLayout, listNavItems);

        this.context = context;
        this.resLayout = resLayout;
        this.listNavItems = listNavItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, resLayout, null);

        ImageView navIcon = (ImageView) v.findViewById(R.id.nav_catIcon);
        TextView catName = (TextView) v.findViewById(R.id.nav_catName);

        Item_NavList navItem = listNavItems.get(position);

        catName.setText(navItem.getTitle());
        navIcon.setImageResource(navItem.getResIcon());

        return v;
    }
}
