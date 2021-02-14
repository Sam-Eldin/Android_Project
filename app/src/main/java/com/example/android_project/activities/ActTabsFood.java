package com.example.android_project.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.android_project.R;
import com.example.android_project.adapters.AdapterSectionsFood;
import com.example.android_project.adapters.RecyclerViewAdapter;
import com.example.android_project.entities.Food;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class ActTabsFood extends AppCompatActivity
{
    private AdapterSectionsFood mAdapterSectionsFood;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        mAdapterSectionsFood = new AdapterSectionsFood(getSupportFragmentManager());

        initComponents();
    }

    public void initComponents(){
        // Set up the ViewPager with the sections adapter
        mViewPager = (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabFoodTypes);
        tabLayout.setupWithViewPager(mViewPager);

    }


    private void setupViewPager(ViewPager viewPager){

        AdapterSectionsFood foodAdapter = new AdapterSectionsFood(getSupportFragmentManager());
        foodAdapter.addFragmentAllTypes(new FragmentAllTypes(), "All types");

        viewPager.setAdapter(foodAdapter);

    }

    /***
     * public View onCreateView(@NonNull LayoutInflater inflater,
     *                              ViewGroup container, Bundle savedInstanceState)
     *     {
     *         mContext = Project.APP_INSTANCE.getApplicationContext();
     *
     *         homeViewModel =
     *                 new ViewModelProvider(this).get(HomeViewModel.class);
     *         View root = inflater.inflate(R.layout.fragment_home, container, false);
     *         final Button button = root.findViewById(R.id.takePicture);
     *         button.setOnClickListener(view -> {
     *             System.out.println("hello");
     *             Food mFood = new Food();
     *
     *             mFood.setName("a");
     *             mFood.setType("B");
     *             mFood.setPrice(10);
     *             Intent intent = new Intent();
     *             intent.setAction(Intent.ACTION_GET_CONTENT);
     *             startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
     *           //  mFood.setImagePath("\"/src/UI/Images/default_pic.png\"");
     *             intent.setType("image/*");
     *
     *        //     Project.APP_INSTANCE.getWMDBAPI().saveFood(mFood);
     *
     *         });
     *         homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>()
     *         {
     *             @Override
     *             public void onChanged(@Nullable String s)
     *             {
     *
     *             }
     *         });
     *         return root;
     *     }
     *     @Override
     *     public void onActivityResult(int requestCode, int resultCode, Intent data)
     *     {
     *         super.onActivityResult(requestCode, resultCode, data);
     *
     *         if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
     *             mUri = data.getData();
     *
     *             try {
     *                 InputStream inputStream = mContext.getContentResolver().openInputStream(mUri);
     *
     *                 Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
     *
     *                 //mimgProjectIcon.setImageURI(mImgUri);
     *                 //mimgProjectIcon.setImageBitmap((Bitmap) data.getExtras().get("data"));
     *             } catch (FileNotFoundException e) {
     *                 e.printStackTrace();
     *             }
     *         }
     *         super.onActivityResult(requestCode, resultCode, data);        }
     * }
     *
     *
     * ***/
}
