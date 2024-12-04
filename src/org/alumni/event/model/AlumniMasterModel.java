package org.alumni.event.model;

public class AlumniMasterModel 
{
	private int aid;
	private String name;
	private String email;
	private String contact;
	private int age;
	private String company;
	private int bid;
	private BatchMasterModel bm;
	public AlumniMasterModel()
	{
		
	}
	public AlumniMasterModel(String name, String email, String contact, int age, String company, int bid)
	{
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.age = age;
		this.company = company;
		this.bid = bid;
	}
	public int getAid() 
	{
		return aid;
	}
	public void setAid(int aid) 
	{
		this.aid = aid;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getContact() 
	{
		return contact;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public String getCompany() 
	{
		return company;
	}
	public void setCompany(String company) 
	{
		this.company = company;
	}
	public int getBid() 
	{
		return bid;
	}
	public void setBid(int bid) 
	{
		this.bid = bid;
	}
	public void setBatchMasterModel(BatchMasterModel bm)
	{
		this.bm=bm;
	}
	public BatchMasterModel getBatchMasterModel()
	{
		return bm;
	}
}
