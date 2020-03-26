package com.fari.calender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText date;
    CalendarView calender;
    long today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (EditText) findViewById(R.id.input);
        calender = (CalendarView) findViewById(R.id.calender);

        today = calender.getDate();
    }

    public void goTo(View view) {

        //convert string format of date to long
        try {
            String dateString = date.getText().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date newDate = sdf.parse(dateString);
            long longDate = newDate.getTime();

            calender.setDate(longDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refresh(View view) {
        calender.setDate(today);
        date.setText("");
    }
}