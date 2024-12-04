package org.alumni.event.repository;

import java.util.Vector;

import org.alumni.event.config.DBHelper;
import org.alumni.event.model.AlumniMasterModel;

public class AlumniEventRepository extends DBHelper
{
	Vector<AlumniMasterModel> v2 = new Vector<AlumniMasterModel>();
	public Vector<AlumniMasterModel> getAlumniWiseEvents(String eventname)
	{
		try
		{
			v2 = new Vector<AlumniMasterModel>();
			pstmt = conn.prepareStatement("select am.aid as Aid, am.name as Alumni_Name, am.company as Company_Name from alumnimaster am inner join eventmaster em on am.bid = em.bid where em.name = ?");
			pstmt.setString(1, eventname);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				AlumniMasterModel amd = new AlumniMasterModel();
				amd.setAid(rs.getInt(1));
				amd.setName(rs.getString(2));
				amd.setCompany(rs.getString(3));
				v2.add(amd);
			}
			if(v2.size()>0)
			{
				return v2;
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
