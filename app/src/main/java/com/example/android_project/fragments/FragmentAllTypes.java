package com.example.android_project.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project.R;
import com.example.android_project.adapters.RecyclerViewAdapter;
import com.example.android_project.entities.Food;

public class FragmentAllTypes extends Fragment implements RecyclerViewAdapter.ItemListener {
    private static final String TAG = "All types ";
    private Context mContext;
    private GridLayout mlstFragmentAllTypes;

    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        Toast.makeText(super.getContext(), "onCreateView", Toast.LENGTH_LONG).show();
        View view = inflater.inflate(R.layout.fragment_all_types, container, false);
        mlstFragmentAllTypes = view.findViewById(R.id.lstFragmentAllTypes);
        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Toast.makeText(super.getContext(), "onCreateView", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(Food item) {
        Toast.makeText(mContext.getApplicationContext(), item.getName() + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
