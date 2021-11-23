package gsonParse;

import com.google.gson.Gson;
import model.Root;

import java.io.FileReader;
import java.io.IOException;

public class GsonParser {
    public Root parse(String path){
        Gson gson=new Gson();

        try(FileReader reader=new FileReader(path)) {
            Root root = gson.fromJson(reader,Root.class);

            return root;
        } catch (IOException e) {
            System.out.println("Parsing error");
        }
        return null;
    }
}
