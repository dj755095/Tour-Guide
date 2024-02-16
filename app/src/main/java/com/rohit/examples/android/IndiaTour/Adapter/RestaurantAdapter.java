package com.rohit.examples.android.IndiaTour.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rohit.examples.android.IndiaTour.Model.Restaurant;
import com.rohit.examples.android.IndiaTour.Utils.Utils;
import com.rohit.examples.android.IndiaTour.R;

import java.io.File;
import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private final Context context;    private static final String EXTERNAL_STORAGE_FOLDER = "HamraStorage";
    private final ArrayList<Restaurant> restaurants;

    /**
     * Constructor to initialize the adapter with current context object and Restaurants list
     *
     * @param context     access to application-specific resources and classes
     * @param restaurants Getting restaurants list
     */
    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
     * Inflating restaurants fragment layout
     *
     * @param viewGroup ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType  the view type of the new View
     * @return returns a new ViewHolder that holds a View of the given view type
     */
    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RestaurantViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_restaurant_fragment, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param restaurantViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param position             The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull final RestaurantViewHolder restaurantViewHolder, int position) {

        //Storing the stable ID for the item at position
        final Restaurant restaurant = restaurants.get(position);

        //Based on item position, storing the data accordingly
        String imageName = restaurant.getRestaurantImage(); // Replace "your_image_name.jpg" with the actual name of your image file
//        Demo d = new Demo();
        if (imageName != null && !imageName.isEmpty()) {
            Bitmap bitmap = loadImageFromExternalStorage(imageName);
            if (bitmap != null) {
                restaurantViewHolder.restoImg.setImageBitmap(bitmap);
            } else {
                restaurantViewHolder.restoImg.setImageResource(R.drawable.bhopal);
            }
        } else {
            restaurantViewHolder.restoImg.setImageResource(R.drawable.bhopal); // Set a default image resource
        }



//        restaurantViewHolder.restoImg.setImageResource(restaurant.getRestaurantImageId());
        restaurantViewHolder.restoTitle.setText(restaurant.getRestaurantTitle());
        restaurantViewHolder.restoType.setText(restaurant.getRestaurantType());
        restaurantViewHolder.restoRating.setText(String.valueOf(restaurant.getRestaurantRating()));
        restaurantViewHolder.restoRatingBar.setRating(restaurant.getRestaurantRating());

        //Click Listener to open a detail intent, displaying more info about restaurants
        restaurantViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, restaurant, restaurantViewHolder.restoImg);
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
        return restaurants.size();
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final ImageView restoImg;
        final TextView restoTitle;
        final TextView restoType;
        final TextView restoRating;
        final RatingBar restoRatingBar;
        final CardView cardView;

        RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            // Fetching view IDs for view elements from resource
            restoImg = itemView.findViewById(R.id.restaurant_image);
            restoTitle = itemView.findViewById(R.id.restaurant_name);
            restoType = itemView.findViewById(R.id.restaurant_type);
            restoRating = itemView.findViewById(R.id.rating);
            restoRatingBar = itemView.findViewById(R.id.ratingBar);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}