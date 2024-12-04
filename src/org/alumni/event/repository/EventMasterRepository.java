package org.alumni.event.repository;

import java.util.Vector;

import org.alumni.event.config.DBHelper;
import org.alumni.event.model.EventMasterModel;

public class EventMasterRepository extends DBHelper
{
	Vector<EventMasterModel> v1 = new Vector<EventMasterModel>();
	public boolean isEventAdded(EventMasterModel em)
	{
		try
		{
			pstmt = conn.prepareStatement("insert into eventmaster values('0',?,?,?,?,?,?)");
			pstmt.setString(1, em.getName());
			pstmt.setString(2, em.getDate());
			pstmt.setString(3, em.getTime());
			pstmt.setString(4, em.getVenue());
			pstmt.setInt(5, em.getBid());
			pstmt.setString(6, em.getSubject());
			int val = pstmt.executeUpdate();
			return val>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return false;
	}
	public Vector<EventMasterModel> getallEvents()
	{
		try
		{
			v1 = new Vector<EventMasterModel>();
			pstmt = conn.prepareStatement("select *from eventmaster");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				EventMasterModel em = new EventMasterModel();
				em.setEid(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setDate(rs.getString(3));
				em.setTime(rs.getString(4));
				em.setVenue(rs.getString(5));
				em.setEid(rs.getInt(6));
				em.setName(rs.getString(7));
				v1.add(em);
			}
			if(v1.size()>0)
			{
				return v1;
			}
			else
			{
				return null;
			}
		}
		catch(Exception ex)
		{
			return null;
		}
	}
}
