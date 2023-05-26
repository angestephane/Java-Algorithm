package org.stephane.filter;

import org.stephane.entity.Seisme;
import org.stephane.utility.ConvertData;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Filter {
    private String file;

    public Filter(String file){
        this.file = file;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }

    public ArrayList<Seisme> filter(ArrayList<Seisme> data, FilterAndSorting filter){

        ArrayList<Seisme> result = new ArrayList<>();
        for(Seisme se : data){
            if(filter.satisfie(se)) result.add(se);
        }
        return result;
    }

    public String getPath () {
        Path resourceDirectory = Paths.get("src", "main", "resources", "data");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        return  absolutePath + getFile();
    }

    public ArrayList<Seisme> getData() {
        ConvertData parser = new ConvertData();
        return parser.read(this.getPath());

    }

    public ArrayList<Seisme> FilterByDepth(double minDepth, double maxDepth) {
        FilterAndSorting filterByDepth = new FilterAndSortingByDepth(minDepth, maxDepth, "filtre par profondeur");
        ArrayList<Seisme> resultOfFilter = filter(getData(), filterByDepth);
        FilterAndSortingByDepth sortingByDepth = new FilterAndSortingByDepth("Sorting by depth");
        return sortingByDepth.sortingBy(resultOfFilter);
    }


}
