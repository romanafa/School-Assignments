import java.util.Scanner;

public class ReadScores {
    public static void main(String[] args) throws Exception{    //we declare "throws Exception" because invoking the constructor new Scanner(File) may throw an I/O exception

        double total = 0;       //initializing with 0, getting new value later as we sum together the scores
        int scoreCount = 0;     //counting how many times score appears to use it for computing of average


        //get the file name from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: ");      //for example relative path to scores: out/production/FileHandling/scores.txt  or absolute path: C:\Users\Expert\IdeaProjects\LearningJava\out\production\FileHandling\scores.txt
        java.io.File file = new java.io.File(input.next());     //creating a File object
        input.close();                                          //closing scanner

        //print out message if file does not exist
        if(file.exists() == false){
            System.out.println("File does not exist.");
            System.exit(1);    //exit code 1 = shutting down the program with expected error (file was not found- as we expected) = "exception error"
        }

        //using try-with-resources
        try(Scanner fileInput = new Scanner(file)){     //reading file with Scanner (book page 504)
            while(fileInput.hasNext()){                 //returns true if the file has more data to read, so the loop will finish when it will return false
                total += fileInput.nextDouble();
                scoreCount++;
            }
        }
        System.out.println("Total score is " + total);
        System.out.printf("Average score is: %.2f", total/scoreCount);
    }
}
