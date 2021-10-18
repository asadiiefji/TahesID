package com.example.tahesid;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tahesid.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PilihTarget extends AppCompatActivity {

    private LinearLayout btnLebihBerat;
    private TextView progrssBerat;
    private LinearLayout btnIdeal;
    private TextView progressIdeal;
    private LinearLayout btnLebihRingan;
    private TextView progressRingan;
    DatabaseReference databaseReference;
    private ImageButton mulaiLebihBerat;
    private ImageButton mulaiIdeal;
    private ImageButton mulaiLebihRingan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_target);
        initView();
        databaseReference = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user.getLebih_berat() == 0) {
                    progrssBerat.setVisibility(View.GONE);
                } else if (user.getLebih_berat() != 0) {
                    progrssBerat.setText(String.valueOf(user.getLebih_berat()) + "/ 10");
                    mulaiLebihBerat.setVisibility(View.GONE);
                }
                if (user.getIdeal() == 0) {
                    progressIdeal.setVisibility(View.GONE);
                } else if (user.getIdeal() != 0) {
                    progressIdeal.setText(String.valueOf(user.getIdeal()) + "/ 10");
                    mulaiIdeal.setVisibility(View.GONE);
                }
                if (user.getLebih_ringan() == 0) {
                    progressRingan.setVisibility(View.GONE);
                } else if (user.getLebih_ringan() != 0) {
                    progressRingan.setText(String.valueOf(user.getLebih_ringan()) + "/ 10");
                    mulaiLebihRingan.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void initView() {
        btnLebihBerat = (LinearLayout) findViewById(R.id.btn_lebih_berat);
        progrssBerat = (TextView) findViewById(R.id.progrss_berat);
        btnIdeal = (LinearLayout) findViewById(R.id.btn_ideal);
        progressIdeal = (TextView) findViewById(R.id.progress_ideal);
        btnLebihRingan = (LinearLayout) findViewById(R.id.btn_lebih_ringan);
        progressRingan = (TextView) findViewById(R.id.progress_ringan);
        mulaiLebihBerat = (ImageButton) findViewById(R.id.mulai_lebih_berat);
        mulaiIdeal = (ImageButton) findViewById(R.id.mulai_ideal);
        mulaiLebihRingan = (ImageButton) findViewById(R.id.mulai_lebih_ringan);
    }
}