package com.example.themovieapp.models.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<V extends ViewDataBinding> extends AppCompatActivity {
    private V viewDataBinding;

    protected abstract void init();

    protected abstract int setContentVewId();

    protected V getBinding() {
        return viewDataBinding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.inflate(getLayoutInflater(), setContentVewId(), null, false);
        setContentView(viewDataBinding.getRoot());

        init();
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

