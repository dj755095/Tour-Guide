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

import com.rohit.examples.android.IndiaTour.Model.Shop;
import com.rohit.examples.android.IndiaTour.Utils.Utils;
import com.rohit.examples.android.IndiaTour.R;

import java.io.File;
import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private final Context context;    private static final String EXTERNAL_STORAGE_FOLDER = "HamraStorage";
    private final ArrayList<Shop> shops;

    /**
     * Constructor to initialize the adapter with current context object and Restaurants list
     *
     * @param context access to application-specific resources and classes
     * @param shops   Getting shops list
     */
    public ShopAdapter(Context context, ArrayList<Shop> shops) {
        this.context = context;
        this.shops = shops;
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
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ShopViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_shopping_fragment, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param shopViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param position       The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull final ShopViewHolder shopViewHolder, int position) {

        //Storing the stable ID for the item at position
        final Shop shop = shops.get(position);

        String imageName = shop.getShopImage(); // Replace "your_image_name.jpg" with the actual name of your image file
//        Demo d = new Demo();
        if (imageName != null && !imageName.isEmpty()) {
            Bitmap bitmap = loadImageFromExternalStorage(imageName);
            if (bitmap != null) {
                shopViewHolder.shopImg.setImageBitmap(bitmap);
            } else {
                shopViewHolder.shopImg.setImageResource(R.drawable.bhopal);
            }
        } else {
            shopViewHolder.shopImg.setImageResource(R.drawable.bhopal);// set a default image resource
        }
            // Image loaded successfully, display it in an ImageView

        //Based on item position, storing the data accordingly
//        shopViewHolder.shopImg.setImageResource(shop.getShopImageId());
        shopViewHolder.shopTitle.setText(shop.getShopTitle());
        shopViewHolder.shopPlace.setText(shop.getShopPlace());
        shopViewHolder.shopRating.setText(String.valueOf(shop.getShopRating()));
        shopViewHolder.shopRatingBar.setRating(shop.getShopRating());

        //Click Listener to open a detail intent, displaying more info about shops
        shopViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, shop, shopViewHolder.shopImg);
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
        return shops.size();
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final ImageView shopImg;
        final TextView shopTitle;
        final TextView shopRating;
        final RatingBar shopRatingBar;
        final TextView shopPlace;
        final CardView cardView;

        ShopViewHolder(@NonNull View itemView) {
            super(itemView);

            // Fetching view IDs for view elements from resource
            shopImg = itemView.findViewById(R.id.shop_image);
            shopTitle = itemView.findViewById(R.id.shop_name);
            shopRating = itemView.findViewById(R.id.rating);
            shopRatingBar = itemView.findViewById(R.id.ratingBar);
            shopPlace = itemView.findViewById(R.id.shop_address);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}