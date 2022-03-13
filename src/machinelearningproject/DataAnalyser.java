package machinelearningproject;
//List and ArrayList are used for dynamic storage of data.
import java.util.ArrayList;
import java.util.List;





/**
 * This is a class that is used to perform methods which separates the data of a CSV file into
 * easier variables to manipulate such as columns, features and rows.
 *
 * @author Jack O'Shea
 * @version 1.0
 * @since 13/02/2022
 *
 */
public class DataAnalyser
{
    //Variables:
    /**
     * The concept of the data analysis, such as will this person become an entrepreneur.
     */
    private String concept = "";

    /**
     * The index of the last column of the dataset which stores the classification of the data.
     */
    protected int lastColumn;

    /**
     * The inputted string which is read and analysed by the class.
     */
    protected String inputData;

    //Input data array and its subsets.

    /**
     * The inputted string in an array form.
     */
    private List<String> inputDataArray = new ArrayList<>();
    /**
     * The inputted string in an array form which will be used for training.
     */
    protected List<String> trainingArray = new ArrayList<>();
    /**
     * The inputted string in an array form which will be used for testing.
     */
    protected List<String> testingArray = new ArrayList<>();

    //The features and classes of the dataset.
    /**
     * The features of the dataset we are analysing.
     */
    protected List<String> features = new ArrayList<>();
    /**
     * The classification of the dataset.
     */
    protected List<String> classes = new ArrayList<>();

    /**
     * <p>This method is the constructor for the DataAnalyser class and is used to read in an input
     * string and manipulate it into variables which are easier to use. </p>
     */
    public DataAnalyser(String inputData)
    {


        System.out.println("\nScanning the data and beginning data preparation");
        System.out.println("=================================================\n");

        //Sets the inputted string as a variable available to all the functions.
        setInputData(inputData);


        //Examines the data for all the essential components.
        dataExaminer(getInputData());


        //analyser
        setClasses();

    }

    //MAIN CORE FUNCTIONS:
    /**
     * <p>This method is used to perform methods which analyse the data. </p>
     * @param inputData The data inputted to the examiner in the form of a string.
     */
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
    /**
     * <p>This method is used to separate the data into a training and testing set. </p>
     * @param trainPercentage The percentage of the total dataset used for training.
     */
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

    /**
     * <p>This method is print all the data of the analyser to standard output. </p>S
     */
    public void printAllData()
    {
        System.out.println("\nInput Data Array");
        System.out.println("=================\n");

        System.out.println("\n Features");
        System.out.println("=========");

        for(String feature: getFeatures())
        {
            System.out.println(feature);
        }

        System.out.println("\nConcept of the dataset");
        System.out.println("======================");
        System.out.println(getConcept());



        System.out.println("\nClasses of the data");
        System.out.println("==============");

        for(String classID : getClasses())
        {
            System.out.println(classID);
        }
    }



    //SETTERS

    /**
     * <p>This method is used to turn the input string into an array.</p>
     */
    public void setInputDataArray()
    {
        //Separates the input data into an array of strings.
        for(String line: inputData.split("\n"))
        {
            //Adds each string to array list
            inputDataArray.add(line);

        }
    }
    /**
     * <p>This method is used to set the features of the dataset. </p>
     */
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

    /**
     * <p>This method is used to set the concept of the dataset. </p>
     */
    public void setConcept()
    {
        //The concept of the data is the question being asked. It is the last feature.
        this.concept = this.features.get(this.features.size()-1);

        //The concept is removed from the features set, so it only has features.
        this.features.remove(this.features.size()-1);
    }
    /**
     * <p>This method is used to set the input data of the dataset. </p>
     * @param inputData The string you are setting as inputData.
     */
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
    /**
     * <p>This method is used to set the classes of the dataset. </p>
     */
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
    /**
     * <p>This method is used to return the inputDataArray of the dataset. </p>
     * @return inputDataArray the data stored in inputDataArray.
     */
    public List<String> getInputDataArray()
    {
        return inputDataArray;
    }

    /**
     * <p>This method is used to get the features of the dataset. </p>
     */
    public List<String> getFeatures()
    {

        return features;
    }

    /**
     * <p>This method is used to get the concept of the dataset. </p>
     */
    public String getConcept() {

        return concept;
    }

    /**
     * <p>This method is used to get the inputData as a string of the dataset. </p>
     */
    public String getInputData() {
        System.out.println("Inputted Data");
        System.out.println("==============");

        System.out.println(inputData);
        return inputData;
    }
    /**
     * <p>This method is used to get the classes of the dataset. </p>
     */
    public List<String> getClasses() {

        return classes;
    }



}