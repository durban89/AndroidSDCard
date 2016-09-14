package com.gowhich.androidsdcard;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    private final String TAG = "MyTest";

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void saveFile(){
//        Context context = getContext();
        FileService fileService  = new FileService();
        boolean flag = fileService.saveContentToSDCard("hello.txt","你好");
        Log.i("MyTest", "----->" + flag);
    }
}