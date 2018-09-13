package com.my.file;

import java.io.File;

/**
 * Created by kyle on 2018/9/10.
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("");
        System.out.println(file.getAbsolutePath());//F:\ChromeYouTubeDownloads\gupao\workspace\java_topics\javaresources
        System.out.println(System.getProperty("user.dir"));//F:\ChromeYouTubeDownloads\gupao\workspace\java_topics\javaresources


    }
}
