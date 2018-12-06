package blahblah.hihi.btl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import blahblah.hihi.btl.adapter.MainAdapter;
import blahblah.hihi.btl.doituong.MainDanhSach;
import blahblah.hihi.btl.doituong.Tien;

public class MainActivity extends Activity {
//    ListView lvDanhSach;
    TextView sotien;
    Tien tien;
    MainAdapter adapter;
    MainDanhSach mainDanhSach, mainDanhSach1;
    Button btnThu, btnChi;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuChi:
                Intent intent1 = new Intent(this, BangChiActivity.class);
                intent1.putExtra("tien",tien.getSoTien());
                startActivityForResult(intent1,1);
                break;
            case R.id.mnuThu:
                Intent intent2 = new Intent(this, BangThuActivity.class);
                startActivityForResult(intent2,2);
                break;
            case R.id.mnuQuanLyTien:
                Intent intent3 = new Intent(this, QuanLyTienActivity.class);
                intent3.putExtra("tien",tien.getSoTien());
                startActivityForResult(intent3, 3);
                break;
            case R.id.mnuHuongDan:
                Intent intent4 = new Intent(this, HuongDanActivity.class);
                startActivity(intent4);
                break;
            case R.id.mnuThongTin:
                Intent intent5 = new Intent(this,ThongTinActivity.class);
                startActivity(intent5);
                break;

            case R.id.mnuDanhSachChi:
                Intent intent = new Intent(MainActivity.this, DanhSachChiTienActivity.class);
                Bundle informacion = new Bundle();
                informacion.putSerializable("eventos", mainDanhSach1);
                intent.putExtras(informacion);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==1){
            mainDanhSach = new MainDanhSach();
            mainDanhSach = (MainDanhSach) data.getSerializableExtra("chi");
            mainDanhSach1 = mainDanhSach;
            adapter.add(mainDanhSach);
            tien.setSoTien(tien.getSoTien()-mainDanhSach.getSotien());
            Toast.makeText(this,"-"+mainDanhSach.getSotien(), Toast.LENGTH_LONG).show();
        }
        if (requestCode==2&& resultCode ==2){
            mainDanhSach = new MainDanhSach();
            mainDanhSach = (MainDanhSach) data.getSerializableExtra("thu");
            tien.setSoTien(tien.getSoTien()+mainDanhSach.getSotien());
            adapter.add(mainDanhSach);
            Toast.makeText(this,"+"+mainDanhSach.getSotien(), Toast.LENGTH_LONG).show();
        }
        if (requestCode==3 && resultCode ==3){
            tien.setSoTien(data.getIntExtra("tien",0));
        }
        if (requestCode == 4 && resultCode == RESULT_OK){
            int newmoney;
            mainDanhSach = new MainDanhSach();
            mainDanhSach = (MainDanhSach) data.getSerializableExtra("edited");
            MainDanhSach old = adapter.getItem(pos);
            if (mainDanhSach.getLoai().equals("Chi")){
                if (old.getSotien()<mainDanhSach.getSotien()){
                    newmoney = mainDanhSach.getSotien()-old.getSotien();
                    tien.setSoTien(tien.getSoTien()-newmoney);
                    Toast.makeText(this,"-"+newmoney, Toast.LENGTH_LONG).show();
                } else if (old.getSotien()>mainDanhSach.getSotien()){
                    newmoney = old.getSotien() - mainDanhSach.getSotien();
                    tien.setSoTien(tien.getSoTien()+newmoney);
                    Toast.makeText(this,"+"+newmoney, Toast.LENGTH_LONG).show();
                }
            } else {
                if (old.getSotien()<mainDanhSach.getSotien()){
                    newmoney = mainDanhSach.getSotien()-old.getSotien();
                    tien.setSoTien(tien.getSoTien()+newmoney);
                    Toast.makeText(this,"+"+newmoney, Toast.LENGTH_LONG).show();
                } else if (old.getSotien()>mainDanhSach.getSotien()){
                    newmoney = old.getSotien() - mainDanhSach.getSotien();
                    tien.setSoTien(tien.getSoTien()-newmoney);
                    Toast.makeText(this,"-"+newmoney, Toast.LENGTH_LONG).show();
                }
            }

            adapter.remove(adapter.getItem(pos));
            adapter.insert(mainDanhSach,pos);

        }
        sotien.setText("Tổng số tiền là: "+ tien.getSoTien());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontext,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //int possion = info.position; // lấy ra vị trí item mình chọn
        pos = info.position;
        int id = item.getItemId(); // id của item
        switch (id){
            case R.id.mnuchitiet:
                Intent intent1 = new Intent(MainActivity.this,ChiTietActivity.class);
                intent1.putExtra("chitiet",adapter.getItem(pos));
                startActivity(intent1);
                break;
            case R.id.mnuedit:
                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                intent.putExtra("edit",adapter.getItem(pos));
                startActivityForResult(intent,4);
                break;
            case R.id.mnudelete:
                mainDanhSach = adapter.getItem(pos);
                if (mainDanhSach.getLoai().equals("Thu")){
                    Toast.makeText(MainActivity.this,"-"+mainDanhSach.getSotien(), Toast.LENGTH_SHORT).show();
                    tien.setSoTien(tien.getSoTien()-mainDanhSach.getSotien());
                }
                else {
                    Toast.makeText(MainActivity.this,"+"+mainDanhSach.getSotien(), Toast.LENGTH_SHORT).show();
                    tien.setSoTien(tien.getSoTien()+mainDanhSach.getSotien());
                }
                adapter.remove(adapter.getItem(pos));
                break;
        }
        sotien.setText("Tỏng số tiền là: "+ tien.getSoTien());
        return super.onContextItemSelected(item);
    }

    private void addEvents() {
    }

    private void addControls() { //khai báo các thứ
        adapter = new MainAdapter(this,R.layout.layoutmain);
        tien = new Tien();
        tien.setSoTien(500000);
//        lvDanhSach = (ListView) findViewById(R.id.lvDanhSach);
//        lvDanhSach.setAdapter(adapter);
//        registerForContextMenu(lvDanhSach);
        sotien =  findViewById(R.id.textView2);
        sotien.setText("Tổng số tiền là: "+ tien.getSoTien());
//        adapter.add(new MainDanhSach("Test 1","dien giai 1","13-04-1997","Chi",10000,R.drawable.chi));
//        adapter.add(new MainDanhSach("Test 2","dien giai 2","16-11-1997","Thu",10000,R.drawable.thu));
//        adapter.add(new MainDanhSach("Test 3","dien giai 3","16-11-1997","Chi",10000,R.drawable.chi));
//        adapter.add(new MainDanhSach("Test 4","dien giai 4","16-11-1997","Thu",10000,R.drawable.thu));
//        adapter.add(new MainDanhSach("Tesst 5","dien giai 5","16-11-1997","Chi",10000,R.drawable.chi));
    }

}