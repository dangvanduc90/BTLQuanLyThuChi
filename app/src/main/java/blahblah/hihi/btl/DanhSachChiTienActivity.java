package blahblah.hihi.btl;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import blahblah.hihi.btl.adapter.MainAdapter;
import blahblah.hihi.btl.doituong.MainDanhSach;
import blahblah.hihi.btl.doituong.Tien;
public class DanhSachChiTienActivity extends Activity {
    ListView lvDanhSach;
    MainAdapter adapter;
    MainDanhSach mainDanhSach;
    TextView sotien;
    Tien tien;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_chi_tien2);
        addControls();
        addEvents();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            mainDanhSach = (MainDanhSach) bundle.getSerializable("eventos");
            if (mainDanhSach != null) {
                Log.d("1234", mainDanhSach.getDiengiai());
                Log.d("1234", mainDanhSach.getSotien() + "");
                adapter.add(mainDanhSach);
                adapter.notifyDataSetChanged();
            }
        }
    }
    private void addControls() {
    }
    private void addEvents() {
        tien = new Tien();
        tien.setSoTien(500000);
        sotien =  findViewById(R.id.textView2);
        adapter = new MainAdapter(this,R.layout.layoutmain);
        lvDanhSach = (ListView) findViewById(R.id.lvDanhSach);
        lvDanhSach.setAdapter(adapter);
        registerForContextMenu(lvDanhSach);
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
                Intent intent1 = new Intent(DanhSachChiTienActivity.this,ChiTietActivity.class);
                intent1.putExtra("chitiet",adapter.getItem(pos));
                startActivity(intent1);
                break;
            case R.id.mnuedit:
                Intent intent = new Intent(DanhSachChiTienActivity.this,EditActivity.class);
                intent.putExtra("edit",adapter.getItem(pos));
                startActivityForResult(intent,4);
                break;
            case R.id.mnudelete:
                mainDanhSach = adapter.getItem(pos);
                if (mainDanhSach.getLoai().equals("Thu")){
                    Toast.makeText(DanhSachChiTienActivity.this,"-"+mainDanhSach.getSotien(), Toast.LENGTH_SHORT).show();
                    tien.setSoTien(tien.getSoTien()-mainDanhSach.getSotien());
                }
                else {
                    Toast.makeText(DanhSachChiTienActivity.this,"+"+mainDanhSach.getSotien(), Toast.LENGTH_SHORT).show();
                    tien.setSoTien(tien.getSoTien()+mainDanhSach.getSotien());
                }
                adapter.remove(adapter.getItem(pos));
                break;
        }
        sotien.setText("Tỏng số tiền là: "+ tien.getSoTien());
        return super.onContextItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==1){
            mainDanhSach = new MainDanhSach();
            mainDanhSach = (MainDanhSach) data.getSerializableExtra("chi");
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
}