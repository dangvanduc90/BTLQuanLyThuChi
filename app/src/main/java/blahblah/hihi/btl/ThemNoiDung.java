package blahblah.hihi.btl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThemNoiDung extends Activity {
    EditText edtNhapNoiDung;
    Button btnok,btnhuy;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_noi_dung);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("noidung",edtNhapNoiDung.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControls() {
        intent = getIntent();
        btnhuy = (Button) findViewById(R.id.btnHuy);
        btnok = (Button) findViewById(R.id.btnOK);
        edtNhapNoiDung = (EditText) findViewById(R.id.edtNhapNoiDung);
    }
}
