
/**
 * Write a description of class BubbleSort here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
public class BubbleSort{
    static int arr[] = {8,38,93,39,21,26,63,11,32}; 
    static int size = arr.length;
    public static void main(String args[]){ 
        sort(); 
        System.out.println("Bubble Sort: \n" + arrReuslt()); 
    } 

    public static void sort(){
        int current = 0;  
        for(int i=0; i < size-1; i++){  
            for(int j=1; j < (size-i-1); j++){  
                if(arr[j] > arr[j+1]){    
                    current = arr[j];  
                    arr[j] = arr[j+1];  
                    arr[j+1] = current;  
                }  
            }  
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
