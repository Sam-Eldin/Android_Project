package com.example.android_project.adapters;

import com.example.android_project.fragments.FragmentAllTypes;
import com.example.android_project.fragments.FragmentSalad;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class AdapterSectionsFood extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();


    public void addFragmentAllTypes(FragmentAllTypes aFragmentAll, String aTitleAll) {
        mFragmentList.add(aFragmentAll);
        mFragmentTitleList.add(aTitleAll);
    }

    public void addFragment(Fragment fm, String title) {
        mFragmentList.add(fm);
        mFragmentTitleList.add(title);
    }

    public AdapterSectionsFood(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentAllTypes();
            case 1:
                return new FragmentSalad();
        }
        return new FragmentSalad();
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
