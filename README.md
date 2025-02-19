# CS.11.05-Lab.5.1

This lab contains information about food waste and poverty for many countries and is placed into various arrays described below:


|Variable|Description|
| --- | --- |
|countries| An array containing the list of countries|
|totalWasteKgPerCapitaPerYear| An array containing the total amount of food wasted in kg by a country per capita per year|
|householdEstimatesKgPerCapitaPerYear| An array containing the total household food waste in kg by a country per capita per year|
|retailEstimatesKgPerCapitaPerYear| An array containing the total retail food waste in kg by a country per capita per year|
|foodServiceEstimatesKgPerCapitaPerYear| An array containing the total food service food waste in kg by a country per capita per year|
|confidences| An array containing the level of confidence in the food waste figures being accurate for a given country. This ranges from "Very Low Confidence", "Low Confidence", "Medium Confidence", and "High Confidence".|
|percentagesShareInPoverty| An array containing the percentage of a country's population living on less than $30 USD per day (this will be referred to as "poverty")|

The dataset is organised alphabetically by country. This means countries[0] contains the country "Albania". 
Conversely, countries[148] contains "Zimbabwe", the last country available in this dataset. 
<br />
<br />
All of a country's data can be found in its corresponding index. This means for example, Albania's data will be found on index 0 for all of the other array's (totalWasteKgPerCapita[0] will contain Albania's total amount of food wasted in kg per capita per year, confidences[0] will contain the confidence level of the food waste figures being accurate for Albania, percentagesShareInPoverty[0] will contain the percentage of Albanians living on less than $30 USD per day, etc...).
This is also true for Zimbabwe where all its corresponding data will be found in all other arrays in index 148.
<br />
<br />
Your task is to complete all of the following methods in the Main class:

|Method|Description|
| --- | --- |
|meanTotalWasteKgPerCapitaPerYear| Return the mean value from the totalWasteKgPerCapitaPerYear array|
|medianHouseholdEstimateKgPerCapitaPerYear| Return the median value from the householdEstimatesKgPerCapitaPerYear array|
|minRetailEstimateKgPerCapitaPerYear| Return the smallest value from the retailEstimatesKgPerCapitaPerYear array|
|maxFoodServiceEstimateKgPerCapitaPerYear| Return the largest value from the foodServiceEstimatesKgPerCapitaPerYear array|
|getCountryTotalWastePerYear| Given a country, find its total food waste per capita per year|
|getCountryWithMostWastePerCapita| Returns the country with the largest total food waste per capita per year in kg|
|getCountriesWithHighestPovertyPercentage| Returns an array of countries with the largest % of its population living in poverty (Note: This implies that multiple countries can share the same percentage of individuals living in poverty. Coincidentally, this number can be the largest number in the array)|
|getCountriesWithHighConfidence| Returns an array of countries where the confidence of its food waste data is high. The corresponding String in the confidences array is: "High Confidence"|

# Dataset

The dataset is a combination of two datasets from [Kaggle](https://www.kaggle.com/). 
The first is a [food waste dataset](https://www.kaggle.com/datasets/joebeachcapital/food-waste) by sector (retail, food services, and household) for all countries.
The second is an [extreme poverty dataset](https://www.kaggle.com/datasets/mathurinache/extreme-poverty) that shows the percentage of the population living under $30 USD a day for a given year.
In this combined dataset, the last year when poverty was measured for a country is used and noted under the "Year" column in the CSV file.
Note that all countries are not listed present in this dataset as it is based on an inner join. 
This means that the country will only be listed if the country has data in both the food waste and extreme poverty dataset.
