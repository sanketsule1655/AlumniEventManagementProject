package org.alumni.event.service;

import java.util.Vector;

import org.alumni.event.model.EventMasterModel;
import org.alumni.event.repository.EventMasterRepository;

public class EventMasterServices 
{
	EventMasterRepository emr = new EventMasterRepository();
	public boolean isEventAdded(EventMasterModel em)
	{
		boolean b = emr.isEventAdded(em);
		return b;
	}
	public Vector<EventMasterModel> getallEvents()
	{
		Vector<EventMasterModel> vect = emr.getallEvents();
		return vect;
	}
}
