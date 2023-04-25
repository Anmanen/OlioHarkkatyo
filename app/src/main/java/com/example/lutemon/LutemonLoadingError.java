package com.example.lutemon;

import android.widget.Toast;

import androidx.annotation.Nullable;

public class LutemonLoadingError extends Throwable {

    private String message;
    public LutemonLoadingError(Exception e){
        this.message = e.getMessage();
    }

    @Nullable
    @Override
    public String getMessage() {
        return message;
    }
}
