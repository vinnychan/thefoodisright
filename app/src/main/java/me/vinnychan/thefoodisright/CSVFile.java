package me.vinnychan.thefoodisright;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
    InputStream inputStream;

    public CSVFile(InputStream inputStream){

        this.inputStream = inputStream;
    }

    public List<Food> read(){
        List<Food> resultList = new ArrayList<Food>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {

            Food food;

            String csvLine;
            while ((csvLine = reader.readLine()) != null) {


                String[] row = csvLine.split(",");
                double calorie = Double.parseDouble(row[1]);

                food = new Food(row[0], calorie);

                resultList.add(food);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }
}
