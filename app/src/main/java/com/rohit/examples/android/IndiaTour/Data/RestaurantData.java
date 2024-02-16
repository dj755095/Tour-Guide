package com.rohit.examples.android.IndiaTour.Data;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rohit.examples.android.IndiaTour.Model.Restaurant;
import com.rohit.examples.android.IndiaTour.R;

import java.util.ArrayList;

public class RestaurantData {

    //Method to fetch values from resources bundle
    public static ArrayList<Restaurant> fetchRestaurantData(Context context) {

        ArrayList<Restaurant> restaurants = new ArrayList<>();
        Resources resources = context.getResources();
        SharedPreferences preferences = context.getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String selectedPlace = preferences.getString("places", "DefaultPlace");
        TypedArray typedArray = null;


        //Logic to fetch and store Restaurants Drawable
        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            typedArray = resources.obtainTypedArray(R.array.restoMumbaiImageId);

        } else if ("Delhi".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.restoDelhiImageId);
            // Action for Delhi
        } else if ("Goa".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.restoGoaImageId);
            // Action for Goa
        } else if ("Manali".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.restoManaliImageId);
            // Action for Manali
        } else if ("Kashmir".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.restoKashmirImageId);
            // Action for Kashmir
        } else if ("Udaipur".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.restoUdaipurImageId);
            // Action for Udaipur
        } else if ("Bhopal".equals(selectedPlace)) {
            // Action for Bhopal
            typedArray = resources.obtainTypedArray(R.array.restoImgId);
        } else {
            // Default action if the selected place is not recognized
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }
        int[] restoImgId = new int[typedArray.length()];
        for (int index = 0; index < restoImgId.length; index++) {
            restoImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Logic to fetch and store Restaurants Rating
        typedArray = resources.obtainTypedArray(R.array.restoRating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

        String[] name = new String[0];
        String[] time = new String[0];
        String[] phone = new String[0];
        String[] type = new String[0];
        String[] address = new String[0];
        String[] url = new String[0];
        String[] image = new String[0];

        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            name = resources.getStringArray(R.array.restmumbaiName);
            time = resources.getStringArray(R.array.restmumbaiTime);
            phone = resources.getStringArray(R.array.restmumbaiPhone);
            type = resources.getStringArray(R.array.restmumbaiType);
            address = resources.getStringArray(R.array.restmumbaiAddress);
            url = resources.getStringArray(R.array.restmumbaiUrl);
            image = resources.getStringArray(R.array.restmumbaiImage);
        } else if ("Delhi".equals(selectedPlace)) {
            // Action for Delhi
            name = resources.getStringArray(R.array.restdelhiName);
            time = resources.getStringArray(R.array.restdelhiTime);
            phone = resources.getStringArray(R.array.restdelhiPhone);
            type = resources.getStringArray(R.array.restdelhiType);
            address = resources.getStringArray(R.array.restdelhiAddress);
            url = resources.getStringArray(R.array.restdelhiUrl);
            image = resources.getStringArray(R.array.restdelhiImage);
        } else if ("Goa".equals(selectedPlace)) {
            // Action for Goa
            name = resources.getStringArray(R.array.restgoaName);
            time = resources.getStringArray(R.array.restgoaTime);
            phone = resources.getStringArray(R.array.restgoaPhone);
            type = resources.getStringArray(R.array.restgoaType);
            address = resources.getStringArray(R.array.restgoaAddress);
            url = resources.getStringArray(R.array.restgoaUrl);
            image = resources.getStringArray(R.array.restgoaImage);
        } else if ("Manali".equals(selectedPlace)) {
            // Action for Manali
            name = resources.getStringArray(R.array.restmanaliName);
            time = resources.getStringArray(R.array.restmanaliTime);
            phone = resources.getStringArray(R.array.restmanaliPhone);
            type = resources.getStringArray(R.array.restmanaliType);
            address = resources.getStringArray(R.array.restmanaliAddress);
            url = resources.getStringArray(R.array.restmanaliUrl);
            image = resources.getStringArray(R.array.restmanaliImage);
        } else if ("Kashmir".equals(selectedPlace)) {
            // Action for Kashmir
            name = resources.getStringArray(R.array.restkashmirName);
            time = resources.getStringArray(R.array.restkashmirTime);
            phone = resources.getStringArray(R.array.restkashmirPhone);
            type = resources.getStringArray(R.array.restkashmirType);
            address = resources.getStringArray(R.array.restkashmirAddress);
            url = resources.getStringArray(R.array.restkashmirUrl);
            image = resources.getStringArray(R.array.restkashmirImage);
        } else if ("Udaipur".equals(selectedPlace)) {
            // Action for Udaipur
            name = resources.getStringArray(R.array.restudaipurName);
            time = resources.getStringArray(R.array.restudaipurTime);
            phone = resources.getStringArray(R.array.restudaipurPhone);
            type = resources.getStringArray(R.array.restudaipurType);
            address = resources.getStringArray(R.array.restudaipurAddress);
            url = resources.getStringArray(R.array.restudaipurUrl);
            image = resources.getStringArray(R.array.restudaipurImage);
        } else if ("Bhopal".equals(selectedPlace)) {
            name = resources.getStringArray(R.array.restoName);
            time = resources.getStringArray(R.array.restoTime);
            phone = resources.getStringArray(R.array.restoPhone);
            type = resources.getStringArray(R.array.restoType);
            address = resources.getStringArray(R.array.restoAddress);
            url = resources.getStringArray(R.array.restoUrl);
            image = resources.getStringArray(R.array.restoImage);
        } else {
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }

        //Getting values from string-arrays to store data
//        String[] name = resources.getStringArray(R.array.restoName);
//        String[] time = resources.getStringArray(R.array.restoTime);
//        String[] phone = resources.getStringArray(R.array.restoPhone);
//        String[] type = resources.getStringArray(R.array.restoType);
//        String[] address = resources.getStringArray(R.array.restoAddress);
//        String[] url = resources.getStringArray(R.array.restoUrl);

        //Mapping data set with recycler view items accordingly
        String pre = "restaurant" + selectedPlace;
        Toast.makeText(context, "Referenced to "+ pre, Toast.LENGTH_SHORT).show();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("restaurant");
        for (int i = 0; i < restoImgId.length; i++) {
            Restaurant restaurant = new Restaurant(restoImgId[i], name[i], rating[i], type[i], phone[i], time[i], address[i], url[i]);
            Restaurant restaurant2 = new Restaurant(restoImgId[i], name[i], rating[i], type[i], phone[i], time[i], address[i], url[i],image[i]);
            ref.child(pre).child(name[i]).setValue(restaurant2);
            restaurants.add(restaurant2);
        }
        return restaurants;
    }
}