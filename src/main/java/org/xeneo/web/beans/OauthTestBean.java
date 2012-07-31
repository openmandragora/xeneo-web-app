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
package org.xeneo.web.beans;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.xeneo.web.oauth.api.GithubApi;



/**
 *
 * @author Stefan
 */

@Component("oauth")
@Scope("request")
public class OauthTestBean {
    Logger logger = LoggerFactory.getLogger(OauthTestBean.class);
    
    
    public String getOauthUrl() {
        OAuthService service = new ServiceBuilder()
                           .provider(GithubApi.class)
                           .apiKey("56720661e30f89d6b970")
                           .apiSecret("0d8fcfe29d5c88f6f5b9e7fd6bdab9031e71bc34")                           
                           .build();
        
        return service.getAuthorizationUrl(null);
    }   
    
    public String getAccessToken() {
        
        
                
        return "/";
    }
    
}
