package com.rohit.examples.android.IndiaTour.Activity;

import static android.os.Environment.getExternalStorageDirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rohit.examples.android.IndiaTour.Login.LoginActivity;
import com.rohit.examples.android.IndiaTour.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SemiMain extends AppCompatActivity {

    private static final String ASSET_IMAGES_FOLDER = "images";
    private static final String ASSET_XML_FILE = "arrays.xml";
    private static final String ASSET_XML_FILE2 = "strings.xml";
    private static final String EXTERNAL_STORAGE_FOLDER = "HamraStorage";

    FirebaseAuth mAuth;
    Button logoutBtn,nextBtn;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 123;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_main);

        CardView cardViewMumbai = findViewById(R.id.cardViewMumbai);
        CardView cardViewDelhi = findViewById(R.id.cardViewDelhi);
        CardView cardViewGoa = findViewById(R.id.cardViewGoa);
        CardView cardViewManali = findViewById(R.id.cardViewManali);
        CardView cardViewKashmir = findViewById(R.id.cardViewKashmir);
        CardView cardViewUdaipur = findViewById(R.id.cardViewUdaipur);
        CardView cardViewBhopal = findViewById(R.id.cardViewBhopal);

        //Permission><<
        checkAndRequestPermissions();


        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Set click listeners for each CardView
        // Set click listeners for each CardView
        cardViewMumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Mumbai CardView
                editor.putString("places", "Mumbai");
                showToast("Mumbai Clicked");
                editor.apply();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        cardViewDelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Delhi CardView
                editor.putString("places", "Delhi");
                showToast("Delhi Clicked");
                editor.apply();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        cardViewGoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Goa CardView
                editor.putString("places", "Goa");
                showToast("Goa Clicked");
                editor.apply();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        cardViewManali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Manali CardView
                editor.putString("places", "Manali");
                showToast("Manali Clicked");
                editor.apply();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        cardViewKashmir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Kashmir CardView
                editor.putString("places", "Kashmir");
                showToast("Kashmir Clicked");
                editor.apply();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        cardViewUdaipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Udaipur CardView
                editor.putString("places", "Udaipur");
                showToast("Udaipur Clicked");
                editor.apply();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        cardViewBhopal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for Bhopal CardView
                editor.putString("places", "Bhopal");
                showToast("Bhopal Clicked");
                editor.apply();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });









        mAuth = FirebaseAuth.getInstance();

        logoutBtn = findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });


    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void checkAndRequestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Request WRITE_EXTERNAL_STORAGE permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

        } else {
            // Permission is already granted, proceed with copying
            Toast.makeText(this, "Proceeddd", Toast.LENGTH_SHORT).show();
            copyFilesToExternalStorage();
        }
    }

    private void copyFilesToExternalStorage() {
        // Check if external storage is available and writable
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // External storage is available and writable
            File hamraStorageDir = new File(getExternalFilesDir(null), EXTERNAL_STORAGE_FOLDER);

            if (!hamraStorageDir.exists()) {
                // Create HamraStorage directory if it doesn't exist
                if (hamraStorageDir.mkdirs()) {
                    Toast.makeText(this, "Creation suceessFull", Toast.LENGTH_SHORT).show();
                    // Directory created successfully
                } else {
                    Toast.makeText(this, "fail hogya dir creation", Toast.LENGTH_SHORT).show();
                    // Handle the case where directory creation failed
                }
            }

            AssetManager assetManager = getAssets();
            try {
                // Copy images
                String[] imageFiles = assetManager.list(ASSET_IMAGES_FOLDER);
                if (imageFiles != null) {
                    for (String fileName : imageFiles) {
                        try (InputStream inputStream = assetManager.open(ASSET_IMAGES_FOLDER + "/" + fileName);
                             OutputStream outputStream = new FileOutputStream(
                                     new File(hamraStorageDir, fileName))) {

                            byte[] buffer = new byte[1024];
                            int read;
                            while ((read = inputStream.read(buffer)) != -1) {
                                outputStream.write(buffer, 0, read);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                // Copy arrays.xml
                copyXmlFileToExternalStorage(assetManager, ASSET_XML_FILE,hamraStorageDir);

                // Copy strings.xml
                copyXmlFileToExternalStorage(assetManager, ASSET_XML_FILE2,hamraStorageDir);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "external storage is not available", Toast.LENGTH_SHORT).show();
            // Handle the case where external storage is not available
        }
    }


    private void copyXmlFileToExternalStorage(AssetManager assetManager, String fileName, File hamraStorageDir) {
        try (InputStream inputStream = assetManager.open(fileName);
             OutputStream outputStream = new FileOutputStream(
                     new File(hamraStorageDir, fileName))) { // Remove EXTERNAL_STORAGE_FOLDER from here

            byte[] buffer = new byte[1024];
            int read;
            while ((read = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Welcome Back"+ currentUser.getEmail(), Toast.LENGTH_SHORT).show();
        }
    }
}