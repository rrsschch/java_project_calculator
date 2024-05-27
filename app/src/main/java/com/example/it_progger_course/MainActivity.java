package com.example.it_progger_course;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import android.content.res.ColorStateList;
import android.graphics.Color;

class Numbers {
    double num1;
    double num2;

    double result;
};




public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //данные для работы
        final Numbers numbers = new Numbers();


        Map<String, Boolean> operation = new HashMap<String, Boolean>(){{
            put("+", false);
            put("-", false);
            put("*", false);
            put("/", false);
        }};

        TextView view = findViewById(R.id.textView);
        Button btn_point = findViewById(R.id.button_point);

        Button btn_0 = findViewById(R.id.button_0);
        Button btn_one = findViewById(R.id.button_one);
        Button btn_two = findViewById(R.id.button_two);
        Button btn_three = findViewById(R.id.button_three);
        Button btn_four = findViewById(R.id.button_four);
        Button btn_five = findViewById(R.id.button_five);
        Button btn_six = findViewById(R.id.button_six);
        Button btn_seven = findViewById(R.id.button_seven);
        Button btn_eight = findViewById(R.id.button_eight);
        Button btn_nine = findViewById(R.id.button_nine);


        Button btn_clean = findViewById(R.id.button_clean);
        Button btn_delete = findViewById(R.id.button_delete);

        Button btn_equal = findViewById(R.id.button_equal);
        Button btn_plus = findViewById(R.id.button_plus);
        Button btn_minus = findViewById(R.id.button_minus);

        view.setText("0");

        //кнопки от 0 до 9
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getText().toString() == "0") {
                    return;
                }
                else{
                    String text = view.getText().toString();
                    view.setText(text + "0");
                }

            }
        });


        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = view.getText().toString();
                if (!currentText.contains(".")) {
                    view.setText(currentText + ".");
                }
            }
        });


        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation.get("+")){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("1");
                        btn_plus.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffa500")));
                        btn_plus.setTextColor(getResources().getColor(R.color.white));
                    }
                    else {
                        String text = view.getText().toString();
                        view.setText(text + "1");
                    }
                }

                else {
                    if (view.getText().toString() == "0") {
                        view.setText("1");
                    } else {
                        String text = view.getText().toString();
                        view.setText(text + "1");
                    }
                }
            }
        });

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operation.get("+")){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("2");
                        btn_plus.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffa500")));
                        btn_plus.setTextColor(getResources().getColor(R.color.white));
                    }
                    else {
                        String text = view.getText().toString();
                        view.setText(text + "2");
                    }
                }
                else {
                    if (view.getText().toString() == "0") {
                        view.setText("2");
                        ;
                    } else {
                        String text = view.getText().toString();
                        view.setText(text + "2");
                    }
                }
            }
        });

        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getText().toString() == "0") {
                    view.setText("3");;
                }
                else{
                    String text = view.getText().toString();
                    view.setText(text + "3");
                }
            }
        });


        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getText().toString() == "0") {
                    view.setText("4");;
                }
                else{
                    String text = view.getText().toString();
                    view.setText(text + "4");
                }
            }
        });

        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getText().toString() == "0") {
                    view.setText("5");;
                }
                else{
                    String text = view.getText().toString();
                    view.setText(text + "5");
                }
            }
        });

        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getText().toString() == "0") {
                    view.setText("6");;
                }
                else{
                    String text = view.getText().toString();
                    view.setText(text + "6");
                }
            }
        });


        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getText().toString() == "0") {
                    view.setText("7");;
                }
                else{
                    String text = view.getText().toString();
                    view.setText(text + "7");
                }
            }
        });

        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getText().toString() == "0") {
                    view.setText("8");;
                }
                else{
                    String text = view.getText().toString();
                    view.setText(text + "8");
                }
            }
        });

        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getText().toString() == "0") {
                    view.setText("9");;
                }
                else{
                    String text = view.getText().toString();
                    view.setText(text + "9");
                }
            }
        });


        //кнопка очистки и удаления одного знака
        btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText("0");
                numbers.num1 = 0;
                numbers.num2 = 0;
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = view.getText().toString();

                if (currentText != "0" && currentText.length() > 0) {
                    view.setText(currentText.substring(0, currentText.length() - 1));

                    if (view.getText().toString().isEmpty()) {
                        view.setText("0");
                    }
                }
            }
        });


        // кнопки арифметических операций
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.num1 = Double.parseDouble(view.getText().toString());

                if (operation.get("+")){
                    if (numbers.num1 == numbers.result){
                        operation.put("+", true);
                        btn_plus.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                        btn_plus.setTextColor(getResources().getColor(R.color.orange));
                        numbers.num1 = 0;
                        return;
                    }
                    numbers.num2 = Double.parseDouble(view.getText().toString());
                    numbers.result = numbers.num1 + numbers.num2;

                    String result = Double.toString(numbers.num1);
                    numbers.num2 = 0;
                    view.setText(result);

                }
                else {
                    operation.put("+", true);
                    btn_plus.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    btn_plus.setTextColor(getResources().getColor(R.color.orange));
                }
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.num2 = Double.parseDouble(view.getText().toString());
                numbers.result = processOperations(operation, numbers.num1, numbers.num2);
                view.setText(Double.toString(numbers.result));
            }
        });
    }

    double processOperations(Map<String, Boolean> operations, double num1, double num2) {
        double result = 0.0;
        for (Map.Entry<String, Boolean> entry : operations.entrySet()) {
            if (entry.getValue()) {
                switch (entry.getKey()) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                }
            }
        }
        return result;
    }
}