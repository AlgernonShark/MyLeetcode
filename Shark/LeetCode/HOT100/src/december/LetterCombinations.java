package december;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() ==0) return new ArrayList<String>();

        //使用HashMap存放映射关系
        HashMap<Character,String> phone = new HashMap<>();

        phone.put('2',"abc");
        phone.put('3',"def");
        phone.put('4',"ghi");
        phone.put('5',"jkl");
        phone.put('6',"mno");
        phone.put('7',"pqrs");
        phone.put('8',"tuv");
        phone.put('9',"wxyz");

        return new ArrayList<String>();
    }
}
