
import java.util.Random;

class Sum extends Thread {
 int[] array;
 int low, high, partial;

public Sum(int[] arr, int low, int high)

{

this.array = array;
this.low = low;
this.high = Math.min(high, arr.length);

}

public int Single()

{

return partial;

}

public void run()

{

partial = sum(array, low, high);

}

public static int sum(int[] arr)

{

return sum(arr, 0, arr.length);

}

public static int sum(int[] arr, int low, int high)

{

int total = 0;

for (int i = low; i < high; i++) {

total += arr[i];

}

return total;

}
/*
public static int parallelSum(int[] arr)

{

return parallelSum(arr, Runtime.getRuntime().availableProcessors());

}

public static int parallelSum(int[] arr, int threads)

{

int size = (int) Math.ceil(arr.length * 1.0 / threads);

Sum[] sums = new Sum[threads];

for (int i = 0; i < threads; i++) {

sums[i] = new Sum(arr, i * size, (i + 1) * size);

sums[i].start();

}

try {

for (Sum sum : sums) {
sum.join();
}

} 
catch (Exception e) { }

int total = 0;
for (Sum sum : sums) {
total += sum.Single();

}

return total;

}*/

}

public class concurrent {

public static void main(String[] args)

{

Random rand = new Random();
int[] arr = new int[200000000];
for (int i = 0; i < arr.length; i++) {
arr[i] = rand.nextInt(10) + 1;

}

long start = System.nanoTime();

System.out.println(Sum.sum(arr));
System.out.println("Single: " + (System.nanoTime() - start));
start = System.nanoTime();
//System.out.println(Sum.parallelSum(arr));
//System.out.println("Parallel: " + (System.currentTimeMillis() - start));

}

}