package blahblah.hihi.btl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThemTien extends Activity {
    EditText edtNhapTien;
    Button btnCapNhat,btnHuy;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tien);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("tien", Integer.parseInt(edtNhapTien.getText().toString()));
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControls() {
        intent = getIntent();
        edtNhapTien = (EditText) findViewById(R.id.edtNhapTien);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        btnHuy = (Button) findViewById(R.id.btnHuy);
    }
}
