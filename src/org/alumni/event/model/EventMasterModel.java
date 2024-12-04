package org.alumni.event.model;

public class EventMasterModel 
{
	private int eid;
	private String name;
	private String date;
	private String time;
	private String venue;
	private int bid;
	private String subject;
	public EventMasterModel()
	{
		
	}
	public EventMasterModel(String name, String date, String time, String venue, int bid, String subject)
	{
		this.name=name;
		this.date=date;
		this.time=time;
		this.venue=venue;
		this.bid=bid;
		this.subject=subject;
	}
	public int getEid() 
	{
		return eid;
	}
	public void setEid(int eid) 
	{
		this.eid = eid;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public String getTime() 
	{
		return time;
	}
	public void setTime(String time) 
	{
		this.time = time;
	}
	public String getVenue() 
	{
		return venue;
	}
	public void setVenue(String venue) 
	{
		this.venue = venue;
	}
	public int getBid() 
	{
		return bid;
	}
	public void setBid(int bid) 
	{
		this.bid = bid;
	}
	public String getSubject() 
	{
		return subject;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
}
