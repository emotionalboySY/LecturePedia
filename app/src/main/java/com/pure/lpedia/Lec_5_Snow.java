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

public class Lec_5_Snow extends Fragment {

    View v;
    ListView mListView;
    ArrayList<Item_CardList_Snow> listCardItems;
    Adapter_CardItem_Snow cardItemAdapter;
    Bundle args;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.lec_5_snow, container, false);

        mListView = (ListView) v.findViewById(R.id.list_lec_snow);

        listCardItems = new ArrayList<Item_CardList_Snow>();

        new ListSync().execute();

        cardItemAdapter = new Adapter_CardItem_Snow(getActivity().getApplicationContext(), R.layout.card_item_snow, listCardItems);
        mListView.setAdapter(cardItemAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Card_Detail_Snow.class);
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
                doc = Jsoup.connect("http://www.snow.or.kr/common/lecturelast.html").get();
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
            for(Element e : doc.select("div.tabsort.mt3 table tbody table tbody")){
                String Title = e.select("tr th a").text();
                String Date = e.select("tr td.txt").text();
                Item_CardList_Snow data = new Item_CardList_Snow(Title, Date);
                listCardItems.add(data);
            }
            cardItemAdapter.notifyDataSetChanged();
        }
    }
}
