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
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import blahblah.hihi.btl.adapter.BangAdapter;
import blahblah.hihi.btl.doituong.Bang;
import blahblah.hihi.btl.doituong.MainDanhSach;

public class BangChiActivity extends Activity {
    ListView lvBang;
    BangAdapter adapter;
    Bang mucchi,diengiai,ngay,sotien;
    Intent intent;
    TextView tienconlai;
    int sotienconlai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_chi);
        addControls();
        CreateMenu();
        addEvents();
        update();
    }

    private void addEvents() {
        lvBang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent intent = new Intent(BangChiActivity.this,ChiTienActivity.class);
                        startActivityForResult(intent,0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(BangChiActivity.this,ThemNoiDung.class);
                        startActivityForResult(intent1,1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(BangChiActivity.this,ThemTien.class);
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
                if (Integer.parseInt(sotien.getNoiDung())>sotienconlai){
                    Toast.makeText(BangChiActivity.this,"So tien chi lon hon so du\nVui long nhap lai", Toast.LENGTH_LONG).show();
                    //break;
                } else
                if (mucchi.getNoiDung().equals("") || sotien.getNoiDung().equals("0")){
                    Toast.makeText(this,"Thong tin chua hop le", Toast.LENGTH_LONG).show();
                }else {
                    MainDanhSach mainDanhSach = new MainDanhSach();
                    mainDanhSach.setLoai("Chi");
                    mainDanhSach.setHinh(R.drawable.chi);
                    mainDanhSach.setDiengiai(diengiai.getNoiDung());
                    mainDanhSach.setMuc(mucchi.getNoiDung());
                    mainDanhSach.setNgay(ngay.getNoiDung());
                    mainDanhSach.setSotien(Integer.parseInt(sotien.getNoiDung()));
                    intent.putExtra("chi", mainDanhSach);
                    setResult(1, intent);
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
            mucchi.setNoiDung(data.getStringExtra("chitra"));
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

    private void update() {
        adapter.clear();
        adapter.add(mucchi);
        adapter.add(diengiai);
        adapter.add(sotien);
        adapter.add(ngay);
    }

    private void CreateMenu() {
        mucchi = new Bang("Mức chi: ","");
        diengiai = new Bang("Diễn giải: ","");
        sotien = new Bang("Số tiền:","0");
        ngay = new Bang("Ngày: ",new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        adapter.add(mucchi);
        adapter.add(diengiai);
        adapter.add(sotien);
        adapter.add(ngay);

    }

    private void addControls() {
        intent = getIntent();
        tienconlai = (TextView) findViewById(R.id.tv_sotienconlai);
        sotienconlai = intent.getIntExtra("tien",0);
        tienconlai.append(sotienconlai+"");
        lvBang = (ListView) findViewById(R.id.lvBang);
        adapter = new BangAdapter(this,R.layout.layoutbang);
        lvBang.setAdapter(adapter);
    }

}
