package com.example.tahesid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TinggiBadan extends AppCompatActivity {
    private NumberPicker pickerBerat;
    int tinggi;
    private ImageView btnSebelumnya;
    private ImageView btnSelanjutnya;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinggi_badan);
        initView();
        pickerBerat.setMaxValue(300);
        pickerBerat.setMinValue(80);
        Toast.makeText(this, BeratBadan.user_id, Toast.LENGTH_SHORT).show();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("user").child(BeratBadan.user_id);
        pickerBerat.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                tinggi = i1;
            }
        });
        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TinggiBadan.this,MainMenu.class));
                databaseReference.child("tinggi").setValue(tinggi);
            }
        });
        btnSebelumnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        pickerBerat = (NumberPicker) findViewById(R.id.picker_tinggi);
        btnSebelumnya = (ImageView) findViewById(R.id.btn_sebelumnya);
        btnSelanjutnya = (ImageView) findViewById(R.id.btn_selanjutnya);
    }
}