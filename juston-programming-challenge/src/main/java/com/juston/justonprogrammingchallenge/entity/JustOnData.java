package com.juston.justonprogrammingchallenge.entity;

public class JustOnData {

	private Address address; 
	private Meta meta;
	
	public JustOnData() {}; 
	
	public JustOnData(Address address, Meta meta) {
		this.address = address;
		this.meta = meta;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	} 


}


