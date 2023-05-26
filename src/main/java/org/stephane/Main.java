package org.stephane;

import org.stephane.entity.Seisme;
import org.stephane.filter.FilterAndSorting;
import org.stephane.filter.FilterAndSortingByDepth;
import org.stephane.utility.ConvertData;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {

    public static ArrayList<Seisme> filter(ArrayList<Seisme> data, FilterAndSorting filter){

        ArrayList<Seisme> result = new ArrayList<Seisme>();
        for(Seisme se : data){
            if(filter.satisfie(se)) result.add(se);
        }
        return result;
    }
    public static void main(String[] args) {

        //Get file path
        ConvertData parser = new ConvertData();
        Path resourceDirectory = Paths.get("src", "main", "resources", "data");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String source = absolutePath + "/nov20quakedatasmall.atom";

        //Read data
        ArrayList<Seisme> data = parser.read(source);
        System.out.println("#data size before processing : " + data.size());

        double maxDepth = -5000;
        double minDepth = -10000;

        FilterAndSorting filterByDepth = new FilterAndSortingByDepth(minDepth, maxDepth, "filtre par profondeur");
        ArrayList<Seisme> resultOfFilter = filter(data, filterByDepth);

        FilterAndSortingByDepth sortingByDepth = new FilterAndSortingByDepth("Sorting by depth");

        for(Seisme se : sortingByDepth.sortingBy(resultOfFilter)){
            System.out.println(se);
        }
        System.out.println("\n ################################################ #\n data size after processing : " + resultOfFilter.size());
    }
}