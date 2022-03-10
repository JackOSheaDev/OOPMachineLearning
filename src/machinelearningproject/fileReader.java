package machinelearningproject;
/*
    Author:
        Jack O'Shea
    Date:
        3/10/2022
    Purpose:
        fileReader is an abstract class which is used to simulate a file read for different types of files.

    Attributes:
        fileName is the name of the file which will be used by the fileReader.
        fileScanner is a scanner object which will read text from the file.
        fileObject is the file which will be read by the fileReader.

    Methods:
        createFileObject will create a file object and check if the file exists. If it exists a scanner is created.
        readLine will read one line of the file, it will not read a line if the scanner is not working.
        readFile will reset the scanner, scan the whole file and return the result as a string.
        closeScanner will stop the scanner, once it is no longer needed.
        resetScanner is used to scan a new file or restart the scanner at the beginning of the file.
        getFileName will return the file name if it exists.
        setFileName is an abstract method implemented by children classes.



 */

//Import file and scanner library which will be used by the fileReader class.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//An abstract parent class which serves as the template for the CSVReader
abstract class fileReader
{
    // A String input value which is the path to the file
    protected String fileName = "";

    //A Scanner which will be used to read data from the file.
    protected Scanner fileScanner;

    //A File object which will be used to store the file, so it can be read by scanner.
    protected File fileObject;




    protected void createFileObj() {
        //Creates a file object and checks if the file exists.
        fileObject = new File(fileName);
        if(fileObject.exists())
        {
            System.out.println("> File exists and has been located");
            //Only starts the scanner is the file exists.
            resetScanner();
        }
        else
        {
            System.out.println("> File does not exist and cannot be located");
        }

    }

    //A method which returns an individual line from a file which is specified.
    public String readLine()
    {
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

    //A method which returns the whole file as a string seperated by newline characters.
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

    //Turns the scanner off if a scanner is active otherwise says there is no scanner in action.
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

    //Restarts the scanner or initialises it, can be used by end user.s
    public void resetScanner()
    {
        try
        {
            //Start the scanner to view the contents of a file
            fileScanner = new Scanner(fileObject);
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e + " File cannot be found or does not exist.");
        }
        catch(NullPointerException e)
        {
            System.out.println("There is no Scanner currently in operation");
        }
    }


    //getFileName is a method that returns the fileName Variable.
    public String getFileName()
    {
        //Checks if the fileName is blank
        if(fileName.isBlank())
        {
            return "> No file name is stored";
        }
        //If there is a filename it is returned.
        else
        {
            return fileName;
        }
    }

    //An abstract method which will be implemented by the CSVReader
    abstract public void setFileName(String filename);
}
