package machinelearningproject;

//Import file and scanner library which will be used by the FileReader class.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is an abstract class named FileReader which I use to take a string input as a file path,
 * and perform methods such as reading a line from the file or reading the whole file.
 *
 * @author Jack O'Shea
 * @version 1.0
 * @since 13/02/2022
 *
 */
abstract class FileReader
{
    /**
     * The name of the file which will be used by methods within the program to create a file object and return the
     * content of the file
     */
    protected String fileName = "";

    /**
     * A scanner object which will be used to read text from the file object.
     */
    protected Scanner fileScanner;

    /**
     * The file object which will be created by the class.
     */
    protected File fileObject;


    /**
     * <p>This method is used to create a file object to be read by the FileReader. </p>
     */
    protected void createFileObj() {
        //Creates a file object.
        fileObject = new File(getFileName());

        //Verifies the file exists.
        if(fileObject.exists())
        {
            System.out.println("> File exists and has been located");
            //Only starts the scanner is the file exists.
            resetScanner();
        }
        //If the file doesn't exist.
        else
        {
            System.out.println("> File does not exist and cannot be located");
        }

    }

    /**
     * <p>This method is used to read a single line from the file. </p>
     * @return the next line in the file or null if there isn't one
     */
    public String readLine()
    {
        //Only return the next line if there is a next line.
        try
        {
            //Returns a line if there is one.
            if(fileScanner.hasNextLine())
            {
                return fileScanner.nextLine();
            }


        }
        //If the file scanner is not in operation because the file name isn't set a message will be presented to the user.
        catch(NullPointerException e)
        {
            System.out.println("!! Scanner is not in operation");
        }
        return null;
    }

    /**
     * <p>This method is used the whole file into a string variable.</p>
     * @return the contents of the file as a single string.
     */
    public String readFile()
    {
        //Empty String variable
        StringBuilder file = new StringBuilder();

        //Resets scanner to get whole contents of file.
        resetScanner();



        //Creates a string which has the files contents.
        while(fileScanner.hasNextLine())
        {
            //Appends current line to file string.
            file.append(readLine());
            file.append("\n");
        }




        //Close the scanner since the file has been completely read.
        closeScanner();

        //Returns the string value of all the contents.
        return file.toString();

    }

    /**
     * <p>This method is used to turn of the scanner once the file's contents have been read.</p>
     */
    protected void closeScanner()
    {
        //Closes the scanner and prints to output.
        try
        {
            //Tries to close the scanner
            fileScanner.close();
            System.out.println("> File closed correctly");
        }
        //Catches null pointer exception if the scanner isn't on.
        catch(NullPointerException e)
        {
            System.out.println("> No scanner in operation");
        }

    }

    /**
     * <p>This method is used to turn on a new scanner and have it go back to the first line. </p>
     *
     */
    public void resetScanner()
    {
        //Trys to make a scanner if the file exists.
        try
        {
            //Start the scanner to view the contents of a file
            fileScanner = new Scanner(fileObject);
        }
        //If the file is not found.
        catch(FileNotFoundException e)
        {
            System.out.println(e + " File cannot be found or does not exist.");
        }
        //If no file path is specified.
        catch(NullPointerException e)
        {
            System.out.println("There is no Scanner currently in operation");
        }
    }


    /**
     * <p>This method is used to get the name of the file </p>
     * @return the name of the file.
     */
    public String getFileName()
    {
        //Checks if the fileName is blank
        if(fileName.isBlank())
        {
            System.out.println("> No file name is stored");
            return null;
        }
        //If there is a filename it is returned.
        else
        {
            return fileName;
        }
    }

    /**
     * <p>This is an abstract method used by children classes to implement functionality such as file type verification.</p>
     * @param fileName name of the file
     */
    abstract public void setFileName(String fileName);
}
