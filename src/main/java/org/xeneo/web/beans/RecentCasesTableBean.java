package org.xeneo.web.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class RecentCasesTableBean implements Serializable {


    private List<CaseBean> recentCases;
    private CaseBean selectedCase;

    public RecentCasesTableBean() {
        recentCases = new ArrayList<CaseBean>();
        
        recentCases.add(new CaseBean("Casename", "Case description blab blub", "Type 1"));
        recentCases.add(new CaseBean("Casename", "Case description blab blub", "Type 1"));
        recentCases.add(new CaseBean("Casename", "Case description blab blub", "Type 1"));
        recentCases.add(new CaseBean("Casename", "Case description blab blub", "Type 1"));
        recentCases.add(new CaseBean("Casename", "Case description blab blub", "Type 1"));
        recentCases.add(new CaseBean("Casename", "Case description blab blub", "Type 1"));
        recentCases.add(new CaseBean("Casename", "Case description blab blub", "Type 1"));
 
    }

    public List<CaseBean> getRecentCases() {
        return recentCases;
    }

    public void setRecentCases(List<CaseBean> recentCases) {
        this.recentCases = recentCases;
    }

    public CaseBean getSelectedCase() {
        return selectedCase;
    }

    public void setSelectedCase(CaseBean selectedCase) {
        this.selectedCase = selectedCase;
    }

    
    
}