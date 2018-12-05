package blahblah.hihi.btl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import blahblah.hihi.btl.adapter.BangAdapter;
import blahblah.hihi.btl.doituong.Bang;
import blahblah.hihi.btl.doituong.MainDanhSach;

public class BangThuActivity extends Activity {
    ListView lvBang;
    BangAdapter adapter;
    Bang mucthu,diengiai,ngay,sotien;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_thu);
        addControls();
        CreateMenu();
        addEvents();
        update();
    }
    private void update() {
        adapter.clear();
        adapter.add(mucthu);
        adapter.add(diengiai);
        adapter.add(sotien);
        adapter.add(ngay);
    }
    private void addEvents() {
        lvBang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent intent = new Intent(BangThuActivity.this,ThuTienActivity.class);
                        startActivityForResult(intent,0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(BangThuActivity.this,ThemNoiDung.class);
                        startActivityForResult(intent1,1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(BangThuActivity.this,ThemTien.class);
                        startActivityForResult(intent2,2);
                        break;
                }

            }
        });
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
                if (mucthu.getNoiDung().equals("")||sotien.getNoiDung().equals("0")){
                    Toast.makeText(this,"Thong tin chua hop le", Toast.LENGTH_LONG).show();
                }else {
                    MainDanhSach mainDanhSach = new MainDanhSach();
                    mainDanhSach.setLoai("Thu");
                    mainDanhSach.setHinh(R.drawable.thu);
                    mainDanhSach.setDiengiai(diengiai.getNoiDung());
                    mainDanhSach.setMuc(mucthu.getNoiDung());
                    mainDanhSach.setNgay(ngay.getNoiDung());
                    mainDanhSach.setSotien(Integer.parseInt(sotien.getNoiDung()));
                    intent.putExtra("thu", mainDanhSach);
                    setResult(2, intent);
                    finish();
                }
                break;
            case R.id.mnuCancel:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK) {
            mucthu.setNoiDung(data.getStringExtra("chitra"));
        }
        if(requestCode == 1 && resultCode == RESULT_OK) {
            diengiai.setNoiDung(data.getStringExtra("noidung"));
        }
        if(requestCode == 2 && resultCode == RESULT_OK) {
            int tien = data.getIntExtra("tien",0);
            sotien.setNoiDung(tien+"");
        }
        update();
    }
    private void CreateMenu() {
        mucthu = new Bang("Mức thu: ","");
        diengiai = new Bang("Diễn giải: ","");
        sotien = new Bang("Số tiền:","0");
        ngay = new Bang("Ngày: ",new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        adapter.add(mucthu);
        adapter.add(diengiai);
        adapter.add(sotien);
        adapter.add(ngay);

    }
    private void addControls() {
        intent = getIntent();
        lvBang = (ListView) findViewById(R.id.lvBang);
        adapter = new BangAdapter(this,R.layout.layoutbang);
        lvBang.setAdapter(adapter);
    }
}
