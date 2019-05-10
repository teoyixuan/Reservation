package sg.edu.rp.c346.reservation;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnReservation, btnReset;
    TextView tvName, tvMobile, tvPax;
    EditText etName, etMobile, etPax;
    DatePicker dp;
    TimePicker tp;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReservation = findViewById(R.id.btnReservation);
        btnReset = findViewById(R.id.btnReset);
        tvName = findViewById(R.id.textName);
        tvMobile = findViewById(R.id.textViewMobile);
        tvPax = findViewById(R.id.Pax);
        etName = findViewById(R.id.editTextName);
        etMobile = findViewById(R.id.editTextMobile);
        etPax = findViewById(R.id.editTextPax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cb = findViewById(R.id.cbNon);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate( 2019, 5, 1);
                tp.setCurrentHour(07);
                tp.setCurrentMinute(30);
            }
        });

        btnReservation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String b = tp.getCurrentMinute().toString();
                String c = tp.getCurrentHour().toString();
                String d = "Non-Smoking Area";
                if (b.length() == 1) {
                    b = "0" + b;
                }
                if(c.length() == 1){
                    c = "0" + c;
                }
                if(cb.isChecked()){
                    d = "Smoking Area";
                }
                String a = "Name :" + etName.getText().toString() + "\n";
                a += "Mobile :" + etMobile.getText().toString() + "\n";
                a += "Pax :" + etPax.getText().toString() + "\n";
                a += "Date is " + dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear() + "\n";
                a += "Time is " + b + ":" + c + "\n";
                a += d;
                Toast.makeText(MainActivity.this, a, Toast.LENGTH_SHORT ).show();

            }
        });
    }

}
