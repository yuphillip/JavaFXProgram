package sample;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BackEnd {

    public static List<records> fromCSV(){


        List<records> z = new ArrayList<>();
        Path pathToFile = Paths.get("highScores.csv");

        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)){
            String line = br.readLine();
            if(line == null)
            {
                return z;
            }
            while(line != null){
                String[] attributes = line.split(",");

                records temp = records.createRecord(attributes);

                z.add(temp);
                line = br.readLine();

            }

        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        return z;
    }


    public static class records{
        private int clicks;
        private String name;

        public records(int c, String n)
        {
            clicks=c;
            name =n;
        }
        public int getClicks()
        {
            return clicks;
        }
        public String getName()
        {
            return name;
        }
        public String toString()
        {
            return name + " "+ clicks;
        }
        public static records createRecord(String[] info)
        {
            String name = info[0];
            int click = Integer.parseInt(info[1]);
            return new records(click,name);
        }
    }
    public static void write(List<records> r) throws IOException{
        FileWriter x =  new FileWriter("highScores.csv");
        x.append(Controller.name);
        x.append(",");
        x.append(String.valueOf(Controller.score));
        x.append("\n");
        while(r.size()>0)
        {
            x.append(r.get(0).name);
            x.append(",");
            x.append(String.valueOf(r.get(0).clicks));
            x.append("\n");
            r.remove(0);
        }
        x.flush();
        x.close();
    }
}
