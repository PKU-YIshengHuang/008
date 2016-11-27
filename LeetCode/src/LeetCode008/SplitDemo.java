package LeetCode008;

public class SplitDemo {

	public static void main(String[] args) {
		int k = new Solution().myAtoi("    123");
		System.out.println("k="+k);
	}
}
 class Solution {
    public int myAtoi(String str) {
        if (str.length()==0) //排除第一位是空串的情况
            return 0;
        if(str.equals("0"))
            return 0;
        String[] s = str.split("\\s+");
//        System.out.println("s0 = "+s[0]);
//        System.out.println("s1 = "+s[1]);
       // split 无法正确切除前面的有空格的情况，会将空格存储到第一个字符串中。
        if (!s[0].isEmpty())
        	str = s[0];
        else
        	str = s[1];
        System.out.println("str = "+str);
        char[] c = str.toCharArray();
        for(int i = 0; i<c.length; i++){
            if(i==0){
                if(c[0]=='+'){  //除去正负号
                    String str1 = new String(c,1,c.length-1); 
                    str = str1;
                    continue;
                }
                if((c[0]!='-')&&(c[0]<'0'||c[0]>'9'))//除去第一位是字母的情况
                    return 0;
            }
            else                    //第二位以及以后的情况
                if(c[i]<'0'||c[i]>'9')
                    return 0;
        }
        if(str.length()==0||str.equals("-")) //判断除去正负号的串是否是空串；以及只有一个符号（-）的字符串
            return 0;
        double temp = Double.parseDouble(str);
        if(temp<Integer.MAX_VALUE && temp>Integer.MAX_VALUE)
            return 0;
        return (int)temp;
    }
}
