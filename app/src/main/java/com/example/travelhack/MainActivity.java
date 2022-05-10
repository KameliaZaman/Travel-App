package com.example.travelhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private ImageView sundarbanImg,rangamatiImg,bandarbanImg,saintmartinImg,coxsbazarImg,sajekImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);

        sundarbanImg =  findViewById(R.id.sundorbonImg);
        rangamatiImg = findViewById(R.id.rangamatiImg);
        bandarbanImg =findViewById(R.id.bandarbanImg);
        saintmartinImg = findViewById(R.id.saintmartiniImg);
        coxsbazarImg =findViewById(R.id.coxsBazarImg);
        sajekImg = findViewById(R.id.sajekImg);
        sundarbanImg.setOnClickListener(this);
        rangamatiImg.setOnClickListener(this);
        bandarbanImg.setOnClickListener(this);
        saintmartinImg.setOnClickListener(this);
        coxsbazarImg.setOnClickListener(this);
        sajekImg.setOnClickListener(this);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                if(item.getItemId()==R.id.nav_home){
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_map){
                    Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_currency){
                    Intent intent = new Intent(MainActivity.this,CurrencyActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_hotel){
                    Intent intent = new Intent(MainActivity.this,HotelActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_weather){
                    Intent intent = new Intent(MainActivity.this,WeatherActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_profile){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null){
                        Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
                else if(item.getItemId()==R.id.nav_flight){
                    Intent intent=new Intent(MainActivity.this,FlightActivity.class);
                    startActivity(intent);
                }
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.sundorbonImg)
        {
            Intent intent = new Intent(MainActivity.this,PlaceDescription.class);
            intent.putExtra("name","Sundarban");
            startActivity(intent);
        }
        if(v.getId()== R.id.rangamatiImg)
        {
            Intent intent = new Intent(MainActivity.this,PlaceDescription.class);
            intent.putExtra("name","Rangamati");
            startActivity(intent);
        }
        if(v.getId()== R.id.bandarbanImg)
        {
            Intent intent = new Intent(MainActivity.this,PlaceDescription.class);
            intent.putExtra("name","Bandarban");
            startActivity(intent);
        }
        if(v.getId()== R.id.saintmartiniImg)
        {
            Intent intent = new Intent(MainActivity.this,PlaceDescription.class);
            intent.putExtra("name","SaintMartin");
            startActivity(intent);
        }
        if(v.getId()== R.id.coxsBazarImg)
        {
            Intent intent = new Intent(MainActivity.this,PlaceDescription.class);
            intent.putExtra("name","coxsBazar");
            startActivity(intent);
        }
        if(v.getId()== R.id.sajekImg)
        {
            Intent intent = new Intent(MainActivity.this,PlaceDescription.class);
            intent.putExtra("name","Sajek");
            startActivity(intent);
        }
    }
}