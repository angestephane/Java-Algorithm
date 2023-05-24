package org.stephane.filter;

import org.stephane.entity.Seisme;

import java.util.ArrayList;

public class FilterAndSortingByDepth implements FilterAndSorting {
    double minDepth;
    double maxDepth;
    String nameFilter;

    public FilterAndSortingByDepth(double minDepth, double maxDepth, String name ) {
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
        this.nameFilter = name;
    }

    public FilterAndSortingByDepth(String name){
        this.nameFilter = name;
    }

    @Override
    public boolean satisfie(Seisme se){
        return this.maxDepth >= se.getDepth() && se.getDepth() >= this.minDepth;
    }

    @Override
    public ArrayList<Seisme> sortingBy(ArrayList<Seisme> datas) {
        Seisme tmp;
        for(int i = 0; i< datas.size(); i++){
            for(int k = i+1; k < datas.size(); k++) {
                if(datas.get(i).getDepth() > datas.get(k).getDepth()){
                    tmp = datas.get(i);
                    datas.set(i, datas.get(k));
                    datas.set(k, tmp);
                }
            }
        }
        return datas;
    }

    @Override
    public String getName() {
        return this.nameFilter;
    }

}
