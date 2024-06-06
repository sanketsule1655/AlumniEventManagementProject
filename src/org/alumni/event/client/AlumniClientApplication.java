package org.alumni.event.client;
import java.util.*;

import org.alumni.event.model.AlumniMasterModel;
import org.alumni.event.model.BatchMasterModel;
import org.alumni.event.service.AlumniMasterServices;
import org.alumni.event.service.BatchMasterServices;
public class AlumniClientApplication {
	public static void main(String[]x)
	{
		BatchMasterServices bms = new BatchMasterServices();
		BatchMasterModel bm = new BatchMasterModel();
		AlumniMasterModel am = new AlumniMasterModel();
		AlumniMasterServices ams = new AlumniMasterServices();
		Vector<AlumniMasterModel> v = new Vector<AlumniMasterModel>();
		int flag;
		do
		{
			Scanner xyz = new Scanner(System.in);
			int choice;
			String Batch_Name;
			System.out.println("1:Add Alumni's Passout Batch Details....:");
			System.out.println("2:Add New Alumni/View Alumni/Update Alumni/Delete Alumni....:");
			System.out.println("3:Add New Alumni Events....:");
			System.out.println("4:View all the Alumni Events....:");
			System.out.println("5:Send SMS to Alumni for Event....:");
			System.out.println("6:Take Attendance of Alumni.....:");
			System.out.println("7:View All Alumni details as Per the Events.....:");
			System.out.println("8:View All Absent Alumni....:");
			System.out.println("9:Take Feedback from Alumni....:");
			System.out.println("10:Sort Alumni Year Wise....:");
			System.out.println("11:Find the Most Senior Alumni in meet.....:");
			System.out.println("Enter your choice:");
			choice = xyz.nextInt();
			switch (choice) 
			{
			   case 1:
				   System.out.println("Add Alumni's Passout Batch Details......");
			   	   xyz.nextLine();
			   	   System.out.println("Enter the Batch Year you want to add:");
			   	   Batch_Name = xyz.nextLine();
			   	   bm.setBatch_name(Batch_Name);
			   	   boolean b = bms.isAddbatch(bm);
			   	   if(b)
			   	   {
			   		   System.out.println("Batch Added Successfully.....");
			   	   }
			   	   else
			   	   {
			   		   System.out.println("There is Some Problem.....");
			   	   }
			   	   break;
			   case 2:
				   System.out.println("Add new Alumni/View Alumni/Update Alumni/Delete Alumni.....");
				   System.out.println(" ");
				   do
				   {
					   System.out.println("1:Add the Alumni Details manually.....");
					   System.out.println("2:Add Alumni Details in Builk.....");
					   System.out.println("3:View All the Alumni Details.....");
					   System.out.println("4:Update the Alumni Details.....");
					   System.out.println("5:Delete the Specific Alumni Details.....");
					   System.out.println(" ");
					   System.out.println("Enter the Choice:");
					   choice = xyz.nextInt();
					   System.out.println(" ");
					   switch(choice)
					   {
					   case 1:
						   xyz.nextLine();
						   System.out.println("1:Add the Alumni Details manually:");
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
						   if(b)
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
						   System.out.println("Add the Alumni Details in Builk.....");
						   System.out.println(" ");
						   b = ams.isAddBulkAlumni(am);
						   if(b)
						   {
							   System.out.println("Bulk Alumni Added Successfully.....");
						   }
						   else
						   {
							   System.out.println("Some Problem is there.....");
						   }
						   break;
					   case 3:
						   System.out.println("View All the Alumni Details.....");
						   System.out.println(" ");
						   v = ams.getAlumni();
						   if(v!=null)
						   {
							   System.out.println("Alumni has been Stored in Database Successfully.....");
							   for(AlumniMasterModel amodel:v)
							   {
								   System.out.println(amodel.getAid()+"\t"+amodel.getName()+"\t"+amodel.getEmail()+"\t"+amodel.getContact()+"\t"+amodel.getAge()+"\t"+amodel.getCompany()+"\t"+amodel.getBid());
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
						   System.out.println("Update Alumni Details.....");
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
						   if(b)
						   {
							   System.out.println("Alumni Updated Successfully.....");
						   }
						   else
						   {
							   System.out.println("There Might be Some Issue:");
						   }
						   v = ams.getAlumni();
						   if(v!=null)
						   {
							   System.out.println("Alumni are Present in Database....");
							   for(AlumniMasterModel amodel:v)
							   {
								   System.out.println(amodel.getAid()+"\t"+amodel.getName()+"\t"+amodel.getEmail()+"\t"+amodel.getContact()+"\t"+amodel.getAge()+"\t"+amodel.getCompany()+"\t"+amodel.getBid());
								   System.out.println(" "); 
							   }
						   }
						   else
						   {
							   System.out.println("There might be some issue as database does not have alumni details....");
							   System.out.println(" ");
						   }
					       break;
					   case 5:
						   System.out.println("Delete the Alumni Details......");
						   System.out.println(" ");
						   System.out.println("Enter the Alumni Id which you want to delete.....");
						   int aid1 = xyz.nextInt();
						   am.setAid(aid1);
						   flag = ams.deleteid(am);
						   if(flag==1)
						   {
							   System.out.println("Alumni with id " + aid1 +" has been Removed Successfully....");
						   }
						   else
						   {
							   System.out.println("Alumni with id " + aid1 +" has not been Removed, there might be some issue....");
						   }
						   v = ams.getAlumni();
						   if(v!=null)
						   {
							   System.out.println("Alumni are Present in Database....");
							   for(AlumniMasterModel amodel:v)
							   {
								   System.out.println(amodel.getAid()+"\t"+amodel.getName()+"\t"+amodel.getEmail()+"\t"+amodel.getContact()+"\t"+amodel.getAge()+"\t"+amodel.getCompany()+"\t"+amodel.getBid());
								   System.out.println(" "); 
							   }
						   }
						   else
						   {
							   System.out.println("There might be some issue as database does not have alumni details....");
							   System.out.println(" ");
						   }
						   break;
					   }    
				   }while(choice!=6);
		    }
	     }while(true);
	}
}
