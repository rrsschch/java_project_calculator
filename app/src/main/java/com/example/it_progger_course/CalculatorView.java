package com.example.it_progger_course;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
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
import android.app.Activity;
import com.example.it_progger_course.CalculatorModel;

public class CalculatorView {
    TextView view;
    CalculatorModel model;

    public static void turn_off_btn(Context context, CalculatorModel.Operation op, Button btn, String sign){
        op.put(sign, new boolean[]{true, false});
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffa500")));
        btn.setTextColor(context.getResources().getColor(R.color.white));
    }

    public static void all_turn_off_btn(Context context, CalculatorModel.Operation op, Button[] buttons){
        for (Button btn : buttons) {
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffa500")));
            btn.setTextColor(context.getResources().getColor(R.color.white));
        }
        op.all_turn_off();
    }

    public static void turn_on_btn(Context context, CalculatorModel.Operation op, Button btn_op, String sign){
        op.put(sign, new boolean[]{true, true});
        btn_op.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        btn_op.setTextColor(context.getResources().getColor(R.color.orange));
    }

    public CalculatorView(Activity activity, CalculatorModel model) {
        view = activity.findViewById(R.id.textView);
        Button btn_point = activity.findViewById(R.id.button_point);
        Button btn_0 = activity.findViewById(R.id.button_0);
        Button btn_one = activity.findViewById(R.id.button_one);
        Button btn_two = activity.findViewById(R.id.button_two);
        Button btn_three = activity.findViewById(R.id.button_three);
        Button btn_four = activity.findViewById(R.id.button_four);
        Button btn_five = activity.findViewById(R.id.button_five);
        Button btn_six = activity.findViewById(R.id.button_six);
        Button btn_seven = activity.findViewById(R.id.button_seven);
        Button btn_eight = activity.findViewById(R.id.button_eight);
        Button btn_nine = activity.findViewById(R.id.button_nine);


        Button btn_clean = activity.findViewById(R.id.button_clean);
        Button btn_delete = activity.findViewById(R.id.button_delete);

        Button btn_equal = activity.findViewById(R.id.button_equal);
        Button btn_plus = activity.findViewById(R.id.button_plus);
        Button btn_minus = activity.findViewById(R.id.button_minus);
        Button btn_multy = activity.findViewById(R.id.button_multyply);
        Button btn_div = activity.findViewById(R.id.button_divided);
        Button btn_percent = activity.findViewById(R.id.button_percent);

        Map<String, Button> buttonMap = new HashMap<>();
        buttonMap.put("+",btn_plus );
        buttonMap.put("-", btn_minus);
        buttonMap.put("*", btn_multy);
        buttonMap.put("/", btn_div);
        view.setText("0");

        //кнопки от 0 до 9
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getText().toString() == "0") {
                    return;
                }
                else{
                    if (model.operation.any()){
                        double prove = Double.parseDouble(view.getText().toString());

                        if (prove == model.numbers.num1){
                            view.setText("0");
                            String op = model.operation.findOperation();
                            turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
                        }
                        else {
                            String text = view.getText().toString();
                            view.setText(text + "0");
                        }
                    }

                    //ввод первого аргумента
                    else {
                        if (view.getText().toString() == "0") {
                            view.setText("0");
                        } else {
                            String text = view.getText().toString();
                            view.setText(text + "0");
                        }
                    }
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

                // ввод второго аргумента
                if (model.operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (view.getText().toString() == "1") {
                        String text = view.getText().toString();
                        view.setText(text + "1");

                    }

                    else {
                        view.setText("1");
                        String op = model.operation.findOperation();
                        turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
                    }
                }

                //ввод первого аргумента
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

                if (model.operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == model.numbers.num1){
                        view.setText("2");
                        String op = model.operation.findOperation();
                        turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
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
                if (model.operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == model.numbers.num1){
                        view.setText("3");
                        String op = model.operation.findOperation();
                        turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
                    }
                    else {
                        String text = view.getText().toString();
                        view.setText(text + "3");
                    }
                }
                else {
                    if (view.getText().toString() == "0") {
                        view.setText("3");
                        ;
                    } else {
                        String text = view.getText().toString();
                        view.setText(text + "3");
                    }
                }
            }
        });


        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (model.operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == model.numbers.num1){
                        view.setText("4");
                        String op = model.operation.findOperation();
                        turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
                    }
                    else {
                        String text = view.getText().toString();
                        view.setText(text + "4");
                    }
                }
                else {
                    if (view.getText().toString() == "0") {
                        view.setText("4");
                        ;
                    } else {
                        String text = view.getText().toString();
                        view.setText(text + "4");
                    }
                }
            }
        });

        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == model.numbers.num1){
                        view.setText("5");
                        String op = model.operation.findOperation();
                        turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
                    }
                    else {
                        String text = view.getText().toString();
                        view.setText(text + "5");
                    }
                }
                else {
                    if (view.getText().toString() == "0") {
                        view.setText("5");
                        ;
                    } else {
                        String text = view.getText().toString();
                        view.setText(text + "5");
                    }
                }
            }
        });

        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == model.numbers.num1){
                        view.setText("6");
                        String op = model.operation.findOperation();
                        turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
                    }
                    else {
                        String text = view.getText().toString();
                        view.setText(text + "6");
                    }
                }
                else {
                    if (view.getText().toString() == "0") {
                        view.setText("6");
                        ;
                    } else {
                        String text = view.getText().toString();
                        view.setText(text + "6");
                    }
                }
            }
        });


        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == model.numbers.num1){
                        view.setText("7");
                        String op = model.operation.findOperation();
                        turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
                    }
                    else {
                        String text = view.getText().toString();
                        view.setText(text + "7");
                    }
                }
                else {
                    if (view.getText().toString() == "0") {
                        view.setText("7");
                        ;
                    } else {
                        String text = view.getText().toString();
                        view.setText(text + "7");
                    }
                }
            }
        });

        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == model.numbers.num1){
                        view.setText("8");
                        String op = model.operation.findOperation();
                        turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
                    }
                    else {
                        String text = view.getText().toString();
                        view.setText(text + "8");
                    }
                }
                else {
                    if (view.getText().toString() == "0") {
                        view.setText("8");
                        ;
                    } else {
                        String text = view.getText().toString();
                        view.setText(text + "8");
                    }
                }
            }
        });

        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == model.numbers.num1){
                        view.setText("9");
                        String op = model.operation.findOperation();
                        turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);
                    }
                    else {
                        String text = view.getText().toString();
                        view.setText(text + "9");
                    }
                }
                else {
                    if (view.getText().toString() == "0") {
                        view.setText("9");
                        ;
                    } else {
                        String text = view.getText().toString();
                        view.setText(text + "9");
                    }
                }
            }
        });


        //кнопка очистки и удаления одного знака
        btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText("0");
                model.numbers.num1 = 0;
                model.numbers.num2 = 0;

                model.numbers.result = 0;
                model.numbers.const_num2 = 0;

                all_turn_off_btn(activity.getApplicationContext(), model.operation,
                        new Button[]{btn_plus, btn_minus, btn_multy, btn_div});
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

                //включенное состоняние
                if (model.operation.get("+")[0] && !model.operation.get("+")[1]){
                    model.numbers.num2 = Double.parseDouble(view.getText().toString());

                    turn_on_btn(activity.getApplicationContext(), model.operation, btn_plus, "+");
                }
                // если выключен -> включаем
                else {
                    all_turn_off_btn(activity.getApplicationContext(), model.operation,
                            new Button[]{btn_plus, btn_minus, btn_multy, btn_div});

                    model.numbers.num1 = Double.parseDouble(view.getText().toString());
                    turn_on_btn(activity.getApplicationContext(), model.operation, btn_plus, "+");
                }
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //включенное состоняние
                if (model.operation.get("-")[0] && !model.operation.get("-")[1]){
                    model.numbers.num2 = Double.parseDouble(view.getText().toString());
                    turn_on_btn(activity.getApplicationContext(), model.operation, btn_minus, "-");

                    model.numbers.result = model.operation.processOperation(model.numbers.num1, model.numbers.num2);
                    view.setText(Double.toString(model.numbers.result));

                }
                // если выключен -> включаем
                else {
                    all_turn_off_btn(activity.getApplicationContext(), model.operation,
                            new Button[]{btn_plus, btn_minus, btn_multy, btn_div});

                    model.numbers.num1 = Double.parseDouble(view.getText().toString());
                    turn_on_btn(activity.getApplicationContext(), model.operation, btn_minus, "-");
                }
            }
        });

        btn_multy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //включенное состоняние
                if (model.operation.get("*")[0] && !model.operation.get("*")[1]){
                    model.numbers.num1 = Double.parseDouble(view.getText().toString());
                    turn_on_btn(activity.getApplicationContext(), model.operation, btn_multy, "*");
                }
                // если выключен -> включаем
                else {
                    all_turn_off_btn(activity.getApplicationContext(), model.operation,
                            new Button[]{btn_plus, btn_minus, btn_multy, btn_div});

                    model.numbers.num1 = Double.parseDouble(view.getText().toString());
                    turn_on_btn(activity.getApplicationContext(), model.operation, btn_multy, "*");
                }
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //включенное состоняние
                if (model.operation.get("/")[0] && !model.operation.get("/")[1]){
                    model.numbers.num1 = Double.parseDouble(view.getText().toString());
                    turn_on_btn(activity.getApplicationContext(), model.operation, btn_div, "/");
                }
                // если выключен -> включаем
                else {
                    all_turn_off_btn(activity.getApplicationContext(), model.operation,
                            new Button[]{btn_plus, btn_minus, btn_multy, btn_div});

                    model.numbers.num1 = Double.parseDouble(view.getText().toString());
                    turn_on_btn(activity.getApplicationContext(), model.operation, btn_div, "/");
                }
            }
        });


        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.numbers.num1 = Double.parseDouble(view.getText().toString());
                model.numbers.result = model.numbers.num1 / 100;
                view.setText(Double.toString(model.numbers.result));
            }
        });


        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // считываем второй аргумент
                double num = Double.parseDouble(view.getText().toString());


                model.numbers.num2 = num;
                model.numbers.const_num2 = num;
                model.numbers.result = model.operation.processOperation(model.numbers.num1, model.numbers.num2);

                String op = model.operation.findOperation();
                turn_off_btn(activity.getApplicationContext(), model.operation, buttonMap.get(op), op);


                // вывод результата
                int intResult = (int)model.numbers.result;
                if (intResult == model.numbers.result)
                {
                    view.setText(Integer.toString(intResult));
                }
                else {
                    view.setText(Double.toString(model.numbers.result));
                }
            }
        });
    }



}




