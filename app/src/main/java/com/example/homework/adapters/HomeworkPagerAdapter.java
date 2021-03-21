package com.example.homework.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.homework.fragments.RepositoryListFragment;
import com.example.homework.fragments.UserProfileFragment;

public class HomeworkPagerAdapter extends FragmentStateAdapter {

    public HomeworkPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {

            case 0:
                return new UserProfileFragment();
            case 1:
                return new RepositoryListFragment();
            default:
                return new UserProfileFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
