package com.sanjay.onlineclothingshoppings.models.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sanjay.onlineclothingshoppings.models.Alert;
import com.sanjay.onlineclothingshoppings.models.DashboardAcitivity;
import com.sanjay.onlinemobileshoppings.R;



public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText loginUsername,loginPassword;
    private Button btnLogin;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);

        loginUsername = view.findViewById(R.id.loginUsername);
        loginPassword = view.findViewById(R.id.loginPassword);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        return  view;


    }


    private void checkUser(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        String password = sharedPreferences.getString("password","");
        Log.d("Message",username+"  "+password);

        if (username.equals(loginUsername.getText().toString()) && password.equals(loginPassword.getText().toString()) ){
            Intent intent = new Intent(getContext(), DashboardAcitivity.class);
            intent.putExtra("msg","Welcome! "+username);
            Alert.loggedIn = true;
            startActivity(intent);
            getActivity().finish();
        }else{
            Alert.alert(getContext(),"Invalid login details.");
        }
    }

    @Override
    public void onClick(View v) {
        if( loginUsername.getText().toString().length() > 0 && loginPassword.getText().toString().length() > 0 ) {
            checkUser();
        }else{
            Alert.alert(getContext(),"Please enter username and password to login.");
        }
    }
}
