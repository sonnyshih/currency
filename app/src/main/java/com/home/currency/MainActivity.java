package com.home.currency;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ndtEidtText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        ndtEidtText = findViewById(R.id.main_ndtEditText);
        Button goButton = findViewById(R.id.main_goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ndtEidtText.getText().toString().equals("")) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Problem")
                            .setMessage("Please enter your NTD amount")
                            .setPositiveButton("OK", null)
                            .show();

                } else {

                    String ndtString = ndtEidtText.getText().toString();

                    if (isNumeric(ndtString)) {

                        double ndtNumber = Double.parseDouble(ndtString);
                        double result = ndtNumber/30.9f;

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Result")
                                .setMessage("USD is " + result)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ndtEidtText.setText("");
                                    }
                                })
                                .show();

                    } else {

                    }
                }

            }
        });
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
