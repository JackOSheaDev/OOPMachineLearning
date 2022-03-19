package machinelearningproject;

/**
 * This is the main class of the program which can be used to peform Naive Bayes in the command line.
 *
 * @author Jack O'Shea
 * @version 1.0
 * @since 14/03/2022
 *
 */

public class Main
{
    //Main function.
    public static void main(String[] args)
    {
        //Greeting
	    System.out.println("Hello and welcome to the command line based ML project");
        System.out.println("======================================================\n");

        //Read CSV:
        //CSVReader mlFile = new CSVReader("superhero.csv");
        CSVReader mlFile = new CSVReader("MLdata.csv");




        //Return CSV contents.
        String fileContents = mlFile.readFile();
        //System.out.println(fileContents);





        //Scan the data.
        NaiveBayes dataScan = new NaiveBayes(fileContents);
        dataScan.printAllData();

        //Aggregation and probabilities values.
        System.out.println("Aggregation value:");
        System.out.println("===================");
        System.out.println(dataScan.getAggTable());

        System.out.println("\nPrior Probabilities");
        System.out.println("===================");
        System.out.println(dataScan.getProbTable());


        //Function to generate machine learning answer to data.
        //dataScan.generateProbability();






    }
}
