package com.example.orderincafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private static final String EXTRA_USER_NAME = "username";



    private TextView textViewGreeting;
    private RadioGroup radioGroup;
    private RadioButton radioButtonTea;
    private RadioButton radioButtonCoffee;
    private TextView textViewAdditions;
    private CheckBox checkBoxSugar;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxLemon;
    private Spinner spinnerCoffee;
    private Spinner spinnerTea;
    private Button buttonMakeOrder;


    private String username;



    private String drink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        initViews();
        username = getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings = getString(R.string.greeting, username);
        textViewGreeting.setText(greetings);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if(id== radioButtonTea.getId()){
                    onUserChoseTea();
                }else if (id == radioButtonCoffee.getId()){
                    onUserChoseCoffee();
                }
            }
        });

        radioButtonTea.setChecked(true);


        buttonMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserMadeOrder();

            }
        });
    }



    private void onUserMadeOrder(){
        ArrayList<String> additives = new ArrayList<>();
        if(checkBoxSugar.isChecked()){
            additives.add(checkBoxSugar.getText().toString());
        }
        if(checkBoxMilk.isChecked()){
            additives.add(checkBoxMilk.getText().toString());
        }
        if(radioButtonTea.isChecked() && checkBoxLemon.isChecked()){
            additives.add(checkBoxLemon.getText().toString());
        }

        String drinkType="";
        if(radioButtonTea.isChecked()){
            drinkType = spinnerTea.getSelectedItem().toString();
        } else if (radioButtonCoffee.isChecked()){
            drinkType = spinnerCoffee.getSelectedItem().toString();
        }


        Intent intent = OrderDetailsActivity.newIntent(this,
                username,
                drink,
                drinkType,
                additives.toString());


        startActivity(intent);

    }


    private void onUserChoseTea(){
        drink = getString(R.string.tea);
        String additivesLabel = getString(R.string.additions, drink);
        textViewAdditions.setText(additivesLabel);
        checkBoxLemon.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);

    }

    private void onUserChoseCoffee(){
        drink = getString(R.string.coffee);
        String additivesLabel = getString(R.string.additions, drink);
        textViewAdditions.setText(additivesLabel);
        checkBoxLemon.setVisibility(View.INVISIBLE);
        spinnerCoffee.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);


    }



    public static Intent newIntent(Context context, String username){
        Intent intent = new Intent(context, OrderActivity.class);
        intent.putExtra(EXTRA_USER_NAME, username);
        return intent;
    }



    private void initViews(){
        textViewGreeting = findViewById(R.id.textViewGreetings);
        textViewAdditions = findViewById(R.id.textViewAdditions);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        radioGroup = findViewById(R.id.radioGroupDrinks);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);
        checkBoxLemon = findViewById(R.id.checkboxLemon);
        checkBoxSugar = findViewById(R.id.checkboxSugar);
        checkBoxMilk = findViewById(R.id.checkboxMilk);
        buttonMakeOrder = findViewById(R.id.makeOrder);

    }

}