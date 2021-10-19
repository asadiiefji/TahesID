package com.example.tahesid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BeratBadan extends AppCompatActivity {

    private NumberPicker pickerBerat;
    int berat;
    private ImageView btnSebelumnya;
    private ImageView btnSelanjutnya;
    DatabaseReference databaseReference;
    public static String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat_badan);
        initView();
        user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        pickerBerat.setMaxValue(200);
        pickerBerat.setMinValue(10);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("user").child(user_id);
        pickerBerat.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                berat = i1;
            }
        });
        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BeratBadan.this,TinggiBadan.class));
                databaseReference.child("berat").setValue(berat);
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
        pickerBerat = (NumberPicker) findViewById(R.id.picker_berat);
        btnSebelumnya = (ImageView) findViewById(R.id.btn_sebelumnya);
        btnSelanjutnya = (ImageView) findViewById(R.id.btn_selanjutnya);
    }
}