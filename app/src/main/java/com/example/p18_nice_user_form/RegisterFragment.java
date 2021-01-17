package com.example.p18_nice_user_form;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class RegisterFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    String gender_selected, usernameInput, passInput, passConfInput, emailInput, namesInput, surnamesInput, birthDateInput;
    TextInputEditText username, password, passConf, email, names, surnames, birthDate;
    Button login_button, register_button;
    Spinner spinner;
    private final TextWatcher registerTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            usernameInput = Objects.requireNonNull(username.getText()).toString().trim();
            passInput = Objects.requireNonNull(password.getText()).toString().trim();
            passConfInput = Objects.requireNonNull(passConf.getText()).toString().trim();
            emailInput = Objects.requireNonNull(email.getText()).toString().trim();
            namesInput = Objects.requireNonNull(names.getText()).toString().trim();
            surnamesInput = Objects.requireNonNull(surnames.getText()).toString().trim();
            birthDateInput = Objects.requireNonNull(birthDate.getText()).toString().trim();

            if (usernameInput.isEmpty()) {
                username.setError(String.valueOf(R.string.requiredField));
                register_button.setEnabled(false);
            } else {
                register_button.setEnabled(true);
            }
            if (passInput.isEmpty()) {
                password.setError(String.valueOf(R.string.requiredField));
                register_button.setEnabled(false);
            } else {
                register_button.setEnabled(true);
            }
            if (passConfInput.isEmpty()) {
                passConf.setError(String.valueOf(R.string.requiredField));
                register_button.setEnabled(false);
            } else {
                register_button.setEnabled(true);
            }
            if (emailInput.isEmpty()) {
                email.setError(String.valueOf(R.string.requiredField));
                register_button.setEnabled(false);
            } else {
                register_button.setEnabled(true);
            }
            if (namesInput.isEmpty()) {
                names.setError(String.valueOf(R.string.requiredField));
                register_button.setEnabled(false);
            } else {
                register_button.setEnabled(true);
            }
            if (surnamesInput.isEmpty()) {
                surnames.setError(String.valueOf(R.string.requiredField));
                register_button.setEnabled(false);
            } else {
                register_button.setEnabled(true);
            }
            if (birthDateInput.isEmpty()) {
                birthDate.setError(String.valueOf(R.string.requiredField));
                register_button.setEnabled(false);
            } else {
                register_button.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        //Components fragment_register
        spinner = v.findViewById(R.id.gender_spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.gender_array, android.R.layout.simple_selectable_list_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        login_button = v.findViewById(R.id.button_login_registerScreen);
        register_button = v.findViewById(R.id.button_register_registerScreen);
        username = v.findViewById(R.id.editText_username_register);
        password = v.findViewById(R.id.editText_password_register);
        passConf = v.findViewById(R.id.editText_passRepeat_register);
        email = v.findViewById(R.id.editText_email_register);
        names = v.findViewById(R.id.editText_names_register);
        surnames = v.findViewById(R.id.editText_surnames_register);
        birthDate = v.findViewById(R.id.editText_datePicker_register);

        login_button.setOnClickListener(v1 -> {
            NavDirections navDirections = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment();
            Navigation.findNavController(v).navigate(navDirections);
        });

        username.addTextChangedListener(registerTextWatcher);
        password.addTextChangedListener(registerTextWatcher);
        passConf.addTextChangedListener(registerTextWatcher);
        email.addTextChangedListener(registerTextWatcher);
        names.addTextChangedListener(registerTextWatcher);
        surnames.addTextChangedListener(registerTextWatcher);
        birthDate.addTextChangedListener(registerTextWatcher);


        if (gender_selected.isEmpty()) {
            Toast.makeText(getContext(), "Please select a pronoun", Toast.LENGTH_SHORT).show();
        }

        register_button.setOnClickListener(v12 -> {
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