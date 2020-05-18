package org.hcl.src.java.cachework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CacheWords {
  /** javadoc ignored. */
  public static void main(String[] args) throws Exception {
    while (true) {
      System.out.print("Enter a word to be searched ");
      Scanner sc = new Scanner(System.in);
      String searchWord = sc.next();
      if (searchWord.equals("exit")) {
        System.exit(0);
      }
      long startTime = System.currentTimeMillis();
      boolean val = isWord(searchWord);
      if (val == true) {
        System.out.println("the word " + searchWord + " present is" + val);
        long endTime = System.currentTimeMillis();
        System.out.println("Time took" + (endTime - startTime) + "ms");
      } else {
        System.out.println("the word " + searchWord + " present is" + val);
      }
    }
  }

  /** javadoc ignored. */
  public static boolean isWord(String searchWord) throws IOException {
    String filePath = "file";
    boolean status = false;
    List<String> cacheList = new ArrayList<String>();
    cacheList.add("pleasant");
    cacheList.add("tenuous");
    cacheList.add("aboriginal");
    cacheList.add("better");
    cacheList.add("spiteful");
    BufferedReader br;
    String line = "";

    try {
      if (cacheList.contains(searchWord)) {
        status = true;
      } else {
        br = new BufferedReader(new FileReader(filePath));
        try {
          while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
              if (word.equals(searchWord)) {
                status = true;
                if (cacheList.size() < 4) {
                  cacheList.add(searchWord);
                } else {
                  cacheList.remove(0);
                  cacheList.add(searchWord);
                }
              }
            }
          }
          br.close();
        } catch (IOException e) {

          e.printStackTrace();
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println(cacheList);
    return status;
  }
}
