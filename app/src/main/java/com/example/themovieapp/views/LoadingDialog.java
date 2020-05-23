package com.example.themovieapp.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.themovieapp.databinding.DialogLoadingBinding;

public class LoadingDialog extends Dialog {
    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogLoadingBinding binding = DialogLoadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
