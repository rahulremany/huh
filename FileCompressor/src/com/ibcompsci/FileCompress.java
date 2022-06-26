package com.ibcompsci;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class FileCompress {

    public static String OUTPUT = "";
    public static String INPUT = "";

    public FileCompress(String input, String output, String name) {
        INPUT = input;
        OUTPUT = output + "/" + name + ".gz";
    }

    public static void fileCompress() {
        byte[] buf = new byte[1024]; // new buffer byte array with a smaller byte size to write file into
        try {
            GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(OUTPUT)); // output stream

            FileInputStream in = new FileInputStream((INPUT)); // input stream


            int size; // size of the read byte
            while((size = in.read(buf)) > 0) { // while the size is equal to the read byte from the buffer
                out.write(buf, 0, size); // write to the buffer with that size
            }

            // close output streams
            in.close();
            out.finish();
            out.close();

            System.out.println("File in directory " + INPUT + " successfully compressed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
