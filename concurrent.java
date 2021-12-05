/*
 * Implement a parallel array sum, and compare performance with single thread sum. 
 * This is not an easy assignment 
 * – just do as much as you can and turn in what you have for partial credit.

Make an array of 200 million random numbers between 1 and 10. 
Compute the sum in parallel using multiple threads. Then compute the sum 
with only one thread, and display the sum and times for both cases.
 */
import java.util.Random;

class Sum extends Thread {
 int[] arr;
 int low, high, partial;

public Sum(int[] arr, int low, int high){

this.arr = arr;
this.low = low;
this.high = Math.min(high, arr.length);

}
public int Single(){
return partial;
}

public void run(){

partial = sum(arr, low, high);

}

public static int sum(int[] arr){

return sum(arr, 0, arr.length);

}

public static int sum(int[] arr, int low, int high){

int total = 0;
for (int i = low; i < high; i++) {
total += arr[i];

}

return total;

}

public static int parallel(int[] arr)
{
return parallel(arr, Runtime.getRuntime().availableProcessors());
}

public static int parallel(int[] arr, int threads)

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
catch (InterruptedException e) { }

int total = 0;

for (Sum sum : sums) {
total += sum.Single();

}

return total;

}

}
public class concurrent {
public static void main(String[] args){

Random rand = new Random();
int[] arr = new int[200000000];
for (int i = 0; i < arr.length; i++) {
arr[i] = rand.nextInt(10) + 1;

}

long start = System.nanoTime();

System.out.println(Sum.sum(arr));
System.out.println("Single: " + (System.nanoTime() - start));
start = System.nanoTime();

System.out.println(Sum.parallel(arr));
System.out.println("Parallel: " + (System.nanoTime() - start));


}

}