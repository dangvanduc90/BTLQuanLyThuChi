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

import blahblah.hihi.btl.adapter.TienAdapter;
import blahblah.hihi.btl.doituong.Tien;

public class QuanLyTienActivity extends Activity {
    ListView lvDanhSachLoaiTien;
    TienAdapter tienAdapter;
    Tien tien;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tien);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvDanhSachLoaiTien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Tien tien = tienAdapter.getItem(position);
                Intent intent = new Intent(QuanLyTienActivity.this,ThemTien.class);
                startActivityForResult(intent,1);
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            tien.setSoTien(data.getIntExtra("tien",0));
        }

        update();
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
                intent.putExtra("tien",tien.getSoTien());
                setResult(3,intent);
                finish();
                break;
            case  R.id.mnuCancel:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void addControls() {
        intent = getIntent();
        lvDanhSachLoaiTien = (ListView) findViewById(R.id.lvDanhSachLoaiTien);
        tienAdapter = new TienAdapter(QuanLyTienActivity.this,R.layout.layoutquanlytien);
        lvDanhSachLoaiTien.setAdapter(tienAdapter);
        tien = new Tien(R.drawable.vi,intent.getIntExtra("tien",0),"Vi");
        tienAdapter.add(tien);

    }
    private void update(){
        tienAdapter.clear();
        tienAdapter.add(tien);
    }
}
