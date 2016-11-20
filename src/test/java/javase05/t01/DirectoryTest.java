package javase05.t01;


import javase05.t01.exceptions.*;
import org.junit.Before;
import org.junit.Test;
import utils.Utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static utils.Utils.getAbsoluteTestResourcePath;
import static utils.Utils.getFileSeparator;

public class DirectoryTest {

    private Directory dir;
    private static final char[] cbuf = "Some words written in file\n".toCharArray();
    private static final String separator = getFileSeparator();

    @Before
    public void start() throws IOException{
        dir = new Directory(getAbsoluteTestResourcePath());
        File tempFile = new File(getAbsoluteTestResourcePath() + "FileForDirectoryTest.txt");
        tempFile.createNewFile();
    }

    @Test
    public void getCurPath(){
        String path = dir.getCurPath();
        if (!path.endsWith(separator)){
            path = path + separator;
        }

        assertEquals(getAbsoluteTestResourcePath(),path);
    }

    @Test
    public void printDirectoryContent() throws IOException {
        dir.printFiles();
    }

    @Test(expected = NotDirectoryException.class)
    public void printContentWithinFile() throws IOException{
        dir.open("FileForDirectoryTest.txt");
        dir.printFiles();
    }

    @Test
    public void goToExistentDirectory() throws IOException{
        dir.go("DirForDirectoryTest");
        assertEquals(dir.getCurPath(), Utils.getAbsoluteTestResourcePath("DirForDirectoryTest"));
    }

    @Test(expected = DirectoryNotFoundException.class)
    public void goToNonexistentDirectory() throws IOException{
        dir.go("NonexistentDir");
    }

    @Test(expected = NotDirectoryException.class)
    public void goToFileInsteadOfDirectory() throws IOException{
        dir.go("FileForDirectoryTest.txt");
    }

    @Test
    public void openAndCloseExistentFile() throws IOException{
        try(Directory localDir = dir.open("FileForDirectoryTest.txt")){
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void openNonexistentFile() throws IOException{
        try(Directory localDir = dir.open("NonexistentFile.txt")){
        }
    }

    @Test(expected = FileAlreadyOpenedException.class)
    public void openAlreadyOpenedFile() throws IOException{
        try(Directory localDir = dir.open("FileForDirectoryTest.txt");
        Directory localDir1 = dir.open("FileForDirectoryTest.txt")){

        }
    }

    @Test
    public void writeInFile() throws IOException{
        try(Directory localDir = dir.open("FileForDirectoryTest.txt")) {
            localDir.write(cbuf, 0, cbuf.length);
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(Utils.getAbsoluteTestResourcePath("FileForDirectoryTest.txt")))){
            assertEquals(String.valueOf(cbuf),reader.readLine() + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test(expected = NotBoundedFileException.class)
    public void writeInDirectory() throws IOException {
        dir.write(cbuf,0,cbuf.length);
    }

    @Test (expected = NotBoundedFileException.class)
    public void closeWithinDirectory() throws IOException{
        dir.close();
    }

    @Test(expected = FileNotFoundException.class)
    public void deleteExistentFile() throws IOException{
        dir.delete("FileForDirectoryTest.txt");
        dir.open("FileForDirectoryTest.txt");
    }

    @Test(expected = FileNotFoundException.class)
    public void deleteNonexistentFile() throws IOException{
        dir.delete("NonexistentFile.txt");
    }

    @Test(expected = NotTextFileException.class)
    public void deleteDirectory()throws IOException {
        dir.delete("DirForDirectoryTest");
    }
}
