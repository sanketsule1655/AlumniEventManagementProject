package org.alumni.event.service;

import org.alumni.event.model.BatchMasterModel;
import org.alumni.event.repository.BatchMasterRepository;

public class BatchMasterServices 
{
	BatchMasterRepository bmr = new BatchMasterRepository();
	public boolean isAddbatch(BatchMasterModel bm)
	{
		boolean b = bmr.isAddbatch(bm);
		return b;
	}
}
