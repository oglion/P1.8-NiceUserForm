package com.example.p18_nice_user_form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        Button login_button = v.findViewById(R.id.button_login_loginScreen);
        Button register_button = v.findViewById(R.id.button_register_loginScreen);

        login_button.setOnClickListener(v1 -> {
            NavDirections navDirections = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment();
                    Navigation.findNavController(v).navigate(navDirections);
        });

        register_button.setOnClickListener(v12 -> {
            NavDirections navDirections = LoginFragmentDirections.actionLoginFragmentToRegisterFragment();
                    Navigation.findNavController(v).navigate(navDirections);
        });

        return v;
    }
}