package com.jamc.note_keeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.Toolbar;

import java.util.List;


public class NoteListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note_list);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        final ListView listNotes = findViewById(R.id.list_node);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();

        ArrayAdapter<NoteInfo> adapterNotes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);

        listNotes.setAdapter(adapterNotes);

        listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);

                NoteInfo note = (NoteInfo) listNotes.getItemAtPosition(position);

                intent.putExtra(NoteActivity.NOTE_INFO, note);

                startActivity(intent);
            }
        });
    }

}