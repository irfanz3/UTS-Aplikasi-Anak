package me.zaelani.utsaplikasianak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Nama: Irfan Zaelani
 * NIM: 10117911
 * Kelas: IF-6K
 *
 * 16 Mei 2020
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText childName;
    private EditText childAge;
    private RadioGroup childGender;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initUI();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = childName.getText().toString();
                String age = childAge.getText().toString();
                String gender = getChildGender();

                if (inputValidation(name, age, gender)) {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra(MainActivity.KEY_NAME, name);
                    intent.putExtra(MainActivity.KEY_AGE, age);
                    intent.putExtra(MainActivity.KEY_GENDER, gender);
                    startActivity(intent);
                }
            }
        });
    }

    private void initUI() {
        childName = findViewById(R.id.name);
        childAge = findViewById(R.id.input_age);
        childGender = findViewById(R.id.gender);
        btnRegister = findViewById(R.id.register);

        TextView welcomeMessage = findViewById(R.id.welcome_message);
        welcomeMessage.setText(Html.fromHtml(getResources().getString(R.string.welcome_message)));
    }

    private boolean inputValidation(String name, String age, String gender) {

        if (isEmpty(name) || isEmpty(age) || isEmpty(gender)) {
            Toast.makeText(this, "Silahkan isi semau Biodata", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private boolean isEmpty(String input) {
        return "".equalsIgnoreCase(input);
    }

    private String getChildGender() {
        int selectedRadioId = childGender.getCheckedRadioButtonId();
        if (selectedRadioId < 0) return "";

        RadioButton gender = findViewById(selectedRadioId);
        return gender.getText().toString();
    }
}
