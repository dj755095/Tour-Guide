package com.rohit.examples.android.IndiaTour.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rohit.examples.android.IndiaTour.Adapter.TabAdapter;
import com.rohit.examples.android.IndiaTour.Fragment.EventFragment;
import com.rohit.examples.android.IndiaTour.Fragment.HotelFragment;
import com.rohit.examples.android.IndiaTour.Fragment.PlaceFragment;
import com.rohit.examples.android.IndiaTour.Fragment.RestaurantFragment;
import com.rohit.examples.android.IndiaTour.Fragment.ShopFragment;
import com.rohit.examples.android.IndiaTour.Login.LoginActivity;
import com.rohit.examples.android.IndiaTour.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fetching view IDs from resource
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);

        // Registering TabLayout with FragmentManager
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());

        // Adding Fragment with help of TabLayout adapter
        tabAdapter.addFragment(new PlaceFragment(), getString(R.string.places));
        tabAdapter.addFragment(new HotelFragment(), getString(R.string.hotels));
        tabAdapter.addFragment(new RestaurantFragment(), getString(R.string.restaurants));
        tabAdapter.addFragment(new ShopFragment(), getString(R.string.shoppings));
        //tabAdapter.addFragment(new EventFragment(), getString(R.string.events));

        //Setting the Fragments with ViewPager
        viewPager.setAdapter(tabAdapter);

        //Setting up TabLayout with ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }


}