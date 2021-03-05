package com.example.android_project.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android_project.R;
import com.example.android_project.arrays.ArrayListFood;
import com.example.android_project.common.Project;
import com.example.android_project.entities.Food;

import java.util.ArrayList;

public class AdapterFoodList extends BaseAdapter {

    private final ArrayListFood mArrayListFood;

    public AdapterFoodList(ArrayListFood aArrayListGroup) {
        mArrayListFood = aArrayListGroup;

    }

    @Override
    public int getCount() {
        return mArrayListFood.size();
    }

    @Override
    public Object getItem(int i) {
        return mArrayListFood.getLoaded();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Food food;
        View resultView;
        LayoutInflater layoutInflater;

        TextView txtFoodName;
        TextView txtFoodPrice;
        ImageButton imgBtnFood;


        if (convertView == null) {
            layoutInflater = (LayoutInflater) Project.APP_INSTANCE.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // create the custom layout to show the "workers"
            resultView = layoutInflater.inflate(R.layout.lo_item_food, null);

            // find the objects inside the custom layout...
            txtFoodName = resultView.findViewById((R.id.txtItmFood));
            txtFoodPrice = resultView.findViewById((R.id.txtItmPrice));
            imgBtnFood = resultView.findViewById((R.id.imgBtnFood));


            resultView.setTag(R.id.txtItmFood, txtFoodName);
            resultView.setTag(R.id.txtItmPrice, txtFoodPrice);
            resultView.setTag(R.id.imgBtnFood, imgBtnFood);

        } else {
            resultView = convertView;

            // extract all the pointers to the objects from the "tag" list.
            txtFoodName = (TextView) resultView.getTag(R.id.txtItmFood);
            txtFoodPrice = (TextView) resultView.getTag(R.id.txtItmPrice);
        }


        food = mArrayListFood.get(position);
        txtFoodName.setText(food.getName());
        txtFoodPrice.setText(food.getPrice());


        return resultView;
    }
}
