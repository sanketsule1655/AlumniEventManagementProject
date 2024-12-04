package org.alumni.event.service;

import java.util.Vector;

import org.alumni.event.model.AlumniMasterModel;
import org.alumni.event.repository.AlumniMasterRepository;

public class AlumniMasterServices 
{
	AlumniMasterRepository amr = new AlumniMasterRepository();
	public boolean isAddAlumni(AlumniMasterModel am)
	{
		boolean b = amr.isAddAlumni(am);
		return b;
	}
	public boolean isAddBulkAlumni(AlumniMasterModel am)
	{
		boolean b = amr.isAddBulkAlumni(am);
		return b;
	}
	public Vector<AlumniMasterModel> getAlumni()
	{
		Vector<AlumniMasterModel> v = amr.getAlumni();
		return v;
	}
	public boolean isAlumniUpdate(AlumniMasterModel am)
	{
		boolean b = amr.isAlumniUpdate(am);
		return b;
	}
	public int deleteid(AlumniMasterModel am)
	{
		int b = amr.deleteid(am);
		return b;
	}
	public Vector<AlumniMasterModel> sortYearWiseAlumni()
	{
		Vector<AlumniMasterModel> v = amr.sortYearWiseAlumni();
				return v;
	}
	public Vector<AlumniMasterModel> getSeniorAlumni()
	{
		Vector<AlumniMasterModel> v = amr.getSeniorAlumni();
		return v;
	}
}
