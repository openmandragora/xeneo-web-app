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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.xeneo.core.security.User;
import org.xeneo.core.security.UserService;

/**
 *
 * @author Stefan Huber
 */

@Component("user")
@Scope("session")
public class UserManagementBean {
    
    @Autowired
    private UserService us;
    
    private User user;
    
    public String getFirstName() {
        if (user == null) {        
            user = us.getCurrentUser();
        }
        
        return user.getFirstName();
    }
   
    public String getLastName() {
        if (user == null) {        
            user = us.getCurrentUser();
        }
        
        return user.getLastName();
    }
}
