package com.example.android_project.activities;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;

import com.example.android_project.R;
import com.example.android_project.adapters.AdapterSectionsFood;
import com.example.android_project.adapters.RecyclerViewAdapter;
import com.example.android_project.arrays.ArrayListFood;
import com.example.android_project.common.Project;
import com.example.android_project.entities.Food;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


public class MenuOptions extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener
{

    private AppBarConfiguration mAppBarConfiguration;

    private Context mContext;
    private Food mFood;
    private Project mProject;

    private NavigationView mNavView;

    private AdapterSectionsFood mAdapterSectionsFood;
    private ViewPager mViewPager;

     private ImageButton mImgBtn;
     private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initComponents();

        mContext = this;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.foodRecycle);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayListFood foods = new ArrayListFood();
        Food t = new Food();
        Food t2 = new Food();
        Food t3 = new Food();
        t.setName("a");
        t.setPrice(10);
        t.setType("AllTypes");
        t.setImage("https://hellonutritarian.com/wp-content/uploads/2017/09/Hummus-Balsamic-Dressing-Whole-Food-Plant-Based-Diet-oil-free-vegan-salad-dressing-Dr-Greger-How-Not-to-Die-What-the-Health-Dr-Fuhrman-Eat-to-Live-program-the-salad-is-the-main-dish-500x500.jpg");

        t2.setName("a");
        t2.setPrice(10);
        t2.setType("AllTypes");
        t2.setImage("https://hellonutritarian.com/wp-content/uploads/2017/09/Hummus-Balsamic-Dressing-Whole-Food-Plant-Based-Diet-oil-free-vegan-salad-dressing-Dr-Greger-How-Not-to-Die-What-the-Health-Dr-Fuhrman-Eat-to-Live-program-the-salad-is-the-main-dish-500x500.jpg");

        t3.setName("a");
        t3.setPrice(10);
        t3.setType("AllTypes");
        t3.setImage("https://hellonutritarian.com/wp-content/uploads/2017/09/Hummus-Balsamic-Dressing-Whole-Food-Plant-Based-Diet-oil-free-vegan-salad-dressing-Dr-Greger-How-Not-to-Die-What-the-Health-Dr-Fuhrman-Eat-to-Live-program-the-salad-is-the-main-dish-500x500.jpg");

        foods.add(t);
        foods.add(t2);
        foods.add(t3);
        mAdapterSectionsFood = new AdapterSectionsFood(getSupportFragmentManager());
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mContext, foods, null);
        recyclerView.setAdapter(recyclerViewAdapter);

//        mProject= (Project) getApplication();




    }


    public void initComponents()
    {
        setContentView(R.layout.activity_menu_options);

        mRecyclerView = (RecyclerView) findViewById(R.id.foodRecycle);

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        mNavView = (NavigationView) findViewById(R.id.nav_view);
        mNavView.setNavigationItemSelectedListener(this);



        // NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //   mAppBarConfiguration = new AppBarConfiguration.Builder(
        //         R.id.nav_home)
        //       .setDrawerLayout(drawer)
        //        .build();
        //  NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //  NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //  NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

//    @Override
//    public boolean onSupportNavigateUp()
//    {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        return false;
    }

    private void setupViewPager(ViewPager viewPager){

        AdapterSectionsFood foodAdapter = new AdapterSectionsFood(getSupportFragmentManager());
        foodAdapter.addFragmentAllTypes(new FragmentAllTypes(), "All types");


        viewPager.setAdapter(foodAdapter);


    }

}