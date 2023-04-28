package com.bunty.photoeditor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.bunty.photoeditor.databinding.ActivityMainBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public static Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(MainActivity.this)
                        .crop()
                        .start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            imageUri=data.getData();
            if(!imageUri.equals("")){
                startActivity(new Intent(MainActivity.this,FinalActivity.class));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}