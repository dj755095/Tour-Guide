package com.rohit.examples.android.IndiaTour.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.Toast;

import com.rohit.examples.android.IndiaTour.R;

import java.io.File;

public class Demo extends AppCompatActivity {
    private static final String EXTERNAL_STORAGE_FOLDER = "HamraStorage";
    private static final String IMAGE_FILE_NAME = "place_manali1"; // Change this to your image file name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        // Get the ImageView
        ImageView yourImageView = findViewById(R.id.imageView);
//        String imageName = IMAGE_FILE_NAME; // Replace "your_image_name.jpg" with the actual name of your image file
//        Bitmap bitmap = loadImageFromExternalStorage(imageName);
//        if (bitmap != null) {
//            // Image loaded successfully, display it in an ImageView
//            yourImageView.setImageBitmap(bitmap);
//        } else {
//            // Failed to load image, handle accordingly
//        }

    }
    public Bitmap loadImageFromExternalStorage(String imageName) {
        Bitmap bitmap = null;

        // Check if external storage is available and readable
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // External storage is available and readable
            File hamraStorageDir = new File(getExternalFilesDir(null), EXTERNAL_STORAGE_FOLDER);

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

            if (bitmap == null) {
                // Image file not found
                Toast.makeText(this, "Image file not found", Toast.LENGTH_SHORT).show();
            }
        } else {
            // External storage is not available or not readable
            Toast.makeText(this, "External storage is not available", Toast.LENGTH_SHORT).show();
        }

        return bitmap;
    }



}