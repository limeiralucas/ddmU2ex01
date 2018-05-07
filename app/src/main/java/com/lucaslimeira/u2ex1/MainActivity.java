package com.lucaslimeira.u2ex1;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DatePicker.OnDateSetListerner, TimePicker.OnTimeSetListener {

    private Calendar dateTime;
    private TextView dateTimeText;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTimeText = findViewById(R.id.dateTimeText);
        dateTime = Calendar.getInstance();
        dateTimeText.setText(formatter.format(dateTime.getTime()));
    }

    public void openDate(View view) {
        datePicker = new DatePicker();
        datePicker.show(getFragmentManager(), "datePicker");
    }

    public void openTime(View view) {
        timePicker = new TimePicker();
        timePicker.show(getFragmentManager(), "timePicker");
    }

    @Override
    public void updateDate(int year, int month, int dayOfMonth) {
        this.dateTime.set(Calendar.YEAR, year);
        this.dateTime.set(Calendar.MONTH, month);
        this.dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        this.dateTimeText.setText(formatter.format(this.dateTime.getTime()));
    }

    @Override
    public void updateTime(int hourOfDay, int minute) {
        this.dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        this.dateTime.set(Calendar.MINUTE, minute);

        this.dateTimeText.setText(formatter.format(this.dateTime.getTime()));
    }
}
