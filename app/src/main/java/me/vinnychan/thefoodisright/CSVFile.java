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

    public List<Legume> read(){
        List<Legume> resultList = new ArrayList<Legume>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {

            Legume legume;

            String csvLine;
            while ((csvLine = reader.readLine()) != null) {


                String[] row = csvLine.split(",");
                double calorie = Double.parseDouble(row[1]);

                legume = new Legume(row[0], calorie);

                resultList.add(legume);
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
