package com.gowhich.androidsdcard;

import android.content.Context;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by durban126 on 16/9/14.
 */
public class FileService {

    private Context context;

    public FileService(Context context){
        this.context = context;
    }

    public FileService(){

    }

    public String getContentFromSDCard(String fileName){
        FileInputStream inputStream = null;

        //缓冲区，与磁盘无关，不需要关闭
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        File file = new File(Environment.getExternalStorageDirectory(), fileName);

        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            try {
                inputStream = new FileInputStream(file);
                int len = 0;
                byte[] data = new byte[1024];

                while ((len = inputStream.read(data)) != -1){
                    outputStream.write(data, 0, len);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return new String(outputStream.toString());
    }

    public boolean saveContentToSDCard(String filename, String content){

        boolean flag = false;

        FileOutputStream outputStream = null;

        File file = new File(Environment.getExternalStorageDirectory(), filename);

        //判断SDCard是否可用
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            try {
                outputStream = new FileOutputStream(file);
                outputStream.write(content.getBytes());
                flag = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(outputStream != null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return flag;
    }
}
