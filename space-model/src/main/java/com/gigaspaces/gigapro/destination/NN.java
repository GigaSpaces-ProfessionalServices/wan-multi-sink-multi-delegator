package com.gigaspaces.gigapro.destination;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NN", schema = "DBO")
public class NN implements Serializable {
    
    private String id;
    
    private String currentOtherFlag;
    private String priorityCode;
    private String preferenceTypeCode;
    
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getCurrentOtherFlag() {
        return currentOtherFlag;
    }
    public void setCurrentOtherFlag(String currentOtherFlag) {
        this.currentOtherFlag = currentOtherFlag;
    }
    public String getPriorityCode() {
        return priorityCode;
    }
    public void setPriorityCode(String priorityCode) {
        this.priorityCode = priorityCode;
    }
    public String getPreferenceTypeCode() {
        return preferenceTypeCode;
    }
    public void setPreferenceTypeCode(String preferenceTypeCode) {
        this.preferenceTypeCode = preferenceTypeCode;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((currentOtherFlag == null) ? 0 : currentOtherFlag.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((preferenceTypeCode == null) ? 0 : preferenceTypeCode.hashCode());
        result = prime * result + ((priorityCode == null) ? 0 : priorityCode.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NN other = (NN) obj;
        if (currentOtherFlag == null) {
            if (other.currentOtherFlag != null)
                return false;
        } else if (!currentOtherFlag.equals(other.currentOtherFlag))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (preferenceTypeCode == null) {
            if (other.preferenceTypeCode != null)
                return false;
        } else if (!preferenceTypeCode.equals(other.preferenceTypeCode))
            return false;
        if (priorityCode == null) {
            if (other.priorityCode != null)
                return false;
        } else if (!priorityCode.equals(other.priorityCode))
            return false;
        return true;
    }
}