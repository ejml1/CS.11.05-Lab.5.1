# CS.11.05-Lab.5.1

In this lab, a dataset that contains information about many countries food waste and poverty information is being read into various arrays as listed below:
<pre>
countries - An array containing the list of countries

totalWasteKgPerCapitaPerYear - An array containing the total amount of food wasted in kg by a country per capita per year

householdEstimatesKgPerCapitaPerYear - An array containing the total household food waste in kg by a country per capita per year

householdEstimatesTonnesPerYear - An array containing the total household food waste in tonnes by a country per year

retailEstimatesKgPerCapitaPerYear - An array containing the total retail food waste in kg by a country per capita per year

retailEstimatesTonnesPerYear - An array containing the total retail food waste in tons by a country per year

foodServiceEstimatesKgPerCapitaPerYear - An array containing the total food service food waste in kg by a country per capita per year

foodServiceEstimatesTonnesPerYear - An array containing the food service food waste in tonnes by a country per year

confidences - An array containing the level of confidence in the food waste figures being accurate for a given country. This ranges from "Very Low Confidence", "Low Confidence", "Medium Confidence", and "High Confidence".

regions - An array containing the part of the world the given country is in

years - An array containing the year the "percentages share in poverty" figures were taken from

percentagesShareInPoverty - An array containing the percentage of a country's population living on less than $30 USD per day (this will be referred to as "poverty")
</pre>

The dataset is organised alphabetically by country. This means countries[0] contains the country "Albania". 
Conversely, countries[148] contains "Zimbabwe", the last country available in this dataset. 
<br />
<br />
All of a country's data can be found in its corresponding index. This means for example, Albania's data will be found on index 0 for all of the other array's (totalWasteKgPerCapita[0] will contain Albania's total amount of food wasted in kg per capita per year, confidences[0] will contain the confidence level of the food waste figures being accurate for Albania, percentagesShareInPoverty[0] will contain the percentage of Albanians living on less than $30 USD per day, etc...).
This is also true for Zimbabwe where all its corresponding data will be found in all other arrays in index 148.
<br />
<br />
Your task is to choose one of these metrics above and use the given array to find either the mean, median, min, or max values. This will be computed in the corresponding method in the Main class. For example, if you wanted to find the median value for food waste in retail in kg per capita per year for all countries, you would write your solution in the method: medianRetailEstimateKgPerCapitaPerYear().
<br />
<br />
There are also miscellaneous methods that require more complicated logic which should be done individually. These are:

1. getCountryTotalWastePerYear(country, countries, totalWasteKgPerCapitaPerYear) 
2. getCountryWithMostWastePerCapita(countries, totalWasteKgPerCapitaPerYear)
3. getCountriesWithHighestPovertyPercentage(countries, percentagesShareInPoverty)
4. getCountriesWithHighConfidence(countries, confidences)

Explanation: 
1. getCountryTotalWastePerYear takes in a country to find its total waste per capita per year in kg
2. getCountryWithMostWastePerCapita returns the country with the highest total waste per capita per year in kg
3. getCountriesWithHighestPovertyPercentage(countries, percentagesShareInPoverty)
3. getCountriesWithHighestPovertyPercentage returns an array of countries with the highest % of its population living in poverty. (Note: This implies that multiple countries have the same number of individuals living in poverty. This number also coincidentally is the largest number in the  array)
4. getCountriesWithHighConfidence returns an array of countries where the confidence of its food waste data is high (The corresponding String in the confidences array is: "High Confidence")

## Extension

If the miscellaneous methods have also been completed, I encourage you to explore the dataset on your own in the Explore class. The arrays can be initialised by calling the setUp() method. See what you can come up with! If you're stuck, maybe create a method to find the country associated with those minimum and maximum values for one of the metrics to start.

# Dataset

The dataset is a combination of two datasets from [Kaggle](https://www.kaggle.com/). 
The first is a [food waste dataset](https://www.kaggle.com/datasets/joebeachcapital/food-waste) by sector (retail, food services, and household) for all countries.
The second is an [extreme poverty dataset](https://www.kaggle.com/datasets/mathurinache/extreme-poverty) that shows the percentage of the population living under $30 USD a day for a given year.
In this combined dataset, the last year when poverty was measured for a country is used and noted under the "Year" column in the CSV file.
Note that all countries are not listed present in this dataset as it is based on an inner join. 
This means that the country will only be listed if the country has data in both the food waste and extreme poverty dataset.
