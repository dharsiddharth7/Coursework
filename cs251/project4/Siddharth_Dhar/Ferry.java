import java.util.ArrayList;
import java.util.*;
/**
 * Created by Siddharth on 10/30/17.
 */
public class Ferry {
    public static int count = 0;
    public static int ferryLoading(ArrayList<Integer> arrayList,int lengthFerry) {
        
        int sum1 = 0;
        int leftCount = lengthFerry;
        int i = 0;
        int difference1 = 0;
        int difference2 = 0;
        int index = 0;
        int index2 = 0;
        int sum2 = 0;
        int rightCount = lengthFerry;
        
        while(sum1 <= leftCount && i < arrayList.size()) {
            if(arrayList.get(i) + sum1 > leftCount) {
                difference1 = leftCount - sum1;
                index = i;
                break;
            } else {
                ++count;
                sum1 += arrayList.get(i);
            }
            i++;
        }
        
        while(sum2 <= rightCount && index < arrayList.size()) {
            if (difference1 >= arrayList.get(index)) {
                difference1 -= arrayList.get(index);
                ++count;
                ++index;
            }
            
            if ((arrayList.get(index) + sum2) > rightCount) {
                difference2 = rightCount - sum2;
                index2 = index;
                break;
            } else {
                ++count;
                sum2 += arrayList.get(index);
            }
            index++;
        }
        
        while(arrayList.size() > index2) {
            if(difference1 >= arrayList.get(index2)) {
                difference1 -= arrayList.get(index2);
                ++count;
                ++index2;
                if(difference2 >= arrayList.get(index2)) {
                    difference2 -= arrayList.get(index2);
                    ++count;
                    ++index2;
                }
            }
            if(difference2 >= arrayList.get(index2)) {
                difference2 -= arrayList.get(index2);
                ++count;
                ++index2;
                if(difference1 >= arrayList.get(index2)) {
                    difference1 -= arrayList.get(index2);
                    ++count;
                    ++index2;
                }
            } else {
                break;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int L = Integer.parseInt(args[0]);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int N = StdIn.readInt();
        int i = 0;
        while(i < N) {
            int num = StdIn.readInt();
            arrayList.add(num);
            i++;
        }
        int count = ferryLoading(arrayList,L);
        StdOut.println(count);
        
        //        Scanner sc = new Scanner(System.in);
        //        int N = sc.nextInt();
        //
        //        ArrayList<Integer> arrayList = new ArrayList<>();
        //        int i = 0;
        //
        //        while(i < N) {
        //            int num = sc.nextInt();
        //            arrayList.add(num);
        //            i++;
        //        }
        //
        //        int count = ferryLoading(arrayList,100);
        //        System.out.println(100 + " " + count);
        
        //                ArrayList<Integer> arrayList = new ArrayList<>();
        //                arrayList.add(27);
        //                arrayList.add(16);
        //                arrayList.add(31);
        //                arrayList.add(45);
        //                arrayList.add(36);
        //                arrayList.add(10);
        //                arrayList.add(45);
        //                arrayList.add(25);
        //                arrayList.add(38);
        //                arrayList.add(47);
        //                arrayList.add(8);
        //                arrayList.add(46);
        //                arrayList.add(56);
        //                arrayList.add(55);
        //                arrayList.add(40);
        //                arrayList.add(33);
        //                arrayList.add(43);
        //                arrayList.add(44);
        //                arrayList.add(20);
        //                arrayList.add(50);
        //                arrayList.add(52);
        //                arrayList.add(12);
        //                arrayList.add(33);
        //                arrayList.add(30);
        //                arrayList.add(50);
        //                arrayList.add(18);
        //                arrayList.add(49);
        //                arrayList.add(40);
        //                arrayList.add(51);
        //                arrayList.add(34);
        //                arrayList.add(24);
        //                arrayList.add(12);
        //                arrayList.add(17);
        //
        //
        //                int count = ferryLoading(arrayList,200);
        //                System.out.println(count);
    }
}

