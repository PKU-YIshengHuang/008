package LeetCode008;

public class SplitDemo1 {
	public static void main(String[] args) {
		int k = new Solution1().atoi("    123");
		System.out.println("k="+k);
	}

}
 class Solution1{
    public int atoi(String str) {
        
        // 1. null or empty string
        if (str == null || str.length() == 0) return 0;
        
        // 2. whitespaces
        str = str.trim();
        
        // 3. +/- sign
        boolean positive = true;
        int i = 0;
        if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) == '-') {
            positive = false;
            i++;
        }
        
        // 4. calculate real value
        double tmp = 0;
        for ( ; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            
            if (digit < 0 || digit > 9) break;
            
            // 5. handle min & max
            if (positive) {
                tmp = 10*tmp + digit;
                if (tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else {
                tmp = 10*tmp - digit;
                if (tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        
        int ret = (int)tmp;
        return ret;
    }
}
 
 
 class Solution2 { 
	  public int atoi(String str) {  
	    if (str == null || str.length() < 1)  
	        return 0;  
	   
	    // trim white spaces  
	    str = str.trim();  
	   
	    char flag = '+';  
	   
	    // check negative or positive  
	    int i = 0;  
	    if (str.charAt(0) == '-') {  
	        flag = '-';  
	        i++;  
	    } else if (str.charAt(0) == '+') {  
	        i++;  
	    }  
	    // use double to store result  
	    double result = 0;  
	   
	    // calculate value  
	    while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {  
	        result = result * 10 + (str.charAt(i) - '0');  
	        i++;  
	    }  
	   
	    if (flag == '-')  
	        result = -result;  
	   
	    // handle max and min  
	    if (result > Integer.MAX_VALUE)  
	        return Integer.MAX_VALUE;  
	   
	    if (result < Integer.MIN_VALUE)  
	        return Integer.MIN_VALUE;  
	   
	    return (int) result;  
	}  
  }