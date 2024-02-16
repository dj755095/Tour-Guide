package com.rohit.examples.android.IndiaTour.Data;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rohit.examples.android.IndiaTour.Model.Shop;
import com.rohit.examples.android.IndiaTour.R;

import java.util.ArrayList;

public class ShopData {

    //Method to fetch values from resources bundle
    public static ArrayList<Shop> fetchShopData(Context context) {

        ArrayList<Shop> shops = new ArrayList<>();
        Resources resources = context.getResources();
        SharedPreferences preferences = context.getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String selectedPlace = preferences.getString("places", "DefaultPlace");
        TypedArray typedArray = null;

        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            typedArray = resources.obtainTypedArray(R.array.shopMumbaiImageId);

        } else if ("Delhi".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.shopDelhiImageId);
            // Action for Delhi
        } else if ("Goa".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.shopGoaImageId);
            // Action for Goa
        } else if ("Manali".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.shopManaliImageId);
            // Action for Manali
        } else if ("Kashmir".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.shopKashmirImageId);
            // Action for Kashmir
        } else if ("Udaipur".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.shopUdaipurImageId);
            // Action for Udaipur
        } else if ("Bhopal".equals(selectedPlace)) {
            // Action for Bhopal
            typedArray = resources.obtainTypedArray(R.array.shopImgId);
        } else {
            // Default action if the selected place is not recognized
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }



        //Logic to fetch and store Shops Drawable
        int[] shopImgId = new int[typedArray.length()];
        for (int index = 0; index < shopImgId.length; index++) {
            shopImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Logic to fetch and store Shops Rating
        typedArray = resources.obtainTypedArray(R.array.shopRating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();


        String[] name = new String[0];
        String[] place = new String[0];
        String[] time = new String[0];
        String[] phone = new String[0];
        String[] address = new String[0];
        String[] image = new String[0];


        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            name = resources.getStringArray(R.array.shopmumbaiName);
            place = resources.getStringArray(R.array.shopmumbaiPlace);
            time = resources.getStringArray(R.array.shopmumbaiTime);
            phone = resources.getStringArray(R.array.shopmumbaiPhone);
            address = resources.getStringArray(R.array.shopmumbaiAddress);
            image = resources.getStringArray(R.array.shopMumbaiImage);
        } else if ("Delhi".equals(selectedPlace)) {
            // Action for Delhi
            name = resources.getStringArray(R.array.shopdelhiName);
            place = resources.getStringArray(R.array.shopdelhiPlace);
            time = resources.getStringArray(R.array.shopdelhiTime);
            phone = resources.getStringArray(R.array.shopdelhiPhone);
            address = resources.getStringArray(R.array.shopdelhiAddress);
            image = resources.getStringArray(R.array.shopDelhiImage);
        } else if ("Goa".equals(selectedPlace)) {
            // Action for Goa
            name = resources.getStringArray(R.array.shopgoaName);
            place = resources.getStringArray(R.array.shopgoaPlace);
            time = resources.getStringArray(R.array.shopgoaTime);
            phone = resources.getStringArray(R.array.shopgoaPhone);
            address = resources.getStringArray(R.array.shopgoaAddress);
            image = resources.getStringArray(R.array.shopGoaImage);
        } else if ("Manali".equals(selectedPlace)) {
            // Action for Manali
            name = resources.getStringArray(R.array.shopmanaliName);
            place = resources.getStringArray(R.array.shopmanaliPlace);
            time = resources.getStringArray(R.array.shopmanaliTime);
            phone = resources.getStringArray(R.array.shopmanaliPhone);
            address = resources.getStringArray(R.array.shopmanaliAddress);
            image = resources.getStringArray(R.array.shopManaliImage);
        } else if ("Kashmir".equals(selectedPlace)) {
            // Action for Kashmir
            name = resources.getStringArray(R.array.shopkashmirName);
            place = resources.getStringArray(R.array.shopkashmirPlace);
            time = resources.getStringArray(R.array.shopkashmirTime);
            phone = resources.getStringArray(R.array.shopkashmirPhone);
            address = resources.getStringArray(R.array.shopkashmirAddress);
            image = resources.getStringArray(R.array.shopKashmirImage);
        } else if ("Udaipur".equals(selectedPlace)) {
            // Action for Udaipur
            name = resources.getStringArray(R.array.shopudaipurName);
            place = resources.getStringArray(R.array.shopudaipurPlace);
            time = resources.getStringArray(R.array.shopudaipurTime);
            phone = resources.getStringArray(R.array.shopudaipurPhone);
            address = resources.getStringArray(R.array.shopudaipurAddress);
            image = resources.getStringArray(R.array.shopUdaipurImage);
        } else if ("Bhopal".equals(selectedPlace)) {
            name = resources.getStringArray(R.array.shopName);
            place = resources.getStringArray(R.array.shopPlace);
            time = resources.getStringArray(R.array.shopTime);
            phone = resources.getStringArray(R.array.shopPhone);
            address = resources.getStringArray(R.array.shopAddress);
            image = resources.getStringArray(R.array.shopImg);
        } else {
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }


        //Getting values from string-arrays to store data
//        String[] name = resources.getStringArray(R.array.shopName);
//        String[] place = resources.getStringArray(R.array.shopPlace);
//        String[] time = resources.getStringArray(R.array.shopTime);
//        String[] phone = resources.getStringArray(R.array.shopPhone);
//        String[] address = resources.getStringArray(R.array.shopAddress);
        String pre = "shop" + selectedPlace;
        Toast.makeText(context, "Referenced to "+ pre, Toast.LENGTH_SHORT).show();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("shop");
        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < shopImgId.length; i++) {
            Shop shop = new Shop(shopImgId[i], name[i], rating[i], phone[i], place[i], time[i], address[i]);
            Shop shop1 = new Shop(shopImgId[i], name[i], rating[i], phone[i], place[i], time[i], address[i],image[i]);
            ref.child(pre).child(name[i]).setValue(shop1);
            shops.add(shop1);
        }
        return shops;
    }
}