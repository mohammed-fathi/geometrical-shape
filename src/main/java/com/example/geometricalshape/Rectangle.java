package com.example.geometricalshape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.geometricalshape.databinding.ActivityRectangleBinding;

public class Rectangle extends AppCompatActivity {
    double result,x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        ActivityRectangleBinding binding = DataBindingUtil.setContentView(this ,R.layout.activity_rectangle);
        binding.setLifecycleOwner(this);

        binding.newOperationBtn.setEnabled(false);

        binding.resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentx =binding.xField.getText().toString().trim();
                String currenty =binding.yField.getText().toString().trim();
                if (currentx.length()==0 || currenty.length()==0){
                    Toast.makeText(Rectangle.this, "Fieldes is Empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (binding.areaRb.isChecked()){
                        x =Double.parseDouble(currentx);
                        y =Double.parseDouble(currenty);
                        result=x*y;
                        binding.resultTxt.setText(result+"");
                        binding.perimeterRb.setEnabled(false);
                        binding.newOperationBtn.setEnabled(true);
                    }
                    else {
                        if (binding.perimeterRb.isChecked()){
                            x =Double.parseDouble(currentx);
                            y =Double.parseDouble(currenty);
                            result=(x+y)*2;
                            binding.resultTxt.setText(result+"");
                            binding.areaRb.setEnabled(false);
                            binding.newOperationBtn.setEnabled(true);
                        }
                        else {
                            Toast.makeText(Rectangle.this, "Choose", Toast.LENGTH_SHORT).show();
                        }
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
                binding.yField.setText("");
                binding.areaRb.setEnabled(true);
                binding.perimeterRb.setEnabled(true);
                binding.newOperationBtn.setEnabled(false);
            }
        });
    }
}
