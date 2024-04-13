package VacuousWinners.GameLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        BufferedReader file;

        try{
            file = new BufferedReader(new FileReader(desc));
    
        
        while (file.ready()){
            out += file.readLine() + "\n";
            
        }
       //out = file.readLine();
            file.close();
        }catch (IOException e){
            System.out.println("Error "+prompt);
            return out;
        };
        
        return out;
    }

    public String loadPrompt(){
        String out = "";
        BufferedReader file;

        try{
            file = new BufferedReader(new FileReader(prompt));
    
        
        while (file.ready()){
            out += file.readLine() + "\n";
            
        }
       //out = file.readLine();
            file.close();
        }catch (IOException e){
            System.out.println("Error "+prompt);
            return out;
        };
        System.out.println(out);
        return out;
    }

}
