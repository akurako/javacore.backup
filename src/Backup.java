import java.io.*;

public class Backup {

    public void BackupFolder(String source, String dest) {
        String[] fileList;
        int fileCount = 0;
        File sourceFolder = new File(source);
        File destFolder = new File(dest);
        if (sourceFolder.exists() == true) {
            destFolder.mkdir();
            fileList = sourceFolder.list();
            System.out.println("Staring backup of "+source+ " folder.");
            while (fileCount < fileList.length) {
                copyFile(source+"/"+fileList[fileCount],dest+"/"+fileList[fileCount]);
                fileCount ++ ;

            }
        } else {
            System.out.println("Folder " + source + " does not exists.");

        }
    }
    public void copyFile (String source, String dest){

        File sourceFile;
        File destFile;
        FileInputStream fis;
        FileOutputStream fos;
        int buffer;

        sourceFile = new File(source);
        destFile = new File(dest);

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);
            while ((buffer = fis.read()) != -1 ) {
                fos.write(buffer);
            }
            System.out.println("File "+sourceFile.getName() + " copied successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
