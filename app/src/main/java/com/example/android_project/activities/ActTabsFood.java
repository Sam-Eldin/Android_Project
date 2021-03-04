package com.example.android_project.activities;

import android.os.Bundle;

import com.example.android_project.R;
import com.example.android_project.adapters.AdapterSectionsFood;
import com.example.android_project.fragments.FragmentAllTypes;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ActTabsFood extends AppCompatActivity
{
    private AdapterSectionsFood mAdapterSectionsFood;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        mAdapterSectionsFood = new AdapterSectionsFood(getSupportFragmentManager());

        initComponents();
    }

    public void initComponents(){
        // Set up the ViewPager with the sections adapter
        mViewPager = (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabFoodTypes);
        tabLayout.setupWithViewPager(mViewPager);

    }


    private void setupViewPager(ViewPager viewPager){

        AdapterSectionsFood foodAdapter = new AdapterSectionsFood(getSupportFragmentManager());
        foodAdapter.addFragmentAllTypes(new FragmentAllTypes(), "All types");

        viewPager.setAdapter(foodAdapter);

    }


}
