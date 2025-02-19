
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVReader {

    //1
    static ArrayList<String> countries;
    static ArrayList<Integer> totalWasteKgPerCapitaPerYear;
    static ArrayList<Integer> householdEstimatesKgPerCapitaPerYear;
    //5
    static ArrayList<Integer> retailEstimateKgPerCapitaPerYear;
    //7
    static ArrayList<Integer> foodServiceEstimateKgPerCapitaPerYear;
    //9
    static ArrayList<String> confidence;

    //11
    static ArrayList<String> region;
    
    //14
    static ArrayList<String> year;
    static ArrayList<Double> percentageShareInPoverty;


    /** 
     * Method used to populate the arrays for all countries
     */
    public static void populateArrays()
    {
        populateArrays(-1);
    }

    /**
     * 
     * @param size
     */
    public static void populateArrays(int size) {

        countries = new ArrayList<>();
        totalWasteKgPerCapitaPerYear = new ArrayList<>();
        householdEstimatesKgPerCapitaPerYear = new ArrayList<>();

        retailEstimateKgPerCapitaPerYear = new ArrayList<>();

        foodServiceEstimateKgPerCapitaPerYear = new ArrayList<>();

        confidence = new ArrayList<>();
        region = new ArrayList<>();
        year = new ArrayList<>();
        percentageShareInPoverty = new ArrayList<>();

        File file = new File("src/combined_data.csv");

        int numCols = 16;

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
    
            String line;
            int linesRead = 0;

            while((line = br.readLine()) !=null && (linesRead < size || size == -1))
            {
                String[] values = line.split(",");
                for (int i = 0; i < numCols; i++)
                {

                    switch(i)
                    {
                        case 1 -> countries.add(values[i]);
                        case 2 -> {
                            int value = Integer.parseInt(values[i]);
                            totalWasteKgPerCapitaPerYear.add(value);
                            }
                        case 3 -> {
                            int value = Integer.parseInt(values[i]);
                            householdEstimatesKgPerCapitaPerYear.add(value);
                        }
                        case 5 -> {
                            int value = Integer.parseInt(values[i]);
                            retailEstimateKgPerCapitaPerYear.add(value);
                        }
                        case 7 -> {
                            int value = Integer.parseInt(values[i]);
                            foodServiceEstimateKgPerCapitaPerYear.add(value);
                        }
                        case 9 -> confidence.add(values[i]);
    
                        case 11 -> region.add(values[i]);
    
                        case 14 -> year.add(values[i]);
                        case 15 -> {
                            double value = Double.parseDouble(values[i]);
                            percentageShareInPoverty.add(value);
                        }
                        
                        default -> {
                        }
                    }
                }
                linesRead++;
            }
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }

    
}
