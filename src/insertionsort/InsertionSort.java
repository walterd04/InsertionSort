/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

/**
 *
 * @author Devin Walter
 */
import java.util.Scanner;
import java.io.*;
public class InsertionSort {
    
    // implements the insertion sort and returns sorted array
    static double[] insertionSort(double[] array){
        double swap;
        for(int i = 1; i < array.length; i++){
            int j = i - 1;
            while(j >= 0 && array[j] > array[i]){
                swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i = j;
                j--;
            }
        }
        return array;
    }
    
    // prints an array into file
    public static void printArrayToFile(double[] array, String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".txt"));
        for(int i = 0; i < array.length; i++){
            writer.write(array[i] + ", ");
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }
    
    // prints an array to console
    static void printArrayToConsole(double[] array){
        for(double d : array){
            System.out.print(d + ", ");
        }
    }
    
    //populates the array from a file, the file format should read the first number as int for how many numbers in the array
    //each double should be separated by a new line
    static double[] populateArray(){
        Scanner scan = null;
        String filename;
        try{
            //Commented out code takes user file path to retrieve data, uncommented code means the file path must be changed to right path
            /*Scanner sc = new Scanner(System.in);
            System.out.println("Enter path for data file: ");
            filename = sc.nextLine();
            scan = new Scanner(new File(filename));*/
            
            scan = new Scanner(new File("C:\\Users\\Administrator\\Downloads\\SomeDataToImport\\temp.dat"));
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        //populates the array
        //takes the first number in file as how many items in array
        int n = scan.nextInt();
        double[] unsortedArray = new double[n];
        for(int i = 0; i < unsortedArray.length; i++){
            unsortedArray[i] = scan.nextDouble();
        }
        scan.close();
        return unsortedArray;
    }

    
    public static void main(String[] args) {
        double[] unsortedArray = populateArray();
        System.out.print("UNSORTED LIST: ");
        printArrayToConsole(unsortedArray);
        System.out.println();
        
        //creates and prints sorted array to console
        double[] sortedArray = insertionSort(unsortedArray);
        System.out.print("SORTED LIST: ");
        printArrayToConsole(sortedArray);
        System.out.println();
        
        //saves array to file
        Scanner scanMain = new Scanner(System.in);
        System.out.print("Enter filename you would like to save to: ");
        String filename = scanMain.nextLine();
        try{
            printArrayToFile(sortedArray, filename);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
