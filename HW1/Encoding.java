import java.util.*;

public class Encoding
{
 public static Set<String> morseCodes(int m, int n) {
	 
        Set<String> result = new TreeSet<>();

        StringBuilder s = new StringBuilder();
        helperMC(m, n, s, result);

        return result;
    }

    public static void helperMC(int m, int n, StringBuilder s, Set<String> result) {
    	
        if(m== 0 && n==0){
            result.add(s.toString());
        }

        if (m > 0)
            helperMC(m-1, n, s.append("."), result);
        if (n > 0)
            helperMC(m, n-1, s.append("-"), result);
    }


    public static void main(String[] args) {

        System.out.println(morseCodes(2, 1));
    }
}