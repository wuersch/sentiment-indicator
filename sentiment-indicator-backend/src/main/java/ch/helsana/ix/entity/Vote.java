package ch.helsana.ix.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vote {
    @Id
    @GeneratedValue
    private Long id;
    private int item;
    private String user;
    private String businessUnit;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfVoting;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public int getItem() {
        return item;
    }
    
    public void setItem(int item) {
        this.item = item;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Date getTimeOfVoting() {
        return timeOfVoting;
    }

    public void setTimeofVoting(Date timeOfVoting) {
        this.timeOfVoting = timeOfVoting;
    }
}