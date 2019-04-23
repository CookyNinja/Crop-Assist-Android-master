package com.example.android.tflitecamerademo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class DiseaseDetails extends AppCompatActivity {

    Spinner disease_drop_down = null;
    String selected_crop = null;
    TextView heading, tv_select_disease, tv_disease_details = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.disease_details);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));

        heading = findViewById(R.id.disease_details_heading);
        tv_select_disease = findViewById(R.id.tv_select_disease);
        tv_disease_details = findViewById(R.id.tv_disease_details);
        disease_drop_down = findViewById(R.id.disease_drop_down);

        // justification for textview (Only for API >26)
        tv_disease_details.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        // get the selected crop from the intent
        selected_crop = getIntent().getStringExtra("SELECTED_CROP");


        // set font face
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Kavoon-Regular.ttf");
        Typeface custom_font_pacifico = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");

        heading.setTypeface(custom_font);
        tv_select_disease.setTypeface(custom_font_pacifico);

        // create Spinner
        List<String> disease_categories = new ArrayList<String>();
        disease_categories.add("nothing");

        // add different diseases to the spinner for different crops
        switch (selected_crop){
            case "nothing": {
                break;
            }

            case "Barley": {
                disease_categories.add("Net Blotch");
                disease_categories.add("Powdery Mildew");
                break;
            }

            case "Cotton": {
                disease_categories.add("Ascochyta Blight");
                disease_categories.add("Boll Rot");
                break;
            }

            case "Guava": {
                disease_categories.add("Fruit Fly Damage");
                disease_categories.add("Guava Rust");
                break;
            }

            case "Mustard": {
                disease_categories.add("Alternaria Blight");
                disease_categories.add("White Rust");
                break;
            }

            case "Pumpkin": {
                disease_categories.add("Downy Mildew");
                disease_categories.add("Southern Blight");
                break;
            }
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(DiseaseDetails.this, android.R.layout.simple_spinner_item, disease_categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        disease_drop_down.setAdapter(dataAdapter);

        disease_drop_down.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(selected_crop){

                    case "nothing": {
                        tv_disease_details.setText(R.string.nothing);
                        break;
                    }



                    case "Barley": {
                        switch(i) {
                            case 0: {
                                tv_disease_details.setText(R.string.nothing);
                                break;
                            }
                            case 1: {
                                tv_disease_details.setText(R.string.net_blotch);
                                break;
                            }
                            case 2: {
                                tv_disease_details.setText(R.string.powdery_mildew);
                                break;
                            }
                        }

                        break;
                    }



                    case "Cotton": {
                        switch(i) {
                            case 0: {
                                tv_disease_details.setText(R.string.nothing);
                                break;
                            }
                            case 1: {
                                tv_disease_details.setText(R.string.asycochyta_blight);
                                break;
                            }
                            case 2: {
                                tv_disease_details.setText(R.string.boll_rot);
                                break;
                            }
                        }

                        break;
                    }



                    case "Guava": {
                        switch(i) {
                            case 0: {
                                tv_disease_details.setText(R.string.nothing);
                                break;
                            }
                            case 1: {
                                tv_disease_details.setText(R.string.fruit_fly_damage);
                                break;
                            }
                            case 2: {
                                tv_disease_details.setText(R.string.guava_rust);
                                break;
                            }
                        }

                        break;
                    }



                    case "Mustard": {
                        switch(i) {
                            case 0: {
                                tv_disease_details.setText(R.string.nothing);
                                break;
                            }
                            case 1: {
                                tv_disease_details.setText(R.string.alternaria_blight);
                                break;
                            }
                            case 2: {
                                tv_disease_details.setText(R.string.white_rust);
                                break;
                            }
                        }

                        break;
                    }



                    case "Pumpkin": {
                        switch(i) {
                            case 0: {
                                tv_disease_details.setText(R.string.nothing);
                                break;
                            }
                            case 1: {
                                tv_disease_details.setText(R.string.downy_mildew);
                                break;
                            }
                            case 2: {
                                tv_disease_details.setText(R.string.southern_blight);
                                break;
                            }
                        }

                        break;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tv_disease_details.setText(R.string.nothing);
            }
        });

    }


}
