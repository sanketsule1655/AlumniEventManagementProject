package org.alumni.event.model;

public class AttendanceModel 
{
	private int bid;
	private int eid;
	private String date;
	private String status;
	private AlumniMasterModel am;
	private EventMasterModel em;
	public int getBid() 
	{
		return bid;
	}
	public void setBid(int bid) 
	{
		this.bid = bid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) 
	{
		this.eid = eid;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
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
