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
        getAggregate();


        //Naive Bayes
        generatePriorProbabilities();


        //Naive_bayes
        dataTest();
    }

    //Naive Bayes
    public boolean generateProbability(String [] args)
    {
        //This segment of code gets the probability for the naive bayes theorem.
        //Initial value of divisor is 1.
        double divisor = 1;
        //For every string in the classes' dictionary,
        for(String classifier : classes)
        {
            //THe divisor is multiplied by the probability.
            divisor = divisor * probTable.get("P("+classifier+")");

        }

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
            //TODO change here
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


    //Creates a table of all the probabilities seperated by class.
    private void getAggregate()
    {
        //For each row in the training array.
        for(String row: trainingArray)
        {
            //Split the row into columns.
            String[] rowSegments = row.split(",");

            //For each column
            for(int i=0;i<lastColumn;i++)
            {

                //TODO If errors revert this string
                //Creates a key for the aggregate table containing the classifier, the feature and the result.
                String key = rowSegments[lastColumn] + "_" + features.get(i) + "_" + rowSegments[i];

                //Checks if the table already contains the entry.
                if(aggTable.containsKey(key))
                {
                    //If the table contains the entry, the value is incremented.
                    aggTable.replace(key, aggTable.get(key) + 1);
                }
                //If the table does not contain the entry
                else
                {
                    //The key is added to the table.
                    aggTable.put(key, 1);
                }


            }


        }

    }

    //Gets the probabilities of A and B.
    private void generatePriorProbabilities()
    {
        //For each classifier in the list.
        for(String classifier: classes)
        {
            //Initialise a counter to 0
            Double counter = (double) 0;

            //For each element in the training list array.
            for (int i = 0; i < trainingArray.size(); i++) {
                //The row is the current element in the for loop.
                String row = trainingArray.get(i);

                //The row is segmented into sections.
                String[] rowSegments = row.split(",");

                //Each row has a classifier at the end such as Yes or No in the case of Entrepreneur
                if (rowSegments[lastColumn].equals(classifier)) {
                    //Increments the counter.
                    counter++;
                }
            }
            //Places the probability into the dictionary in the form P(Classifier)
            probTable.put("P(" + classifier + ")",counter / trainingArray.size());
        }
    }





}