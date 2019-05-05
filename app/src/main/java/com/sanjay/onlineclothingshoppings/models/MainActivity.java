package com.sanjay.onlineclothingshoppings.models;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sanjay.onlineclothingshoppings.models.models.Item;
import com.sanjay.onlinemobileshoppings.R;

public class MainActivity extends AppCompatActivity {

    private Button btnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetStarted = findViewById(R.id.btnGetStarted);

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !Alert.loggedIn ){
                    Intent intent = new Intent(getApplicationContext(),LoginRegisterActivity.class);
                    intent.putExtra("noLogIn",true);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(getApplicationContext(), Item.DashboardActivity.class);
                    intent.putExtra("Welcome!",true);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

}
