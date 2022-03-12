package machinelearningproject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class NaiveBayes extends dataAnalyser
{

    public Hashtable<String, Integer> aggTable = new Hashtable<>();
    public Hashtable<String, Double> probTable = new Hashtable<>();

    public NaiveBayes(String inputData) {
        super(inputData);

        //Naive Bayes
        //getAggregate();


        //Naive Bayes
        //generatePriorProbabilities();


        //Naive_bayes
        //dataTest();
    }

    //Naive Bayes
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
    //Naive Bayes
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



    //data analyser
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


    //Naive Bayes
    private void generatePriorProbabilities()
    {
        for(String classifier: classes)
        {
            Double counter = (double) 0;
            for (int i = 0; i < trainingArray.size(); i++) {
                String row = trainingArray.get(i);
                String[] rowSegments = row.split(",");
                if (rowSegments[lastColumn].equals(classifier)) {
                    counter++;
                }
            }
            probTable.put("P(" + classifier + ")",counter / trainingArray.size());
        }
    }





}