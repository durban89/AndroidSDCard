package com.gowhich.androidsdcard;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.util.Log;
import org.junit.Test;

import java.io.File;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void saveFile(){
        Context context = getContext();
        FileService fileService  = new FileService(context);
        boolean flag = fileService.saveContentToSDCard("hello.txt","你好");
        Log.i("MyTest","----->" + flag);
    }

    @Test
    public void readFile(){
        Context context = getContext();
        FileService fileService = new FileService(context);
        String str = fileService.getContentFromSDCard("hello.txt");
        Log.i("MyTest","----->" + str);
    }
}