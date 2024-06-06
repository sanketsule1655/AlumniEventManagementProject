package org.alumni.event.repository;

import org.alumni.event.config.DBHelper;
import org.alumni.event.model.BatchMasterModel;

public class BatchMasterRepository extends DBHelper
{
	public boolean isAddbatch(BatchMasterModel bm)
	{
		try
		{
			pstmt = conn.prepareStatement("insert into batchmaster values(0,?)");
			pstmt.setString(1, bm.getBatch_name());
			int val = pstmt.executeUpdate();
			return val>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return false;
	}
}
