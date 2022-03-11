package machinelearningproject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;


public class dataAnalyser
{
    List<String> inputDataArray = new ArrayList<>();
    List<String> trainingArray = new ArrayList<>();
    List<String> testingArray = new ArrayList<>();

    List<String> features = new ArrayList<>();
    List<String> classes = new ArrayList<>();


    Hashtable<String, Integer> aggTable = new Hashtable<>();
    Hashtable<String, Double> probTable = new Hashtable<>();


    String concept = "";
    int lastColumn;

    public dataAnalyser(String inputData)
    {
        dataSplit(inputData);
        setClasses();
        getAggregate();
        generatePriorProbabilities();
        dataTest();



    }

    public boolean generateProbability(String [] args)
    {

        //TODO multiple values in key set
        double divisor = probTable.get("P(Yes)") * probTable.get("P(No)");

        double positive = 1;

        for(int i=0;i<args.length-1;i++)
        {
            positive = positive * aggTable.get(classes.get(0)+"_"+features.get(i)+"_"+args[i]) / trainingArray.size();
        }

        double negative = 1;

        for(int i=0;i<args.length-1;i++)
        {
            negative = negative * aggTable.get(classes.get(1)+"_"+features.get(i)+"_"+args[i]) / trainingArray.size();
        }


        return positive / divisor > negative / divisor;

    }

    public void dataTest()
    {
        int incorrect = 0;
        int correct = 0;
        for(String row: testingArray)
        {

            List<String> args = new ArrayList<>();

            for(String rowSlice : row.split(","))
            {
                args.add(rowSlice);
            }

            String final_element = args.get(args.size()-1);

            args.remove(args.size()-1);

            if(final_element.equals("Yes"))
            {
                if(generateProbability(args.toArray(new String[0])))
                    correct++;
                else
                {
                    incorrect++;
                }
            }
            else if(final_element.equals("No"))
            {
                if(generateProbability(args.toArray(new String[0])))
                    incorrect++;
                else
                {
                    correct++;
                }

            }







        }
        System.out.println("RESULTS ARE CORRECT: " + correct + " INCORRECT: " + incorrect);
    }




    private void getAggregate()
    {
        for(String row: trainingArray)
        {
            String[] rowSegments = row.split(",");
            for(int i=0;i<lastColumn;i++)
            {

                //TODO If errors revert this string
                String key = rowSegments[lastColumn] + "_" + features.get(i) + "_" + rowSegments[i];
                if(aggTable.containsKey(key))
                {
                    aggTable.replace(key, aggTable.get(key) + 1);
                }
                else
                {
                    aggTable.put(key, 1);
                }


            }


        }

    }

    public void setClasses()
    {
        this.lastColumn = trainingArray.get(0).split(",").length - 1;
        for(String row: trainingArray)
        {
            if (!classes.contains(row.split(",")[lastColumn]))
            {
                classes.add(row.split(",")[lastColumn]);
            }
        }
    }



    public void dataSplit(String inputData)
    {
        for(String line: inputData.split("\n"))
        {
            inputDataArray.add(line);

        }
        String features = inputDataArray.get(1);

        for(String feature: features.split(","))
        {
            this.features.add(feature);
        }
        this.concept = this.features.get(this.features.size()-1);
        this.features.remove(this.features.size()-1);


        separateData(70);



    }
    public void separateData(int trainPercentage)
    {
        int rows = inputDataArray.size();
        int counter = 0;
        //Evaluates to 70 percent
        int trainingRows = (int)((float) rows/100 * trainPercentage);
        System.out.println("There are " + trainingRows + " rows in the training dataset");


        while(counter < trainingRows)
        {
            trainingArray.add(inputDataArray.get(counter+2));
            counter++;
        }
        while(counter < rows)
        {

            testingArray.add(inputDataArray.get(counter));
            counter++;
        }

    }

    private void generatePriorProbabilities()
    {
        for(String classifier: classes)
        {
            Double counter = (double) 0;
            for(String row: trainingArray)
            {
                String[] rowSegments = row.split(",");
                if(rowSegments[lastColumn].equals(classifier))
                {
                    counter ++;
                }
            }
            probTable.put("P(" + classifier + ")",counter / trainingArray.size());
        }
    }




}