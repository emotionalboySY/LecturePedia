package com.pure.lpedia;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;

import java.util.List;
import java.util.Vector;

public class Lec_5_Hum extends Fragment implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {

    private TabHost tabHost;
    private ViewPager viewPager;
    private Adapter_TabPage myViewPagerAdapter;
    int i = 0;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tabs_viewpager_layout, container, false);

        i++;

        //init tabhost
        this.initializeTabHost(savedInstanceState);

        //init ViewPager
        this.initializeViewPager();

        return v;
    }

    class FakeContent implements TabContentFactory {

        Context context;
        public FakeContent(Context mcontext)
        {
            context = mcontext;
        }

        @Override
        public View createTabContent(String tag) {

            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

    private void initializeViewPager() {

        List<Fragment> fragments = new Vector<Fragment>();

        fragments.add(new List_TabPast());
        fragments.add(new List_TabFuture());

        this.myViewPagerAdapter = new Adapter_TabPage(
                getChildFragmentManager(), fragments);
        this.viewPager = (ViewPager) v.findViewById(R.id.view_pager);
        this.viewPager.setAdapter(this.myViewPagerAdapter);
        viewPager.setOnPageChangeListener(this);

    }

    private void initializeTabHost(Bundle args) {

        tabHost = (TabHost) v.findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec(getString(R.string.tab_future));
        tabSpec.setIndicator(getString(R.string.tab_future));
        tabSpec.setContent(new FakeContent(getActivity()));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(getString(R.string.tab_past));
        tabSpec.setIndicator(getString(R.string.tab_past));
        tabSpec.setContent(new FakeContent(getActivity()));
        tabHost.addTab(tabSpec);

        tabHost.setOnTabChangedListener(this);

    }

    @Override
    public void onTabChanged(String tanId) {
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);

        HorizontalScrollView hScrollView = (HorizontalScrollView) v.findViewById(R.id.h_scroll_view);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft()
                - (hScrollView.getWidth() - tabView.getWidth()) / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int position) {
        this.tabHost.setCurrentTab(position);
    }
}
