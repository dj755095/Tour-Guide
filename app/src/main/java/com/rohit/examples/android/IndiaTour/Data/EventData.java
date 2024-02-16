package com.rohit.examples.android.IndiaTour.Data;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.widget.Toast;

import com.rohit.examples.android.IndiaTour.Model.Event;
import com.rohit.examples.android.IndiaTour.R;

import java.util.ArrayList;

public class EventData {

    //Method to fetch values from resources bundle
    public static ArrayList<Event> fetchEventData(Context context) {

        ArrayList<Event> events = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store Events Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.eventImgId);
        int[] eventImgId = new int[typedArray.length()];
        for (int index = 0; index < eventImgId.length; index++) {
            eventImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

//        SharedPreferences preferences = context.getSharedPreferences("MyPrefs", MODE_PRIVATE);
//        String selectedPlace = preferences.getString("places", "DefaultPlace");
//        String[] name = new String[0];
//        String[] date = new String[0];
//        String[] time = new String[0];
//        String[] place = new String[0];
//        String[] url = new String[0];
//
//        if ("Mumbai".equals(selectedPlace)) {
//            // Action for Mumbai
//        } else if ("Delhi".equals(selectedPlace)) {
//            // Action for Delhi
//        } else if ("Goa".equals(selectedPlace)) {
//            // Action for Goa
//        } else if ("Manali".equals(selectedPlace)) {
//            // Action for Manali
//        } else if ("Kashmir".equals(selectedPlace)) {
//            // Action for Kashmir
//        } else if ("Udaipur".equals(selectedPlace)) {
//            // Action for Udaipur
//        } else if ("Bhopal".equals(selectedPlace)) {
//            name = resources.getStringArray(R.array.eventName);
//            date = resources.getStringArray(R.array.eventDate);
//            time = resources.getStringArray(R.array.eventTime);
//            place = resources.getStringArray(R.array.eventPlace);
//            url = resources.getStringArray(R.array.eventUrl);
//        } else {
//            Toast.makeText(context, "Kuch Toh gadbad h babu bhaiya", Toast.LENGTH_SHORT).show();
//        }
//        //Getting values from string-arrays to store data
        String[] name = resources.getStringArray(R.array.eventName);
        String[] date = resources.getStringArray(R.array.eventDate);
        String[] time = resources.getStringArray(R.array.eventTime);
        String[] place = resources.getStringArray(R.array.eventPlace);
        String[] url = resources.getStringArray(R.array.eventUrl);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < eventImgId.length; i++) {
            Event event = new Event(eventImgId[i], name[i], date[i], time[i], place[i], url[i]);
            events.add(event);
        }
        return events;
    }
}