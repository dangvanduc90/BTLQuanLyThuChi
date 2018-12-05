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

public class ThuTienActivity extends Activity {
    ListView lvThu;
    ChiTraAdapter chiTraAdapter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thu_tien);
        addControls();
        addEvents();
        CreateMenu();

    }

    private void addEvents() {
        lvThu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        chiTraAdapter.add(new ChiTra(R.drawable.luong,"Luong"));
        chiTraAdapter.add(new ChiTra(R.drawable.thuong,"Thuong"));
        chiTraAdapter.add(new ChiTra(R.drawable.duocchotang,"Duoc cho/ tang"));
        chiTraAdapter.add(new ChiTra(R.drawable.tienlai,"Tien lai"));
        chiTraAdapter.add(new ChiTra(R.drawable.khac,"Khac"));
    }
    private void addControls() {
        intent = getIntent();
        lvThu = (ListView) findViewById(R.id.lvThu);
        chiTraAdapter = new ChiTraAdapter(this,R.layout.layoutchitra);
        lvThu.setAdapter(chiTraAdapter);

    }
}
