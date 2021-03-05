package com.example.android_project.common;

import android.app.Application;
import android.database.Cursor;

import com.example.android_project.arrays.ArrayListFood;
import com.example.android_project.db.WMDBAPI;
import com.example.android_project.db.WMSQLiteOpenHelper;
import com.example.android_project.entities.Food;
import com.example.android_project.entities.FoodTypes;

import static com.example.android_project.db.WMSQLiteOpenHelper.FLD_FOOD_NAME;
import static com.example.android_project.db.WMSQLiteOpenHelper.TBL_FOOD;

public class Project extends Application
{
    public static Project APP_INSTANCE = null;
    private WMDBAPI mWMDBAPI;


    private ArrayListFood mArrayListFood;

    @Override
    public void onCreate()
    {
        super.onCreate();
        super.getApplicationContext().deleteDatabase("project.db");
        mWMDBAPI = new WMDBAPI(this);

        mArrayListFood = new ArrayListFood();

        APP_INSTANCE = this;

        addBasicItems();
    }

    public WMDBAPI getWMDBAPI() {
        return mWMDBAPI;
    }
    public ArrayListFood getmArrayListFood()
    {
        return mArrayListFood;
    }

    public void setmArrayListFood(ArrayListFood mArrayListFood)
    {
        this.mArrayListFood = mArrayListFood;
    }


    private void addBasicItems(){
        if(mWMDBAPI.getCount() > 0)
            return;

        // <--- MAIN MEAL --->
        Food f = new Food();
        f.setType(FoodTypes.MainDish.getType());
        f.setName("Big Mac");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Big-Mac.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.MainDish.getType());
        f.setName("Quarter Pounder with Cheese");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Quarter-Pounder-with-Cheese.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.MainDish.getType());
        f.setName("Double Quarter Pounder with Cheese");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Double-Quarter-Pounder-with-Cheese.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.MainDish.getType());
        f.setName("Cheeseburger");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Cheeseburger.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.MainDish.getType());
        f.setName("McDouble");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-McDouble.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        // <--- HOT DRINKS --->

        f.setType(FoodTypes.HotDrinks.getType());
        f.setName("Caramel Macchiato");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-caramel-macchiato.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.HotDrinks.getType());
        f.setName("Cappuccino");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-cappuccino.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);f.setType(FoodTypes.HotDrinks.getType());
        f.setName("Mocha");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-McCafe-Mocha-Medium.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);f.setType(FoodTypes.HotDrinks.getType());
        f.setName("Latte");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-McCafe-Latte-Medium.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);f.setType(FoodTypes.HotDrinks.getType());
        f.setName("Americano");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-americano.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        // <--- COLD DRINKS --->
        f.setType(FoodTypes.ColdDrinks.getType());
        f.setName("Coca cola");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Coca-Cola-Classic-Small.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.ColdDrinks.getType());
        f.setName("Sprite");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Sprite-Small.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.ColdDrinks.getType());
        f.setName("Fanta Orange");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-fanta-orange.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.ColdDrinks.getType());
        f.setName("Chocolate shake");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Chocolate-McCafe-Shake-Medium.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.ColdDrinks.getType());
        f.setName("iced tea");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Iced-Tea-Large.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);


        // <--- Salads --->
        f.setType(FoodTypes.Salad.getType());
        f.setName("Avocado Crunch Salad");
        f.setPrice(10);
        f.setImage("https://s3.amazonaws.com/alif-alif-online-store-production/ojs/spree/products/71/large/Avocado_Crunch_Salad-_big.png?1613501338");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Salad.getType());
        f.setName("Farmer's Garden Salad");
        f.setPrice(10);
        f.setImage("https://s3.amazonaws.com/alif-alif-online-store-production/ojs/spree/products/61/large/Farmers_Garden_Salad-2.png?1613481566");

        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Salad.getType());
        f.setName("Crispy Thai Salad");
        f.setPrice(10);
        f.setImage("https://s3.amazonaws.com/alif-alif-online-store-production/ojs/spree/products/66/large/Crispy_Thai_Salad_.png?1613486393");

        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Salad.getType());
        f.setName("OJ's Strawberry Salad");
        f.setPrice(10);
        f.setImage("https://s3.amazonaws.com/alif-alif-online-store-production/ojs/spree/products/70/large/OJ" + "'s_Strawberry_Salad_big_.png?1613494865");
        mWMDBAPI.saveFood(f);

    }
}
