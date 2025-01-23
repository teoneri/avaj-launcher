package avaj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    static private BufferedWriter writer;
    static private String file = "simulation.txt";
    static private List<String> text = new ArrayList<String>();

    static public void printSim()
    {
        try
        {
            writer = new BufferedWriter(new FileWriter(file));

            for(int i = 0; i < text.size(); i++)
            {
                writer.write(text.get(i));
            }
            writer.close();
        }
        catch(IOException e)
        {
            throw new RuntimeException("File write error");
        }
    }

    static public void logMessage(String str)
    {
        text.add(str);
    }

}
