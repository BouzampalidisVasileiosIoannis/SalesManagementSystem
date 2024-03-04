package output;

import data.SalesManager;

public abstract class ReportGenerator {

	protected SalesManager agent;
	
	
	
	//TEMPLATE METHOD WITH ABSTRACT METHODS TO BE IMPLEMENTED ACCORDINGLY
	public void saveFile() {
		try {
			openFile();
			
			writeSalesData();
			
			closeFile();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//ABSTRACT METHODS TO BE IMPLEMENTED DIFFERENTLY
	public abstract void closeFile();
	public abstract void writeSalesData();
	public abstract void openFile();
}
