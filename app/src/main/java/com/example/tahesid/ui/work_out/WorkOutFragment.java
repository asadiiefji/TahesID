package com.example.tahesid.ui.work_out;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tahesid.BeratBadan;
import com.example.tahesid.Login;
import com.example.tahesid.Model.User;
import com.example.tahesid.PilihTarget;
import com.example.tahesid.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class WorkOutFragment extends Fragment {

    View root;
    private LinearLayout cardLatihan1;
    private TextView tvMulai1;
    private LinearLayout cardLatihan2;
    private TextView tvMulai2;
    private LinearLayout cardLatihan3;
    private TextView tvMulai3;
    private LinearLayout cardLatihan4;
    private TextView tvMulai4;
    private LinearLayout cardLatihan5;
    private TextView tvMulai5;
    private LinearLayout cardLatihan6;
    private TextView tvMulai6;
    private LinearLayout cardLatihan7;
    private TextView tvMulai7;
    DatabaseReference databaseReference;
    int lebih_berat,ideal,lebih_ringan;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (PilihTarget.tipe_latihan.equals("lebih_berat")) {
            root = inflater.inflate(R.layout.fragment_work_out, container, false);
            initView(root);

        } else if (PilihTarget.tipe_latihan.equals("lebih_ringan")) {
            root = inflater.inflate(R.layout.fragment_lebih_ringan, container, false);
            initView(root);

        } else if (PilihTarget.tipe_latihan.equals("ideal")) {
            root = inflater.inflate(R.layout.fragment_ideal, container, false);
            initView(root);

        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("user").child(BeratBadan.user_id);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (PilihTarget.tipe_latihan.equals("lebih_ringan")){
                    lebih_ringan = user.getLebih_ringan();
                    lebih_berat = 404;
                    ideal = 404;
                }else if (PilihTarget.tipe_latihan.equals("ideal")){
                    ideal = user.getIdeal();
                    lebih_berat = 404;
                    lebih_ringan = 404;
                } else if (PilihTarget.tipe_latihan.equals("lebih_berat")) {
                    ideal = 404;
                    lebih_berat = user.getLebih_berat();
                    lebih_ringan = 404;
                }


                if (ideal == 0 || lebih_berat == 0 || lebih_ringan == 0){
                    cardLatihan2.setEnabled(false);
                    cardLatihan3    .setEnabled(false);
                    cardLatihan4.setEnabled(false);
                    cardLatihan5.setEnabled(false);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai3.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai4.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai5.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));

                }else if(ideal == 1 || lebih_berat == 1 || lebih_ringan == 1){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(false);
                    cardLatihan4.setEnabled(false);
                    cardLatihan5.setEnabled(false);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai4.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai5.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if (ideal == 2 || lebih_berat == 2 || lebih_ringan == 2){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(false);
                    cardLatihan5.setEnabled(false);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai5.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if(ideal == 3|| lebih_berat == 3 || lebih_ringan == 3){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(true);
                    cardLatihan5.setEnabled(false);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai5.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if (ideal == 4 || lebih_berat == 4 || lebih_ringan == 4){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(true);
                    cardLatihan5.setEnabled(true);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai5.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if(ideal == 5 || lebih_berat == 5 || lebih_ringan == 5){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(true);
                    cardLatihan5.setEnabled(true);
                    cardLatihan6.setEnabled(true);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai5.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai6.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if (ideal == 6 || lebih_berat == 6 || lebih_ringan == 6){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(true);
                    cardLatihan5.setEnabled(true);
                    cardLatihan6.setEnabled(true);
                    cardLatihan7.setEnabled(true);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai5.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai6.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai7.setTextColor(Color.parseColor("#FF8A00"));
                }

                if (ideal == 0){
                    cardLatihan2.setEnabled(false);
                    cardLatihan3.setEnabled(false);
                    cardLatihan4.setEnabled(false);
                    cardLatihan5.setEnabled(false);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai3.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai4.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai5.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));

                }else if(ideal == 1){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(false);
                    cardLatihan4.setEnabled(false);
                    cardLatihan5.setEnabled(false);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai4.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai5.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if (ideal == 2){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(false);
                    cardLatihan5.setEnabled(false);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai5.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if(ideal == 3){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(true);
                    cardLatihan5.setEnabled(false);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai5.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if (ideal == 4){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(true);
                    cardLatihan5.setEnabled(true);
                    cardLatihan6.setEnabled(false);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai5.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai6.setTextColor(Color.parseColor("#C2C2C2"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if(ideal == 5){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(true);
                    cardLatihan5.setEnabled(true);
                    cardLatihan6.setEnabled(true);
                    cardLatihan7.setEnabled(false);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai5.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai6.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai7.setTextColor(Color.parseColor("#C2C2C2"));
                }else if (ideal == 6){
                    cardLatihan2.setEnabled(true);
                    cardLatihan3.setEnabled(true);
                    cardLatihan4.setEnabled(true);
                    cardLatihan5.setEnabled(true);
                    cardLatihan6.setEnabled(true);
                    cardLatihan7.setEnabled(true);

                    tvMulai2.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai3.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai4.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai5.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai6.setTextColor(Color.parseColor("#FF8A00"));
                    tvMulai7.setTextColor(Color.parseColor("#FF8A00"));
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError databaseError) {

            }
        });


        return root;
    }

    private void initView(View view) {

        cardLatihan1 = (LinearLayout) view.findViewById(R.id.cardLatihan1);
        tvMulai1 = (TextView) view.findViewById(R.id.tv_mulai_1);
        cardLatihan2 = (LinearLayout) view.findViewById(R.id.cardLatihan2);
        tvMulai2 = (TextView) view.findViewById(R.id.tv_mulai_2);
        cardLatihan3 = (LinearLayout) view.findViewById(R.id.cardLatihan3);
        tvMulai3 = (TextView) view.findViewById(R.id.tv_mulai_3);
        cardLatihan4 = (LinearLayout) view.findViewById(R.id.cardLatihan4);
        tvMulai4 = (TextView) view.findViewById(R.id.tv_mulai_4);
        cardLatihan5 = (LinearLayout) view.findViewById(R.id.cardLatihan5);
        tvMulai5 = (TextView) view.findViewById(R.id.tv_mulai_5);
        cardLatihan6 = (LinearLayout) view.findViewById(R.id.cardLatihan6);
        tvMulai6 = (TextView) view.findViewById(R.id.tv_mulai_6);
        cardLatihan7 = (LinearLayout) view.findViewById(R.id.cardLatihan7);
        tvMulai7 = (TextView) view.findViewById(R.id.tv_mulai_7);
    }
}