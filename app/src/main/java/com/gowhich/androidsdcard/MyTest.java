package com.gowhich.androidsdcard;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by durban126 on 16/9/14.
 */
public class MyTest extends AndroidTestCase {

    private final String TAG = "MyTest";

    public MyTest(){

    }

    public void saveFile(){
        Context context = getContext();
        FileService fileService  = new FileService(context);
        boolean flag = fileService.saveContentToSDCard("hello.txt","你好");
        Log.i(TAG,"----->" + flag);
    }
}
