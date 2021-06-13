package com.example.antrian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.antrian.models.Item_antrian;

public class Detail_antrian extends AppCompatActivity {
    TextView txt_status , txt_nomor , txt_jam;
    ImageView img_status;

    private Item_antrian item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_antrian);
        txt_status = findViewById(R.id.txt_status);
        img_status = findViewById(R.id.img_status);
        txt_jam = findViewById(R.id.txt_jam);
        txt_nomor = findViewById(R.id.txt_nomor);

        item = getIntent().getParcelableExtra("item");
        System.out.println(item.getJam_dipanggil());
        if (item.getJam_dipanggil() == null){
            txt_status.setText("Belum Dipanggil");
            txt_nomor.setText(item.getNomor_antrian());
            txt_jam.setText(item.getJam_dibuat());
            img_status.setImageResource(R.mipmap.ic_user_call1_foreground);
        }
        else {
            txt_status.setText("Terpanggil");
            txt_nomor.setText(item.getNomor_antrian());
            txt_jam.setText(item.getJam_dibuat());
            img_status.setImageResource(R.mipmap.ic_user_call_foreground);
        }
    }
}