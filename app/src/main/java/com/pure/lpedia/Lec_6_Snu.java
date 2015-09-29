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
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Lec_6_Snu extends Fragment {

    View v;
    ListView mListView;
    ArrayList<Item_CardList_Snu> listCardItems;
    Adapter_CardItem_Snu cardItemAdapter;
    Bundle args;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.lec_6_snu, container, false);

        mListView = (ListView) v.findViewById(R.id.list_lec_snu);

        listCardItems = new ArrayList<Item_CardList_Snu>();

        new ListSync().execute();

        cardItemAdapter = new Adapter_CardItem_Snu(getActivity().getApplicationContext(), R.layout.card_item_snu, listCardItems);
        mListView.setAdapter(cardItemAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Card_Detail_Snu.class);
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
                doc = Jsoup.connect("http://snui.snu.ac.kr/ocw/index.php?mode=list&best=3").get();
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
            for(Element e : doc.select("div#ocw_list1 table.ocw_list tbody tr td[width=230px]")){
                String Title = e.select("a").text();
                Item_CardList_Snu data = new Item_CardList_Snu(Title);
                listCardItems.add(data);
            }
            cardItemAdapter.notifyDataSetChanged();
        }
    }
}
