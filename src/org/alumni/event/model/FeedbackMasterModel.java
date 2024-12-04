package org.alumni.event.model;

public class FeedbackMasterModel 
{
	private String details;
	private int rating;
	int aid;
	int eid;
	AlumniMasterModel am;
	EventMasterModel em;
	public FeedbackMasterModel()
	{
		
	}
	public FeedbackMasterModel(int fid, String details, int rating, int aid, int eid, AlumniMasterModel am, EventMasterModel em)
	{
		this.details=details;
		this.rating=rating;
		this.aid=aid;
		this.eid=eid;
		this.am=am;
		this.em=em;
	}
	public String getDetails() 
	{
		return details;
	}
	public void setDetails(String details) 
	{
		this.details = details;
	}
	public int getRating() 
	{
		return rating;
	}
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
	public int getAid() 
	{
		return aid;
	}
	public void setAid(int aid) 
	{
		this.aid = aid;
	}
	public int getEid() 
	{
		return eid;
	}
	public void setEid(int eid) 
	{
		this.eid = eid;
	}
	public AlumniMasterModel getAm() 
	{
		return am;
	}
	public void setAm(AlumniMasterModel am) 
	{
		this.am = am;
	}
	public EventMasterModel getEm() 
	{
		return em;
	}
	public void setEm(EventMasterModel em) 
	{
		this.em = em;
	}
}
