package org.xeneo.web.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean
public class TableBean implements Serializable {


    private List<UserManagementBean> searchedUsers;
    private UserManagementBean[] selectedUsers;
    private UserManagementBean selectedUser;

    private UserDataModel mediumCarsModel;  
  
    private List<UserManagementBean> filteredCars;
    private SelectItem[] manufacturerOptions;  

    public TableBean() {
        searchedUsers = new ArrayList<UserManagementBean>();
        

        searchedUsers.add(new UserManagementBean("Bart", "Simpson"));
        searchedUsers.add(new UserManagementBean("Lisa", "Simpson"));
        searchedUsers.add(new UserManagementBean("Homer", "Simpson"));
        searchedUsers.add(new UserManagementBean("Maggy", "Simpson"));
        searchedUsers.add(new UserManagementBean("Marge", "Simpson"));
        
        mediumCarsModel = new UserDataModel(searchedUsers); 
    }

    public List<UserManagementBean> getSearchedUsers() {
        return searchedUsers;
    }

    public void setSearchedUsers(List<UserManagementBean> searchedUsers) {
        this.searchedUsers = searchedUsers;
    }

    public UserDataModel getMediumCarsModel() {
        return mediumCarsModel;
    }

    public void setMediumCarsModel(UserDataModel mediumCarsModel) {
        this.mediumCarsModel = mediumCarsModel;
    }

    public UserManagementBean getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserManagementBean selectedUser) {
        this.selectedUser = selectedUser;
    }

    public UserManagementBean[] getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(UserManagementBean[] selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public List<UserManagementBean> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<UserManagementBean> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public SelectItem[] getManufacturerOptions() {
        return manufacturerOptions;
    }

    public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
        this.manufacturerOptions = manufacturerOptions;
    }
    
    
    
    private SelectItem[] createFilterOptions(String[] data)  {  
        SelectItem[] options = new SelectItem[data.length + 1];  
  
        options[0] = new SelectItem("", "Select");  
        for(int i = 0; i < data.length; i++) {  
            options[i + 1] = new SelectItem(data[i], data[i]);  
        }  
  
        return options;  
    }  
    
    
    
    
}