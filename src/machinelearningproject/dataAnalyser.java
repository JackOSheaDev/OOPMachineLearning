package machinelearningproject;

public class dataAnalyser {


    String[] inputDataArray;
    String[] features;

    Integer numFeatures = 0;


    public dataAnalyser(String inputData)
    {
        dataSplit(inputData);

    }

    public void dataSplit(String inputData)
    {
        this.inputDataArray = inputData.split("\n");

        setNumFeatures();
        setFeatures();



    }


    private void setNumFeatures()
    {
        //System.out.println(inputDataArray[0]);

        String[] labels = inputDataArray[0].split(",");


        for (String label : labels) {
            //System.out.println(label);
            if (label.equals("Feature")) {
                this.numFeatures++;
            }
        }


    }
    public int getNumFeatures()
    {
        System.out.println("The number of features in the dataset is: "+ numFeatures.toString());
        return numFeatures;
    }
    public String[] getFeatures()
    {

        System.out.println("The features in the dataset are: ");
        for(String feature: features)
        {
            System.out.println(feature);
        }
        System.out.println();
        return features;
    }



    public void setFeatures()
    {
        this.features = inputDataArray[1].split(",");
    }




}
