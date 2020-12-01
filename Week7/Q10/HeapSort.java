/**
 * Write a description of class Q10 here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
public class HeapSort{ 
    static int arr[] = {8,38,93,39,21,26,63,11,32}; 
    static int size = arr.length;
    public static void main(String args[]){ 
        Sequence(); 
        System.out.println("Sequence: \n" + arrReuslt()); 
    } 
    
    public static void Sequence(){ 
        int root = 0;
        int currSize = size / 2 - 1;
        while(currSize >= root){
            heap(size, currSize); 
            currSize--;
        }
        
        currSize = size - 1;
        while(currSize > root){
            int temp = arr[root]; 
            arr[root] = arr[currSize]; 
            arr[currSize] = temp; 
            heap(currSize, root);
            currSize--;
        }
    } 
  
    public static void heap(int size, int root) { 
        int largest = root; 
        int min = 2 * root + 1;
        int max = 2 * root + 2;
  
        if (max < size && arr[max] > arr[largest]) 
            largest = max; 
        
        if (min < size && arr[min] > arr[largest]) 
            largest = min; 
  
        if (largest != root){ 
            int replace = arr[root]; 
            arr[root] = arr[largest]; 
            arr[largest] = replace; 
  
            heap(size, largest); 
        } 
    } 
  
    public static String arrReuslt() { 
        String result = "";
        for (int i = 0; i < size; i++) {
            result += arr[i] + " "; 
        }
        return result;
    } 
} 