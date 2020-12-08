package ebd.globalUtils.fileHandler;

import java.io.*;

public class FileHandler {

    public static FileReader readConfigurationFile(String filepath) throws IOException {
        // does the path exist: configuration/scenario/
        File file = new File("configuration/" + filepath);

        // search for filename in configuration/scenario/
        if(file.length() == 0) {
            // create directory
            file.getParentFile().mkdir();

            // search in resource stream for filename
            try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath)) {
                if(inputStream == null) {
                    throw new IOException("The stream " + filepath + " could not be found");
                }
                // write file in directory configuration/scenario
                try(FileOutputStream outputStream = new FileOutputStream(file)) {
                    int    length;
                    byte[] buffer = new byte[1024];
                    while((length = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, length);
                    }
                } catch(IOException ioe) {
                    throw new IOException(filepath + " could not be created. " + ioe.getMessage());
                }
            }
        }

        return new FileReader(file);
    }
}
