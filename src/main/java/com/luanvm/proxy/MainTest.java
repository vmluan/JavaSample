package main.java.com.luanvm.proxy;

/**
 * Created by Admin on 1/19/2017.
 */
public class MainTest {

    public static void main(String[] args){

        Cat cat = new Cat();

        SampleProxy sampleProxy = new SampleProxy();
        Object t= sampleProxy.getWrapperProxy(cat,cat.getClass().getInterfaces()[0]);
        CatService catService = (CatService) t;
        catService.says();
        catService.says("Test AOP with proxy");
        //wrapperCat.says();

    }
}
