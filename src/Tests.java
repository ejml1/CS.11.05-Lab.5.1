import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.*;
import java.util.Arrays;

public class Tests {

    String[] countries;
    int[] totalWasteKgPerCapitaPerYear;
    int[] householdEstimatesKgPerCapitaPerYear;
    int[] retailEstimatesKgPerCapitaPerYear;
    int[] foodServiceEstimatesKgPerCapitaPerYear;
    String[] confidences;
    String[] regions;
    String[] years;
    double[] percentagesShareInPoverty;

    String[] countriesSmall;
    int[] totalWasteKgPerCapitaPerYearSmall;
    int[] householdEstimatesKgPerCapitaPerYearSmall;

    @Before
    public void setUp()
    {
        CSVReader.populateArrays();

        countries = CSVReader.countries.toArray(new String[CSVReader.countries.size()]);
        totalWasteKgPerCapitaPerYear = CSVReader.totalWasteKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        householdEstimatesKgPerCapitaPerYear = CSVReader.householdEstimatesKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        retailEstimatesKgPerCapitaPerYear = CSVReader.retailEstimateKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        foodServiceEstimatesKgPerCapitaPerYear = CSVReader.foodServiceEstimateKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        confidences = CSVReader.confidence.toArray(new String[CSVReader.confidence.size()]);
        regions = CSVReader.region.toArray(new String[CSVReader.region.size()]);
        years = CSVReader.year.toArray(new String[CSVReader.year.size()]);
        percentagesShareInPoverty = CSVReader.percentageShareInPoverty.stream().mapToDouble(i -> i).toArray();

        CSVReader.populateArrays(4);

        countriesSmall = CSVReader.countries.toArray(new String[CSVReader.countries.size()]);
        totalWasteKgPerCapitaPerYearSmall = CSVReader.totalWasteKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        householdEstimatesKgPerCapitaPerYearSmall = CSVReader.householdEstimatesKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();

    }

    /**************************************************************************************************************
     * Testing for the averages
     **************************************************************************************************************/

    @Test
    public void meanTotalWasteKgPerCapitaPerYear()
    {
        assertEquals(129, Main.meanTotalWasteKgPerCapitaPerYear(totalWasteKgPerCapitaPerYear));
    }

    /**************************************************************************************************************
     * Testing for the medians
     **************************************************************************************************************/

    @Test
    public void medianHouseholdEstimatesKgPerCapitaPerYearOddListSize()
    {
        assertEquals(84, Main.medianHouseholdEstimateKgPerCapitaPerYear(householdEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void medianHouseholdEstimatesKgPerCapitaPerYearEvenListSize()
    {
        assertEquals(92, Main.medianHouseholdEstimateKgPerCapitaPerYear(householdEstimatesKgPerCapitaPerYearSmall));
    }

    /**************************************************************************************************************
     * Testing for the minimums
     **************************************************************************************************************/

    @Test
    public void minRetailEstimateKgPerCapitaPerYear()
    {
        assertEquals(4, Main.minRetailEstimateKgPerCapitaPerYear(retailEstimatesKgPerCapitaPerYear));
    }

    /**************************************************************************************************************
     * Testing for the maximums
     **************************************************************************************************************/

    @Test
    public void maxFoodServiceEstimateKgPerCapitaPerYear()
    {
        assertEquals(90, Main.maxFoodServiceEstimateKgPerCapitaPerYear(foodServiceEstimatesKgPerCapitaPerYear));
    }

    /**************************************************************************************************************
     * Misc Tests
     **************************************************************************************************************/

    @Test
    public void getCountryTotalWastePerYear()
    {
        assertEquals(127, Main.getCountryTotalWastePerYear("Albania", countries, totalWasteKgPerCapitaPerYear));
        assertEquals(97, Main.getCountryTotalWastePerYear("Belize", countries, totalWasteKgPerCapitaPerYear));
        assertEquals(139, Main.getCountryTotalWastePerYear("United States of America", countries, totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void getCountryWithMostWastePerCapitaSmall()
    {
        assertEquals("Angola", Main.getCountryWithMostWastePerCapita(countriesSmall, totalWasteKgPerCapitaPerYearSmall));
    }


    @Test
    public void getCountryWithMostWastePerCapita()
    {
        assertEquals("Malaysia", Main.getCountryWithMostWastePerCapita(countries, totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void getCountriesWithHighestPovertyPercentageSmall()
    {
        String[] countries = Main.getCountriesWithHighestPovertyPercentage(this.countriesSmall, percentagesShareInPoverty);
        assertTrue(Arrays.asList(countries).contains("Algeria"));
        assertEquals(1, countries.length);
    }

    @Test
    public void getCountriesWithHighestPovertyPercentage()
    {
        
        String[] countries = Main.getCountriesWithHighestPovertyPercentage(this.countries, percentagesShareInPoverty);
        assertTrue(Arrays.asList(countries).contains("Guinea-Bissau"));
        assertTrue(Arrays.asList(countries).contains("Madagascar"));
        assertTrue(Arrays.asList(countries).contains("Mali"));
        assertTrue(Arrays.asList(countries).contains("Somalia"));
        assertEquals(4, countries.length);
    }


    @Test
    public void getCountriesWithHighConfidenceSmall()
    {
        String [] countries = Main.getCountriesWithHighConfidence(this.countriesSmall, confidences);
        assertNull(countries);
    }

    @Test
    public void getCountriesWithHighConfidence()
    {
        String[] countries = Main.getCountriesWithHighConfidence(this.countries, confidences);
        assertTrue(Arrays.asList(countries).contains("Australia"));
        assertTrue(Arrays.asList(countries).contains("Austria"));
        assertTrue(Arrays.asList(countries).contains("Denmark"));
        assertTrue(Arrays.asList(countries).contains("Germany"));
        assertTrue(Arrays.asList(countries).contains("Italy"));
        assertTrue(Arrays.asList(countries).contains("Sweden"));
        assertTrue(Arrays.asList(countries).contains("United Kingdom"));
        assertTrue(Arrays.asList(countries).contains("United States of America"));

        assertEquals(8, countries.length);
    }
    
}
