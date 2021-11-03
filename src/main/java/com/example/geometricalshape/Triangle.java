package com.example.geometricalshape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.geometricalshape.databinding.ActivityTriangleBinding;

public class Triangle extends AppCompatActivity {
    double result,x,y,z;
    ActivityTriangleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_triangle);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_triangle);
        binding.setLifecycleOwner(this);

        binding.newOperationBtn.setEnabled(false);
        binding.resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentx =binding.xField.getText().toString().trim();
                String currenty =binding.yField.getText().toString().trim();
                String currentz =binding.zField.getText().toString().trim();
                if (currentx.length()==0 || currenty.length()==0 && currentz.length()==0){
                    Toast.makeText(Triangle.this, "Fieldes is Empty", Toast.LENGTH_SHORT).show();
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
                            z =Double.parseDouble(currentz);
                            result=x+y+z;
                            binding.resultTxt.setText(result+"");
                            binding.areaRb.setEnabled(false);
                            binding.newOperationBtn.setEnabled(true);
                        }
                        else {
                            Toast.makeText(Triangle.this, "Choose", Toast.LENGTH_SHORT).show();
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
                binding.zField.setText("");
                binding.areaRb.setEnabled(true);
                binding.perimeterRb.setEnabled(true);
                binding.zField.setEnabled(true);
                binding.newOperationBtn.setEnabled(false);
            }
        });


    }
}