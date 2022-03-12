package machinelearningproject;



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
        NaiveBayes dataScan = new NaiveBayes(fileContents);
        dataScan.printAllData();

        System.out.println("Aggregation value:");
        System.out.println("===================");
        System.out.println((dataScan).aggTable);

        System.out.println("\nPrior Probabilities");
        System.out.println("===================");

        System.out.println(( dataScan).probTable);


        String[] arguments = {"Male","No","No","Rural","No"};
        //System.out.println(dataScan.generateProbability("Yes",arguments));
        //System.out.println(dataScan.generateProbability(arguments));





    }
}
