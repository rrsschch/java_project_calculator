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

class Numbers {
    double num1;
    double num2;
    double result;

    double const_num2;
};

class Operation{

    // ( знак операции: {физ.статус, графический статус}
    Map<String, boolean[]> operation = new HashMap<String, boolean[]>(){{
        put("+",  new boolean[]{false, false});
        put("-",  new boolean[]{false,false});
        put("*",  new boolean[]{false,false});
        put("/",  new boolean[]{false,false});
    }};



    public boolean any() {

        for (boolean[] value : this.operation.values()) {
            if (value[0]) {
                return true;
            }
        }
        return false;
    };

    public boolean any_second() {

        for (boolean[] value : this.operation.values()) {
            if (value[1]) {
                return true;
            }
        }
        return false;
    };
    public void put(String op, boolean[] status_condition){
        this.operation.put(op, status_condition);
    }

    public boolean[] get(String op){
        return this.operation.get(op);
    }

    void all_turn_off(){
        this.operation.put("+",  new boolean[]{false, false});
        this.operation.put("-",  new boolean[]{false, false});
        this.operation.put("*",  new boolean[]{false, false});
        this.operation.put("/",  new boolean[]{false, false});;
    }

    double processOperation(double num1, double num2) {
    double result = 0.0;
    for (Map.Entry<String, boolean[]> entry : this.operation.entrySet()) {
        if (entry.getValue()[0]) {
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
                case "/":
                    result = num1 / num2;
                    break;
            }
        }
    }
    return result;
}
    public static void turn_off_btn(Context context, Operation op, Button btn, String sign){
        op.put(sign, new boolean[]{true, false});
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffa500")));
        btn.setTextColor(context.getResources().getColor(R.color.white));
    }

    public static void all_turn_off_btn(Context context, Operation op, Button[] buttons){
        for (Button btn : buttons) {
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffa500")));
            btn.setTextColor(context.getResources().getColor(R.color.white));
        }
         op.all_turn_off();
    }

    public static void turn_on_btn(Context context, Operation op, Button btn_op, String sign){
        op.put(sign, new boolean[]{true, true});
        btn_op.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        btn_op.setTextColor(context.getResources().getColor(R.color.orange));
    }


    public String findOperation() {
        for (Map.Entry<String, boolean[]> entry : this.operation.entrySet()) {
            String key = entry.getKey();
            boolean[] values = entry.getValue();
            if (values[0]) {
                return key;
            }
        }
        return null;
    }



}



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //данные для работы
        final Numbers numbers = new Numbers();
        Operation operation = new Operation();

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
        Button btn_multy = findViewById(R.id.button_multyply);
        Button btn_div = findViewById(R.id.button_divided);
        Button btn_percent = findViewById(R.id.button_percent);

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
                    if (operation.any()){
                        double prove = Double.parseDouble(view.getText().toString());

                        if (prove == numbers.num1){
                            view.setText("0");
                            String op = operation.findOperation();
                            Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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
                if (operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (view.getText().toString() == "1") {
                        String text = view.getText().toString();
                        view.setText(text + "1");

                    }

                    else {
                        view.setText("1");
                        String op = operation.findOperation();
                        Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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

                if (operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("2");
                        String op = operation.findOperation();
                        Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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
                if (operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("3");
                        String op = operation.findOperation();
                        Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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
                if (operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("4");
                        String op = operation.findOperation();
                        Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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
                if (operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("5");
                        String op = operation.findOperation();
                        Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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
                if (operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("6");
                        String op = operation.findOperation();
                        Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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
                if (operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("7");
                        String op = operation.findOperation();
                        Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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
                if (operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("8");
                        String op = operation.findOperation();
                        Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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
                if (operation.any()){
                    double prove = Double.parseDouble(view.getText().toString());

                    if (prove == numbers.num1){
                        view.setText("9");
                        String op = operation.findOperation();
                        Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);
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
                numbers.num1 = 0;
                numbers.num2 = 0;
                numbers.result = 0;
                numbers.const_num2 = 0;

                Operation.all_turn_off_btn(getApplicationContext(), operation,
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
                if (operation.get("+")[0] && !operation.get("+")[1]){
                    numbers.num2 = Double.parseDouble(view.getText().toString());

                    Operation.turn_on_btn(getApplicationContext(), operation, btn_plus, "+");
                }
                // если выключен -> включаем
                else {
                    Operation.all_turn_off_btn(getApplicationContext(), operation,
                            new Button[]{btn_plus, btn_minus, btn_multy, btn_div});

                    numbers.num1 = Double.parseDouble(view.getText().toString());
                    Operation.turn_on_btn(getApplicationContext(), operation, btn_plus, "+");
                }
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //включенное состоняние
                if (operation.get("-")[0] && !operation.get("-")[1]){
                    numbers.num2 = Double.parseDouble(view.getText().toString());
                    Operation.turn_on_btn(getApplicationContext(), operation, btn_minus, "-");

                    numbers.result = operation.processOperation(numbers.num1, numbers.num2);
                    view.setText(Double.toString(numbers.result));

                }
                // если выключен -> включаем
                else {
                    Operation.all_turn_off_btn(getApplicationContext(), operation,
                            new Button[]{btn_plus, btn_minus, btn_multy, btn_div});

                    numbers.num1 = Double.parseDouble(view.getText().toString());
                    Operation.turn_on_btn(getApplicationContext(), operation, btn_minus, "-");
                }
            }
        });

        btn_multy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //включенное состоняние
                if (operation.get("*")[0] && !operation.get("*")[1]){
                    numbers.num1 = Double.parseDouble(view.getText().toString());
                    Operation.turn_on_btn(getApplicationContext(), operation, btn_multy, "*");
                }
                // если выключен -> включаем
                else {
                    Operation.all_turn_off_btn(getApplicationContext(), operation,
                            new Button[]{btn_plus, btn_minus, btn_multy, btn_div});

                    numbers.num1 = Double.parseDouble(view.getText().toString());
                    Operation.turn_on_btn(getApplicationContext(), operation, btn_multy, "*");
                }
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //включенное состоняние
                if (operation.get("/")[0] && !operation.get("/")[1]){
                    numbers.num1 = Double.parseDouble(view.getText().toString());
                    Operation.turn_on_btn(getApplicationContext(), operation, btn_div, "/");
                }
                // если выключен -> включаем
                else {
                    Operation.all_turn_off_btn(getApplicationContext(), operation,
                            new Button[]{btn_plus, btn_minus, btn_multy, btn_div});

                    numbers.num1 = Double.parseDouble(view.getText().toString());
                    Operation.turn_on_btn(getApplicationContext(), operation, btn_div, "/");
                }
            }
        });


        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.num1 = Double.parseDouble(view.getText().toString());
                numbers.result = numbers.num1 / 100;
                view.setText(Double.toString(numbers.result));
            }
        });


        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // считываем второй аргумент
                double num = Double.parseDouble(view.getText().toString());


                numbers.num2 = num;
                numbers.const_num2 = num;
                numbers.result = operation.processOperation(numbers.num1, numbers.num2);

                String op = operation.findOperation();
                Operation.turn_off_btn(getApplicationContext(), operation, buttonMap.get(op), op);


                // вывод результата
                int intResult = (int)numbers.result;
                if (intResult == numbers.result)
                {
                    view.setText(Integer.toString(intResult));
                }
                else {
                    view.setText(Double.toString(numbers.result));
                }
            }
        });
    }


}