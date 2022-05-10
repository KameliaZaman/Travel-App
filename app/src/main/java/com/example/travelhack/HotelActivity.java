package com.example.travelhack;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HotelActivity extends AppCompatActivity {

    ImageView arrowImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_hotel_activity);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                if(item.getItemId()==R.id.nav_home){
                    Intent intent = new Intent(HotelActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_map){
                    Intent intent = new Intent(HotelActivity.this,MapsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_currency){
                    Intent intent = new Intent(HotelActivity.this,CurrencyActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_hotel){
                    Intent intent = new Intent(HotelActivity.this,HotelActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_weather){
                    Intent intent = new Intent(HotelActivity.this,WeatherActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_profile){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null){
                        Intent intent=new Intent(HotelActivity.this,ProfileActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent=new Intent(HotelActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
                else if(item.getItemId()==R.id.nav_flight){
                    Intent intent=new Intent(HotelActivity.this,FlightActivity.class);
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
                Intent intent = new Intent(HotelActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}