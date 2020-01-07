import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	
	int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 

    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 

            int pi = partition(arr, low, high); //arrayi s�ralad� 
            sort(arr, low, pi-1); //sol taraf� g�nderiyor
            sort(arr, pi+1, high); //sa� taraf� g�nderiyor
        } 
    } 

}
