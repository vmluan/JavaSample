package main.java.com.luanvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Admin on 1/18/2017.
 */
public class SampleProxy{
    public class ACLCommonInvocationHandler implements InvocationHandler{
        private Object applicationService; // object need to be wrappered.
        public ACLCommonInvocationHandler(Object applicationService){
            this.applicationService = applicationService;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // Do your business here.
            System.out.println("===================== Do you business here");
            boolean isAllowed = true;
            if (isAllowed) {
                Object object = method.invoke(this.applicationService, args);
                System.out.println("=========================== " +  method.getName() + " is complete");
                return null;
            } else {
                return null;
            }
        }
    }


    public Object getWrapperProxy(Object objectService, Class<?> objectInterfaces){
        Object t = Proxy.newProxyInstance(objectService.getClass().getClassLoader()
                                            ,new Class<?>[]{objectInterfaces}
                                            , new ACLCommonInvocationHandler(objectService));
                ; // params: loader, interfaces, InvocationHandler.
        return t;
    }
}
