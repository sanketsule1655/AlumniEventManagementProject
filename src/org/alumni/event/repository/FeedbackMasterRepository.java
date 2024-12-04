package org.alumni.event.repository;

import java.util.Vector;

import org.alumni.event.config.DBHelper;
import org.alumni.event.model.AlumniMasterModel;
import org.alumni.event.model.EventMasterModel;
import org.alumni.event.model.FeedbackMasterModel;

public class FeedbackMasterRepository extends DBHelper
{
	Vector <FeedbackMasterModel> vect = null;
	public boolean isFeedbackAdded(FeedbackMasterModel fm)
	{
		try
		{
			pstmt = conn.prepareStatement("insert into feedbackmaster values(?,?,?,?,)");
			pstmt.setInt(1, fm.getAid());
			pstmt.setInt(2, fm.getEid());
			pstmt.setString(3, fm.getDetails());
			pstmt.setInt(4, fm.getRating());
			return pstmt.executeUpdate()>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return false;
	}
	public Vector<FeedbackMasterModel> getfeedback()
	{
		vect = new Vector<FeedbackMasterModel>();
		try
		{
			pstmt = conn.prepareStatement("select am.name as Alumni_name, em.name as Event_name, fm.details as feedback, fm.rating as Ratings from alumnimaster am inner join feedbackmaster fm on am.aid = fm.aid inner join eventmaster em on em.eid = fm.eid");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				FeedbackMasterModel fm = new FeedbackMasterModel();
				AlumniMasterModel am = new AlumniMasterModel();
				EventMasterModel em = new EventMasterModel();
				am.setName(rs.getString(1));
				fm.setAm(am);
				em.setName(rs.getString(2));
				fm.setEm(em);
				fm.setDetails(rs.getString(3));
				fm.setRating(rs.getInt(4));
				vect.add(fm);
			}
			if(vect.size()>0)
			{
				return vect;
			}
			else
			{
				return null;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
			return null;
		}
	}
}
