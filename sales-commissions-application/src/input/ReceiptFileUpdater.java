package input;

import java.io.File;

import data.Receipt;

//MOVED TO INPUT PACKAGE FOR CORRECT IMPLEMENTATION OF THE IO OPERATIONS

public abstract class ReceiptFileUpdater {

	protected File fileToAppend;
	protected String country;
	protected String city;
	protected String street;
	protected String number;
	
	//CREATING A RECEIPT OBJECT TO FIX PRIMITIVE OBSESSION
	//DELETING UNNECESSARY FIELDS
	protected Receipt receipt = new Receipt();
	
	//TEMPLATE METHOD WITH ABSTRACT METHODS TO BE IMPLEMENTED ACCORDINGLY
	public void appendFile() {
		try {
			openFile();
			
			writeDataFields();
			
			closeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public abstract void setFileToAppend(File fileToAppend); 
	
	//CREATING APPROPRIATE METHOD
	//DELETING UNNECESSARY METHODS
	public void setReceiptInfo(Receipt receipt) {
		this.receipt = receipt;
	}
	//ABSTRACT METHODS TO BE IMPLEMENTED DIFFERENTLY
	public abstract void openFile();
	public abstract void writeDataFields();
	public abstract void closeFile();

}

