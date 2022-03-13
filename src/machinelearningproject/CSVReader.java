package machinelearningproject;

/**
 * This is a class which extends FileReader,
 * and implements a constructor and overrides an abstract method.
 * @author Jack O'Shea
 * @version 1.0
 * @since 13/02/2022
 */
public class CSVReader extends FileReader
{

    /**
     * <p>This is the constructor used to initialise the file with its name. </p>
     * @param fileName The name of the file to be read.
     */
    public CSVReader(String fileName)
    {
        //Calls method to set the name to whatever is passed.
        setFileName(fileName);
    }



    /**
     * <p>This method is used to set the filename and verify the file extension.</p>
     */
    @Override
    public void setFileName(String filename) {
        //Ensures the file type is csv.
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
            //Creates the file object.
            createFileObj();
        }
    }



}