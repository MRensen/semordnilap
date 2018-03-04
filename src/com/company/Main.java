package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static File file = new File("src/com/company/words.txt");

    public static void main(String[] args) throws IOException{
        // Using only words from this list, report the total number of unique semordnilap pairs, and print 5 examples
        // (Note that lager/regal and regal/lager should be counted as one unique pair.)

        BufferedReader reader = null;

            reader = new BufferedReader(new FileReader(file));
            String line;
            ArrayList<String> list = new ArrayList();
            int counter = 0;

            ArrayList<String> checkList = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

            for(int i = 0; i < list.size(); i++) {
                String iReverse = new StringBuilder( list.get(i)).reverse().toString();
                String iWord = list.get(i);
                String lastLetter = iWord.substring((iWord.length()-1), iWord.length());
                int max = list.size();
                int min = 0;
                int result = recursiveBinary(list, lastLetter, max, min);

                if(result >=0 && result <= list.size()){
                    int o = result;
                    //System.out.println(" test: "  + "list.get(o) :" +  list.get(o) + ", iWord: " + iWord+", iReverse: " + iReverse);
                    while(list.get(o).substring(0,1).equals(lastLetter)){

                        if (list.get(o).equals(iWord)){

                        } else if(list.get(o).equals(iReverse)){
                            // checklist.contains should be exchanged for another binary search for optimalization
                            if(!checkList.contains(iWord)) {
                                System.out.println(list.get(o) + " - " + iWord);
                                checkList.add(list.get(o));
                            }
                        }
                        if(o>0){
                            o--;
                        } else{
                            break;
                        }
                    }
                    o=result;
                    while(list.get(o).substring(0,1).equals(lastLetter)){

                        if (list.get(o).equals(iWord)){

                        } else if(list.get(o).equals(iReverse)){
                            // checklist.contains should be exchanged for another binary search for optimalization
                            if(!checkList.contains(iWord)) {
                                System.out.println(list.get(o) + " - " + iWord);
                                checkList.add(list.get(o));
                            }                         }
                        if(o<(list.size()-1)){
                            o++;
                        }else{
                            break;
                        }

                    }
                }else{
                    System.out.println("failure: binary search result < 0");
                }
            }
            System.out.println(checkList.size());



    }

    public static int recursiveBinary (ArrayList<String> list, String key, int max, int min){

        int middle = (min + max)/2;

        if(max<min){
            return -1;
        }

        if(key.compareTo((list.get(middle)).substring(0,1))==0){
            return middle;
        } else if(key.compareTo((list.get(middle)).substring(0,1)) < 0){
            return recursiveBinary(list , key, middle-1, min);
        } else{
            return recursiveBinary(list, key, max, middle+1);
        }


//            if(list.contains(iReverse)){
//                System.out.println( i + " - " + iReverse);
//                list.remove(iReverse);
//                list.remove(i);
//                if(list.size()>0){
//                    reverse(list, i);
//                }
//            }

    }
}


