package edu;

import java.io.*;

public class FileReader{
    public BufferedReader getBufferedReader(String filename) throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputstrem = classloader.getResourceAsStream(filename);
        InputStreamReader inputstreamreader = new InputStreamReader(inputstrem);
        BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
        return bufferedreader;
    }
}