package com.penzov.notetoself;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ListItemHolder> {
    private List<Note> mNoteList;
    private MainActivity mMainActivity;

    @NonNull
    @Override
    public NoteAdapter.ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ListItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ListItemHolder(View view) {
            super(view);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
