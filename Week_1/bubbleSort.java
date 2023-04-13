import java.util.Arrays;
class bubbleSort {
    public static void main (String args[]){
        int[] unsorted = {3,5,1,2,4};
        int len = unsorted.length;

        for(int i = 0; i < len-1; i++){
            for(int j=0; j< len-i-1; j++){
            	
                if(unsorted[j] > unsorted[j+1]){
                    int temp =unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1] = temp; 
                    System.out.println("Switched: " + (unsorted[j]) + " and " + (unsorted[j + 1]));
                }
                else{
                	continue;
                }
                
                System.out.println("Round: " + (j + 1) + " Array: " + Arrays.toString(unsorted)); 
               
            }
            
        }
    }
}