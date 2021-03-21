package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.example.homework.adapters.HomeworkPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setPagerAdapter();
    }

    private void findViews() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
    }

    private void setPagerAdapter() {

        viewPager.setAdapter(new HomeworkPagerAdapter(this));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {

            switch (position) {
                case 0: {
                    tab.setText(R.string.user_profile);
                    break;
                }
                case 1:
                    tab.setText(R.string.repository_list);
                    break;
            }
        });
        tabLayoutMediator.attach();
    }
}