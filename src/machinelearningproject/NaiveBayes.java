package machinelearningproject;

//Import data structures which are used to store data throughout the program.
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * This is a class that is used to perform the Naive Bayes Machine Learning algorithm on a set of
 * data to predict the result of combinations of features.
 *
 * @author Jack O'Shea
 * @version 1.0
 * @since 13/02/2022
 *
 */
public class NaiveBayes extends DataAnalyser
{

    /**
     * Aggregate table stores all the possible combinations of data.
     */
    public Hashtable<String, Integer> aggTable = new Hashtable<>();
    /**
     * The probability table stores the prior probabilities for calculations.
     */
    public Hashtable<String, Double> probTable = new Hashtable<>();

    /**
     * <p>This method is the constructor for the Naive Bayes class which extends DataAnalyser
     * using the call to super as well as implementing further functionality.</p>
     * @param inputData The string of input data which must be passed to super.
     */
    public NaiveBayes(String inputData) {
        //Call to super to extend Data Analyser.
        super(inputData);

        //Call to aggregate function to get the aggregate table.
        getAggregate();


        //Call to generate the prior possibilities used for calculations.
        generatePriorProbabilities();

        //Tests the accuracy of the machine learning algorithm using the testing data.
        dataTest();
    }

    /**
     * <p>This method is used to perform methods which analyse the data. </p>
     * @param args The arguments passed to the probability function to get the probability of
     *             a set of arguments.
     */
    public String generateProbability(String [] args)
    {
        //This segment of code gets the probability for the naive bayes theorem.
        //Initial value of divisor is 1.
        double divisor = 1;
        //For every string in the classes' dictionary,
        for(String classifier : classes)
        {
            //The divisor is multiplied by the probability.
            divisor = divisor * probTable.get("P("+classifier+")");

        }

        
        //Array list used to house the probabilities calculated.
        List<Double> values = new ArrayList<>();

        //For each classifier in the class list.
        for(String classifier: classes)
        {
            //Calculates the numerator by multiplying the individual probabilities.
            double numerator = 1;
            for(int i=0;i<args.length-1;i++)
            {

                //If the value isn't present in the table it is set to 0.
                aggTable.putIfAbsent(classifier + "_" + features.get(i) + "_" + args[i], 0);
                //Multiplies the numerator by a value in the aggTable / the size of the array as specified by naive bayes.
                numerator = numerator * aggTable.get(classifier+"_"+features.get(i)+"_"+args[i]) / trainingArray.size();

            }
            //Adds the value to numerator.
            values.add(numerator);
        }

        //Variables to store max_index and max_value.
        int max_index = 0;
        double max_value = 0;


        //Gets the highest probability.
        for(int i=0;i<values.size();i++)
        {
            if(values.get(i) > max_value)
            {
                max_value = values.get(i);
                max_index = i;
            }
        }

        //Returns a classifier such as Yes or no by specifying the index.
        return getClasses().get(max_index);
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

            if(final_element.equals(generateProbability(args.toArray(new String[0]))))
            {
                correct++;
            }
            else
            {
                incorrect++;
            }











        }
        System.out.println("RESULTS ARE CORRECT: " + correct + " INCORRECT: " + incorrect);
        System.out.println("FINAL ACCURACY: " + (double) correct / (double) testingArray.size());

    }




    /**
     * <p>This method is used create a table of all the possibilities </p>
     *
     */
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

    /**
     * <p>This method is used to get the prior possibilites IE. P(A) and P(B)..</p>
     *
     */
    private void generatePriorProbabilities()
    {
        //For each classifier in the list.
        for(String classifier: classes)
        {
            //Initialise a counter to 0
            double counter =  0;

            //For each element in the training list array.
            for (String row : trainingArray) {
                //The row is the current element in the for loop.
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