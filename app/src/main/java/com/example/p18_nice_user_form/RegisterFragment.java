package com.example.p18_nice_user_form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    String gender_selected;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        //Components fragment_register
        Spinner spinner = v.findViewById(R.id.gender_spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.gender_array, android.R.layout.simple_selectable_list_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Button login_button = v.findViewById(R.id.button_login_registerScreen);
        Button register_button = v.findViewById(R.id.button_register_registerScreen);
        TextInputEditText username = v.findViewById(R.id.editText_username_register);
        TextInputEditText password = v.findViewById(R.id.editText_password_register);
        TextInputEditText passConf = v.findViewById(R.id.editText_passRepeat_register);
        TextInputEditText email = v.findViewById(R.id.editText_email_register);
        TextInputEditText names = v.findViewById(R.id.editText_names_register);
        TextInputEditText surnames = v.findViewById(R.id.editText_surnames_register);
        TextInputEditText birthDate = v.findViewById(R.id.editText_datePicker_register);

        login_button.setOnClickListener(v1 -> {
            NavDirections navDirections = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment();
            Navigation.findNavController(v).navigate(navDirections);
        });

        register_button.setOnClickListener(v12 -> {

            username.

            if(username.getText().equals("")){
                username.setError("Required field*");
            }
            if(password.getText().equals("")){
                password.setError("Required field*");
            }
            if(passConf.getText().equals("")){
                passConf.setError("Required field*");
            }
            if (email.getText().equals("")){
                email.setError("Required field*");
            }
            if (names.getText().equals("")){
                names.setError("Required field*");
            }
            if (surnames.getText().equals("")){
                surnames.setError("Required field*");
            }
            if (birthDate.getText().equals("")){
                birthDate.setError("Required field*");
            }
            if(gender_selected.isEmpty()){
                Toast.makeText(getContext(), "Please select a pronoun", Toast.LENGTH_SHORT).show();
            }

                NavDirections navDirections = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment();
                Navigation.findNavController(v).navigate(navDirections);

        });

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       gender_selected = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}