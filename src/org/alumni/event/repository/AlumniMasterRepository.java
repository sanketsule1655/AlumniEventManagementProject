package org.alumni.event.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import org.alumni.event.config.DBHelper;
import org.alumni.event.config.PathHelper;
import org.alumni.event.model.AlumniMasterModel;
import org.alumni.event.model.BatchMasterModel;

public class AlumniMasterRepository extends DBHelper
{
	Vector<AlumniMasterModel> v = null;
	public boolean isAddAlumni(AlumniMasterModel am)
	{
		try
		{
			pstmt = conn.prepareStatement("insert into alumnimaster values ('0',?,?,?,?,?,?)");
			pstmt.setString(1, am.getName());
			pstmt.setString(2, am.getEmail());
			pstmt.setString(3, am.getContact());
			pstmt.setInt(4, am.getAge());
			pstmt.setString(5, am.getCompany());
			pstmt.setInt(6, am.getBid());
			int val = pstmt.executeUpdate();
			return val>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return false;
	}
	public boolean isAddBulkAlumni(AlumniMasterModel am)
	{
		try
		{
			FileReader fr = new FileReader(PathHelper.path + "Alumni.csv");
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			int val = 0;
			while((line = br.readLine())!= null)
			{
				String data[] = line.split(",");
				pstmt = conn.prepareStatement("insert into alumnimaster values(0,?,?,?,?,?,?)");
				pstmt.setString(1, data[1]);
				pstmt.setString(2, data[2]);
				pstmt.setString(3, data[3]);
				pstmt.setInt(4, Integer.parseInt(data[4]));
				pstmt.setString(5, data[5]);
				pstmt.setInt(6, Integer.parseInt(data[6]));
				val = pstmt.executeUpdate();
			}
			br.close();
			fr.close();
			return val>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return false;
	}
	public Vector<AlumniMasterModel> getAlumni()
	{
		try
		{
			v = new Vector<AlumniMasterModel>();
			pstmt = conn.prepareStatement("select *from alumnimaster");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				AlumniMasterModel am = new AlumniMasterModel();
				am.setAid(rs.getInt(1));
				am.setName(rs.getString(2));
				am.setEmail(rs.getString(3));
				am.setContact(rs.getString(4));
				am.setAge(rs.getInt(5));
				am.setCompany(rs.getString(6));
				am.setBid(rs.getInt(7));
				v.add(am);
			}
			pstmt.close();
			rs.close();
			if(v.size()>0)
			{
				return v;
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
	public boolean isAlumniUpdate(AlumniMasterModel am)
	{
		try
		{
     		pstmt = conn.prepareStatement("update alumnimaster set name = ?, email = ?, contact = ?, age = ?, company = ?, bid = ? where aid=?");
			pstmt.setString(1, am.getName());
			pstmt.setString(2, am.getEmail());
			pstmt.setString(3, am.getContact());
			pstmt.setInt(4, am.getAge());
			pstmt.setString(5, am.getCompany());
			pstmt.setInt(6, am.getBid());
			pstmt.setInt(7, am.getAid());
			int val = pstmt.executeUpdate();
			pstmt.close();
			return val>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return false;
	}
	public int deleteid(AlumniMasterModel am)
	{
		try
		{
			pstmt = conn.prepareStatement("delete from alumnimaster where aid = ?");
			pstmt.setInt(1, am.getAid());
			int val = 0;
			val = pstmt.executeUpdate();
			pstmt.close();
			return val>0?1:0;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return 0;
	}
	public Vector<AlumniMasterModel> sortYearWiseAlumni()
	{
		v = new Vector<AlumniMasterModel>();
		try
		{
			pstmt = conn.prepareStatement("select am.aid as Aid, am.Name as Alumni_Name, am.company as Company_Name, bm.batch_name as Year from AlumniMaster am inner join batchmaster bm on am.bid = bm.bid order by bm.batch_name asc");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				AlumniMasterModel am = new AlumniMasterModel();
				am.setAid(rs.getInt(1));
				am.setName(rs.getString(2));
				am.setCompany(rs.getString(3));
				BatchMasterModel bm = new BatchMasterModel();
	            bm.setBatch_name(rs.getString(4));
				am.setBatchMasterModel(bm);
			}
			if(v.size()>0)
			{
				return v;
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
	public Vector<AlumniMasterModel> getSeniorAlumni()
	{
		v = new Vector<AlumniMasterModel>();
		try
		{
			pstmt = conn.prepareStatement("select bm.batch_name as Year, am.name as Alumni_name, am.company as Company from alumnimaster am inner join batchmaster bm on am.bid = bm.bid where bm.batch_name in (select(batch_name)from batchmaster)");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				AlumniMasterModel am = new AlumniMasterModel();
				BatchMasterModel bm = new BatchMasterModel();
				bm.setBatch_name(rs.getString(1));
				am.setBatchMasterModel(bm);
				am.setName(rs.getString(2));
				am.setCompany(rs.getString(3));
				v.add(am);
			}
			if(v.size()>0)
			{
				return v;
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
