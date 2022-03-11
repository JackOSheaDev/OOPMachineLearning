package machinelearningproject;

import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
	    System.out.println("Hello and welcome to the command line based ML project");
        System.out.println("======================================================\n");

        //Read CSV:
        CSVReader mlFile = new CSVReader("MLdata.csv");
        //Return CSV contents.
        String fileContents = mlFile.readFile();
        //Print CSV contents.
        //System.out.println(fileContents);


        //Scan the data.
        System.out.println("\nScanning the data and beginning data preperation");
        System.out.println("=================================================\n");
        dataAnalyser dataScan = new dataAnalyser(fileContents);
        System.out.println("Features");
        System.out.println("=========");
        for (String feature : dataScan.features) {
            System.out.println(feature);
        }
        System.out.println("\nThe study is " + dataScan.concept);
        System.out.println("\nClasses are " + dataScan.classes);



        System.out.println("\nSize of training set is "+dataScan.trainingArray.size());
        System.out.println("Size of testing set is "+dataScan.testingArray.size()+"\n");

        System.out.println("Aggregation value:");
        System.out.println("===================");
        System.out.println(dataScan.aggTable);

        System.out.println("\nPrior Probabilities");
        System.out.println("===================");

        System.out.println(dataScan.probTable);

        //False
        //String[] arguments = {"Male", "No", "Yes", "Urban","Yes"};
        //True
        //String[] arguments = {"Male", "Yes", "No", "Rural","Yes"};

        //System.out.println(dataScan.generateProbability("Yes",arguments));






    }
}
