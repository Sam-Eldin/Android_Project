package com.example.android_project.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_project.R;
import com.example.android_project.activities.ActPhoto;
import com.example.android_project.arrays.ArrayListFood;
import com.example.android_project.common.Project;
import com.example.android_project.entities.Food;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayListFood mArrayListFood;
    protected ItemListener mListener;

    public RecyclerViewAdapter(Context context, ArrayListFood values, ItemListener itemListener) {
        mArrayListFood = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Food item;
        TextView txtFoodName;
        TextView txtFoodPrice;
        ImageView image;

        View resultView;
        LayoutInflater layoutInflater;

        public ViewHolder(View v) {
            super(v);

            layoutInflater = (LayoutInflater) Project.APP_INSTANCE.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            resultView = layoutInflater.inflate(R.layout.lo_item_food, null);
            txtFoodName = (TextView) v.findViewById((R.id.txtItmFood));
            txtFoodPrice = (TextView) v.findViewById((R.id.txtItmPrice));
            image = (ImageView) v.findViewById((R.id.imgBtnFood));
            v.setTag(R.id.txtItmFood, txtFoodName);
            v.setTag(R.id.txtItmPrice, txtFoodPrice);
            v.setTag(R.id.imgBtnFood, image);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, ActPhoto.class);
                    intent.putExtra("img", item.getImage());
                    mContext.startActivity(intent);
                }
            });
        }
// this is update

        public void setData(Food item) {
            this.item = item;
            txtFoodName.setText(item.getName());
            txtFoodPrice.setText((item.getPrice()).toString());

            Picasso.get().load(item.getImage()).into(image);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    public void setmArrayListFood(ArrayListFood ff){
        mArrayListFood = ff;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lo_item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Food item = mArrayListFood.get(position);

        ((ViewHolder) holder).setData(mArrayListFood.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayListFood.size();
    }

    public interface ItemListener {
        void onItemClick(Food item);
    }
}
