package com.example.orderincafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderDetailsActivity extends AppCompatActivity {


    private static final String EXTRA_USER_NAME = "username";
    private static final String EXTRA_DRINK = "drink";
    private static final String EXTRA_DRINK_TYPE = "drinkType";
    private static final String EXTRA_ADDITIVES = "additives";



    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewDrinkType;
    private TextView textViewAdditives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        initViews();

        Intent intent = getIntent();
        textViewName.setText(intent.getStringExtra(EXTRA_USER_NAME));
        textViewDrink.setText(intent.getStringExtra(EXTRA_DRINK));
        textViewDrinkType.setText(intent.getStringExtra(EXTRA_DRINK_TYPE));
        textViewAdditives.setText(intent.getStringExtra(EXTRA_ADDITIVES));

    }






    private void initViews(){
        textViewName = findViewById(R.id.textViewName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewDrinkType = findViewById(R.id.textViewDrinkType);
        textViewAdditives = findViewById(R.id.textViewAdditions);

    }



    public static Intent newIntent(Context context,
                                   String username,
                                   String drink,
                                   String drinkType,
                                   String additives
    ){
        Intent intent = new Intent(context, OrderDetailsActivity.class);
        intent.putExtra(EXTRA_USER_NAME, username);
        intent.putExtra(EXTRA_DRINK, drink);
        intent.putExtra(EXTRA_DRINK_TYPE, drinkType);
        intent.putExtra(EXTRA_ADDITIVES, additives);
        return intent;
    }
}