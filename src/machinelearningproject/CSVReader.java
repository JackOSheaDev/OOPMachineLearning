package machinelearningproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader
{
    File csvFile;
    Scanner scanFile;



    public CSVReader(String filename)
    {
        csvFile = new File(filename);
        try
        {
            scanFile = new Scanner(csvFile);
            while(scanFile.hasNextLine())
            {

                String currentLine = scanFile.nextLine();
                System.out.println(currentLine);
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("File was not found. Please check the path");
        }

    }
}
