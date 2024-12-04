package org.alumni.event.service;

import java.util.Vector;

import org.alumni.event.model.AlumniMasterModel;
import org.alumni.event.repository.AlumniEventRepository;

public class AlumniEventServices 
{
	AlumniEventRepository aerepo = new AlumniEventRepository();
	public Vector<AlumniMasterModel> getAlumniWiseEvents(String eventname)
	{
		Vector<AlumniMasterModel> v = aerepo.getAlumniWiseEvents(eventname);
		return v;
	}
}
