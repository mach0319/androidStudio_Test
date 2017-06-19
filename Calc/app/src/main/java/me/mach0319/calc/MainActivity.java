package me.mach0319.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button pl,mi,gop,na;
    TextView tx;
    View.OnClickListener clickListener;
    double a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pl = (Button)findViewById(R.id.btpl);
        mi = (Button)findViewById(R.id.btmi);
        gop = (Button)findViewById(R.id.btgop);
        na = (Button)findViewById(R.id.btna);
        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);
        tx = (TextView)findViewById(R.id.tx);

       clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Double.parseDouble(ed1.getText().toString());
                b = Double.parseDouble(ed2.getText().toString());
                switch (v.getId()) {
                    case R.id.btpl:
                        c = a + b;
                        break;
                    case R.id.btmi:
                        c = a - b;
                        break;
                    case R.id.btna:
                        c = a / b;
                        break;
                    case R.id.btgop:
                        c = a / b;
                        break;
                }

                tx.setText(String.valueOf(c));
            }
       };

        pl.setOnClickListener(clickListener);
        mi.setOnClickListener(clickListener);
        gop.setOnClickListener(clickListener);
        na.setOnClickListener(clickListener);
    }
}
