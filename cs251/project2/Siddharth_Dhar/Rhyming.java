import java.util.ArrayList;
import java.lang.*;
import java.util.*;
import edu.princeton.cs.algs4.StdIn;


/**
 * Created by Siddharth on 9/22/17.
 */

public class Rhyming {
    private static int patternLength;

    public static String findSuffix(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return null;
        }
        int length = Math.min(s1.length(), s2.length());
        int i;
        for (i = 0; i < length; i++) {
            if (s1.charAt(s1.length()-i-1) != s2.charAt(s2.length()-i-1)) {
                return s1.substring(s1.length() - i);
            }
        }

        return i == s1.length() ? s1 : i == s2.length() ? s2 : null;
    }

    public static String findPrefix(String s1, String s2){
        if (s1 == null || s2 == null) {
            return null;
        }
        int length = Math.min(s1.length(), s2.length());
        int i;
        for (i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0,i);
            }
        }
        return i == s1.length() ? s1 : i == s2.length() ? s2 : null;
    }

    public static Map<String, ArrayList<String>> rhymingSuffix (ArrayList<String> arrayList) {
        TreeMap<String, TreeSet<String>> treeMap = new TreeMap<>((a, b) -> {
            if (a.length() != b.length()) return Integer.compare(a.length(), b.length());
            return a.compareTo(b);
        });

        ArrayList<String> newArrayList = new ArrayList<String>();
        newArrayList = reverseList(arrayList);

        for (int i = 0; i < newArrayList.size(); i++) {
            String str1 = arrayList.get(i);
            for (int j = i+1; j < newArrayList.size(); j++) {
                String str2 = arrayList.get(j);
                String suffix = findSuffix(str1, str2);
                if (suffix.length() != 0) {
                    TreeSet<String> treeSet = treeMap.getOrDefault(suffix, new TreeSet<>());
                    //TreeSet<String> treeSet = endsWith(arrayList,suffix);
                    if (treeSet.contains(str1) == false) {
                        treeSet.add(str1);
                        //String result1 = putLineAfter(str1,suffix);
                        //treeSet.add(result1);
                    }
                    if (treeSet.contains(str2) == false) {
                        treeSet.add(str2);
                        //String result2 = putLineAfter(str2,suffix);
                        //treeSet.add(result2);
                    }
                    treeMap.put(suffix, treeSet);
                }
            }
        }

        HashMap<String,ArrayList<String>> newMap = new HashMap<>();

        for(Map.Entry<String, TreeSet<String>> entry : treeMap.entrySet())
        {
            String key = entry.getKey();
            int keyLength = key.length();

            ArrayList<String> newVal = new ArrayList<>();
            newVal.addAll(entry.getValue());

            for(int i=0; i<newVal.size();i++)
            {
                String val = newVal.get(i);
                if(val.substring(val.length()-keyLength).equals(key))
                {
                    newVal.set(i, val.substring(0,val.length()-keyLength) + "|" + val.substring(val.length()-keyLength));
                }

                newMap.put(key,newVal);
            }

        }

        Map<String, ArrayList<String>> d = new TreeMap<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        if (s1.length() < s2.length())
                            return -1;
                        else if (s1.length() > s2.length())
                            return 1;
                        else
                            return s1.compareTo(s2);
                    }
                });
        d.putAll(newMap);

        for(Map.Entry look :    d.entrySet())
        {
            StdOut.println(look.getValue());
        }



        return d;
    }

    public static TreeSet<String> endsWith(List<String> set, String pattern) {
        TreeSet<String> treeSet = new TreeSet<>();
        patternLength = pattern.length();
        int counter = 0;
        for(int i = 0; i < set.size(); i++) {
            if(set.get(i).endsWith(pattern)) {
                String newWord = putLineAfter(set.get(i),pattern);
                treeSet.add(newWord);
                counter++;
            }
        }

        if(counter > 0) {
            return treeSet;
        } else {
            treeSet.clear();
        }
        return treeSet;
    }

    public static String putLineAfter(String word, String pattern) {
        int patterLength = pattern.length();
        String newWord = "";
        newWord = word.substring(0,word.length()-patterLength) + "|" + pattern;
        return newWord;
    }

    public static ArrayList<String> reverseList(List<String> words) {
        String[] t = new String[words.size()];
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < words.size(); i++) {
            StringBuilder sb = new StringBuilder(words.get(i));
            arrayList.add(sb.reverse().toString());
        }
        return arrayList;
    }


    public static void main(String[] args) {

        /**
         ArrayList<String> arrayList = new ArrayList<>();
         arrayList.add("electrics");
         arrayList.add("ethnic");
         arrayList.add("clinic");
         arrayList.add("coughed");
         arrayList.add("laughed");
         arrayList.add("metrics");

         TreeMap<String,TreeSet<String>> treeMap = new TreeMap<>();
         treeMap = rhymingSuffix(arrayList);

         Collection c = treeMap.values();
         Iterator itr = c.iterator();
         while(itr.hasNext()) {
         System.out.println(itr.next());
         }
         **/

        Rhyming rhyming = new Rhyming();
        Map<String, ArrayList<String>> treeMap = new TreeMap<>();

        ArrayList<String> arrayList = new ArrayList<String>();

        while(!StdIn.isEmpty())
        {
            String str = StdIn.readString();
            arrayList.add(str);
        }

        treeMap = rhyming.rhymingSuffix(arrayList);
        Collection c = treeMap.values();
        Iterator itr = c.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        }
    }

}
