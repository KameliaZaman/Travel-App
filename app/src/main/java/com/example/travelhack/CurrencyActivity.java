package com.example.travelhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CurrencyActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;
    TextView txtResult;
    ImageView arrowImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_currency_activity);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                if(item.getItemId()==R.id.nav_home){
                    Intent intent = new Intent(CurrencyActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_map){
                    Intent intent = new Intent(CurrencyActivity.this,MapsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_currency){
                    Intent intent = new Intent(CurrencyActivity.this,CurrencyActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_hotel){
                    Intent intent = new Intent(CurrencyActivity.this,HotelActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_weather){
                    Intent intent = new Intent(CurrencyActivity.this,WeatherActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_profile){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null){
                        Intent intent=new Intent(CurrencyActivity.this,ProfileActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent=new Intent(CurrencyActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
                else if(item.getItemId()==R.id.nav_flight){
                    Intent intent=new Intent(CurrencyActivity.this,FlightActivity.class);
                    startActivity(intent);
                }
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        ed1 = findViewById(R.id.txtamount);
        b1=findViewById(R.id.btn1);
        txtResult=findViewById(R.id.txtResult);

        String[] from = {"$USD-US Dollar","€EUR-Euro","£GBP-British Pound","₹INR-Indian Rupee","৳BDT-Bangladeshi Taka","¥JPY-Japanese Yen","CHF-Swiss Franc","₺TRY-Turkish Lira","₽RUB-Russian Ruble", "(﷼)SAR-Saudi Real"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"$USD-US Dollar","€EUR-Euro","£GBP-British Pound","₹INR-Indian Rupee","৳BDT-Bangladeshi Taka","¥JPY-Japanese Yen","CHF-Swiss Franc","₺TRY-Turkish Lira","₽RUB-Russian Ruble", "(﷼)SAR-Saudi Real"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        arrowImg=findViewById(R.id.arrowImg);
        arrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CurrencyActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ed1.getText().toString().equals("")) {
                    txtResult.setText("Please enter an amount!");
                } else {

                    Double tot = 0.0;
                    final DecimalFormat df = new DecimalFormat("0.00");
                    Double amount = Double.parseDouble(ed1.getText().toString());

                    if (sp1.getSelectedItem().toString() == "$USD-US Dollar") {
                        if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 0.89;
                        } else if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 0.74;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 74.99;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 85.82;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 115.31;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 0.93;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 13.59;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 77.45;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 3.75;
                        }
                    } else if (sp1.getSelectedItem().toString() == "€EUR-Euro") {
                        if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 1.11;
                        } else if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 0.83;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 83.64;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 95.46;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 128.62;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 1.03;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 15.16;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 86.54;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 4.18;
                        }
                    } else if (sp1.getSelectedItem().toString() == "£GBP-British Pound") {
                        if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 1.34;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 1.20;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 100.58;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 115.04;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 154.70;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 1.24;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 18.24;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 104.09;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 5.02;
                        }
                    } else if (sp1.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                        if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 0.01;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 0.01;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 0.09;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 1.14;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 1.53;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 0.01;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 0.18;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 1.03;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 0.05;
                        }
                    } else if (sp1.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                        if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 0.01;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 0.01;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 0.87;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 0.08;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 1.34;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 0.01;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 0.15;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 0.90;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 0.04;
                        }
                    } else if (sp1.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                        if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 0.08;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 0.07;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 0.64;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 0.74;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 0.06;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 0.08;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 0.11;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 0.67;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 0.03;
                        }
                    } else if (sp1.getSelectedItem().toString() == "CHF-Swiss Franc") {
                        if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 1.07;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 0.96;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 80.57;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 92.31;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 123.95;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 0.80;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 14.62;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 83.38;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 4.02;
                        }
                    } else if (sp1.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                        if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 0.07;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 0.06;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 5.51;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 6.31;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 8.47;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 0.06;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 0.05;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 5.70;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 0.27;
                        }
                    } else if (sp1.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                        if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 0.01;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 0.01;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 0.96;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 1.10;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 1.48;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 0.93;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 0.01;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 0.09;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 0.04;
                        }
                    } else if (sp1.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                        if (sp2.getSelectedItem().toString() == "$USD-US Dollar") {
                            tot = amount * 0.26;
                        } else if (sp2.getSelectedItem().toString() == "(﷼)SAR-Saudi Real") {
                            tot = amount * 1.00;
                        } else if (sp2.getSelectedItem().toString() == "€EUR-Euro") {
                            tot = amount * 0.23;
                        } else if (sp2.getSelectedItem().toString() == "₹INR-Indian Rupee") {
                            tot = amount * 19.99;
                        } else if (sp2.getSelectedItem().toString() == "৳BDT-Bangladeshi Taka") {
                            tot = amount * 22.88;
                        } else if (sp2.getSelectedItem().toString() == "¥JPY-Japanese Yen") {
                            tot = amount * 30.76;
                        } else if (sp2.getSelectedItem().toString() == "CHF-Swiss Franc") {
                            tot = amount * 0.24;
                        } else if (sp2.getSelectedItem().toString() == "₺TRY-Turkish Lira") {
                            tot = amount * 3.62;
                        } else if (sp2.getSelectedItem().toString() == "₽RUB-Russian Ruble") {
                            tot = amount * 20.69;
                        } else if (sp2.getSelectedItem().toString() == "£GBP-British Pound") {
                            tot = amount * 0.19;
                        }
                    }

                    df.setRoundingMode(RoundingMode.UP);
                    txtResult.setText("Converted amount: " + df.format(tot)+ "");
                }
            }
        });
    }
}

