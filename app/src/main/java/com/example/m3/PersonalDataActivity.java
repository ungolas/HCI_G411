package com.example.m3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalDataActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, emailEditText, insuranceNumberEditText, passwordEditText;
    private boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);
        setTitle("Persönliche Daten");

        firstNameEditText = findViewById(R.id.first_name_edit_text);
        lastNameEditText = findViewById(R.id.last_name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        insuranceNumberEditText = findViewById(R.id.insurance_number_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);

        // Beispiel-Daten
        setExampleData();
    }

    private void setExampleData() {
        firstNameEditText.setText("Max");
        lastNameEditText.setText("Mustermann");
        emailEditText.setText("max.mustermann@example.com");
        insuranceNumberEditText.setText("1234567890");
        passwordEditText.setText("Passwort123");
    }

    public void editData(View view) {
        if (isEditing) {
            Toast.makeText(this, "Daten gespeichert", Toast.LENGTH_SHORT).show();
            // Bearbeiten-Modus deaktivieren
            setEditingMode(false);
        } else {
            // Aktivieren des Bearbeiten-Modus
            setEditingMode(true);
        }
    }

    private void setEditingMode(boolean isEditing) {
        this.isEditing = isEditing;
        if (isEditing) {
            // Textfelder bearbeitbar machen
            firstNameEditText.setEnabled(true);
            lastNameEditText.setEnabled(true);
            emailEditText.setEnabled(true);
            insuranceNumberEditText.setEnabled(true);
            passwordEditText.setEnabled(true);
        } else {
            // Textfelder nicht bearbeitbar machen
            firstNameEditText.setEnabled(false);
            lastNameEditText.setEnabled(false);
            emailEditText.setEnabled(false);
            insuranceNumberEditText.setEnabled(false);
            passwordEditText.setEnabled(false);
        }
    }
    }
