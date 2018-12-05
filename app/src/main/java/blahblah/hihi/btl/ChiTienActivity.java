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


import blahblah.hihi.btl.adapter.ChiTraAdapter;
import blahblah.hihi.btl.doituong.ChiTra;

public class ChiTienActivity extends Activity {
    ListView lvChi;
    ChiTraAdapter chiTraAdapter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tien);
        addControls();
        CreateMenu();
        addEvents();
    }

    private void addEvents() {
        lvChi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChiTra chiTra = chiTraAdapter.getItem(position);
                intent.putExtra("chitra",chiTra.getNoiDung());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucancel,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setResult(RESULT_CANCELED);
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void CreateMenu() {
        chiTraAdapter.add(new ChiTra(R.drawable.chovay,"Cho vay"));
        chiTraAdapter.add(new ChiTra(R.drawable.trano,"Tra no"));
        chiTraAdapter.add(new ChiTra(R.drawable.anuong,"An uong"));
        chiTraAdapter.add(new ChiTra(R.drawable.dicho,"Di cho/sieu thi"));
        chiTraAdapter.add(new ChiTra(R.drawable.anquan,"An quan"));
        chiTraAdapter.add(new ChiTra(R.drawable.cafe,"Cafe"));
        chiTraAdapter.add(new ChiTra(R.drawable.concai,"Con cai"));
        chiTraAdapter.add(new ChiTra(R.drawable.sua,"Sua"));
        chiTraAdapter.add(new ChiTra(R.drawable.hocphi,"Hoc phi"));
        chiTraAdapter.add(new ChiTra(R.drawable.sachvo,"Sach vo"));
        chiTraAdapter.add(new ChiTra(R.drawable.dochoi,"Do choi"));
        chiTraAdapter.add(new ChiTra(R.drawable.tientieuvat,"Tien tieu vat"));
        chiTraAdapter.add(new ChiTra(R.drawable.dichvu,"Dich vu sinh hoat"));
        chiTraAdapter.add(new ChiTra(R.drawable.diennuoc,"Dien nuoc"));
        chiTraAdapter.add(new ChiTra(R.drawable.internet,"Internet"));
        chiTraAdapter.add(new ChiTra(R.drawable.gas,"Gas"));
        chiTraAdapter.add(new ChiTra(R.drawable.truyenhinh,"Truyen hinh"));
        chiTraAdapter.add(new ChiTra(R.drawable.dienthoaidd,"Dien thoai di dong"));
        chiTraAdapter.add(new ChiTra(R.drawable.dilai,"Di lai"));
        chiTraAdapter.add(new ChiTra(R.drawable.xangxe,"Xang xe"));
        chiTraAdapter.add(new ChiTra(R.drawable.baohiem,"Bao hiem xe"));
        chiTraAdapter.add(new ChiTra(R.drawable.ruaxe,"Rua xe"));
        chiTraAdapter.add(new ChiTra(R.drawable.suaxe,"Sua chua xe"));
        chiTraAdapter.add(new ChiTra(R.drawable.trangphuc,"Trang phuc"));
        chiTraAdapter.add(new ChiTra(R.drawable.quanao,"Quan ao"));
        chiTraAdapter.add(new ChiTra(R.drawable.giaydep,"Giay dep"));
        chiTraAdapter.add(new ChiTra(R.drawable.phukienkhac,"Phu kien khac"));
        chiTraAdapter.add(new ChiTra(R.drawable.suckhoe,"Suc khoe"));
        chiTraAdapter.add(new ChiTra(R.drawable.khamchuabenh,"Kham chua benh"));
        chiTraAdapter.add(new ChiTra(R.drawable.nhacua,"Nha cua"));
        chiTraAdapter.add(new ChiTra(R.drawable.muasamdodac,"Mua sam do dac"));
        chiTraAdapter.add(new ChiTra(R.drawable.suachuanhacua,"Sua chua nha cua"));
        chiTraAdapter.add(new ChiTra(R.drawable.vuichoigiaitri,"Vui choi giai tri"));
        chiTraAdapter.add(new ChiTra(R.drawable.dulich,"Du lich"));

    }

    private void addControls() {
        intent = getIntent();
        lvChi = (ListView) findViewById(R.id.lvChi);
        chiTraAdapter = new ChiTraAdapter(this,R.layout.layoutchitra);
        lvChi.setAdapter(chiTraAdapter);

    }
}
