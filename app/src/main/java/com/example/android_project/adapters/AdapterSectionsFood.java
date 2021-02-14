package com.example.android_project.adapters;

import com.example.android_project.activities.FragmentAllTypes;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdapterSectionsFood extends FragmentPagerAdapter
{
    private final List<Fragment>mFragmentList = new ArrayList<>();
    private final List<String>mFragmentTitleList = new ArrayList<>();


    public void addFragmentAllTypes(FragmentAllTypes aFragmentAll, String aTitleAll){
        mFragmentList.add(aFragmentAll);
        mFragmentTitleList.add(aTitleAll);
    }
    public AdapterSectionsFood(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    public AdapterSectionsFood(@NonNull FragmentManager fm, int behavior)
    {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return mFragmentTitleList.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount()
    {
        return mFragmentList.size();
    }
}
