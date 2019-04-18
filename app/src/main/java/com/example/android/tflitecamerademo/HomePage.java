package com.example.android.tflitecamerademo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewDebug;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    Spinner crop_drop_down = null;
    Button identify_crop_btn = null;
    Button identify_disease_btn = null;
    String selected_crop = null;
    TextView app_name_display_1, app_name_display_2, tv_select_crop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.home_page);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));

        // Spinner element
        crop_drop_down = findViewById(R.id.crop_drop_down);
        identify_crop_btn = findViewById(R.id.identify_crop_btn);
        identify_disease_btn = findViewById(R.id.identify_disease_btn);
        tv_select_crop = findViewById(R.id.tv_select_crop);

        app_name_display_1 = findViewById(R.id.app_name_display_1);
        app_name_display_2 = findViewById(R.id.app_name_display_2);


        //setting the font for app name display
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Kavoon-Regular.ttf");
        Typeface custom_font_pacifico = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");

        app_name_display_1.setTypeface(custom_font);
        app_name_display_2.setTypeface(custom_font);
        identify_crop_btn.setTypeface(custom_font_pacifico);
        identify_disease_btn.setTypeface(custom_font_pacifico);
        tv_select_crop.setTypeface(custom_font_pacifico);



        // Spinner Drop down elements (types of crops)
        List<String> crop_categories = new ArrayList<String>();
        crop_categories.add("Barley");
        crop_categories.add("Cotton");
        crop_categories.add("Guava");
        crop_categories.add("Mustard");
        crop_categories.add("Pumpkin");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(HomePage.this, android.R.layout.simple_spinner_item, crop_categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        crop_drop_down.setAdapter(dataAdapter);

        // go to CameraActivity to identify crop
        identify_crop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( HomePage.this , CameraActivity.class);
                startActivity(intent);
            }
        });

        // code to exceute after selecting from the dropdown
        // zeroeth element selected by default
        crop_drop_down.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                selected_crop = crop_categories.get(position);
                Toast.makeText(getApplicationContext(), selected_crop, Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here

                // select crop at zeroeth index by default
                selected_crop = crop_categories.get(0);
                Toast.makeText(getApplicationContext(), selected_crop, Toast.LENGTH_SHORT ).show();
            }

        });

        identify_disease_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
