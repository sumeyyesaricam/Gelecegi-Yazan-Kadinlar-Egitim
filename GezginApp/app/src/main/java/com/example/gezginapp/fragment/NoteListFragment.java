package com.example.gezginapp.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gezginapp.R;
import com.example.gezginapp.adapter.NoteAdapter;
import com.example.gezginapp.adapter.PlaceAdapter;
import com.example.gezginapp.model.Note;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    ArrayList<Note> notes;
RecyclerView recycler_note;
    public NoteListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("notlar");
        getData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_note_list, container, false);
        recycler_note=view.findViewById(R.id.recycler_note);

        return view;
    }

    public void getData() {
        notes = new ArrayList<>();
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot _snapshot : snapshot.getChildren()) {
                        String uid = _snapshot.getKey();
                        String title = _snapshot.getValue().toString();
                        Note note=new Note();
                        note.setNoteId(uid);
                        note.setTitle(title);
                        notes.add(note);
                    }
                }
                NoteAdapter adapter=new NoteAdapter(notes,getContext());
                recycler_note.setAdapter(adapter);
                LinearLayoutManager linearLayoutManager =
                        new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation
                        (LinearLayoutManager.VERTICAL);
                recycler_note.setLayoutManager
                        (linearLayoutManager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
