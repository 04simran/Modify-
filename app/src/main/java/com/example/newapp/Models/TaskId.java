package com.example.newapp.Models;

import androidx.annotation.NonNull;

import com.google.firebase.database.Exclude;

import org.checkerframework.checker.index.qual.PolyUpperBound;

public class TaskId {
    @Exclude
    public String TaskId;
    public <T extends TaskId> T withId(@NonNull final  String id){
        this.TaskId = id;
        return (T) this;
    }
}
