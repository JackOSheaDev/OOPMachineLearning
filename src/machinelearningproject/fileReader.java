package machinelearningproject;

//An abstract parent class which serves as the template for the CSVReader
abstract class fileReader
{
    //String input value which is the path to the file
    String fileName = "";

    //getFileName is a method that the CSVReader must implement to return the filename
    public String getfileName()
    {
        //Checks if the fileName is blank
        if(fileName.isBlank())
        {
            return "No file name was inputted";
        }
        //If there is a filename it is returned.
        else
        {
            return fileName;
        }
    }

    //An abstract method which will be implemented by the CSVReader
    abstract public void setFilename(String filename);

}
