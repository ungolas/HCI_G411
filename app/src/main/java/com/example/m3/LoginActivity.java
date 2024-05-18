package com.example.m3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private TextView forgotPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        forgotPasswordTextView = findViewById(R.id.forgot_password_text_view);

        // Vorausgefüllte Werte
        emailEditText.setText("max.mustermann@example.com");
        passwordEditText.setText("Passwort123");

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleForgotPassword();
            }
        });
    }

    private void login() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Beispiel Login-Check
        if (email.equals("max.mustermann@example.com") && password.equals("Passwort123")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Falsche E-Mail oder Passwort", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleForgotPassword() {
        String email = emailEditText.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Bitte geben Sie Ihre E-Mail-Adresse ein", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Einmalpasswort an " + email + " gesendet", Toast.LENGTH_SHORT).show();
        }
    }
}
