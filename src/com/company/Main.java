package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static File file = new File("/home/rensen/IdeaProjects/semordnilap/src/com/company/words.txt");

    public static void main(String[] args) {
        // Using only words from this list, report the total number of unique semordnilap pairs, and print 5 examples
        // (Note that lager/regal and regal/lager should be counted as one unique pair.)

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            ArrayList list = new ArrayList();

            int test = 0;

            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

            reverse(list);




        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public static void reverse (ArrayList list){

        for(int i = 0; i < list.size(); i++){
            String iReverse = new StringBuilder((String) list.get(i)).reverse().toString();
            if(list.contains(iReverse)){
                System.out.println( i + " - " + iReverse);
                list.remove(iReverse);
                list.remove(i);
                if(list.size()>0){
                    reverse(list);
                }
            }
        }
    }

}
