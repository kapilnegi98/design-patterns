package designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kapil Negi
 */

interface FileSystem{
    public void ls();
}
class File implements FileSystem{
    String fileName;
    File(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void ls() {
        System.out.println("File:" + fileName);
    }
}
class Directory implements  FileSystem{
    String directoryName;
    List<FileSystem> fileSystemList;
    Directory(String directoryName){
        this.directoryName = directoryName;
        fileSystemList = new ArrayList<>();
    }
    public void add(FileSystem fileSystem){
        fileSystemList.add(fileSystem);
    }
    @Override
    public void ls() {
        System.out.println("Directory: " + directoryName);
        for(FileSystem fileSystem : fileSystemList){
            fileSystem.ls();
        }
    }
}
public class CompositePattern {
    public static void main(String args[]) {

        Directory movieDirectory = new Directory("Movie");

        FileSystem border = new File("Border");
        movieDirectory.add(border);

        Directory comedyMovieDirectory = new Directory("ComedyMovie");
        File hulchul = new File("Hulchul");
        comedyMovieDirectory.add(hulchul);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();
    }
    }
