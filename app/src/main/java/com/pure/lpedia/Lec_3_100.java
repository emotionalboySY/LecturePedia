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

public class Lec_3_100 extends Fragment {

    View v;
    ListView mListView;
    ArrayList<Item_CardList_100> listCardItems;
    Adapter_CardItem_100 cardItemAdapter;
    Bundle args;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.lec_3_100, container, false);

        mListView = (ListView) v.findViewById(R.id.list_lec_300);

        listCardItems = new ArrayList<Item_CardList_100>();

        new ListSync().execute();

        cardItemAdapter = new Adapter_CardItem_100(getActivity().getApplicationContext(), R.layout.card_item_100, listCardItems);
        mListView.setAdapter(cardItemAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Card_Detail_100.class);
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
                doc = Jsoup.connect("http://www.kbs.co.kr/1tv/sisa/100do/view/vod/index.html").get();
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
            for(Element e : doc.select("table.tbe tbody tr")){
                String Title = e.select("td.bcc a").text();
                int num = Title.indexOf(" - ");
                String Name = Title.substring(7, num);
                Title = Title.substring(num+3, Title.length());
                String Date = e.select("td.bdt").text();
                Item_CardList_100 data = new Item_CardList_100(Title, Name, Date);
                listCardItems.add(data);
            }
            cardItemAdapter.notifyDataSetChanged();
        }
    }
}
