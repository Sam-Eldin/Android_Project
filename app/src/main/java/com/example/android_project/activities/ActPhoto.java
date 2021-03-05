package com.example.android_project.activities;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.android_project.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActPhoto extends AppCompatActivity
{
    ImageView mImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_photo_full_screen);


        mImage = findViewById(R.id.image);

        String txtImage = getIntent().getStringExtra("img");

        Picasso.get().load(txtImage).into(mImage);
    }
}
