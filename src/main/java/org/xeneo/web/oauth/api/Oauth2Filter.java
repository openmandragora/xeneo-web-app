/*
 * Copyright 2012 XENEO.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xeneo.web.oauth.api;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Stefan
 */
public class Oauth2Filter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(Oauth2Filter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        // filterConfig.
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Enumeration pars = request.getParameterNames();
        while(pars.hasMoreElements()) {
            String par = (String) pars.nextElement();
        }
    }

    public void destroy() {
        
    }
    
}
