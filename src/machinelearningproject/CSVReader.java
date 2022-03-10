package machinelearningproject;
/*
    Author:
        Jack O'Shea
    Date:
        3/10/2022
    Purpose:
        The purpose of CSV reader is to read a csv file and extends the fileReader class.
    Attributes:
        All attributes are extended from fileReader.
    Methods:
        Constructor sets the file name.
        setFileName checks if the file is in CSV format and creates the file object

 */


//Class which extends the fileReader class and implements a method to verify the file type before setting it.
public class CSVReader extends fileReader
{

    //Constructor which initialises the CSVReader object with the name and creates the file.
    public CSVReader(String fileName)
    {
        //Calls method to set the name to whatever is passed.
        setFileName(fileName);
    }


    //Implemented version of setFilename which checks the file extension, it also recreates the fill object.
    @Override
    public void setFileName(String filename) {
        if(!filename.endsWith(".csv"))
        {
            //If the file type is incorrect.
            System.out.println("Invalid file type");
            System.out.println("File has not been created and scanner is not operating");
        }
        else
        {
            //If the file type is correct the object is created.
            System.out.println("Correct file type");
            this.fileName = filename;
            createFileObj();
        }
    }



}