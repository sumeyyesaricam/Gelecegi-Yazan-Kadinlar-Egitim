package com.example.gezginapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gezginapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotFragment_ extends Fragment implements View.OnClickListener {


    public NotFragment_() {
        // Required empty public constructor
    }
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;

    FirebaseAuth mFirebaseAuth;
    FirebaseUser mFirebaseUser;

    Button btnAdd, btnListele;
    EditText etNote;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("notlar");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_not_fragment_, container, false);
        btnAdd = view.findViewById(R.id.add_notes_btn);
        btnListele = view.findViewById(R.id.go_to_notes_btn);
        etNote = view.findViewById(R.id.user_notes_et);
        btnListele.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_notes_btn:
                addNote();
                break;
            case R.id.go_to_notes_btn:
                goToNotesFragment();
                break;
        }
    }
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void goToNotesFragment() {
        loadFragment(new NoteListFragment());
    }

    private void addNote() {
          mDatabaseReference.child(UUID.randomUUID().toString()).child(UUID.randomUUID().toString()).setValue(etNote.getText().toString());
    }
}
