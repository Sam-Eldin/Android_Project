package com.example.android_project.arrays;

import com.example.android_project.entities.Group;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListGroup extends ArrayList<Group>
{
    private Date loaded;

    public Date getLoaded() {
        return loaded;
    }

    public void setLoaded(Date loaded) {
        this.loaded = loaded;
    }
}
