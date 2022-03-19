package machinelearninggui;

import machinelearningproject.CSVReader;
import machinelearningproject.NaiveBayes;

public class Model
{
    private String filename;
    private String concept;
    public Model()
    {

    }

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
        NaiveBayes dataScan = new NaiveBayes(fileContents);

        concept = dataScan.getConcept();
    }


}
