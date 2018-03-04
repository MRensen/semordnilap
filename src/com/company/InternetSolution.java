package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InternetSolution {
    public static void main(String[] args) throws Exception {
        List<String> lst = Files.readAllLines(Paths.get("src/com/company/words.txt"));
        Set<String> seen = new HashSet<>();
        int count = 0;
        for (String w : lst) {
            w = w.toLowerCase();
            String r = new StringBuilder(w).reverse().toString();
            if (seen.contains(r)) {
                if (count++ < 5)
                    System.out.printf("%-10s %-10s\n", w, r);
            } else seen.add(w);
        }
        System.out.println("\nSemordnilap pairs found: " + count);
    }
}
