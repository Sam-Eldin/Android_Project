package com.example.android_project.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android_project.R;
import com.example.android_project.adapters.AdapterFoodList;
import com.example.android_project.adapters.RecyclerViewAdapter;
import com.example.android_project.arrays.ArrayListFood;
import com.example.android_project.common.Project;
import com.example.android_project.entities.Food;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentSalad extends Fragment implements RecyclerViewAdapter.ItemListener
{
    private static final String TAG = "FragSalad";
    private Context mContext;
    private GridLayout mlstFragmentAllTypes;

    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_salad, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onItemClick(Food item)
    {
    }
}
