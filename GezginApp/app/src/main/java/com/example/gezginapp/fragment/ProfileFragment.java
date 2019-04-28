package com.example.gezginapp.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gezginapp.R;
import com.example.gezginapp.activity.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment {
    private static final int IMAGE_REQUEST = 111;

    ImageView imageUser;
    ImageButton btn_camera;
    Button btn_Save;
    Uri filePath;
    StorageReference mStorageRef;
    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStorageRef = FirebaseStorage.getInstance().getReference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        imageUser = view.findViewById(R.id.imageUser);
        btn_camera = view.findViewById(R.id.btn_camera);
        btn_Save = view.findViewById(R.id.btn_Save);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPhoto();
            }
        });
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavePhoto();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_REQUEST && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Picasso.with(getActivity())
                        .load(filePath).fit().centerCrop().into(imageUser);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void SavePhoto() {
        if (filePath != null) {
            showProgressDialog();
            mStorageRef.child("userprofilephoto").putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            dismissProgressDialog();
                            Toast.makeText(getActivity(),
                                    "Fotoğraf başarılı bir şekilde kaydedildi.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    dismissProgressDialog();
                    Toast.makeText(getActivity(), "Fotoğraf Kaydedilemedi", Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Yükleniyor...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    private void dismissProgressDialog() {
        progressDialog.dismiss();
    }


    private void selectPhoto() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser
                (intent, "Resim Seçiniz"), IMAGE_REQUEST);
    }
}
