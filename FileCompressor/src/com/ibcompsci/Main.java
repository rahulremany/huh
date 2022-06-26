package com.ibcompsci;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean processFinished = false;
        while (!processFinished) {
            System.out.println("Do you want to compress or decompress? Type 'D' to decompress, and 'C' to compress.");
            Scanner s = new Scanner(System.in);
            String decision = s.next();
            decision = decision.toLowerCase(Locale.ROOT);
            if (decision.equals("c")) {
                System.out.println("Enter the path of the file you want to compress:");
                Scanner s1 = new Scanner(System.in);
                String inputPath = s1.next();
                System.out.println("Enter the path where you want to send the compressed file (don't include the name yet):");
                Scanner s2 = new Scanner(System.in);
                String outputPath = s2.next();
                System.out.println("Enter what you want as the name of the new file:");
                Scanner s3 = new Scanner(System.in);
                String name = s3.next();


                FileCompress f = new FileCompress(inputPath, outputPath, name);
                f.fileCompress();

                processFinished = true;
            } else if (decision.equals(("d"))) {
                System.out.println("Enter the path of the file you want to decompress:");
                Scanner s1 = new Scanner(System.in);
                String inputPath = s1.next();
                System.out.println("Enter the path where you want to send the decompressed file (don't include the name yet):");
                Scanner s2 = new Scanner(System.in);
                String outputPath = s2.next();
                System.out.println("Enter what you want as the name of the new file:");
                Scanner s3 = new Scanner(System.in);
                String name = s3.next();
                System.out.println("What file type will the decompressed file be? (use the abbreviation, i.e. '.docx'");
                Scanner s4 = new Scanner(System.in);
                String type = s4.next();

                FileDecompress f = new FileDecompress(inputPath, outputPath, name, type);
                f.fileDecompress();

                processFinished = true;
            } else {
                System.out.println("Invalid key entered, please try again");
            }
        }
    }
}
