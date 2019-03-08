package site.syso.easy;

/**
 * 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 */
public class ToLowerCase {

    public static void main(String[] args) {
        System.out.println(toLowerCase("abCDeFgsfDFAl"));
    }

    public static String toLowerCase(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char a = str.charAt(i);
            char c = (a >= 'A' && a <= 'Z') ? (char) (a + 32) : a;
            sb.append(c);
        }
        return sb.toString();
    }

}
