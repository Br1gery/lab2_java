package com.example.lab2_java;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOError;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private EditText firstNumber;
    private EditText secondNumber;
    private TextView resultCalc;
    private TextView symbol;
    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstNumber = findViewById(R.id.firstNum);
        secondNumber = findViewById(R.id.secondNum);
        resultCalc = findViewById(R.id.result);
        symbol = findViewById(R.id.plusSymb);
        errorText = findViewById(R.id.error);

    }

    public void getSum(View view) {
        errorText.setText("");
        if(!firstNumber.getText().toString().equals("") & !secondNumber.getText().toString().equals("")){
            symbol.setText("+");
            Number result = Double.parseDouble(firstNumber.getText().toString()) + Double.parseDouble(secondNumber.getText().toString());
            resultCalc.setText(result.toString());
        }else{
            errorText.setText("Поля пустые");
        }
    }

    public void getDif(View view) {
        errorText.setText("");
        if(!firstNumber.getText().toString().equals("") & !secondNumber.getText().toString().equals("")){
            symbol.setText("-");

            Number result = Double.parseDouble(firstNumber.getText().toString()) - Double.parseDouble(secondNumber.getText().toString());
            resultCalc.setText(result.toString());

        }else{
            errorText.setText("Поля пустые");
        }

    }

    public void getDiv(View view) {
        errorText.setText("");
        if(!firstNumber.getText().toString().equals("") & !secondNumber.getText().toString().equals("")){
            if(!secondNumber.getText().toString().equals("0")){

                symbol.setText("/");

                Number result = Double.parseDouble(firstNumber.getText().toString()) / Double.parseDouble(secondNumber.getText().toString());
                resultCalc.setText(result.toString());
            }else{
                errorText.setText("Деление на ноль");
            }
        }else{
            errorText.setText("Поля пустые");
        }

    }

    public void getMulti(View view) {
        errorText.setText("");
        if(!firstNumber.getText().toString().equals("") & !secondNumber.getText().toString().equals("")){

            symbol.setText("*");

            Number result = Double.parseDouble(firstNumber.getText().toString()) * Double.parseDouble(secondNumber.getText().toString());
            resultCalc.setText(result.toString());
        }else{
            errorText.setText("Поля пустые");
        }

    }

    public void clear(View view) {
        errorText.setText("");
        resultCalc.setText("0");
        firstNumber.setText("");
        secondNumber.setText("");
    }
}