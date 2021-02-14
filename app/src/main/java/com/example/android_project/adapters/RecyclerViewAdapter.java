package com.example.android_project.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android_project.R;
import com.example.android_project.arrays.ArrayListFood;
import com.example.android_project.common.Project;
import com.example.android_project.entities.Food;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter
{

    private Context mContext;
    private ArrayListFood mArrayListFood;
    protected ItemListener mListener;


    public RecyclerViewAdapter(Context context, ArrayListFood values, ItemListener itemListener)
    {

        mArrayListFood = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public RelativeLayout relativeLayout;
        Food item;

        TextView txtFoodType;
        TextView txtFoodName;
        TextView txtFoodPrice;
        ImageButton imgBtnFood;

        View resultView;
        LayoutInflater layoutInflater;

        public ViewHolder(View v)
        {
            super(v);

            if (v == null)
            {
                //layoutInflater = (LayoutInflater) Project.APP_INSTANCE.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                resultView = layoutInflater.inflate(R.layout.lo_item_food, null);

                txtFoodName = (TextView) v.findViewById((R.id.txtItmFood));
                txtFoodPrice = (TextView) v.findViewById((R.id.txtItmPrice));
                imgBtnFood = (ImageButton) v.findViewById((R.id.imgBtnFood));

                v.setTag(R.id.txtItmFood, txtFoodName);
                v.setTag(R.id.txtItmPrice, txtFoodPrice);
                v.setTag(R.id.imgBtnFood, imgBtnFood);

            } else
            {

                resultView = v;
                txtFoodName = (TextView) v.getTag(R.id.txtItmFood);
                txtFoodPrice = (TextView) v.getTag(R.id.txtItmPrice);
                imgBtnFood = (ImageButton) v.getTag(R.id.imgBtnFood);
            }
        }


        public void setData(Food item)
        {
            this.item = item;
            txtFoodName.setText(item.getName());
            txtFoodPrice.setText(item.getPrice());
        }

        @Override
        public void onClick(View view)
        {
            if (mListener != null) {
                mListener.onItemClick(item);
            }

        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(mContext).inflate(R.layout.lo_item_food, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ((ViewHolder)holder).setData(mArrayListFood.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mArrayListFood.size();
    }

    public interface ItemListener {
        void onItemClick(Food item);
    }
}
