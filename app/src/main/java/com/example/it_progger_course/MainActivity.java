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

import com.example.it_progger_course.CalculatorModel;
import com.example.it_progger_course.CalculatorView;

public class MainActivity extends AppCompatActivity {
    private CalculatorModel model;
    private CalculatorView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new CalculatorModel();
        view = new CalculatorView(this, model);

    }
}