package VacuousWinners.GameLogic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.python.core.Py;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class ChallengeControl {

    private final static String[] urls = {"HelloWorld","sphere","trig","tree_identifier"};
    private static ArrayList<Challenge> challenges = new ArrayList<>();
    private int curr_chal = 0;

    public ChallengeControl(){
        for (String url:urls){
        challenges.add(new Challenge("Directions/"+url+".txt","Prompts/"+url+".txt"));
        }
    }
    
    public ArrayList<String> getNextChallenge(){

        ArrayList<String> out = new ArrayList<>();
        out.add(challenges.get(curr_chal).loadDesc());
        out.add(challenges.get(curr_chal).loadPrompt());
        return out;

    }

    public void submitChallenge(String submission, Player player){


        try{
            FileWriter submit = new FileWriter("Test_Code/"+urls[curr_chal]+".py");
            String write = String.format("'''%s'''\n%s",player.getName(),submission);
            submit.write(write);
            submit.close();
        }catch (IOException e){
            return;
        }      

        Properties props = new Properties();
        
        // Prevent the 'site' module from being imported on startup
        props.setProperty("python.import.site", "false");

         PythonInterpreter.initialize(System.getProperties(), props, new String[0]);

        try (PythonInterpreter pyInterpreter = new PythonInterpreter(null, new PySystemState())) {
            

            // Load the Python script
            pyInterpreter.execfile("tests/"+urls[curr_chal]+"Test.py");
            
            // Get the Python function object
            PyObject pyFunction = pyInterpreter.get("run");
            
            // Call the Python function with an argument
            PyObject pyObjectReturn = pyFunction.__call__();
            
            // Convert the return value to a Java string
            String returnValue = pyObjectReturn.toString();

            player.addCoins(Integer.parseInt(returnValue));
            
            System.out.println(returnValue); // Prints: Hello, John Doe
        } catch (Exception e) {
            e.printStackTrace();
        }

        curr_chal ++;

    }

}
