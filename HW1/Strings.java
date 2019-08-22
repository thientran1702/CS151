
public class Strings {
	
	public static String uniqueLetters(String str) 
    { 
       
        int[] count = new int[200]; 
       
       //count characters in the array
        int i; 
        for (i = 0; i < str.length(); i++) 
            if(str.charAt(i)!=' ') 
                count[(int)str.charAt(i)]++; 
        int n = i; 
       
        // Print characters having count more than 0 
        for (i = 0; i < n; i++) 
            if (count[(int)str.charAt(i)] == 1) 
                System.out.print(str.charAt(i));
		return str; 
    } 
       
    public static void main(String args[]) 
    { 
        String str = "harrasses"; 
        uniqueLetters(str); 
    } 
} 