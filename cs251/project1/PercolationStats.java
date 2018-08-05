/**
 * Created by Siddharth on 9/9/17.
 */
public class PercolationStats {
    private double[] array;
    private double[] time;
    private int counter;
    private int T;
    private int N;
    private String type;
    private double mean;
    private double stddev;
    private double timeStddev;
    private double timeMean;

    public static boolean validateArguements(int T, int N) {
        return T >= 0 && N >= 0;
    }

    public PercolationStats(int T, int N, String type) {
        this.T = T;
        this.N = N;
        array = new double[this.T];
        time = new double[this.T];
        if(validateArguements(T,N)) {
            if (type.equalsIgnoreCase("fast")) {
                for (int i = 0; i < this.T; i++) {
                    Stopwatch stopwatch = new Stopwatch();
                    Percolation percolation = new Percolation(N);
                    int counter = 0;
                    while (percolation.percolates() == false) {
                        int row = StdRandom.uniform(this.N);
                        int col = StdRandom.uniform(this.N);
                        if (percolation.isOpen(col,row) == false) {
                            counter++;
                        }
                        percolation.open(col,row);
                    }
                    array[i] = (double) counter / (double)(this.N * this.N);
                    time[i] = stopwatch.elapsedTime();
                }
            } else if (type.equalsIgnoreCase("slow")) {
                for (int i = 0; i < this.T; i++) {
                    Stopwatch stopwatch = new Stopwatch();
                    PercolationSlow percolation = new PercolationSlow(N);
                    int counter = 0;
                    while (percolation.percolates() == false) {
                        int row = StdRandom.uniform(this.N);
                        int col = StdRandom.uniform(this.N);
                        if (percolation.isOpen(col,row) == false) {
                            counter++;
                        }
                        percolation.open(col,row);
                    }
                    array[i] = (double) counter / (double)(this.N * this.N);
                    time[i] = stopwatch.elapsedTime();
                }
            } else {

            }
        }
    }
    public double mean() {
        return StdStats.mean(array);
    }

    public double stddev() {
        return StdStats.stddev(array);
    }
    public double timeMean() {
        return StdStats.mean(time);
    }

    public double timeStddev() {
        return StdStats.stddev(time);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        String type = args[2];
        Stopwatch stop = new Stopwatch();

        PercolationStats stats = new PercolationStats(T,N,type);
        StdOut.println("mean threshold = " + stats.mean());
        StdOut.println("std dev = " + stats.stddev());
        StdOut.println("time = " + stop.elapsedTime());
        StdOut.println("mean time = " + stats.timeMean());
        StdOut.println("stddev time = " + stats.timeStddev());
    }
}
