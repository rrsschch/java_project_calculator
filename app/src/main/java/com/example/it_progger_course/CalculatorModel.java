package com.example.it_progger_course;
import android.app.Activity;
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

public class CalculatorModel {

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
            for (Map.Entry<String, boolean[]> entry : this.operation.entrySet())
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
            return result;
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

    Numbers numbers;
    Operation operation;

    public CalculatorModel() {
        this.numbers = new Numbers();
        this.operation = new Operation();
    }

}



