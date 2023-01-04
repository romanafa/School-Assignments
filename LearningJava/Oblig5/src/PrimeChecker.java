//Prime number - divisible only by its self


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeChecker {
    private long number = 9223372036854775783L;
    private int numberOfThreads = 10;
    private boolean isPrime;    //Variable used to define whether or not the number is a prime.
    private long[] startValues;    //Array telling threads where to start checking if number is prime.
    private long[] endValues;   //Array telling threads where to stop checking if number is prime.
    private ExecutorService pool;   //Used to set up all threads and run them when needed ExecutorService


    public static void main(String[] args){
        PrimeChecker  checkPrime = new PrimeChecker ();
    }

    private PrimeChecker () {
        init();
        long startTime;

        //region Multi-thread
        startTime = System.currentTimeMillis();
        System.out.println("Checking if " + number + "  is a prime number, multithreaded");
        runThreads();
        while (!pool.isTerminated()); // Wait for threads to finish
        System.out.printf("%s is%sa prime number. \nExecution time: %s ms. \n\n", number, isPrime ? " " : " not ", System.currentTimeMillis() - startTime);


        //region Single-thread
        startTime = System.currentTimeMillis();
        System.out.println("Checking if " + number + "is a prime number, singlethreaded.");
        System.out.printf("%s is%sa prime number. \nExecution time: %s ms.", number, singlethreadedPrimeCheck() ? " " : " not ", System.currentTimeMillis() - startTime);
    }


    private void init(){    //Initializes the multiple threads and their division of work loads.
        startValues = new long[numberOfThreads];
        endValues = new long[numberOfThreads];
        pool = Executors.newFixedThreadPool(numberOfThreads);
        long iterator = (long)(Math.sqrt(number) / numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            if (i == 0) {
                startValues[i] = 3;
                endValues[i] = startValues[i] + iterator;
            } else {
                startValues[i] = endValues[i - 1] + 1;
                endValues[i] = startValues[i] + iterator;
            }
        }
    }


    private void runThreads(){      //Runs threads that check for primarity of specified number.
        try {
            for (int i = 0; i < numberOfThreads; i++)
                pool.execute(new PrimeTask(number, startValues[i], endValues [i]));
        } catch (Exception ex) {
            System.out.println("Error.");
        }
    }

    private void notPrime(){
        pool.shutdown();
        isPrime = false;
    }

    private boolean singlethreadedPrimeCheck() { //Singlethraded prime checking algorithm, same as the one used in multithreaded approach.
        if (number % 2 == 0)
            return false;
        for (long i = 3; i <= Math.sqrt(number); i = i+2)
            if (number % i == 0)
                return false;
        return true;
    }



    class PrimeTask implements Runnable {
        private long number;
        private long startValue;
        private long endValue;

        PrimeTask(long number, long startValue, long endValue){
            this.number = number;
            this.startValue = startValue;
            this.endValue = endValue;
        }

        public void run() {
            if (number % 2 == 0)
                notPrime();
            for (long i = startValue; i <= endValue; i = i+2)
                if (number % i == 0)
                    notPrime();
            if (endValue == endValues[numberOfThreads - 1]) {
                pool.shutdown();
                isPrime = true;
            }
        }
    }
}