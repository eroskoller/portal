/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author eros
 */
@WebListener
public class SessionCounter implements HttpSessionListener {

    private static int count;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
//        System.out.println("session created: " + event.getSession().getId());
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
//        System.out.println("session destroyed: " + event.getSession().getId());
        count--;
    }

    public static int getCount() {
        return count;
    }

}
