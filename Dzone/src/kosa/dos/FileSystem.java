package kosa.dos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 
public class FileSystem {

	 

    private File presentDirFile = new File("C:\\Mission\\");

    

    public void fileListPrint(){

        File[] fileList = presentDirFile.listFiles();

        

        for(int i = 0; i < fileList.length; i++){

            if(fileList[i].isDirectory()){

                System.out.println(fileList[i].getName()+"\t<DIR>");

            }else{

                System.out.println(fileList[i].getName()+"\t<FILE>");

            }

        }

    }

    

    public void moveDir(String dest){

        File[] fileList = presentDirFile.listFiles();

        File destFile = new File(presentDirFile, dest);

        for(int i = 0; i < fileList.length; i++){

            if(fileList[i].getPath().equals(destFile.getPath())){

                presentDirFile = destFile;

                return;

            }

        }

        System.out.println("해당파일 목록에 존재하지 않음");

    }

    

    

    public void moveSuperDir(){

        

        String presentPath = presentDirFile.getPath();

        int presentNameSize = presentDirFile.getName().length();

        

        String superPath = presentPath.substring(0, presentPath.length()-presentNameSize);

        

        presentDirFile = new File(superPath);

    }

    

    public void makeDir(String newDirName){

        File newDir = new File(presentDirFile, newDirName);

        File[] fileList = presentDirFile.listFiles();

        

        for(int i = 0; i < fileList.length; i++){

            if(fileList[i].getPath().equals(newDir.getPath())){

                System.out.println("똑같은 이름의 파일이 존재 합니다.");

                return;

            }

        }

        newDir.mkdir();

    }

    

    

    public void copy(String sorceStr){

        if(sorceStr.lastIndexOf("\\") == -1){

            return;

        }

        

        String destStr = sorceStr.substring(sorceStr.lastIndexOf("\\")+1);

        File sourceFile = new File(presentDirFile, sorceStr);

        File dest = new File(presentDirFile, destStr);

        

        copyAllFile(sourceFile, dest);

    }

    

    

    public void copyAllFile(File sourceFile, File dest){

        if(sourceFile.isFile()){

            File destFile = new File(dest, sourceFile.getName());

            copyFile(sourceFile, destFile);

            return;

        }

        

        File[] fileList = sourceFile.listFiles();

        dest.mkdir();

        

        for(int i = 0; i < fileList.length; i++){

            if(fileList[i].isDirectory()){

                File destDir = new File(dest, fileList[i].getName());

                copyAllFile(fileList[i], destDir);

            }else{

                File destFile = new File(dest, fileList[i].getName());

                copyFile(fileList[i], destFile);

            }

            

        }

    }

    

    public void copyFile(File sourceFile, File dest){

        FileInputStream fis = null;

        FileOutputStream fos = null;

        try {

            fis = new FileInputStream(sourceFile);

            fos = new FileOutputStream(dest);

            

            byte[] arrByte = new byte[5000];

            

            while((fis.read(arrByte)) != -1){

                fos.write(arrByte);

            }

        } catch (IOException e) {

            e.printStackTrace();

            System.out.println("해당 파일이 존재하지 않습니다");

        }finally {

            try {

                if(fis != null){

                    fis.close();

                }

                if(fos != null){

                    fos.close();

                }

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

 

    public File getPresentDirFile() {

        return presentDirFile;

    }

 

    public void setPresentDirFile(File presentDirFile) {

        this.presentDirFile = presentDirFile;

    }

}

 