package input;


import java.io.File;
import data.SalesManager;
import data.ClothesKind;
import data.Receipt;

public abstract class Input {
	
	protected SalesManager salesManager;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected int receiptID;
	protected String date;
	protected String kind;
	protected double sales;
	protected int items;
	protected String companyName;
	protected String companyCountry;
	protected String companyCity;
	protected String companyStreet;
	protected int companyStreetNumber;

	
	
	//TEMPLATE METHOD WITH ABSTRACT METHODS TO BE IMPLEMENTED ACCORDINGLY
	public void readFile() {
		try {
			openFile();
			
			readDataFromLines();
			
			closeFile();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	//ABSTRACT METHODS TO BE IMPLEMENTED DIFFERENTLY
	public abstract void openFile();
	public abstract void readDataFromLines();
	public abstract void closeFile();	


	public Input() {
		salesManager = new SalesManager();
		kind  = new String("");
	}
	

	
	public void addAgent() {
		salesManager.setName(name);
		salesManager.setAfm(afm);
	}
	
	//FIXING addReceipt METHOD AFTER DELETING THE LAZY CLASSES,
	//USING THE setKind METHOD OF THE Receipt CLASS
	
	public void addReceipt( ){
		Receipt receipt = new Receipt();			
			if(kind.equals("Shirts")) {
				receipt.setKind(ClothesKind.SHIRT.getValue());
			}
			else if (kind.equals("Skirts")) {
				receipt.setKind(ClothesKind.SKIRT.getValue());
			}
			else if (kind.equals("Trousers")) {
				receipt.setKind(ClothesKind.TROUSER.getValue());
			}
			else {
				receipt.setKind(ClothesKind.COAT.getValue());
			}
			
			receipt.setReceiptID(receiptID);			
			receipt.setDate(date);
			receipt.setSales(sales);
			receipt.setItems(items);
			receipt.getCompany().setName(companyName);
			receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
			receipt.getCompany().getCompanyAddress().setCity(companyCity);
			receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
			receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
			salesManager.getReceipts().add(receipt);
	}
	public SalesManager getAgent() {
		return salesManager;
	}

	
}
