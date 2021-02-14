package com.example.android_project.activities;

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

public class FragmentAllTypes extends Fragment implements RecyclerViewAdapter.ItemListener
{
    private static final String TAG = "All types ";
    private Context mContext;
    private GridLayout mlstFragmentAllTypes;

    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
//
//        mContext = this.getContext();
//        View view =inflater.inflate(R.layout.content_main, container, false);
//        ArrayListFood foods = new ArrayListFood();
//        Food t = new Food();
//        t.setName("a");
//        t.setPrice(55);
//        t.setType("AllTypes");
//
//        foods.add(t);
//
//        recyclerView = (RecyclerView) view.findViewById(R.id.foodRecycle);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        recyclerViewAdapter = new RecyclerViewAdapter(mContext, foods, null);
//        recyclerView.setAdapter(recyclerViewAdapter);
      //  View view = inflater.inflate(R.layout.fragment_all_types, container, false);
      //  mlstFragmentAllTypes = (GridLayout)view.findViewById(R.id.lstFragmentAllTypes);

  //      AdapterFoodList adapterFoodList;
//        adapterFoodList = new AdapterFoodList(getActivity(), Project.APP_INSTANCE.getmArrayListFood());

       // mlstFragmentAllTypes.(adapterFoodList);
       // mlstFragmentAllTypes.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
    //    GridLayoutManager manager = new GridLayoutManager(mContext.getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);
    //    recyclerView.setLayoutManager(manager);

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onItemClick(Food item)
    {
        Toast.makeText(mContext.getApplicationContext(), item.getName() + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
