package javabootcamp.helloworld;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author samirkrishna on 15-08-2022
 * @project JavaBootCamp
 */
public class Strings {
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Strings.reverseString(input);

        Strings.reverseSentenceWithPreserve(input);

        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        System.out.println(Strings.isAnagram(input1,input2));

        System.out.println(Strings.isPangarm(input));

        Strings.countSpecialChars(input);
    }

    private static void countSpecialChars(String input) {
        int count =0;
        for (Character ch:input.toCharArray()) {
            if(!((ch>=65 && ch<=90) || (ch>=97 && ch<=122) || (ch>=48 && ch<=57))){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPangarm(String input) {
        HashMap<Character,Integer> map = new HashMap<>();
        final int alphabets = 26;
        int count =0;
        for (Character ch:input.toCharArray()) {
            if(map.containsKey(ch) && ((ch>=65 && ch<=90) || (ch>=97 && ch<=122) ))
                map.put(ch,map.get(ch));
            else if((ch>=65 && ch<=90) || (ch>=97 && ch<=122))
                map.put(ch,1);
        }
        for (Map.Entry<Character,Integer> entry :map.entrySet()) {
            count++;
        }
        if(count==alphabets){
            return true;
        }
        return false;
    }

    private static boolean isAnagram(String input1, String input2) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (Character ch:input1.toCharArray()) {
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }

        for (Character ch:input2.toCharArray()) {
            if(map.containsKey(ch) && map.get(ch)>0){
                map.put(ch,map.get(ch)-1);
            }else{
                return false;
            }
        }
        return true;
    }

    private static void reverseSentenceWithPreserve(String input) {
        String arr[] = input.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String str:arr) {
            sb.append(reverseString(str)+" ");
        }
        System.out.println(sb);
    }

    private static String reverseString(String input) {
        StringBuffer sb = new StringBuffer();
        for(int i=input.length()-1;i>=0;i--){
            sb.append(input.charAt(i));
        }
        //System.out.println(sb);
        return sb.toString();
    }
}
