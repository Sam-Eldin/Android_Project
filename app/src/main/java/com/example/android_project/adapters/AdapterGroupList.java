package com.example.android_project.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.android_project.arrays.ArrayListGroup;

import java.util.ArrayList;

public class AdapterGroupList extends BaseAdapter
{

    private Context mContext;
    private ArrayListGroup mArrayListGroup;

    public AdapterGroupList(Context aContext, ArrayListGroup aArrayListGroup){
        mArrayListGroup = aArrayListGroup;
        mContext = aContext;

    }

    @Override
    public int getCount()
    {
        return mArrayListGroup.size();
    }

    @Override
    public Object getItem(int i)
    {
        return mArrayListGroup.getLoaded();
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return null;
    }
}
