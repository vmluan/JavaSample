package main.java.com.luanvm.proxy;

/**
 * Created by Admin on 1/19/2017.
 */
public class Cat implements CatService {
    private String name;

    @Override
    public void says(){
        System.out.println("I am cat");
    }

    @Override
    public void says(String message) {
        System.out.println(message);
    }
}
