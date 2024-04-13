package VacuousWinners.GameLogic;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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

        String pythonScriptPath = "/tests/"+urls[curr_chal]+".py";

        String[] cmd = new String[]{"python", pythonScriptPath};
        
        // Use ProcessBuilder to start a new process running the Python script
        ProcessBuilder pb = new ProcessBuilder(cmd);
        
        try {
            Process p = pb.start();
            
            // Capture and print the script's output
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            
            // Wait for the process to finish and check the exit value
            int exitValue = p.waitFor();
            if (exitValue == 0) {
                System.out.println("Execution successful");
            } else {
                System.out.println("Execution failed with exit code: " + exitValue);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        curr_chal ++;

    }

}
