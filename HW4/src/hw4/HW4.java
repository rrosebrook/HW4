package hw4;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;



/**
 *
 * Java program to read file using Scanner class in Java.
 * java.util.Scanner is added on Java 5 and offer convenient method to read data
 *
 * @author
 */
public class HW4 {
    
    static ArrayList<String> text = new ArrayList<>();
    static String file1 = ""; //= "C:/Users/Public/Documents/Test.txt";
    static String file2 = "";//= "C:/Users/Public/Documents/Test2.txt";
    static String file3 = "";//= "C:/Users/Public/Documents/Test3.txt";
    static ArrayList<String> cleantext = new ArrayList<>();
    static ArrayList<String> cleantext2 = new ArrayList<>();

    public static void getFileLocs() {
        System.out.println("What is the location of the file?");
        Scanner fileloc = new Scanner(System.in);
        file1 = fileloc.nextLine();
        System.out.println("And we'll need two locations to save text.");
        System.out.println("File location #1: ");
        Scanner fileloc2 = new Scanner(System.in);
        file2 = fileloc2.nextLine();
        System.out.println("File location #2: ");
        Scanner fileloc3 = new Scanner(System.in);
        file3 = fileloc3.nextLine();
        System.out.println("\n\n");
    }
    
    public static void getTextArray() throws FileNotFoundException, IOException {
        
        //Get the text into an array
        Scanner sc = new Scanner(new File(file1));
        while (sc.hasNext()) {
            text.add(sc.next());
            }

        String[] arr = text.toArray(new String[0]);
        //System.out.println(java.util.Arrays.toString(arr));
        
        //Remove non-alpha characters from the array
        for(int i=0; i<text.size(); i++) {
            arr[i] = arr[i].replaceAll("[^a-zA-Z]", "");
        }
        
        //write cleaned text to a file
        try ( 
                FileWriter fw = new FileWriter(file2)) {
            for (int i=0; i < text.size(); i++) {
                fw.write(arr[i] + " ");
            }
        }
        
        
        
    }
    
    
    
    public static void getCleanArray() throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File(file2));
        while (sc.hasNext()) {
            cleantext.add(sc.next());
            }

    }
    
    public static void getSecondCopy() throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File(file2));
        while (sc.hasNext()) {
            cleantext2.add(sc.next());
            }

    }
    
    public static void sortArrayBubble() {
        //ArrayList<String> tempLisyList<String>) this.text;
        
        
        for(int j=0; j<cleantext.size(); j++) {
            for(int i=j+1;i<cleantext.size();i++) {
                if((cleantext.get(i)).compareToIgnoreCase(cleantext.get(j))<0){
                    String t = cleantext.get(j);
                    cleantext.set(j, cleantext.get(i));
                    cleantext.set(i, t);
            }
            }
        
        //System.out.println(cleantext.get(j));
    }
    }
    
    public static void sortInternal() {
        Collections.sort(cleantext2);
        //System.out.println("After sorting: " + cleantext2);
    }
    
    public static void calculateWallClockSorts() {
        LocalTime startTime = LocalTime.now();
        sortArrayBubble();
        LocalTime stopTime = LocalTime.now();
        long time = ChronoUnit.NANOS.between(startTime, stopTime);
        System.out.println("    Bubble Sort: " + time + " nanoseconds.");
        
        LocalTime startTimeI = LocalTime.now();
        sortInternal();
        LocalTime stopTimeI = LocalTime.now();
        long timeI = ChronoUnit.NANOS.between(startTimeI, stopTimeI);
        System.out.println("    Internal Sort: " + time + " nanoseconds.");
    }     

    public static void calculateCPUSorts() {
        long startTime = System.nanoTime();
        sortArrayBubble();
        long stopTime = System.nanoTime();
        long duration = (stopTime - startTime);
        System.out.println("    Bubble Sort: " + duration + " nanoseconds.");
    //}
    //public static void calculateInternalSortTimeWC() {;    
        long startTimeI = System.nanoTime();
        sortInternal();
        long stopTimeI = System.nanoTime();
        long durationI = (stopTimeI - startTimeI);
        System.out.println("    Internal Sort: " + durationI + " nanoseconds.");
    }
        
    

    public static void main(String args[]) throws FileNotFoundException, IOException {
  
        getFileLocs();
        getTextArray();
        getCleanArray();
        getSecondCopy();
        System.out.println("Filename: " + file1);
        System.out.println("Number of words: " + cleantext2.size());
        //sortArrayBubble();
        //calculateBubbleSortTimeWC();
        //sortInternal();
        //calculateInternalSortTimeWC();
        System.out.println("Wall Clock:");
        calculateWallClockSorts();
        System.out.println("CPU Time:");
        calculateCPUSorts();
        
        
        
        }       
    
    }   




