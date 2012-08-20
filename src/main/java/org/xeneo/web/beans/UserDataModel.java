package org.xeneo.web.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author XENEO
 */
@ManagedBean
@RequestScoped
public class UserDataModel extends ListDataModel<UserManagementBean> implements SelectableDataModel<UserManagementBean> {

   
    public UserDataModel() {
    }
    
    public UserDataModel(List<UserManagementBean> data) {  
        super(data);  
    }  
      
    @Override  
    public UserManagementBean getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<UserManagementBean> cars = (List<UserManagementBean>) getWrappedData();  
          
        for(UserManagementBean user : cars) {  
            if(user.getFirstName().equals(rowKey))  
                return user;  
        }  
          
        return null;  
    }  
  
    @Override  
    public String getRowKey(UserManagementBean user) {  
        return user.getFirstName();  
    }  
}
