package com.ibcompsci;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class FileDecompress {
    public static String INPUT = "";
    public static String OUTPUT = "";

    public FileDecompress(String input, String output, String name, String type) {
        INPUT = input;
        OUTPUT = output+ "/" + name + type;
    }

    public static void fileDecompress() {
        byte[] buf = new byte[1024]; // new buffer byte array with a smaller byte size to write file into

        try {
            GZIPInputStream in = new GZIPInputStream(new FileInputStream(INPUT)); // input stream
            FileOutputStream out = new FileOutputStream((OUTPUT)); // output stream

            int size; // size of the read byte
            while((size = in.read(buf)) > 0) { // while the size is equal to the read byte from the buffer
                out.write(buf, 1, size); // write to the buffer with that size
            }

            // close the streams
            out.close();
            in.close();

            System.out.println("File at directory " + INPUT + " was successfully decompressed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
