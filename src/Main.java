import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.Finishings;

public class Main {

	public static void main(String[]args) throws IOException {
		File file = new File("input.txt");
		FileReader fileReader = new FileReader(file);
		Scanner giris=new Scanner(file);
		ArrayList<Integer> arl = new ArrayList<Integer>();

		while (giris.hasNext()) {	
			int notu = giris.nextInt();
			arl.add(notu);
		}
		int [] arr=new int[arl.size()];
		for(int k=0;k<arl.size();k++) {
			arr[k]=arl.get(k);

		}
		giris.close();
        binarySort(arr);
        bubbleSort(arr);
        quickSort(arr);
	}
	
	public static void binarySort(int[] arl) throws IOException {
		BinaryInsertionSort algorithm=new BinaryInsertionSort();
		long startTime = System.nanoTime();
		algorithm.sort(arl);
		long endTime = System.nanoTime();
    	System.out.println(endTime-startTime + " nanoSecond for BinarySort");
    	System.out.println("Binary sort minimum number= "+arl[0]);
    	
	}
	public static void bubbleSort(int[] arl) throws IOException {
		long startTime= System.nanoTime();
		BubbleSort algorithm=new BubbleSort();
        algorithm.bubbleSort(arl);    
        long last= System.nanoTime();
    	System.out.println(last-startTime + " nanoSecond for BubbleSort");
    	System.out.println("Bubble sort minimum number= "+arl[0]);
    	writeFile(arl);



	}
	public static void quickSort(int[] arl) throws IOException {
        long first= System.nanoTime();
		QuickSort algorithm = new QuickSort();
        algorithm.sort(arl, 0, arl.length-1);
        long last= System.nanoTime();
        System.out.println(last-first + " nanoSecond for Quick Sort");
    	System.out.println("Quick sort minimum number= "+arl[0]);
	}
	
	

	public static void writeFile(int[] arl) throws IOException {
		ArrayList<Integer> arl1 = new ArrayList<Integer>();
		for(int k=0;k<arl.length;k++) {
			int i=arl[k];
			arl1.add(arl[k]);
 		}
	    File a = new File("output.txt");
        if (!a.exists()) {
            a.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(a, true);
    	BufferedWriter bWriter = new BufferedWriter(fileWriter);
        int n = arl.length; 
        
        bWriter.write(arl1.toString());
        bWriter.write("\n");
        bWriter.close();
    
       
		
	}
}
