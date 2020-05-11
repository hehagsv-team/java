package org.hcl.harika.schoolMgmt;
import org.apache.log4j.Logger;


public class MenuClass {
	final static Logger logger=Logger.getLogger("MenuClass.class");
	public void subjects() {
		logger.info("Enter the subject Name:");
		logger.info("1: PHYSICS");
		logger.info("2: CHEMISTRY");
		logger.info("3: BIOLOGY");
		logger.info("4: HISTORY");
		logger.info("5: GEOGRAPHY");
		logger.info("6: POLITICAL SCIENCE");
		logger.info("7: ECONOMICS");
		logger.info("8: ENGLISH");
		logger.info("9: HINDI");
		logger.info("10: MATHS");		
	}
public void classname() {
	logger.info("Enter the class name:");
	logger.info("1: class name 6: ");
	logger.info("2: class name 7: ");
	logger.info("3: class name 8: ");
	logger.info("4: class name 9: ");
	logger.info("5: class name 10: ");	   
	}
public void schooljdbc() {
	logger.info("Options:");
	logger.info("1. Teacher who teaches in one particular Class");
	logger.info("2. Average marks in each Class");
	logger.info("3. Mark Distribution for each subject");
	logger.info("4. Best Teacher");
	logger.info("5. Student Topper in each Class");
	logger.info("6. Student Topper in each subject in each Class ");
	logger.info("7. all subjects does a class teacher teach");
	logger.info("8. how many teaches each subject");
	logger.info("9. class strength");
	logger.info("11. Back to school menu");
		
	}
}


