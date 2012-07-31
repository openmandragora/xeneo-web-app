package org.xeneo.web.beans;

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


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author XENEO
 */
@Component("casemanagement")
@Scope("request")
public class CaseBean {

    /**
     * Creates a new instance of CaseBean
     */
    public CaseBean() {
    }
    
    private String casename;
    private String casedescription;
    private String casetype;

    public String getCasedescription() {
        return casedescription;
    }

    public void setCasedescription(String casedescription) {
        this.casedescription = casedescription;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getCasetype() {
        return casetype;
    }

    public void setCasetype(String casetype) {
        this.casetype = casetype;
    }
    
    
    
    public String savecase(){
    return null;
    }
    
    public String toindex(){
    return "index";
    }
    
        public String toProfileManaged(){
   
    
        
    return "profile-management";
    }
    
    public String toCaseTypeManagement(){
   
    
        
    return "casetype-management";
    }
    
    public String toCaseManagement(){
    
        return "case-management";
    }
    public String toadduser(){
    
        return "add-user";
    }
}
