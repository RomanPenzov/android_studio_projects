package com.penzov.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class DialogNewNote extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_new_note, null);

        final EditText editTitle = dialogView.findViewById(R.id.editTitle);
        final EditText editDescription = dialogView.findViewById(R.id.editDescription);
        final CheckBox checkBoxIdea = dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo = dialogView.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant = dialogView.findViewById(R.id.checkBoxImportant);
        Button btnCancel = dialogView.findViewById(R.id.btnCancel);
        Button btnOk = dialogView.findViewById(R.id.btnOk);

        builder.setView(dialogView).setMessage("Add a new note");
        //обрабатываем кнопку Cancel
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // создаем новую заметку
                Note newNote = new Note();

                //устанавливаем переменные в соответствии
                //с записями пользователя в форме
                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());
                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.setTodo(checkBoxTodo.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());

                //получаем ссылку на MainActivity
                MainActivity callingActivity = (MainActivity) getActivity();

                //передаем newNote обратно в MainActivity
                callingActivity.createNewNote(newNote);

                //закрываем диалог
                dismiss();
            }
        });

        return builder.create();
    }
}