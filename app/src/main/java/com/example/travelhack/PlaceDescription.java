package com.example.travelhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PlaceDescription extends AppCompatActivity {

    ImageView arrowImg, placeImageView;
    TextView placeNameView, placeDescriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_place_des_activity);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                if(item.getItemId()==R.id.nav_home){
                    Intent intent = new Intent(PlaceDescription.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_map){
                    Intent intent = new Intent(PlaceDescription.this,MapsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_currency){
                    Intent intent = new Intent(PlaceDescription.this,CurrencyActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_hotel){
                    Intent intent = new Intent(PlaceDescription.this,HotelActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_weather){
                    Intent intent = new Intent(PlaceDescription.this,WeatherActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_profile){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null){
                        Intent intent=new Intent(PlaceDescription.this,ProfileActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent=new Intent(PlaceDescription.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
                else if(item.getItemId()==R.id.nav_flight){
                    Intent intent=new Intent(PlaceDescription.this,FlightActivity.class);
                    startActivity(intent);
                }
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        arrowImg=findViewById(R.id.arrowImg);
        arrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaceDescription.this,MainActivity.class);
                startActivity(intent);
            }
        });

        placeImageView= findViewById(R.id.placeImageId);
        placeNameView = findViewById(R.id.placeNameId);
        placeDescriptionView= findViewById(R.id.placeDescriptionId);
        Bundle bundle = getIntent().getExtras();
        if(bundle!= null)
        {
            String placeName = bundle.getString("name");
            showDetails(placeName);
        }
    }

    void showDetails(String placeName)
    {
        if(placeName.equals("Sundarban"))
        {
            placeImageView.setImageResource(R.drawable.sundroban);
            placeNameView.setText(R.string.sundarban_name);
            placeDescriptionView.setText(R.string.sundarban_desc);
        }
        if(placeName.equals("Rangamati"))
        {
            placeImageView.setImageResource(R.drawable.rangamati);
            placeNameView.setText(R.string.ragamati_name);
            placeDescriptionView.setText(R.string.rangamati_desc);
        }
        if(placeName.equals("Bandarban"))
        {
            placeImageView.setImageResource(R.drawable.bandarban);
            placeNameView.setText(R.string.bandarban_name);
            placeDescriptionView.setText(R.string.bandarban_desc);
        }
    }
}
