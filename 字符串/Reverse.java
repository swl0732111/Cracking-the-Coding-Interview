import java.util.*;

public class Reverse {
    public String reverseString(String iniString) {
        char[] a=iniString.toCharArray();    
        for (int i = 0; i < a.length/2; i++) {
            char temp = a[a.length-1-i];
            a[a.length-i-1]=a[i];
            a[i]=temp;
        }
        return new String(a);
    }
}