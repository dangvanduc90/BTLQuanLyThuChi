package blahblah.hihi.btl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HuongDanActivity extends Activity {
    Button btnok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huong_dan);
        btnok = (Button) findViewById(R.id.btnok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
