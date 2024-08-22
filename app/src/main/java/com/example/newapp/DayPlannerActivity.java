package com.example.newapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.newapp.Adaptor.DayPlannerAdaptor;
import com.example.newapp.Models.DayPlannerModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DayPlannerActivity extends AppCompatActivity implements onDialogCloseListner {
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private FirebaseFirestore firestore;
    private DayPlannerAdaptor adaptor;
    private List<DayPlannerModel> mList;
    private Query query;
    private ListenerRegistration listenerRegistration;
     Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_planner);
         recyclerView = findViewById(R.id.recyclerview2);
         fab = findViewById(R.id.floatingActionButton);
         toolbar = findViewById(R.id.toolbar);


         setSupportActionBar(toolbar);
         firestore = FirebaseFirestore.getInstance();
         recyclerView.setLayoutManager(new LinearLayoutManager(DayPlannerActivity.this));
         fab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 AddNewTask.newInstance().show(getSupportFragmentManager(),AddNewTask.TAG);
             }
         });
         mList = new ArrayList<>();
         adaptor = new DayPlannerAdaptor(DayPlannerActivity.this,mList);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TouchHelper(adaptor));
        itemTouchHelper.attachToRecyclerView(recyclerView);
         recyclerView.setAdapter(adaptor);
         ShowData();
    }
    private  void ShowData(){
      query =  firestore.collection("task").orderBy("time", Query.Direction.DESCENDING);
       listenerRegistration = query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for(DocumentChange documentChange : value.getDocumentChanges()){
                    if(documentChange.getType()==DocumentChange.Type.ADDED){
                        String id = documentChange.getDocument().getId();
                        DayPlannerModel dayPlannerModel = documentChange.getDocument().toObject(DayPlannerModel.class)
                                .withId(id);
                        mList.add(dayPlannerModel);
                        adaptor.notifyDataSetChanged();
                    }
                }

                listenerRegistration.remove();
            }
        });
    }

    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        mList.clear();
        ShowData();
        adaptor.notifyDataSetChanged();
    }
}