package listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {


    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
//        System.out.println("增加了一个Request属性");
//        System.out.println("属性是" + servletRequestAttributeEvent.getName());
//        System.out.println("值是" + servletRequestAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
//        System.out.println("Request移除属性");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
//        System.out.println("Request替换属性");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
//        System.out.println("销毁了一个Request");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
//        System.out.println("创建了一个Request");
    }
}
