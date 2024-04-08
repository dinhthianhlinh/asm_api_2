package com.example.asm_api_linh;

import android.content.Context;
import android.widget.Toast;

public class Utility {
    static void showToast(Context context, String messenger){
        Toast.makeText(context, messenger, Toast.LENGTH_SHORT).show();
    }
}
