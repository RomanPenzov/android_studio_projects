package com.penzov.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()); // здесь получаем ссылку на MainActivity

        //ниже видим код без точки с запятой (;) - это одна длинная строка-цепочка
        builder.setMessage("Make a selection")

                // кнопка OKкоторая ничего не делает
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // здесь ничего не происходит
                    }
                })
                // кнопка "Cancel", которая ничего не делает
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // здесь тоже ничего не происходит
                    }
                });
        //создаем объект и возвращаем его
        return builder.create();
    }
}
