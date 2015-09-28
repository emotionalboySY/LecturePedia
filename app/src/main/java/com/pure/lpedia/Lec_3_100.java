package com.pure.lpedia;

import android.content.ClipData;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class Lec_3_100 extends Fragment {

    private TabHost tabHost;
    private ViewPager viewPager;
    private Adapter_CardItem mCardAdapter;
    int i = 0;
    View v;
    Bundle args;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tabs_viewpager_layout, container, false);

        i++;

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
                    Item_CardList data = new Item_CardList(e.select("td.bcc a").text(), e.select("td.bcc a").attr("href"), e.select("td.bdt").text());
                    mCardAdapter.add(data);
                }
            }
        }
        return v;
    }
}
