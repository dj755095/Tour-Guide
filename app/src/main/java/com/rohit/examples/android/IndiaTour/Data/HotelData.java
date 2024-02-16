package com.rohit.examples.android.IndiaTour.Data;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rohit.examples.android.IndiaTour.Model.Hotel;
import com.rohit.examples.android.IndiaTour.R;

import java.util.ArrayList;

public class HotelData {

    //Method to fetch values from resources bundle
    public static ArrayList<Hotel> fetchHotelData(Context context) {

        ArrayList<Hotel> hotels = new ArrayList<>();
        Resources resources = context.getResources();
        SharedPreferences preferences = context.getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String selectedPlace = preferences.getString("places", "DefaultPlace");
        TypedArray typedArray = null;
        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            typedArray = resources.obtainTypedArray(R.array.hotelMumbaiImageId);

        } else if ("Delhi".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.hotelDelhiImageId);
            // Action for Delhi
        } else if ("Goa".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.hotelGoaImageId);
            // Action for Goa
        } else if ("Manali".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.hotelManaliImageId);
            // Action for Manali
        } else if ("Kashmir".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.hotelKashmirImageId);
            // Action for Kashmir
        } else if ("Udaipur".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.hotelUdaipurImageId);
            // Action for Udaipur
        } else if ("Bhopal".equals(selectedPlace)) {
            // Action for Bhopal
            typedArray = resources.obtainTypedArray(R.array.hotelImgID);
        } else {
            // Default action if the selected place is not recognized
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }
        //Logic to fetch and store Hotels Drawable
        int[] hotelImgId = new int[typedArray.length()];
        for (int index = 0; index < hotelImgId.length; index++) {
            hotelImgId[index] = typedArray.getResourceId(index, 0);
        }

        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            typedArray = resources.obtainTypedArray(R.array.hotelMumbaiRating);

        } else if ("Delhi".equals(selectedPlace)) {
            // Action for Delhi
            typedArray = resources.obtainTypedArray(R.array.hotelDelhiRating);

        } else if ("Goa".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.hotelGoaRating);
            // Action for Goa
        } else if ("Manali".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.hotelManaliRating);
            // Action for Manali
        } else if ("Kashmir".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.hotelKashmirRating);
            // Action for Kashmir
        } else if ("Udaipur".equals(selectedPlace)) {
            typedArray = resources.obtainTypedArray(R.array.hotelUdaipurRating);
            // Action for Udaipur
        } else if ("Bhopal".equals(selectedPlace)) {
            // Action for Bhopal
            typedArray = resources.obtainTypedArray(R.array.hotelRating);

        } else {
            // Default action if the selected place is not recognized
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }
        //Logic to fetch and store Hotels Rating
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();


        String[] name = new String[0];
        String[] type = new String[0];
        String[] phone = new String[0];
        String[] address = new String[0];
        String[] image = new String[0];

        if ("Mumbai".equals(selectedPlace)) {
            // Action for Mumbai
            name = resources.getStringArray(R.array.hotelmumbaiName);
            type = resources.getStringArray(R.array.hotelmumbaiType);
            phone = resources.getStringArray(R.array.hotelmumbaiPhone);
            address = resources.getStringArray(R.array.hotelmumbaiAddress);
            image = resources.getStringArray(R.array.hotelMumbaiImage);
        } else if ("Delhi".equals(selectedPlace)) {
            // Action for Delhi
            name = resources.getStringArray(R.array.hoteldelhiName);
            type = resources.getStringArray(R.array.hoteldelhiType);
            phone = resources.getStringArray(R.array.hoteldelhiPhone);
            address = resources.getStringArray(R.array.hoteldelhiAddress);
            image = resources.getStringArray(R.array.hotelDelhiImage);
        } else if ("Goa".equals(selectedPlace)) {
            // Action for Goa
            name = resources.getStringArray(R.array.hotelgoaName);
            type = resources.getStringArray(R.array.hotelgoaType);
            phone = resources.getStringArray(R.array.hotelgoaPhone);
            address = resources.getStringArray(R.array.hotelgoaAddress);
            image = resources.getStringArray(R.array.hotelGoaImage);
        } else if ("Manali".equals(selectedPlace)) {
            // Action for Manali
            name = resources.getStringArray(R.array.hotelmanaliName);
            type = resources.getStringArray(R.array.hotelmanaliType);
            phone = resources.getStringArray(R.array.hotelmanaliPhone);
            address = resources.getStringArray(R.array.hotelmanaliAddress);
            image = resources.getStringArray(R.array.hotelManaliImage);
        } else if ("Kashmir".equals(selectedPlace)) {
            // Action for Kashmir
            name = resources.getStringArray(R.array.hotelkashmirName);
            type = resources.getStringArray(R.array.hotelkashmirType);
            phone = resources.getStringArray(R.array.hotelkashmirPhone);
            address = resources.getStringArray(R.array.hotelkashmirAddress);
            image = resources.getStringArray(R.array.hotelKashmirImage);
        } else if ("Udaipur".equals(selectedPlace)) {
            // Action for Udaipur
            name = resources.getStringArray(R.array.hoteludaipurName);
            type = resources.getStringArray(R.array.hoteludaipurType);
            phone = resources.getStringArray(R.array.hoteludaipurPhone);
            address = resources.getStringArray(R.array.hoteludaipurAddress);
            image = resources.getStringArray(R.array.hotelUdaipurImage);
        } else if ("Bhopal".equals(selectedPlace)) {
            name = resources.getStringArray(R.array.hotelName);
            type = resources.getStringArray(R.array.hotelType);
            phone = resources.getStringArray(R.array.hotelPhone);
            address = resources.getStringArray(R.array.hotelAddress);
            image = resources.getStringArray(R.array.hotelImage);
        } else {
            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
        }

        //Getting values from string-arrays to store data
//        String[] name = resources.getStringArray(R.array.hotelName);
//        String[] type = resources.getStringArray(R.array.hotelType);
//        String[] phone = resources.getStringArray(R.array.hotelPhone);
//        String[] address = resources.getStringArray(R.array.hotelAddress);
        String pre = "hotel" + selectedPlace;
        Toast.makeText(context, "Referenced to "+ pre, Toast.LENGTH_SHORT).show();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("hotel");
        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < hotelImgId.length; i++) {
            Hotel hotel = new Hotel(hotelImgId[i], name[i], rating[i], phone[i], type[i], address[i]);
            Hotel hotel2 = new Hotel(hotelImgId[i], name[i], rating[i], phone[i], type[i], address[i],image[i]);
            ref.child(pre).child(name[i]).setValue(hotel2);
            hotels.add(hotel2);
        }
        return hotels;
    }
}