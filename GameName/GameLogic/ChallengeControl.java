import java.util.ArrayList;

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

    public void submitChallenge(String submission){
        curr_chal ++;
    }

}
