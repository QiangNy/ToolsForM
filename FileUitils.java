package com.cylan.cloud.oem;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by chen on 16-10-12.
 */
public class FileUitils {
    private String SDPATH;

    public String getSDPATH() {
        return SDPATH;
    }

    public FileUitils() {
        SDPATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * 在sdcard创建文件
     */
    public File createSDFile(String filenamel) throws IOException {
        File file = new File(SDPATH + filenamel);
        file.createNewFile();
        return file;
    }

    /*
    * 在sdcard创建目录
    * */
    public File createSDDir(String dirName) {
        File dir = new File(SDPATH + dirName);
        dir.mkdir();
        return dir;
    }

    /*判断sdcard文件夹是否存在*/
    public boolean isFileExist(String fileName) {
        File file = new File(SDPATH + fileName);
        return file.exists();
    }

    /*将一个InputStream里面的数据写入到sdcard中*/
    public File write2SDFromInput(String path, String fileName, InputStream input) throws IOException {
        File file = null;
        OutputStream output = null;
        try {
            createSDDir(path);
            File f = createSDFile(path + fileName);
            output = new FileOutputStream(f);
            byte buffer[] = new byte[1024 * 4];
            while ((input.read(buffer)) != -1) {
                output.write(buffer);
            }
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
