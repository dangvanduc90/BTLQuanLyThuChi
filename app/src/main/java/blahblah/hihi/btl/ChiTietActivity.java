package blahblah.hihi.btl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import blahblah.hihi.btl.doituong.MainDanhSach;

public class ChiTietActivity extends Activity {
    TextView tvMuc,tvNoidung,tvSoTien,tvNgay;
    Button btnThoat;
    Intent intent;
    MainDanhSach mainDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControls() {
        tvMuc = findViewById(R.id.ct_tv_Muc);
        tvNoidung = findViewById(R.id.ct_tv_Noidung);
        tvSoTien = findViewById(R.id.ct_tv_soTien);
        tvNgay = findViewById(R.id.ct_tv_ngay);
        btnThoat = findViewById(R.id.ct_btn_Thoat);
        intent = getIntent();
        mainDanhSach = (MainDanhSach) intent.getSerializableExtra("chitiet");
        tvMuc.append(mainDanhSach.getMuc());
        tvNoidung.append(mainDanhSach.getDiengiai());
        tvSoTien.append(mainDanhSach.getSotien()+" vnd");
        tvNgay.append(mainDanhSach.getNgay());
    }
}
