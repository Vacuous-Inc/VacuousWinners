import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge {

    private File desc;
    private File prompt;

    public Challenge(String desc_url, String prompt_url){
        this.desc = new File(desc_url);
        this.prompt = new File(prompt_url);
    }

    public File getDesc() {
        return this.desc;
    }

    public void setDesc(File desc) {
        this.desc = desc;
    }

    public File getPrompt() {
        return this.prompt;
    }

    public void setPrompt(File prompt) {
        this.prompt = prompt;
    }
    
    public String loadDesc(){
        String out = "";
        Scanner file;
        try{
            file = new Scanner(desc);
        }catch (FileNotFoundException e){
            return out;
        }

        while (file.hasNextLine()){
            out += file.nextLine();
        }
        file.close();
        return out;
    }

    public String loadPrompt(){
        String out = "";
        Scanner file;
        try{
            file = new Scanner(prompt);
        }catch (FileNotFoundException e){
            return out;
        }

        while (file.hasNextLine()){
            out += file.nextLine();
        }
        file.close();
        return out;
    }

}
