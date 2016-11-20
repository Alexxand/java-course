package javase05.t01;


import javase05.t01.exceptions.*;
import javase05.t01.exceptions.FileNotFoundException;

import java.io.*;
import java.util.Arrays;

import static utils.Utils.getAbsoluteResourcePath;
import static utils.Utils.getFileSeparator;


public class Directory implements Closeable{

    private File file;
    private Writer writer = null;
    private static final String separator = getFileSeparator();


    public Directory(){
        this(getAbsoluteResourcePath());
    }

    public Directory(String path){
        file = new File(path);
    }

    public void printFiles() throws NotDirectoryException {
        String[] list = file.list();
        if (list == null){
            throw new NotDirectoryException();
        }
        Arrays.asList(list).forEach(System.out::println);
    }

    public String getCurPath(){
        return file.getPath();
    }

    public void go(String path) throws DirectoryNotFoundException, NotDirectoryException{
        File tempFile = new File(file.getPath() + separator + path);
        if (!tempFile.exists()){
            throw new DirectoryNotFoundException();
        }
        if (!tempFile.isDirectory()){
            throw new NotDirectoryException();
        }
        file = tempFile;
    }


    public Directory open(String fileName) throws FileNotFoundException, FileAlreadyOpenedException {
        if (writer != null)
            throw new FileAlreadyOpenedException();

        File tempFile = new File(file.getPath() + separator + fileName);
        if (!tempFile.exists()){
            throw new FileNotFoundException();
        }

        try{
            writer = new FileWriter(tempFile);
        } catch (IOException e){
            throw new FileNotFoundException();
        }

        file = tempFile;
        return this;
    }

    public void write(char cbuf[], int off, int len) throws NotBoundedFileException {
        if (writer == null)
            throw new NotBoundedFileException();

        try {
            writer.write(cbuf, off, len);
        } catch(IOException e){

        }
    }

    public void close() throws NotBoundedFileException{
        if (writer == null)
            throw new NotBoundedFileException();
        try{
            writer.close();
        } catch(IOException e){

        }
        writer = null;

    }

    public void delete(String fileName) throws FileNotFoundException, NotTextFileException{
        File tempFile = new File(file.getPath() + separator + fileName);
        if (!tempFile.exists())
            throw new FileNotFoundException();
        if (!tempFile.isFile())
            throw new NotTextFileException();
        tempFile.delete();
    }

}
