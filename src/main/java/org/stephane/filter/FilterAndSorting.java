package org.stephane.filter;

import org.stephane.entity.Seisme;

import java.util.ArrayList;

public interface FilterAndSorting {

    boolean satisfie(Seisme se);
    ArrayList<Seisme> sortingBy(ArrayList<Seisme> datas);
    String getName();
}
