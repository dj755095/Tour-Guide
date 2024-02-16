package com.rohit.examples.android.IndiaTour.Data;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rohit.examples.android.IndiaTour.Model.Place;
import com.rohit.examples.android.IndiaTour.R;

import java.util.ArrayList;

public class PlaceData {

    //Method to fetch values from resources bundle
    public static ArrayList<Place> fetchPlaceData(Context context) {



        ArrayList<Place> places = new ArrayList<>();
        Resources resources = context.getResources();
        SharedPreferences preferences = context.getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String selectedPlace = preferences.getString("places", "DefaultPlace");
        TypedArray typedArray = null;

        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            typedArray = resources.obtainTypedArray(R.array.placeMumbaiImageId);
        } else if ("Delhi".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.placeDelhiImageId);
            // Action for Delhi
        } else if ("Goa".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.placeGoaImageId);
            // Action for Goa
        } else if ("Manali".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.placeManaliImageId);
            // Action for Manali
        } else if ("Kashmir".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.placeKashmirImageId);
            // Action for Kashmir
        } else if ("Udaipur".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.placeUdaipurImageId);
            // Action for Udaipur
        } else if ("Bhopal".equals(selectedPlace)) {
            // Action for Bhopal
            typedArray = resources.obtainTypedArray(R.array.placeImageId);
        } else {
            // Default action if the selected place is not recognized
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }

        //Logic to fetch and store Places Drawable
        int[] placeImgId = new int[typedArray.length()];
        for (int index = 0; index < placeImgId.length; index++) {
            placeImgId[index] = typedArray.getResourceId(index, 0);
        }


        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            typedArray = resources.obtainTypedArray(R.array.placeMumbaiRating);

        } else if ("Delhi".equals(selectedPlace)) {
            // Action for Delhi
            typedArray = resources.obtainTypedArray(R.array.placeDelhiRating);

        } else if ("Goa".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.placeGoaRating);
            // Action for Goa
        } else if ("Manali".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.placeManaliRating);
            // Action for Manali
        } else if ("Kashmir".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.placeKashmirRating);
            // Action for Kashmir
        } else if ("Udaipur".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.placeUdaipurRating);
            // Action for Udaipur
        } else if ("Bhopal".equals(selectedPlace)) {
            // Action for Bhopal
            typedArray = resources.obtainTypedArray(R.array.placeRating);

        } else {
            // Default action if the selected place is not recognized
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }
        //Logic to fetch and store Places Rating
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();


        String[] name = new String[0];
        String[] description = new String[0];
        String[] type = new String[0];
        String[] time = new String[0];
        String[] phone = new String[0];
        String[] address = new String[0];
        String[] image = new String[0];

        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            name = resources.getStringArray(R.array.PlacemumbaiName);
            description = resources.getStringArray(R.array.PlacemumbaiDescription);
            type = resources.getStringArray(R.array.PlacemumbaiType);
            time = resources.getStringArray(R.array.PlacemumbaiTime);
            phone = resources.getStringArray(R.array.PlacemumbaiPhone);
            address = resources.getStringArray(R.array.PlacemumbaiAddress);

            image = resources.getStringArray(R.array.placeMumbaiImage);
        } else if ("Delhi".equals(selectedPlace)) {
            // Action for Delhi
            name = resources.getStringArray(R.array.PlacedelhiName);
            description = resources.getStringArray(R.array.PlacedelhiDescription);
            type = resources.getStringArray(R.array.PlacedelhiType);
            time = resources.getStringArray(R.array.PlacedelhiTime);
            phone = resources.getStringArray(R.array.PlacedelhiPhone);
            address = resources.getStringArray(R.array.PlacedelhiAddress);

            image = resources.getStringArray(R.array.placeDelhiImage);

        } else if ("Goa".equals(selectedPlace)) {
            // Action for Goa
            name = resources.getStringArray(R.array.PlacegoaName);
            description = resources.getStringArray(R.array.PlacegoaDescription);
            type = resources.getStringArray(R.array.PlacegoaType);
            time = resources.getStringArray(R.array.PlacegoaTime);
            phone = resources.getStringArray(R.array.PlacegoaPhone);
            address = resources.getStringArray(R.array.PlacegoaAddress);

            image = resources.getStringArray(R.array.placeGoaImage);

        } else if ("Manali".equals(selectedPlace)) {
            // Action for Manali
            name = resources.getStringArray(R.array.PlacemanaliName);
            description = resources.getStringArray(R.array.PlacemanaliDescription);
            type = resources.getStringArray(R.array.PlacemanaliType);
            time = resources.getStringArray(R.array.PlacemanaliTime);
            phone = resources.getStringArray(R.array.PlacemanaliPhone);
            address = resources.getStringArray(R.array.PlacemanaliAddress);

            image = resources.getStringArray(R.array.placeManaliImage);

        } else if ("Kashmir".equals(selectedPlace)) {
            // Action for Kashmir
            name = resources.getStringArray(R.array.PlacekashmirName);
            description = resources.getStringArray(R.array.PlacekashmirDescription);
            type = resources.getStringArray(R.array.PlacekashmirType);
            time = resources.getStringArray(R.array.PlacekashmirTime);
            phone = resources.getStringArray(R.array.PlacekashmirPhone);
            address = resources.getStringArray(R.array.PlacekashmirAddress);

            image = resources.getStringArray(R.array.placeKashmirImage);

        } else if ("Udaipur".equals(selectedPlace)) {
            // Action for Udaipur
            name = resources.getStringArray(R.array.PlaceudaipurName);
            description = resources.getStringArray(R.array.PlaceudaipurDescription);
            type = resources.getStringArray(R.array.PlaceudaipurType);
            time = resources.getStringArray(R.array.PlaceudaipurTime);
            phone = resources.getStringArray(R.array.PlaceudaipurPhone);
            address = resources.getStringArray(R.array.PlaceudaipurAddress);

            image = resources.getStringArray(R.array.placeUdaipurImage);

        } else if ("Bhopal".equals(selectedPlace)) {
            name = resources.getStringArray(R.array.placeName);
            description = resources.getStringArray(R.array.PlaceDescription);
            type = resources.getStringArray(R.array.placeType);
            time = resources.getStringArray(R.array.placeTime);
            phone = resources.getStringArray(R.array.placePhone);
            address = resources.getStringArray(R.array.placeAddress);

            image = resources.getStringArray(R.array.PlaceImage);

        } else {
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }



        //Getting values from string-arrays to store data
//        String[] name = resources.getStringArray(R.array.placeName);
//        String[] type = resources.getStringArray(R.array.placeType);
//        String[] time = resources.getStringArray(R.array.placeTime);
//        String[] phone = resources.getStringArray(R.array.placePhone);
//        String[] address = resources.getStringArray(R.array.placeAddress);

        //Mapping data set with recycler view items accordingly
        String pre = "place" + selectedPlace;
        Toast.makeText(context, "Referenced to "+pre, Toast.LENGTH_SHORT).show();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("place");

        for (int i = 0; i < placeImgId.length; i++) {
            Place place = new Place(placeImgId[i], name[i], rating[i], type[i], time[i], phone[i], address[i], description[i]);
            Place plac2 = new Place(placeImgId[i], name[i], rating[i], type[i], time[i], phone[i], address[i], description[i],image[i]);
            ref.child(pre).child(name[i]).setValue(plac2);
            places.add(plac2);
        }

        return places;
    }
}

