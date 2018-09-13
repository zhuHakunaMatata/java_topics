package com.my.file;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kyle on 2018/9/10.
 */
public class PropertiesDemo {
    //classloader :
    public static void main(String[] args) throws Exception{

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String appName = properties.getProperty("spring.application.name");
        System.out.println(appName);

    }

    //hard code : absolute path
    public static void main1(String[] args) throws Exception{
        File propertiesFile = new File("F:\\ChromeYouTubeDownloads\\gupao\\workspace\\java_topics\\javaresources\\src\\main\\resources\\application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(propertiesFile));
        String appName = properties.getProperty("spring.application.name");
        System.out.println(appName);

    }
}
