package com.example.rejestracja;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Haslo;
    private EditText PowtorzHaslo;
    private TextView Komunikat;
    private Button Zatwierdz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.email);
        Haslo = findViewById(R.id.haslo);
        PowtorzHaslo = findViewById(R.id.powtorzHaslo);
        Komunikat = findViewById(R.id.Komunikat);
        Zatwierdz = findViewById(R.id.zatwierdz);

        Zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String haslo = Haslo.getText().toString().trim();
                String powtorzHaslo = PowtorzHaslo.getText().toString().trim();

                if (email.isEmpty()) {
                    Komunikat.setText("Proszę podać adres E-Mail.");
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Komunikat.setText("Niepoprawny adres E-Mail.");
                } else if (haslo.isEmpty()) {
                    Komunikat.setText("Proszę podać hasło.");
                } else if (powtorzHaslo.isEmpty()) {
                    Komunikat.setText("Proszę powtórzyć hasło.");
                } else if (!(haslo.equals(powtorzHaslo))) {
                    Komunikat.setText("Hasło nie jest takie same.");
                } else {
                    Komunikat.setText("Witaj ," + email);
                }
            }
        });
    }
}