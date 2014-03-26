/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eros
 */

public class IEFilter implements Filter{

    @Override
    public void init(FilterConfig fc) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//         HttpServletResponse response = (HttpServletResponse) res;
//	response.setHeader("X-UA-Compatible", "IE=8");
// 		chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
