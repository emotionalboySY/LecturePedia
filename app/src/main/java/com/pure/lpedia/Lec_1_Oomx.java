package com.pure.lpedia;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class Lec_1_Oomx extends Fragment {

    View v;
    ListView mListView;
    ArrayList<Item_CardList_Oomx> listCardItems;
    Adapter_CardItem_Oomx cardItemAdapter;
    Bundle args;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.lec_1_oomx, container, false);

        mListView = (ListView) v.findViewById(R.id.list_lec_Oomx);

        listCardItems = new ArrayList<Item_CardList_Oomx>();

        new ListSync().execute();

        cardItemAdapter = new Adapter_CardItem_Oomx(getActivity().getApplicationContext(), R.layout.card_item_oomx, listCardItems);
        mListView.setAdapter(cardItemAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Card_Detail_Oomx.class);
                startActivity(intent);
            }
        });

        return v;
    }

    class ListSync extends AsyncTask<String,String,String> {

        Document doc;
        @Override
        protected String doInBackground(String... params) {
            try {
                doc = Jsoup.connect("http://www.onoffmix.com/event?c=16").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            for(Element e : doc.select("div.content div.eventMain div.sideLeft div[class=contentBox todayEventArea] ul.todayEvent")){
                String Title = e.select("li.eventTitle a").text();
                String Date = e.select("li.eventBottomArea ul li.eventPersonnel a span").text();
                Item_CardList_Oomx data = new Item_CardList_Oomx(Title, Date);
                listCardItems.add(data);
            }
            cardItemAdapter.notifyDataSetChanged();
        }
    }
}
