package com.example.lap60020_local.retrofit.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lap60020_local.retrofit.R;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int pos = 0;

    class MyPagerAdpter extends FragmentPagerAdapter{

        FragmentManager fm;
        MyPagerAdpter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
        }


        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return new PopularFragment();
                case 1:
                    return new TopRatedFragment();
                case 2:
                    return new UpComingFragment();
                case 3:
                    return new NowPlayingFragment();
                default:
                    return null;
            }
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0:
                    return getResources().getString(R.string.popular);
                case 1:
                    return getResources().getString(R.string.top_rated);
                case 2:
                    return getResources().getString(R.string.upcoming);
                case 3:
                    return getResources().getString(R.string.nowplaying);
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            return 4;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null) {
            pos = savedInstanceState.getInt("Page",0);
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab);
        MyPagerAdpter pagerAdpter = new MyPagerAdpter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdpter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Page",pos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.search_menu) {
            Intent intent = new Intent(this,SearchActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewPager.setCurrentItem(pos);
    }

}
