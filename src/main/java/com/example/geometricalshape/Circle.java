package com.example.geometricalshape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.geometricalshape.databinding.ActivityCircleBinding;

public class Circle extends AppCompatActivity {
    double result,x,pi=3.114;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        ActivityCircleBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_circle);
        binding.setLifecycleOwner(this);

        binding.areaRb.setEnabled(false);
        binding.perimeterRb.setEnabled(false);
        binding.newOperationBtn.setEnabled(false);

        binding.resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentx =binding.xField.getText().toString().trim();
                if (currentx.length()==0){
                    Toast.makeText(Circle.this, "Please Enter X", Toast.LENGTH_SHORT).show();
                }else {
                    if(binding.areaRb.isChecked()){
                        x =Double.parseDouble(currentx);
                        result=2*pi*x;
                        binding.resultTxt.setText(result+"");
                    }else if (binding.perimeterRb.isChecked()){
                        x = Double.parseDouble(currentx);
                        result=(x*x)*pi;
                        binding.resultTxt.setText(result+"");
                    }
                    else {
                        Toast.makeText(Circle.this, "Choose between Area and perimeter", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.newOperationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;
                binding.resultTxt.setText("");
                binding.xField.setText("");
                binding.areaRb.setEnabled(false);
                binding.perimeterRb.setEnabled(false);
                binding.newOperationBtn.setEnabled(false);
            }
        });
        binding.xField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.areaRb.setEnabled(true);
                binding.perimeterRb.setEnabled(true);
                binding.newOperationBtn.setEnabled(true);
            }
        });
    }
}