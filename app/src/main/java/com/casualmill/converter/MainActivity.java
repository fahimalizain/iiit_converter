package com.casualmill.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText mInput;
    private TextView mOutput;
    private RadioButton mMiles, mCelsius, mFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInput = (EditText) findViewById(R.id.input);
        mOutput = (TextView) findViewById(R.id.output);
        mMiles = (RadioButton) findViewById(R.id.rb_Miles);
        mCelsius = (RadioButton) findViewById(R.id.rb_Celsius);
        mFahrenheit = (RadioButton) findViewById(R.id.rb_Fahrenheit);
    }

    public void convert(View v) {
        mOutput.setText("");
        try {
            double input = Double.parseDouble(mInput.getText().toString());
            double output = -1;

            if (mMiles.isChecked()) {
                Toast.makeText(this,"km -> miles", Toast.LENGTH_SHORT).show();
                output = input * 0.621371f;
            }
            else if (mCelsius.isChecked()) {
                Toast.makeText(this,"fahrenheit -> celsius", Toast.LENGTH_SHORT).show();
                output = (input - 32) * 5 / 9;
            }
            else if (mFahrenheit.isChecked()) {
                Toast.makeText(this,"celsius -> fahrenheit", Toast.LENGTH_SHORT).show();
                output = input * 9 / 5 + 32;
            } else {
                Toast.makeText(this,"Please select a unit to convert to", Toast.LENGTH_SHORT).show();
                return;
            }

            mOutput.setText(String.format(Locale.US, "%.2f", output));
        } catch (Exception e) {
            Toast.makeText(this,"Please provide valid input", Toast.LENGTH_SHORT).show();
        }
    }
}
