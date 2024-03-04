package input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



//MOVED TO INPUT PACKAGE FOR CORRECT IMPLEMENTATION OF THE IO OPERATIONS

public class TextFileReceiptUpdater extends ReceiptFileUpdater{
	
	private FileWriter fileWriter;
		
	public  void setFileToAppend(File fileToAppend) {
		
		this.fileToAppend = fileToAppend;
		
	}
	
	//IMPLEMENTATION OF THE ABSTRACT METHODS OF THE FileAppender CLASS
	
	@Override
	public void openFile() {
		System.out.println(fileToAppend.getAbsolutePath());

		try {
			
			fileWriter = new FileWriter(fileToAppend,true);		
			fileWriter.write("\n");
		
			} catch (IOException e) {
			
				e.printStackTrace();
		}
	}

	@Override
	public void writeDataFields() {
		try {
			
			fileWriter.write("Receipt ID: ");
			fileWriter.write(receipt.getReceiptID()+"");
			fileWriter.write("\n");
	
			fileWriter.write("Date: ");
			fileWriter.write(receipt.getDate());
			fileWriter.write("\n");
	
			fileWriter.write("Kind: ");
			fileWriter.write(receipt.getKind());
			fileWriter.write("\n");
	
			fileWriter.write("Sales: ");
			//TRANSFORMING getSales() TYPE FROM DOUBLE TO STRING
			fileWriter.write(receipt.getSales()+"");
			fileWriter.write("\n");
	
			fileWriter.write("Items: ");
			fileWriter.write(receipt.getItems()+"");
			fileWriter.write("\n");
	
			fileWriter.write("Company: ");
			fileWriter.write(receipt.getCompany().getName());
			fileWriter.write("\n");
	
	
			fileWriter.write("Country: ");
			fileWriter.write(receipt.getCompany().getCompanyAddress().getCountry());
			fileWriter.write("\n");
			
			fileWriter.write("City: ");
			fileWriter.write(receipt.getCompany().getCompanyAddress().getCity());
			fileWriter.write("\n");
	
			fileWriter.write("Street: ");
			fileWriter.write(receipt.getCompany().getCompanyAddress().getStreet());
			fileWriter.write("\n");
	
			fileWriter.write("Number: ");
			fileWriter.write(receipt.getCompany().getCompanyAddress().getStreetNumber()+"");
			fileWriter.write("\n");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void closeFile() {
		try {

			fileWriter.close();

		}catch (IOException e) {

			e.printStackTrace();
		}
	}
}
