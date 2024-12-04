package org.alumni.event.client;

import java.util.*;

import org.alumni.event.model.AlumniMasterModel;
import org.alumni.event.model.AttendanceModel;
import org.alumni.event.model.BatchMasterModel;
import org.alumni.event.model.EventMasterModel;
import org.alumni.event.model.FeedbackMasterModel;
import org.alumni.event.service.AlumniEventServices;
import org.alumni.event.service.AlumniMasterServices;
import org.alumni.event.service.AttendanceService;
import org.alumni.event.service.BatchMasterServices;
import org.alumni.event.service.EventMasterServices;
import org.alumni.event.service.FeedbackMasterService;
import org.helper.EmailHelper;

public class AlumniClientApplication {
	public static void main(String[] x) {
		BatchMasterServices bms = new BatchMasterServices();
		BatchMasterModel bm = new BatchMasterModel();
		AlumniMasterModel am = new AlumniMasterModel();
		AlumniMasterServices ams = new AlumniMasterServices();
		Vector<AlumniMasterModel> v = new Vector<AlumniMasterModel>();
		Vector<EventMasterModel> vect = new Vector<EventMasterModel>();
		Vector<AttendanceModel> v1 = new Vector<AttendanceModel>();
		Vector<FeedbackMasterModel> v2 = new Vector<FeedbackMasterModel>();
		EventMasterModel em = new EventMasterModel();
		EventMasterServices ems = new EventMasterServices();
		AttendanceService atservice = new AttendanceService();
		AttendanceModel atm = new AttendanceModel();
		AlumniEventServices aservice = new AlumniEventServices();
		FeedbackMasterModel fm = new FeedbackMasterModel();
		FeedbackMasterService fms = new FeedbackMasterService();
		int flag;
		do {
			Scanner xyz = new Scanner(System.in);
			int choice;
			String Batch_Name;
			System.out.println("1:Add Alumni's Passout Batch Details.....");
			System.out.println("2:Add New Alumni/View Alumni/Update Alumni/Delete Alumni.....");
			System.out.println("3:Add New Alumni Events.....");
			System.out.println("4:View all the Alumni Events.....");
			System.out.println("5:Send SMS to Alumni for Event.....");
			System.out.println("6:Take Attendance of Alumni.....");
			System.out.println("7:View All Alumni details as Per the Events.....");
			System.out.println("8:View All Absent Alumni.....");
			System.out.println("9:Take Feedback from Alumni.....");
			System.out.println("10:View Feedback from Alumni.....");
			System.out.println("11:Sort Alumni Year Wise.....");
			System.out.println("12:Find the Most Senior Alumni in meet......");
			System.out.println(" ");
			System.out.println("Enter your choice:");
			choice = xyz.nextInt();
			switch (choice) {
			case 1:
				System.out.println("1:Add Alumni's Passout Batch Details......");
				xyz.nextLine();
				System.out.println("Enter the Batch Year you want to add:");
				Batch_Name = xyz.nextLine();
				bm.setBatch_name(Batch_Name);
				boolean b = bms.isAddbatch(bm);
				if (b) 
				{
					System.out.println("Batch Added Successfully.....");
				} 
				else 
				{
					System.out.println("There is Some Problem.....");
				}
				break;
			case 2:
				System.out.println("2:Add new Alumni/View Alumni/Update Alumni/Delete Alumni.....");
				System.out.println(" ");
				do {
					System.out.println("1:Add the Alumni Details manually.....");
					System.out.println("2:Add Alumni Details in Builk.....");
					System.out.println("3:View All the Alumni Details.....");
					System.out.println("4:Update the Alumni Details.....");
					System.out.println("5:Delete the Specific Alumni Details.....");
					System.out.println(" ");
					System.out.println("Enter the Choice:");
					choice = xyz.nextInt();
					System.out.println(" ");
					switch (choice) {
					case 1:
						xyz.nextLine();
						System.out.println("1:Add the Alumni Details manually.....");
						System.out.println(" ");
						System.out.println("Enter the Name of the Alumni:");
						String name = xyz.nextLine();
						System.out.println("Enter the Email of the Alumni:");
						String email = xyz.nextLine();
						System.out.println("Enter the Contact of the Alumni:");
						String contact = xyz.nextLine();
						System.out.println("Enter the Age of the Alumni:");
						int age = xyz.nextInt();
						xyz.nextLine();
						System.out.println("Enter the Alumni's Company:");
						String company = xyz.nextLine();
						System.out.println("Enter the Alumni's Batch_Id:");
						int bid = xyz.nextInt();
						AlumniMasterModel amd = new AlumniMasterModel(name, email, contact, age, company, bid);
						b = ams.isAddAlumni(amd);
						if (b) 
						{
							System.out.println("Alumni details added successfully.....");
							System.out.println(" ");
						} 
						else 
						{
							System.out.println("Some Probelm is there.....");
							System.out.println(" ");
						}
						break;
					case 2:
						System.out.println("2:Add the Alumni Details in Builk.....");
						System.out.println(" ");
						b = ams.isAddBulkAlumni(am);
						if (b) 
						{
							System.out.println("Bulk Alumni Added Successfully.....");
						} 
						else 
						{
							System.out.println("Some Problem is there.....");
						}
						break;
					case 3:
						System.out.println("3:View All the Alumni Details.....");
						System.out.println(" ");
						v = ams.getAlumni();
						if (v != null) 
						{
							System.out.println("Alumni has been Stored in Database Successfully.....");
							for (AlumniMasterModel amodel : v) 
							{
								System.out.println(amodel.getAid() + "\t" + amodel.getName() + "\t" + amodel.getEmail()
										+ "\t" + amodel.getContact() + "\t" + amodel.getAge() + "\t"
										+ amodel.getCompany() + "\t" + amodel.getBid());
								System.out.println(" ");
							}
							System.out.println(" ");
						} 
						else 
						{
							System.out.println("Alumni Data is not Present inside Databases.....");
							System.out.println(" ");
						}
						break;
					case 4:
						System.out.println("4:Update Alumni Details.....");
						System.out.println(" ");
						System.out.println("Enter the Alumni Id you want to Update:");
						int aid = xyz.nextInt();
						am.setAid(aid);
						xyz.nextLine();
						System.out.println("Enter the Updated Alumni Name:");
						String name1 = xyz.nextLine();
						am.setName(name1);
						System.out.println("Enter the Updated Alumni Email:");
						String email1 = xyz.nextLine();
						am.setEmail(email1);
						System.out.println("Enter the Updated Alumni Contact:");
						String contact1 = xyz.nextLine();
						am.setContact(contact1);
						System.out.println("Enter the Updated Alumni age:");
						int age1 = xyz.nextInt();
						am.setAge(age1);
						xyz.nextLine();
						System.out.println("Enter the Updated Alumni Company:");
						String company1 = xyz.nextLine();
						am.setCompany(company1);
						System.out.println("Enter the Updated Alumni Batch_Id:");
						int bid1 = xyz.nextInt();
						am.setBid(bid1);
						b = ams.isAlumniUpdate(am);
						if (b) 
						{
							System.out.println("Alumni Updated Successfully.....");
						} 
						else 
						{
							System.out.println("There Might be Some Issue.....");
						}
						v = ams.getAlumni();
						if (v != null) 
						{
							System.out.println("Alumni are Present in Database.....");
							for (AlumniMasterModel amodel : v) 
							{
								System.out.println(amodel.getAid() + "\t" + amodel.getName() + "\t" + amodel.getEmail()
										+ "\t" + amodel.getContact() + "\t" + amodel.getAge() + "\t"
										+ amodel.getCompany() + "\t" + amodel.getBid());
								System.out.println(" ");
							}
						} 
						else 
						{
							System.out
									.println("There might be some issue as database does not have alumni details.....");
							System.out.println(" ");
						}
						break;
					case 5:
						System.out.println("5:Delete the Alumni Details.....");
						System.out.println(" ");
						System.out.println("Enter the Alumni Id which you want to delete:");
						int aid1 = xyz.nextInt();
						am.setAid(aid1);
						flag = ams.deleteid(am);
						if (flag == 1) 
						{
							System.out.println("Alumni with id " + aid1 + " has been Removed Successfully.....");
						} 
						else 
						{
							System.out.println(
									"Alumni with id " + aid1 + " has not been Removed, there might be some issue.....");
						}
						v = ams.getAlumni();
						if (v != null) 
						{
							System.out.println("Alumni are Present in Database.....");
							for (AlumniMasterModel amodel : v) 
							{
								System.out.println(amodel.getAid() + "\t" + amodel.getName() + "\t" + amodel.getEmail()
										+ "\t" + amodel.getContact() + "\t" + amodel.getAge() + "\t"
										+ amodel.getCompany() + "\t" + amodel.getBid());
								System.out.println(" ");
							}
						} 
						else 
						{
							System.out
									.println("There might be some issue as database does not have alumni details.....");
							System.out.println(" ");
						}
						break;
					}
				} while (choice != 6);
				break;
			case 3:
				System.out.println("3:Add the New AlumniEvent.....");
				System.out.println(" ");
				xyz.nextLine();
				System.out.println("Enter the name of the Event:");
				String name = xyz.nextLine();
				System.out.println("Enter the Event Date:");
				String date = xyz.nextLine();
				System.out.println("Enter the Event Time:");
				String time = xyz.nextLine();
				System.out.println("Enter the Event Venue:");
				String venue = xyz.nextLine();
				System.out.println("Enter the Passout Batch ID of an Alumni for that Event:");
				int bid = xyz.nextInt();
				xyz.nextLine();
				System.out.println("Enter the Event Subject:");
				String subject = xyz.nextLine();
				EventMasterModel emd = new EventMasterModel(name, date, time, venue, bid, subject);
				b = ems.isEventAdded(emd);
				if (b) 
				{
					System.out.println("Event Details Added Successfully.....");
					System.out.println(" ");
				} 
				else 
				{
					System.out.println("There is Some issue.....");
					System.out.println(" ");
				}
				break;
			case 4:
				System.out.println("4:View All the Alumni Events.....");
				System.out.println(" ");
				vect = ems.getallEvents();
				if (vect != null) 
				{
					System.out.println("Events are there in the Databases.....");
					for (EventMasterModel emodel : vect) 
					{
						System.out.println(emodel.getEid() + "\t" + emodel.getName() + "\t" + emodel.getDate() + "\t"
								+ emodel.getTime() + "\t" + emodel.getVenue() + "\t" + emodel.getBid() + "\t"
								+ emodel.getSubject());
						System.out.println(" ");
					}
				} 
				else 
				{
					System.out.println("Some Problem is there.....");
					System.out.println(" ");
				}
				break;
			case 5:
				System.out.println("5:Send SMS/Email to alumni for Event.....");
				System.out.println(" ");
				xyz.nextLine();
				System.out.println("Enter the Sender Name:");
				String sender = xyz.nextLine();
				System.out.println("Enter the Email Subject:");
				String emailsub = xyz.nextLine();
				System.out.println("Enter the Email Content:");
				String emailcont = xyz.nextLine();
				EmailHelper.sendEmail("shreyas", "sanketsule11@gmail.com", "Sanket", "Invititation for Event", "Welcome to Invent");
				v = ams.getAlumni();
				if(v!=null)
				{
					System.out.println("Alumni are Present in the Database.....");
					System.out.println(" ");
					for(AlumniMasterModel amd:v)
					{
						EmailHelper.sendEmail(sender, amd.getEmail(), amd.getName(), emailsub, emailcont);
						System.out.println(" ");
					}
				}
				else
				{
					System.out.println("Alumnis are not in Database.....");
					System.out.println(" ");
				}
				break;
			case 6:
				System.out.println("6:Take the Attendance of the Alumni.....");
				System.out.println(" ");
				System.out.println("Enter the Alumni Id:");
				int aid = xyz.nextInt();
				System.out.println("Enter the Event Id:");
				int eid = xyz.nextInt();
				xyz.nextLine();
				System.out.println("Enter the Event Date:");
				String eventdate = xyz.nextLine();
				System.out.println("Enter P if you are Present Otherwise if you are not Present then enter A");
				String Status = xyz.nextLine();
				b = atservice.isAttendanceMarked(aid, eid, eventdate, Status);
				if (b) 
				{
					System.out.println("Attendance has been Successfully marked.....");
					System.out.println(" ");
				} 
				else 
				{
					System.out.println("Attendance has not been Marked.....");
					System.out.println(" ");
				}
				break;
			case 7:
				System.out.println("7:View All Present Alumni Details.....");
				System.out.println(" ");
				xyz.nextLine();
				System.out.println("Enter the Attendance Status you want to see:");
				String status = xyz.nextLine();
				atm.setStatus(status);
				v1 = atservice.getPresentAlumni(atm);
				if (v1 != null) 
				{
					System.out.println("Present Alumni are Present in the Database.....");
					System.out.println(" ");
					for (AttendanceModel atmodel : v1) 
					{
						System.out.println(atmodel.getAm().getName() + "\t" + atmodel.getEm().getName() + "\t"
								+ atmodel.getEm().getDate() + "\t" + atmodel.getStatus());
						System.out.println(" ");
					}
				} 
				else 
				{
					System.out.println("There is some Problem.....");
					System.out.println(" ");
				}
				break;
			case 8:
				xyz.nextLine();
				System.out.println("8:View All Absent Alumni.....");
				System.out.println(" ");
				System.out.println("Enter the Event Name:");
				String Name = xyz.nextLine();
				v = aservice.getAlumniWiseEvents(Name);
				if (v != null) 
				{
					System.out.println("For" + " " +Name
							+ " event Alumni Details are there in the Database and which are as Follows.....");
					for (AlumniMasterModel amodel : v) 
					{
						System.out.println(amodel.getAid() + "\t" + amodel.getName() + "\t" + amodel.getCompany());
						System.out.println(" ");
					}
				} 
				else 
				{
					System.out
							.println("Alumni Details are not there present for " + Name + " event inside Database.....");
					System.out.println(" ");
				}
				break;
			case 9:
				System.out.println("9:Take Feedback from Alumni.....");
				System.out.println(" ");
				System.out.println("Enter the Alumni's Id:");
				aid = xyz.nextInt();
				System.out.println("Enter the Event Id:");
				eid = xyz.nextInt();
				xyz.nextLine();
				System.out.println("Enter the Feedback in details:");
				String details = xyz.nextLine();
				System.out.println("Enter the Rating for Event:");
				int rating = xyz.nextInt();
				status = atservice.getattendancestatus(aid, eid);
				if("P".equalsIgnoreCase(status))
				{
					System.out.println("Alumni are Present for Event.....");
					System.out.println(" ");
					fm.setAid(aid);
					fm.setEid(eid);
					xyz.nextLine();
					fm.setDetails(details);
					fm.setRating(rating);
					boolean b1 = fms.isFeedbackAdded(fm);
					if(b1)
					{
						System.out.println("Feedback given by Alumni.....");
						System.out.println(" ");
					}
					else
					{
						System.out.println("There is Problem......");
						System.out.println(" ");
					}
				}
				else
				{
					System.out.println("Absent Alumni will not be able to give feedback.....");
					System.out.println(" ");
				}
				break;
			case 10:
				System.out.println("10:Display the Feedback given by the Alumni.....");
				System.out.println(" ");
				v2 = fms.getfeedback();
				if(v2!=null)
				{
					System.out.println("Alumni who has given the Feedback are there in the Database.....");
					System.out.println(" ");
					for(FeedbackMasterModel fdm:v2)
					{
						System.out.println(fdm.getAm().getName()+"\t"+fdm.getEm().getName()+"\t"+fdm.getDetails()+"\t"+fdm.getRating());
						System.out.println(" ");						
					}
				}
				else
				{
					System.out.println("No Alumni Present for event so no feedback received.....");
					System.out.println(" ");
				}
				break;
			case 11:
				System.out.println("11:Sort the Alumni Details Year_Wise.....");
				System.out.println(" ");
				v = ams.sortYearWiseAlumni();
				if (v != null) 
				{
					System.out.println("Alumni Successfully Sorted Year Wise.....");
					System.out.println(" ");
					for (AlumniMasterModel alumnimodel : v) 
					{
						System.out.println(alumnimodel.getAid() + "\t" + alumnimodel.getName() + "\t"
								+ alumnimodel.getCompany() + "\t" + alumnimodel.getBatchMasterModel().getBatch_name());
						System.out.println(" ");
					}
				} 
				else 
				{
					System.out.println("Some Problem is there in the Database table.....");
					System.out.println(" ");
				}
				break;
			case 12:
				System.out.println("12:Find the Most Senior Alumni in the Meet.....");
				System.out.println(" ");
				v = ams.getSeniorAlumni();
				if (v != null) 
				{
					System.out.println("Most Senior Alumnis are Present in the Databases.....");
					System.out.println(" ");
					for (AlumniMasterModel amd : v) 
					{
						System.out.println(amd.getBatchMasterModel().getBatch_name() + "\t" + amd.getName() + "\t"
								+ amd.getCompany());
						System.out.println(" ");
					}
				} 
				else 
				{
					System.out.println("There is Some Issue......");
					System.out.println();
				}
				break;
			default:
				System.out.println("Invalid Choice.....");
				break;
			}
		} while (true);
	}
}
