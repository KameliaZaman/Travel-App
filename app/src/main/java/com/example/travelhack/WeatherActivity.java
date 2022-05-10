package com.example.travelhack;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.text.DecimalFormat;

public class WeatherActivity extends AppCompatActivity {

    EditText etCity,etCountry;
    TextView tvResult;
    private final String url="https://api.openweathermap.org/data/2.5/weather";
    private final String appid="";
    DecimalFormat df= new DecimalFormat("#.##");
    ImageView arrowImg;
    LinearLayout weatherback;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_weather_activity);
        etCity=findViewById(R.id.etCity);
        etCountry=findViewById(R.id.etCountry);
        tvResult=findViewById(R.id.tvResult);
        weatherback=findViewById(R.id.weatherBack);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                if(item.getItemId()==R.id.nav_home){
                    Intent intent = new Intent(WeatherActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_map){
                    Intent intent = new Intent(WeatherActivity.this,MapsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_currency){
                    Intent intent = new Intent(WeatherActivity.this,CurrencyActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_hotel){
                    Intent intent = new Intent(WeatherActivity.this,HotelActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_weather){
                    Intent intent = new Intent(WeatherActivity.this,WeatherActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_profile){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null){
                        Intent intent=new Intent(WeatherActivity.this,ProfileActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent=new Intent(WeatherActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
                else if(item.getItemId()==R.id.nav_flight){
                    Intent intent=new Intent(WeatherActivity.this,FlightActivity.class);
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
                Intent intent = new Intent(WeatherActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getWeatherDetails(View view){
        String tempUrl="";
        String city=etCity.getText().toString().trim();
        String country=etCountry.getText().toString().trim();
        if (city.equals("")){
            tvResult.setText("City field can't be empty!");
        }
        else{
            if (country.equals("")){
                tempUrl=url+"?q="+city+","+country+"&appid="+appid;
            }
            else {
                tempUrl=url+"?q="+city+"&appid="+appid;
            }
            StringRequest stringRequest=new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //Log.d("response",response);
                    String output="";
                    try {
                        JSONObject jsonResponse=new JSONObject(response);
                        JSONArray jsonArray=jsonResponse.getJSONArray("weather");
                        JSONObject jsonObjectWeather=jsonArray.getJSONObject(0);
                        String description=jsonObjectWeather.getString("description");
                        JSONObject jsonObjectMain=jsonResponse.getJSONObject("main");
                        double temp=jsonObjectMain.getDouble("temp")-273.15;
                        double feelslike=jsonObjectMain.getDouble("feels_like")-273.15;
                        float pressure=jsonObjectMain.getInt("pressure");
                        int humidity=jsonObjectMain.getInt("humidity");
                        JSONObject jsonObjectWind=jsonResponse.getJSONObject("wind");
                        String wind=jsonObjectWind.getString("speed");
                        JSONObject jsonObjectClouds=jsonResponse.getJSONObject("clouds");
                        String clouds=jsonObjectClouds.getString("all");
                        JSONObject jsonObjectSys=jsonResponse.getJSONObject("sys");
                        String countryName=jsonObjectSys.getString("country");
                        String cityName=jsonResponse.getString("name");
                        output+="Current weather of "+cityName+"("+countryName+")"+"\nTemp: "+df.format(temp)+"°C"+"\nFeels like: "+df.format(feelslike)+"°C"+"\nHumidity: "+humidity+"%"+"\nDescription: "+description+"\nWind Speed: "+wind+"km/h"+"\nCloudiness: "+clouds+"%"+"\nPressure: "+pressure+" mbar";
                        tvResult.setText(output);

                        if (description.contains("drizzle")){
                            weatherback.setBackgroundResource(R.drawable.drizzle_weather);
                            weatherback.getBackground().setAlpha(128);
                        }
                        else if (description.contains("thunderstorm")){
                            weatherback.setBackgroundResource(R.drawable.thunder_weather);
                            weatherback.getBackground().setAlpha(128);
                        }
                        else if (description.contains("rain")){
                            weatherback.setBackgroundResource(R.drawable.rainy_weather);
                            weatherback.getBackground().setAlpha(128);
                        }
                        else if (description.contains("clouds")){
                            weatherback.setBackgroundResource(R.drawable.cloudy_weather);
                            weatherback.getBackground().setAlpha(128);
                        }
                        else if (description.contains("clear")){
                            weatherback.setBackgroundResource(R.drawable.clear_weather);
                            weatherback.getBackground().setAlpha(128);
                        }
                        else if (description.contains("snow")){
                            weatherback.setBackgroundResource(R.drawable.snow_weather);
                            weatherback.getBackground().setAlpha(128);
                        }
                        else{
                            weatherback.setBackgroundResource(R.drawable.haze_weather);
                            weatherback.getBackground().setAlpha(128);
                        }

                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.toString().trim(),Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}
