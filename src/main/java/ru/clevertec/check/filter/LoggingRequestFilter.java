package ru.clevertec.check.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class LoggingRequestFilter implements Filter {
    private Logger logger;

    @Override
    public void init(FilterConfig filterConfig) {
        logger = LoggerFactory.getLogger(LoggingRequestFilter.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String method = ((HttpServletRequest) request).getMethod();
        String path = ((HttpServletRequest) request).getRequestURI();
        String queryString = ((HttpServletRequest) request).getQueryString();
        logger.info("Method : {}, request path : {}, parameters : {}", method, path, queryString);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
