import java.util.ArrayList;
import java.util.List;


public class Solution17 {
	 public static String[][] s2 = { { "" }, { "" }, { "a", "b", "c" },
			{ "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
			{ "m", "n", "o" }, { "p", "q", "r","s" }, { "t", "u", "v" },
			{ "w", "x", "y", "z" } };
	    public List<String> letterCombinations(String digits) {
	        List<String> al=new ArrayList<String>();
	        if(digits.length()<1)
				return al;
	        
	        int str_len=digits.length();
			int [] end_index=new int[str_len];
			int [] running_index=new int[str_len];
			for(int i=0;i<str_len;i++){
				end_index[i]=s2[Integer.parseInt(digits.charAt(i)+"")].length;
			}
			while(running_index[0]<end_index[0]){
				String temp="";
				for(int i=0;i<running_index.length;i++){
					temp+=(s2[Integer.parseInt(digits.charAt(i)+"")][running_index[i]]);
				}
				al.add(temp);
				running_index[running_index.length-1]++;
				
				for(int i= running_index.length-1;i>-1;i-- ){
					if(running_index[i]>end_index[i]-1 &&i-1>=0){
						running_index[i]=0;
						running_index[i-1]++;
					}
					
				}
				
				
			}
	        return al;
	    }
}
