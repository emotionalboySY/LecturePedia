package com.pure.lpedia;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    GridView lvNav;

    List<Item_NavList> listNavItems;
    int i = 0;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerPane = (RelativeLayout) findViewById(R.id.drawer_pane);
        lvNav = (GridView) findViewById(R.id.nav_GridList);

        listNavItems = new ArrayList<Item_NavList>();
        listNavItems.add(new Item_NavList("전체강의", R.drawable.nav_ic_all));
        listNavItems.add(new Item_NavList("수학", R.drawable.nav_ic_mat));
        listNavItems.add(new Item_NavList("과학", R.drawable.nav_ic_sci));
        listNavItems.add(new Item_NavList("영어", R.drawable.nav_ic_eng));
        listNavItems.add(new Item_NavList("교육", R.drawable.nav_ic_edu));
        listNavItems.add(new Item_NavList("인문학", R.drawable.nav_ic_hum));
        listNavItems.add(new Item_NavList("벤처/창업", R.drawable.nav_ic_sta));
        listNavItems.add(new Item_NavList("IT/컴퓨터", R.drawable.nav_ic_ict));
        listNavItems.add(new Item_NavList("로봇공학", R.drawable.nav_ic_rob));
        listNavItems.add(new Item_NavList("경제", R.drawable.nav_ic_eco));

        Adapter_NavGridList navListAdapter = new Adapter_NavGridList(getApplicationContext(), R.layout.nav_item, listNavItems);

        lvNav.setAdapter(navListAdapter);

        // load first frag  ment as default:
        Fragment def;
        def = new DefaultPage();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, def).commit();

        setTitle(R.string.app_name);
        lvNav.setItemChecked(0, true);
        drawerLayout.closeDrawer(drawerPane);

        //set listener for navigation items
        lvNav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //replace the fragment with the selection correspongingly
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment f = null;

                switch(position) {
                    case 0: f = new Lec_1_Ted(); break;
                    case 1: f = new Lec_2_15min(); break;
                    case 2: f = new Lec_3_100(); break;
                    case 3: f = new Lec_4_Kocw(); break;
                    case 4: f = new Lec_5_Snow(); break;
                    case 5: f = new Lec_6_Snu(); break;
                }

                fragmentManager.beginTransaction().replace(R.id.main_content, f).commit();

                Bundle args = new Bundle();
                args.putInt("position", position);
                f.setArguments(args);

                setTitle(listNavItems.get(position).getTitle());
                lvNav.setItemChecked(position, true);
                drawerLayout.closeDrawer(drawerPane);
            }
        });

        //create listener for drawer layout
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };

        actionBarDrawerToggle.syncState();

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void Action_Date() {
        Calendar c = Calendar.getInstance();
        int date = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);

        Toast.makeText(this, "오늘은 " + year + "년 " + month + "월 " + date + "일입니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Lec_1_Ted/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch(item.getItemId()) {
            case R.id.action_date:
                Action_Date();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
