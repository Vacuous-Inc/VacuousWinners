package VacuousWinners.GameLogic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

public class ChallengeControl {

    private final static String[] urls = {"hello_world","sphere","trig","tree_identifier"};
    private static ArrayList<Challenge> challenges = new ArrayList<>();
    private int curr_chal = 0;

    public ChallengeControl(){
        for (String url:urls){
        challenges.add(new Challenge("Directions/"+url+".md","Prompts/"+url+".py"));
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
            FileWriter submit = new FileWriter("Test_Code"+challenges.get(curr_chal));
            String write = String.format("'''%s'''\n%s",player.getName(),submission);
            submit.write(write);
            submit.close();
        }catch (IOException e){
            return;
        }      

        try (PythonInterpreter pyInterpreter = new PythonInterpreter()) {
            // Load the Python script
            pyInterpreter.execfile(urls[curr_chal]+"Test.py");
            
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
