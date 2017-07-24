package com.example.bibesh.retrofitpractise;

import java.util.List;

/**
 * Created by Bibesh on 6/4/17.
 */

public class Model {
    private int supervisorId;
    private List<Vdc> vdc;

    public List<Vdc> getVdc() {
        return vdc;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

}
