package com.example.android_project.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.android_project.R;
import com.example.android_project.adapters.AdapterSectionsFood;
import com.example.android_project.adapters.RecyclerViewAdapter;
import com.example.android_project.common.Project;
import com.example.android_project.db.WMDBAPI;
import com.example.android_project.db.WMSQLiteOpenHelper;
import com.example.android_project.entities.Food;
import com.example.android_project.entities.FoodTypes;
import com.example.android_project.fragments.FragmentAllTypes;
import com.example.android_project.fragments.FragmentSalad;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.regex.Pattern;


public class MenuOptions extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private Context mContext;

    RecyclerView recyclerView;
    WMDBAPI db;
    Project project;

    int currentTab = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();
        project = Project.APP_INSTANCE;
        mContext = this;
        recyclerView = findViewById(R.id.foodRecycle);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        db = Project.APP_INSTANCE.getWMDBAPI();
        project.setmArrayListFood(db.loadFoodList(FoodTypes.MainDish.getType()));


        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mContext, project.getmArrayListFood(), null);
        recyclerView.setAdapter(recyclerViewAdapter);


        (findViewById(R.id.AddButton)).setOnClickListener(v -> showDialogAdd());
        (findViewById(R.id.RemoveButton)).setOnClickListener(v -> showDialogRemove());
    }

    private void showDialogRemove(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View dialogView = inflater.inflate(R.layout.deletedatadialog, null);
        dialogBuilder.setView(dialogView);
        final EditText foodname = dialogView.findViewById(R.id.foodname);

        dialogBuilder.setTitle("Enter Food Data");
        dialogBuilder.setMessage("All data must be entered");
        dialogBuilder.setPositiveButton("Remove", (dialog, which) -> {
            if(foodname.getText().length() == 0){
                Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "You must enter the food name", Toast.LENGTH_SHORT).show();
                return;
            }
            db.removeFood(foodname.getText().toString());
            updateTab(currentTab);
        });

        dialogBuilder.setNegativeButton("Cancel", (dialog, whichButton) -> {
            // pass
        });
        AlertDialog ad = dialogBuilder.create();
        ad.show();
        ad.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED);
    }
    private void showDialogAdd() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext).setTitle("thi is good");
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View dialogView = inflater.inflate(R.layout.enterdatadialog, null);
        dialogBuilder.setView(dialogView);

        final EditText foodname = dialogView.findViewById(R.id.foodname);
        final EditText foodprice = dialogView.findViewById(R.id.foodprice);
        final Spinner foodtype = dialogView.findViewById(R.id.foodtype);
        final EditText foodimage = dialogView.findViewById(R.id.foodimage);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.foodtypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodtype.setAdapter(adapter);

        dialogBuilder.setTitle("Enter Food Data");
        dialogBuilder.setMessage("All data must be entered");
        dialogBuilder.setPositiveButton("Save", (dialog, whichButton) -> {
            if (foodname.getText().length() == 0) {
                Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "You must enter the food name", Toast.LENGTH_SHORT).show();
                return;
            }
            if (foodprice.getText().length() == 0) {
                Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "You must enter the food price", Toast.LENGTH_SHORT).show();
                return;
            }
            if (foodimage.getText().length() == 0) {
                Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "You must enter the food url", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!Pattern.matches(Patterns.WEB_URL.pattern(),foodimage.getText().toString())) {
                Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "You must enter a valid url", Toast.LENGTH_SHORT).show();
                return;
            }
            if(!foodimage.getText().toString().contains(".jpg") && !foodimage.getText().toString().contains(".png") && !foodimage.getText().toString().contains(".jpeg")){
                Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "You must enter a valid url that is a picture of type {jpg, png, jpeg}", Toast.LENGTH_SHORT).show();
                return;
            }

            Food food = new Food();
            food.setName(foodname.getText().toString());
            switch (foodtype.getSelectedItemPosition()){
                case 0:
                    food.setType(FoodTypes.MainDish.getType()); break;
                case 1:
                    food.setType(FoodTypes.Salad.getType()); break;
                case 2:
                    food.setType(FoodTypes.HotDrinks.getType()); break;
                case 3:
                    food.setType(FoodTypes.ColdDrinks.getType()); break;
            }
            food.setPrice(Integer.parseInt(foodprice.getText().toString()));
            food.setImage(foodimage.getText().toString());
            db.saveFood(food);
            updateTab(currentTab);
            Toast.makeText(Project.APP_INSTANCE.getApplicationContext(), "Successfully added the food", Toast.LENGTH_SHORT).show();
        });
        dialogBuilder.setNegativeButton("Cancel", (dialog, whichButton) -> {
            //pass
        });
        dialogBuilder.create().show();
    }

    public void initComponents() {
        setContentView(R.layout.activity_menu_options);

        ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);


        Toolbar toolbar = findViewById(R.id.toolbar);
        TabLayout tabtab = findViewById(R.id.tabFoodTypes);
        tabtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                System.out.println("Tab {" + tab.getPosition() + "} Got selected");
                currentTab = tab.getPosition();
                updateTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView mNavView = findViewById(R.id.nav_view);
        mNavView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    private void setupViewPager(ViewPager viewPager) {

        AdapterSectionsFood foodAdapter = new AdapterSectionsFood(getSupportFragmentManager());
//        foodAdapter.addFragment(new FragmentSalad(), "Salad");
//        foodAdapter.addFragment(new FragmentAllTypes(), "Main");

        viewPager.setAdapter(foodAdapter);
    }

    public void updateTab(int id){
        switch (id) {
            case 0:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.MainDish.getType()));
                break;
            case 1:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.Salad.getType()));
                break;
            case 2:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.HotDrinks.getType()));
                break;
            case 3:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.ColdDrinks.getType()));
                break;
        }
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mContext, project.getmArrayListFood(), null);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}