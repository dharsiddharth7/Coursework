Steps to compile :

javac -cp .:stdlib.jar:algs4.jar PercolationStats.java
javac -cp .:stdlib.jar:algs4.jar Percolation.java
javac -cp .:stdlib.jar:algs4.jar PercolationSlow.java
javac -cp .:stdlib.jar:algs4.jar PercolationVisualizer.java

Steps to run :

java -cp .:stdlib.jar:algs4.jar Percolation < test4.txt
java -cp .:stdlib.jar:algs4.jar Percolation < test5.txt
java -cp .:stdlib.jar:algs4.jar Percolation < test500.txt

Percolation Visualizer

java -cp .:stdlib.jar:algs4.jar PercolationVisualizer < test4.txt
java -cp .:stdlib.jar:algs4.jar PercolationVisualizer < test5.txt
java -cp .:stdlib.jar:algs4.jar PercolationVisualizer < test500.txt

Percolation Simulation 

java -cp .:stdlib.jar:algs4.jar PercolationStats <N, T. type>

ex) java -cp .:stdlib.jar:algs4.jar PercolationStats 500 10 fast




