package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnClr = findViewById(R.id.btnClr);
        btnEql = findViewById(R.id.btnEql);
        btnDec = findViewById(R.id.btnDec);
        display = findViewById(R.id.display);

        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9, btnAdd, btnSub, btnDiv, btnMul, btnClr, btnEql, btnDec;

    TextView display;



}