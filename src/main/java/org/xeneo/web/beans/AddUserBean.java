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

import java.util.Iterator;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.xeneo.core.security.User;
import org.xeneo.core.services.UserServices;

/**
 *
 * @author Stefan Huber
 */

@Component("adduser")
@Scope("request")

public class AddUserBean {
    
  
    
   private  String firstname;
   private  String lastname;
   private String email;
   private String password;
   private String newpw;
   private String newpw2;
   private String fncolor;


    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNewpw(String newpw) {
        this.newpw = newpw;
    }

    public void setNewpw2(String newpw2) {
        this.newpw2 = newpw2;
    }
    
    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNewpw() {
        return newpw;
    }

    public String getNewpw2() {
        return newpw2;
    }

    public String getFncolor() {
        return fncolor;
    }
    
   
    public String saveuserdata(){

       if(lastname.equals("") && firstname.equals("") && email.equals("")){
   
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"All fields are required!",""));
  
       }
       
       return null;
       
    }
    
    public String savepassword(){
  
       
   FacesContext context = FacesContext.getCurrentInstance();

   
   if(!(newpw.equals(newpw2))&& !(newpw2.equals(""))&& !(newpw.equals("")))
       {  
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No password match!",""));  
   }
   
   if(newpw.length()<7 && !(newpw.equals(""))){
   
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Your password should be a minimum of 6 characters!","" )); 
   }
   
   
   return null;
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
   
   