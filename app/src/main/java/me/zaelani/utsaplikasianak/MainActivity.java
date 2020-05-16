package me.zaelani.utsaplikasianak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Nama: Irfan Zaelani
 * NIM: 10117911
 * Kelas: IF-6K
 *
 * 16 Mei 2020
 */

public class MainActivity extends AppCompatActivity {
    public static String KEY_NAME = "name";
    public static String KEY_GENDER = "gender";
    public static String KEY_AGE = "age";

    public static final String DATA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static Random RANDOM = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCode = findViewById(R.id.registerCode);

        Intent intent = getIntent();
        String name = intent.getStringExtra(KEY_NAME);
        String gender = intent.getStringExtra(KEY_GENDER);
        String age = intent.getStringExtra(KEY_AGE);

        buildWelcomeMessage(name, gender, age);
        btnCode.setText(randomCode());
        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Code Berhasil disalin ke clipboard", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void buildWelcomeMessage(String name, String gender, String age) {
        String message = String.format("%s %s %s Tahun Berhasil Ditambahkan", name, gender, age);
        TextView welcomeMessage = findViewById(R.id.userInfo);
        welcomeMessage.setText(message);
    }

    private String randomCode() {
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            sb.append(DATA.charAt(RANDOM.nextInt(DATA.length())));
        }

        return sb.toString();
    }
}
