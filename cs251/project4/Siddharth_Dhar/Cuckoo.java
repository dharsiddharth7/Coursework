import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.List;

public class Cuckoo{

    public static int n;
    public static boolean verbose;
    public static double h1 = 0;
    public static double h2 = 0;
    public static int maxLoop = 0;
    public static List<Object> keyList = new ArrayList<>();
    public static List<Object> valueList = new ArrayList<>();
    public static Key hashTable[];
    public static double epsilon = 0.05;
    public static int r;


    public Cuckoo(double h1, double h2){
        this.h1 = h1;
        this.h2 = h2;
        r = 256;
        hashTable = new Key[r];
        StdOut.printf("(hash %.0f %.0f %d)%n", h1, h2,r);
    }

    public int size(){
        StdOut.println(n);
        return n;
    }

    public static void verbose(boolean x){
        verbose = x;
    }

    public static void put(Object key, Object value){

    }


    public static void rehashing() {
        r = r * 2;
        n = 0;
        Key[] temp1 = hashTable;
        Key[] temp2 = new Key[r];
        hashTable = temp2;
        for(int i = 0; i< temp1.length;i++){
            if(temp1[i] != null) {
                put(temp1[i].keyId, temp1[i].value);
            }
        }

    }

    public static void main(String[] args) {

    }

}