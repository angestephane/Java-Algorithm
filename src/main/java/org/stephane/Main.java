package org.stephane;

import org.stephane.entity.Seisme;
import org.stephane.utility.ConvertData;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        //Get file path
        ConvertData parser = new ConvertData();
        Path resourceDirectory = Paths.get("src", "main", "resources", "data");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String source = absolutePath + "/nov20quakedatasmall.atom";

        //Read data
        ArrayList<Seisme> data = parser.read(source);
        System.out.println("#data size processing : " + data.size());

    }
}