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
        System.out.println("\nScanning the data and beginning data preperation");
        System.out.println("=================================================\n");
        dataAnalyser dataScan = new dataAnalyser(fileContents);
        System.out.println("Features");
        System.out.println("=========");
        for (String feature : dataScan.features) {
            System.out.println(feature);
        }
        System.out.println("The study is " + dataScan.concept);
        System.out.println("Classes are " + dataScan.classes);



        System.out.println(dataScan.trainingArray.size());
        System.out.println(dataScan.testingArray.size());
        System.out.println(dataScan.aggTable);
        System.out.println(dataScan.probTable);









    }
}
