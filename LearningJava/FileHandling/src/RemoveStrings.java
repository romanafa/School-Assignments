import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveStrings {
    public static void main(String[] args) throws Exception {

        //String[] args should have two commands - check if it is true (in cmd)
        if (args.length != 2) {
            System.out.println("Usage: java RemoveStrings stringToBeRemoved sourceFile");
            System.exit(1);
        }


        //check if source file exists, if it does not, finish the program (bok side 507)
        File sourceFile = new File(args[1]);
        if (!sourceFile.exists()){
            System.out.println("Source file " + args[1] + " does not exist.");
            System.exit(2);
        }

        //using scanner to read file and save the original text as string, so it can write the text back after removing
        Scanner readFile = new Scanner(new FileReader(sourceFile));
        StringBuilder inFile = new StringBuilder();
        while(readFile.hasNext()){
            inFile.append(readFile.next());
        }
        readFile.close();
        String originalFile = inFile.toString();


        ArrayList<String> string2 = new ArrayList<>();
        //create input and output files
        try(
                Scanner input = new Scanner(sourceFile)
                ){
            while(input.hasNext()){  //hasNext() returns true if scanner has more data to be read
                String string1 = input.nextLine();
                string2.add(removeString(args[0], string1));
                if (string1.contains(args[0])){  //check if string we want to remove is in the file to get message printed
                    System.out.println("Reading and removing string from file\n" + "Done!");
                }
            }
        }
        catch (Exception e1){
            System.out.println("Exception");
        }

        try(
                PrintWriter output = new PrintWriter(sourceFile)
                ){
            for (int i = 0; i < string2.size(); i++){
                output.println((string2.get(i)));
            }
            if (originalFile.contains(args[0])){
                output.write(args[0]); // Write text back to the file
                System.out.println("Writing back to file\n" + "Done!");
            }
        }
        catch (Exception e2){
            System.out.println("Exception occurred.");
        }
    }

    //removeString method
    public static String removeString(String string, String line){
        StringBuilder stringBuilder = new StringBuilder(line);
        int indexStart = stringBuilder.indexOf(string);
        int indexEnd = string.length();

        while (indexStart >= 0){
            indexEnd = indexStart + indexEnd;
            stringBuilder = stringBuilder.delete(indexStart, indexEnd);
            indexStart = stringBuilder.indexOf(string, indexStart);
        }
        return stringBuilder.toString();

    }


}
