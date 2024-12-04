package org.alumni.event.service;

import java.util.Vector;

import org.alumni.event.model.FeedbackMasterModel;
import org.alumni.event.repository.FeedbackMasterRepository;

public class FeedbackMasterService 
{
	FeedbackMasterRepository fmrepo = new FeedbackMasterRepository();
	
	public boolean isFeedbackAdded(FeedbackMasterModel fm)
	{
		return fmrepo.isFeedbackAdded(fm);
	}
	public Vector<FeedbackMasterModel> getfeedback()
	{
		Vector<FeedbackMasterModel> vect = fmrepo.getfeedback();
		return vect;
	}
}
