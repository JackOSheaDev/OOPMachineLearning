package machinelearningproject;
/*
    Author:
        Jack O'Shea

    Date:
       3/12/2022

    Purpose:
        This class takes in a string input and performs methods which separate it out into a format easier
        for data manipulation by doing actions such as getting the concept of the data sheet,
        finding how many columns there are, finding the features and classes of the data and printing out the data.

    Attributes:
        concept is the purpose of the machine learning.
        lastColumn is the index of the final column of the data.
        inputData is the string inputted to the constructor.
        inputDataArray is an array version of inputData.
        trainingArray is a subset of the inputDataArray used for ML.
        testingArray is a subset of the inputDataArray used for testing the ML algorithm.
        features is all the features of the dataset.
        classes is the possible results of the data. IE. Yes or No to being an entrepreneur.
    Methods:
        data-examiner splits the data into a simpler form.
        separateData creates the test and train set.
        printalldata returns all the variables of the class.



 */

//List and ArrayList are used for dynamic storage of data.
import java.util.ArrayList;
import java.util.List;

//Data analyser which performs functions to separate a CSV file into rows, features and classes.
public class dataAnalyser
{

    //Variables used by the program.
    String concept = "";
    int lastColumn;
    String inputData;

    //Input data array and its subsets.
    List<String> inputDataArray = new ArrayList<>();
    List<String> trainingArray = new ArrayList<>();
    List<String> testingArray = new ArrayList<>();

    //The features and classes of the dataset.
    List<String> features = new ArrayList<>();
    List<String> classes = new ArrayList<>();


    public dataAnalyser(String inputData)
    {

        /*
        To reduce the complexity of this program and to make it easier to error test, i seperated the
        data analysis features and the machine learning and probability features into two separate classes,
        with NaiveBayes being an implementation of the dataAnalyser
        */
        System.out.println("\nScanning the data and beginning data preparation");
        System.out.println("=================================================\n");

        //Sets the inputted string as a variable available to all the functions.
        setInputData(inputData);


        //Examines the data for all the essential components.
        dataExaminer(inputData);


        //analyser
        setClasses();

    }

    //MAIN CORE FUNCTIONS:
    //Examines the data.
    public void dataExaminer(String inputData)
    {
        //Separates the input string into an array of strings for easier analysis.
        setInputDataArray();

        //Gets the features of the dataset into a String list for easier analysis.
        setFeatures();

        //Sets the concept of the dataset. IE. The question being asked
        setConcept();

        /*
        Call to the separateData method which creates the training data and testing data.
        The 70 represents 70% which is what percentage of the data will be used for training.
        */
        separateData(70);



    }
    //Separates the data into two string lists for training and testing.
    public void separateData(int trainPercentage)
    {
        //The number of rows is the number of elements in the inputDataArray
        int rows = inputDataArray.size();
        System.out.println("Number of rows is : " + rows);
        //Counter is used to add the correct number of elements into each sub Array
        int counter = 0;

        //Calculates the number of training rows there will be:
        int trainingRows = (int)((float) rows/100 * trainPercentage);

        //Prints out the number of rows being added to each dataset.
        System.out.println("There are " + trainingRows + " rows in the training dataset");
        System.out.println("There are " + (rows -trainingRows) + " rows in the testing dataset");


        /*
        Adds "trainingRows" number of rows to the training array, plus 2 is to compensate for the labels
        and features row
        */

        while(counter < trainingRows)
        {
            trainingArray.add(inputDataArray.get(counter+2));
            //Increments counter.
            counter++;
        }


        //Adds the remaining  number of rows to the training array.S
        while(counter < rows)
        {

            testingArray.add(inputDataArray.get(counter));
            //Increments counter.
            counter++;
        }

    }
    //Prints all the data out.
    public void printAllData()
    {
        //getInputDataArray();
        getFeatures();
        getConcept();

        getClasses();
    }


    //SETTERS
    //Turns the input string into an array.
    public void setInputDataArray()
    {
        //Separates the input data into an array of strings.
        for(String line: inputData.split("\n"))
        {
            //Adds each string to array list
            inputDataArray.add(line);

        }
    }
    //Sets the feature array.
    public void setFeatures()
    {
        //The 2nd line in the array contains all the features of the dataset.
        String features = inputDataArray.get(1);

        //Separates the features string into substrings and adds them to a list of features.
        for(String feature: features.split("[;,]"))
        {
            //Adds all the features to the array list
            this.features.add(feature);
        }
    }
    //Sets the concept array.
    public void setConcept()
    {
        //The concept of the data is the question being asked. It is the last feature.
        this.concept = this.features.get(this.features.size()-1);

        //The concept is removed from the features set, so it only has features.
        this.features.remove(this.features.size()-1);
    }
    //Sets the input data string.
    public void setInputData(String inputData) {
        //Checks if the input string is blank:
        if(!inputData.isBlank())
        {
            this.inputData = inputData;
        }
        //If it is blank prints to terminal the string is empty.
        else
        {
            System.out.println("This string is empty !");
        }


    }
    //Sets the classes of the data.
    public void setClasses()
    {
        //The classes are the possible answers to the concept such as Yes or No in this case.
        this.lastColumn = trainingArray.get(1).split("[,;]").length - 1;

        //For each row in the training array.
        for(String row: trainingArray)
        {
            //If the classes array does not contain the class, add it to array
            if (!classes.contains(row.split("[,;]")[lastColumn]))
            {
                //Adds it to the array.
                classes.add(row.split("[,;]")[lastColumn]);
            }
        }
    }

    //GETTERS
    //Gets the input data array
    public List<String> getInputDataArray()
    {

        System.out.println("Input Data Array");
        System.out.println("=================");

        for(String row: inputDataArray)
        {
            System.out.println(row);
        }
        return inputDataArray;
    }
    //Gets all the features.
    public List<String> getFeatures()
    {
        System.out.println("Features");
        System.out.println("=========");

        for(String feature: features)
        {
            System.out.println(feature);
        }
        return features;
    }
    //Gets the concept of the data.
    public String getConcept() {
        System.out.println("Concept of the dataset");
        System.out.println("======================");
        System.out.println(concept);
        return concept;
    }
    //Gets the input data string.
    public String getInputData() {
        System.out.println("Inputted Data");
        System.out.println("==============");

        System.out.println(inputData);
        return inputData;
    }
    //Gets the classes of the data.
    public List<String> getClasses() {
        System.out.println("Classes of the data");
        System.out.println("==============");

        for(String classID : classes)
        {
            System.out.println(classID);
        }
        return classes;
    }



}