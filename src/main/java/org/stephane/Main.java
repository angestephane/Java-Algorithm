package org.stephane;

import org.stephane.entity.Seisme;
import org.stephane.filter.Filter;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Filter filter = new Filter("nov20quakedatasmall.atom");
        ArrayList<Seisme> dataFiltering = filter.filterByDepth(-10000.00, -5000.00);

        filter.readData(dataFiltering);
    }
}