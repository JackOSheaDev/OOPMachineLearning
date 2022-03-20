package machinelearninggui;

import machinelearningproject.CSVReader;
import machinelearningproject.NaiveBayes;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Model
{
    private String filename;
    private String concept;
    List<String> features;
    List<String> classes;
    Hashtable<String, List<String>> featuresResults;
    NaiveBayes dataScan;



    protected List<String> userChoices = new ArrayList<>();


    public int getCurrentIndex() {
        return currentIndex;
    }

    int currentIndex = 0;

    public int getLastIndex() {
        return lastIndex;
    }

    int lastIndex;

    double maxValue;


    public void setFilename(String filename) {
        this.filename = filename;
        startReader();
    }
    protected void startReader()
    {
        CSVReader mlFile = new CSVReader(filename);
        //Return CSV contents.
        String fileContents = mlFile.readFile();
        //Scan the data.
        dataScan = new NaiveBayes(fileContents);

        concept = dataScan.getConcept();
        classes = dataScan.getClasses();
        features = dataScan.getFeatures();
        featuresResults = dataScan.getFeatureResults();
        lastIndex = features.size();
    }

    public String getFeature()
    {
        return features.get(currentIndex);
    }

    public String getChoice1()
    {
        return featuresResults.get(features.get(currentIndex)).get(0);
    }
    public String getChoice2()
    {
        return featuresResults.get(features.get(currentIndex)).get(1);
    }
    public void setUserChoices(String userChoice) {
        this.userChoices.add(userChoice);
    }

    public void incrementCurrentIndex() {
        this.currentIndex += 1;
    }

    public String getResult()
    {

        String[] userChoices = this.userChoices.toArray(new String[0]);
        String result = dataScan.generateProbability((userChoices));


        return result;
    }








}
