import java.util.*;

public class Permutation {
    /* 经典的全排列问题：*/
    public ArrayList<String> getPermutation(String str) {
    	
    	if(str == null) return null;
    	
    	ArrayList<String> res = new ArrayList<>();
    	/* backTracing: */
    	help(res, str.toCharArray(), 0);
        Collections.sort(res);
        Collections.reverse(res);
    	
    	return res;
    	
    }
    
    private void help(ArrayList<String> res, char[] arr, int start) {
    	if(start == arr.length) {
    		res.add(new String(arr));
    	} else {
    		for(int i=start; i<arr.length; i++) {
    			swap(arr, start, i);
    			help(res, arr, start+1);
    			swap(arr, start, i);
    		}
    	}
    }
    
    private void swap(char[] arr, int i, int j) {
    	char temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    	
    }
}