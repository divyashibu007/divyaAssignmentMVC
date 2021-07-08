package com.mvc.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    
    private String accName;
    private String bankName;
    private String accNo;
    @OneToOne
    private User assignedTo;
 




    public Account(){

    }
    public Account(int id){
        this.id=id;
    }
    public Account(int id,String accNo,String type,String accName,String bankName,User assignedTo){
        this.id=id;
        this.type=type;
        this.accNo=accNo;
        this.accName=accName;
        this.bankName=bankName;
        this.assignedTo=assignedTo;
    


    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

  
   
    public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public User getAssignedTo() {
        return assignedTo;
    }
    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String toString(){
        return "Activity{"+"id=" +id+"" +
                ",type='" + type + '\''+
                 
                ",bankName='" + bankName + '\''+
                ",accNo='" + accNo + '\''+
                ",accName='" + accName + '\''+
                ",assignedTo='" + assignedTo + '\''+
              
                '}';
    }


}
