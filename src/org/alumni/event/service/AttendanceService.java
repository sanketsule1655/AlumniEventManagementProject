package org.alumni.event.service;

import java.util.Vector;

import org.alumni.event.model.AttendanceModel;
import org.alumni.event.repository.AttendanceRepository;

public class AttendanceService 
{
	AttendanceRepository atrepo = new AttendanceRepository();
	public boolean isAttendanceMarked(int aid, int eid, String date, String status)
	{
		boolean b = atrepo.isAttendanceMarked(aid, eid, date, status);
		return b;
	}
	public Vector<AttendanceModel> getPresentAlumni(AttendanceModel atm)
	{
		Vector<AttendanceModel> vect = atrepo.getPresentAlumni(atm);
		return vect;
	}
	public String getattendancestatus(int aid, int eid)
	{
		String status = atrepo.getAttendanceStatus(aid, eid);
		return status;
	}
}
