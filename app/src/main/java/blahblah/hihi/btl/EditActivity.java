package blahblah.hihi.btl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;


import blahblah.hihi.btl.doituong.MainDanhSach;

public class EditActivity extends Activity {
    EditText edtMuc,edtNoidung,edtSotien,edtNgay;
    Intent intent;
    MainDanhSach mainDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuxacnhan,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuOk:
                mainDanhSach.setMuc(edtMuc.getText().toString());
                mainDanhSach.setDiengiai(edtNoidung.getText().toString());
                mainDanhSach.setSotien(Integer.parseInt(edtSotien.getText().toString()));
                mainDanhSach.setNgay(edtNgay.getText().toString());
                intent.putExtra("edited",mainDanhSach);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.mnuCancel:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addControls() {
        edtMuc = (EditText) findViewById(R.id.editmuc);
        edtNoidung = (EditText) findViewById(R.id.editnoidung);
        edtSotien = (EditText) findViewById(R.id.editsotien);
        edtNgay = (EditText) findViewById(R.id.editngay);
        intent = getIntent();
        mainDanhSach = (MainDanhSach) intent.getSerializableExtra("edit");
        edtMuc.setText(mainDanhSach.getMuc());
        edtNoidung.setText(mainDanhSach.getDiengiai());
        edtSotien.setText(mainDanhSach.getSotien()+"");
        edtNgay.setText(mainDanhSach.getNgay());
    }


}
