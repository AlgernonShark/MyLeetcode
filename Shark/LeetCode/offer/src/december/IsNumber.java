package december;

public class IsNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0 ) return false;

        s = s.trim();

        // 判断数字
        boolean numFlag = false;
        // 存放.是否出现过
        boolean dotFlag = false;
        // 存放e/E是否出现过
        boolean eFlag = false;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // 判断数字
            if (c >= '0' && c <= '9') numFlag = true;
            // 判断小数点.：只出现一次，前面不能有.和e/E
            else if (c == '.' && !dotFlag && !eFlag) numFlag = true;
            // 判断e/E : 只出现一次，前面不能有e，前面必须有数字，后面也必须有数字
            else if ((c == 'e' || c == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;
            }
            // 判断+-:首位或者前一位必须是e/E
            else if ((c == '+' || c == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {}

            else return false;

        }
        return numFlag;

    }
}
