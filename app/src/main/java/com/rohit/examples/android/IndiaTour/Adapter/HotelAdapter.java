package com.rohit.examples.android.IndiaTour.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohit.examples.android.IndiaTour.Model.Hotel;
import com.rohit.examples.android.IndiaTour.Utils.Utils;
import com.rohit.examples.android.IndiaTour.R;

import java.io.File;
import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private final ArrayList<Hotel> hotels;
    private static final String EXTERNAL_STORAGE_FOLDER = "HamraStorage";

    private final Context context;

    /**
     * Constructor to initialize the adapter with current context object and Hotels list
     *
     * @param context access to application-specific resources and classes
     * @param hotels  getting hotels list
     */
    public HotelAdapter(ArrayList<Hotel> hotels, Context context) {
        this.hotels = hotels;
        this.context = context;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
     * Inflating hotels fragment layout
     *
     * @param viewGroup ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType  the view type of the new View
     * @return returns a new ViewHolder that holds a View of the given view type
     */
    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new HotelViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.layout_hotel_fragment, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param hotelViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param position        The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull final HotelAdapter.HotelViewHolder hotelViewHolder, int position) {
        //Storing the stable ID for the item at position
        final Hotel hotel = hotels.get(position);

        //Based on item position, storing the data accordingly
        String imageName = hotel.getHotelImage(); // Replace "your_image_name.jpg" with the actual name of your image file
//        Demo d = new Demo();
        if (imageName != null && !imageName.isEmpty()) {
            Bitmap bitmap = loadImageFromExternalStorage(imageName);
            if (bitmap != null) {
                hotelViewHolder.hotelImage.setImageBitmap(bitmap);
            } else {
                hotelViewHolder.hotelImage.setImageResource(R.drawable.bhopal);
            }
        } else {
            hotelViewHolder.hotelImage.setImageResource(R.drawable.bhopal); // Set a default image resource
        }


        hotelViewHolder.hotelTitle.setText(hotel.getHotelTitle());
        hotelViewHolder.hotelRating.setText(String.valueOf(hotel.getHotelRating()));
        hotelViewHolder.hotelRatingBar.setRating(hotel.getHotelRating());
        hotelViewHolder.hotelType.setText(hotel.getHotelType());

        //Click Listener to open a detail intent, displaying more info about hotels
        hotelViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, hotel, hotelViewHolder.hotelImage);
            }
        });
    }
    public Bitmap loadImageFromExternalStorage(String imageName) {
        Bitmap bitmap = null;

        // Check if external storage is available and readable
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // External storage is available and readable
            File hamraStorageDir = new File(context.getExternalFilesDir(null), EXTERNAL_STORAGE_FOLDER);

            // List all files in the directory
            File[] files = hamraStorageDir.listFiles();
            if (files != null) {
                // Iterate through the files and find the one matching the provided image name
                for (File file : files) {
                    if (file.getName().startsWith(imageName)) {
                        // Image file found, decode it into a Bitmap
                        bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        break; // Stop iterating after finding the first matching file
                    }
                }
            }
        }

        return bitmap;
    }

    /**
     * Method to count number of items in data set
     *
     * @return returns the total number of items in the data set held by the adapter
     */
    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final ImageView hotelImage;
        final TextView hotelTitle;
        final TextView hotelRating;
        final RatingBar hotelRatingBar;
        final TextView hotelType;
        final LinearLayout constraintLayout;

        HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            // Fetching view IDs for view elements from resource
            hotelImage = itemView.findViewById(R.id.hotel_image);
            hotelTitle = itemView.findViewById(R.id.hotel_name);
            hotelRating = itemView.findViewById(R.id.rating);
            hotelRatingBar = itemView.findViewById(R.id.ratingBar);
            hotelType = itemView.findViewById(R.id.hotel_type);
            constraintLayout = itemView.findViewById(R.id.parent);
        }
    }
}