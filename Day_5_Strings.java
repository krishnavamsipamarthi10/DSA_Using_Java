import java.util.Arrays;
import java.util.HashMap;

class StringBasedProblems{

    //Q1 Reverse a String 

    public static String ReverseStr(String a){
        char[] s =a.toCharArray();
        int st=0,end=s.length-1;
        while(st<end){
            char temp = s[st];
            s[st]=s[end];
            s[end] = temp;
            st++;
            end--;
        }
        return new String(s);
    }

    // Q2 String palindrome

    public static boolean Palindrome(String str){
        char[] a = str.toCharArray();
        int st=0,end=a.length-1;
        while(st<end){
            if(a[st] != a[end]){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

    //Q3 count of characters digits spaces

    public static void CountChars(String s){
        int vow =0,con=0,dig=0,sp=0;
        for(int i=0;i<s.length();i++){
            char ch = Character.toLowerCase(s.charAt(i));

            if(Character.isLetter(ch)){
                if("aeiou".indexOf(ch) != -1){
                    vow++;
                }else con++;
            }
            else if(Character.isDigit(ch)) dig++;
            else if (Character.isSpaceChar(ch)) sp++;

        }
        System.out.println("Vowels: "+vow+"  Consonants: "+con+" Digits: "+dig+" Spaces: "+sp);
    }

    //Q4 Non Repeating characters
    public static void NonRepeatingChars(String s){
        HashMap<Character,Integer> mp = new HashMap<>();

        for(char ch : s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        for(char ch:s.toCharArray()){
            if(mp.get(ch)==1){
                System.out.print(ch+" ");
            }
        }
    }

    //Q5 Anagrams

    public static boolean isAnagram(String s1,String s2){
        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();

        if(s1.length() != s2.length()) return false;

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
    public static void main(String args[]){
        //Q1
        //System.out.print(ReverseStr("lbrce"));


        //Q2
        //System.out.print(Palindrome("level"));

        //Q3
        //CountChars("Hello 123");

        //Q4
        //NonRepeatingChars("mylavaram");

        //Q5
        System.out.println(isAnagram("heart","earth"));
    }
}
