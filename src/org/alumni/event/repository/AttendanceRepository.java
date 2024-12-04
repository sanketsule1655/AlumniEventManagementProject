package org.alumni.event.repository;

import java.util.Vector;

import org.alumni.event.config.DBHelper;
import org.alumni.event.model.AlumniMasterModel;
import org.alumni.event.model.AttendanceModel;
import org.alumni.event.model.EventMasterModel;

public class AttendanceRepository extends DBHelper
{
	Vector<AttendanceModel> vect = null;
	public boolean isAttendanceMarked(int aid, int eid, String date, String status)
	{
		try
		{
			pstmt = conn.prepareStatement("insert into attendancemaster values(?,?,?,?)");
			pstmt.setInt(1, aid);
			pstmt.setInt(2, eid);
			pstmt.setString(3, date);
			pstmt.setString(4, status);
			int val = pstmt.executeUpdate();
			return val>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return false;
	}
	public Vector<AttendanceModel> getPresentAlumni(AttendanceModel atm)
	{
		vect = new Vector<AttendanceModel>();
		try
		{
			pstmt = conn.prepareStatement("select am.name as Alumni_name, em.name as Event_name, a.date as Date, a.status as status from alumnimaster am inner join attendance a on am.aid = a.aid inner join eventmaster em on em.eid=a.eid where a.status = ?");
			pstmt.setString(1, atm.getStatus());
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				AttendanceModel atmodel = new AttendanceModel();
				AlumniMasterModel am = new AlumniMasterModel();
				am.setName(rs.getString(1));
				atmodel.setAm(am);
				EventMasterModel em = new EventMasterModel();
				em.setName(rs.getString(2));
				atmodel.setEm(em);
				em.setDate(rs.getString(3));
				atmodel.setEm(em);
				atmodel.setStatus(rs.getString(4));
				vect.add(atmodel);
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
			return null;
		}
	}
	public String getAttendanceStatus(int aid, int eid)
	{
		String status = null;
		try
		{
			pstmt = conn.prepareStatement("select status from attendancemaster where aid = ? and eid = ?");
			pstmt.setInt(1, aid);
			pstmt.setInt(2, eid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				status = rs.getString(1);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return status;
	}
}
