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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class Lec_2_Ted extends Fragment {

    View v;
    ListView mListView;
    ArrayList<Item_CardList_Ted> listCardItems;
    Adapter_CardItem_Ted cardItemAdapter;
    Bundle args;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.lec_2_ted, container, false);

        mListView = (ListView) v.findViewById(R.id.list_lec_ted);

        listCardItems = new ArrayList<Item_CardList_Ted>();

        new ListSync().execute();

        cardItemAdapter = new Adapter_CardItem_Ted(getActivity().getApplicationContext(), R.layout.card_item_ted, listCardItems);
        mListView.setAdapter(cardItemAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Card_Detail_Ted.class);
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
                doc = Jsoup.connect("http://tvcast.naver.com/ted/clips").get();
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
            for(Element e : doc.select("div.wrap.ch_clip._cardArea div.cds_area._infiniteCardArea div.cds._MM_CARD")){
                String Title = e.select("div.cds_type.uio_thumb dl.cds_info dt.title h3 span").text();
                String Date = e.select("div.cds_type.uio_thumb dl.cds_info dd.meta span.time").text();
                Item_CardList_Ted data = new Item_CardList_Ted(Title, Date);
                listCardItems.add(data);
            }
            cardItemAdapter.notifyDataSetChanged();
        }
    }
}
