package com.github.frahohen.divisioncalculator;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DivisionActivity extends AppCompatActivity {

    private static final String ERROR = "Error:";
    private static final String OUTPUT = "Output:";

    private EditText editTextDividend;
    private EditText editTextDivisor;
    private TextView textViewOutputLabel;
    private TextView textViewOutputText;

    private String outputText;
    private String outputLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        editTextDividend = (EditText) findViewById(R.id.editTextDividend);
        editTextDivisor = (EditText) findViewById(R.id.editTextDivisor);
        textViewOutputLabel = (TextView) findViewById(R.id.textViewOutputLabel);
        textViewOutputText = (TextView) findViewById(R.id.textViewOutputText);

        outputText = "3";
        outputLabel = OUTPUT;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        int orientation = newConfig.orientation;

        if(orientation == Configuration.ORIENTATION_PORTRAIT ||
                orientation == Configuration.ORIENTATION_LANDSCAPE ||
                orientation == Configuration.ORIENTATION_UNDEFINED) {

            textViewOutputLabel.setText(outputLabel);
            textViewOutputText.setText(outputText);
        }
    }

    public void onButtonClickDevide(View v) {
        double dividend = Double.parseDouble(editTextDividend.getText().toString());
        double divisor = Double.parseDouble(editTextDivisor.getText().toString());

        double result = 0.0;

        if (dividend == 0) {
            outputLabel = ERROR;
            outputText = "Dividend hat den Wert 0";

            if (divisor == 0) {
                outputText = "Divisor und Dividend sind 0";

            }
        } else if (divisor == 0) {
            outputLabel = ERROR;
            outputText = "Division durch 0";
        } else{
            try {
                result = dividend / divisor;
            } catch(Exception e){
                Log.getStackTraceString(e);
            }

            outputText = Double.toString(result);
            outputLabel = OUTPUT;
        }

        textViewOutputLabel.setText(outputLabel);
        textViewOutputText.setText(outputText);
    }
}
