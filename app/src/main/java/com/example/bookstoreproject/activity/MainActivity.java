package com.example.bookstoreproject.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookstoreproject.R;
import com.example.bookstoreproject.adapter.MyFragmentPagerAdapter;
import com.example.bookstoreproject.fragment.Fragment01;
import com.example.bookstoreproject.fragment.Fragment02;
import com.example.bookstoreproject.fragment.Fragment03;
import com.example.bookstoreproject.fragment.Fragment04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ming on 2018/09/11.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private LinearLayout llChat, llFriends, llContacts, llSettings;
    private ImageView ivChat, ivFriends, ivContacts, ivSettings, ivCurrent;
    private TextView tvChat, tvFriends, tvContacts, tvSettings, tvCurrent;

    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {

        Fragment fragment01 = new Fragment01();
        Fragment fragment02 = new Fragment02();
        Fragment fragment03 = new Fragment03();
        Fragment fragment04 = new Fragment04();

        fragments.add(fragment01);
        fragments.add(fragment02);
        fragments.add(fragment03);
        fragments.add(fragment04);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        llChat = (LinearLayout) findViewById(R.id.llChat);
        llFriends = (LinearLayout) findViewById(R.id.llFriends);
        llContacts = (LinearLayout) findViewById(R.id.llContacts);
        llSettings = (LinearLayout) findViewById(R.id.llSettings);

        llChat.setOnClickListener(this);
        llFriends.setOnClickListener(this);
        llContacts.setOnClickListener(this);
        llSettings.setOnClickListener(this);

        ivChat = (ImageView) findViewById(R.id.ivChat);
        ivFriends = (ImageView) findViewById(R.id.ivFriends);
        ivContacts = (ImageView) findViewById(R.id.ivContacts);
        ivSettings = (ImageView) findViewById(R.id.ivSettings);

        tvChat = (TextView) findViewById(R.id.tvChat);
        tvFriends = (TextView) findViewById(R.id.tvFriends);
        tvContacts = (TextView) findViewById(R.id.tvContacts);
        tvSettings = (TextView) findViewById(R.id.tvSettings);

        ivChat.setSelected(true);
        tvChat.setSelected(true);
        ivCurrent = ivChat;
        tvCurrent = tvChat;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                changeTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        viewPager.setOffscreenPageLimit(4);
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }

        private void changeTab(int id) {
            ivCurrent.setSelected(false);
            tvCurrent.setSelected(false);
            switch (id) {
                case R.id.llChat:
                    viewPager.setCurrentItem(0);
                case 0:
                    ivChat.setSelected(true);
                    ivCurrent = ivChat;
                    tvChat.setSelected(true);
                    tvCurrent = tvChat;
                    break;
                case R.id.llFriends:
                    viewPager.setCurrentItem(1);
                case 1:
                    ivFriends.setSelected(true);
                    ivCurrent = ivFriends;
                    tvFriends.setSelected(true);
                    tvCurrent = tvFriends;
                    break;
                case R.id.llContacts:
                    viewPager.setCurrentItem(2);
                case 2:
                    ivContacts.setSelected(true);
                    ivCurrent = ivContacts;
                    tvContacts.setSelected(true);
                    tvCurrent = tvContacts;
                    break;
                case R.id.llSettings:
                    viewPager.setCurrentItem(3);
                case 3:
                    ivSettings.setSelected(true);
                    ivCurrent = ivSettings;
                    tvSettings.setSelected(true);
                    tvCurrent = tvSettings;
                    break;
            }
        }
}
