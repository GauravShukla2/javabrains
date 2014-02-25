package com.gaurav.dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
