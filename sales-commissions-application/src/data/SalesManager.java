package data;


import java.util.ArrayList;

import input.ReceiptFileUpdater;
import input.HtmlFileReceiptUpdater;
import input.TextFileReceiptUpdater;
import input.XmlFileReceiptUpdater;


//PROVIDING APPROPRIATE NAME TO THE CLASS
public class SalesManager { 
	private String name;
	private String afm;
	
	//FIXING DEPRECATED VECTOR PROBLEM BY CHANGING IT TO ARRAYLIST
	
	private ArrayList <Receipt> allReceipts;
	private ReceiptFileUpdater receiptFileUpdater;
	static final int LOWER_TOTAL_SALES = 6000;
	static final int HIGHER_TOTAL_SALES = 40000;
	static final int MEDIAN_TOTAL_SALES = 10000;
	
	public SalesManager(){
		allReceipts = new ArrayList<Receipt>();
	}
	
	public void setFileType(String fileType) {
		if(fileType.equals("TXT")){
			receiptFileUpdater = new TextFileReceiptUpdater();
		}	
		else if(fileType.equals("XML")){
			receiptFileUpdater = new XmlFileReceiptUpdater();
		}
		else if(fileType.equals("HTML"))
		{
			receiptFileUpdater = new HtmlFileReceiptUpdater();
		}
	}
	public ArrayList<Receipt> getReceipts(){
		return allReceipts;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAfm() {
		return afm;
	}
	public void setAfm(String afm) {
		this.afm = afm;
	}

	public double calculateTotalSales(){
		double sumSales = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			sumSales += allReceipts.get(i).getSales();
		}
		return sumSales;
	}
	

	public int calculateTotalItems(){
		int sumItems = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			sumItems += allReceipts.get(i).getItems();
		}
		return sumItems;
	}
	
	
	//FIXING DUPLICATION PROBLEM BY ADDING A PARAMETERIZED METHOD, KEEPING THE CORE AND DELETING THE DUPLICATE METHODS
	
	public float calculateKindSales(String clothingKind) {
		float kindSum = 0;
		for (int i = 0; i< allReceipts.size(); i++){
			if(allReceipts.get(i).getKind().equals(clothingKind)){
				kindSum += allReceipts.get(i).getItems();
			}
		}
		return kindSum;
	}
	
	
	//FIXING DUPLICATION PROBLEM BY ADDING STATIC FINAL VARIABLES AND ASSIGNING APPROPRIATE VALUES TO THEM
	
	public double calculateCommission(){
		double commission = 0;
		if( this.calculateTotalSales() > LOWER_TOTAL_SALES && this.calculateTotalSales()<= MEDIAN_TOTAL_SALES){
			commission = 0.1*(calculateTotalSales()-LOWER_TOTAL_SALES);
		}
		else if(this.calculateTotalSales() > MEDIAN_TOTAL_SALES && this.calculateTotalSales() <= HIGHER_TOTAL_SALES ){
			commission = (((calculateTotalSales() - MEDIAN_TOTAL_SALES) * 0.15) + (MEDIAN_TOTAL_SALES*0.1));			
		}
		else if(this.calculateTotalSales() > HIGHER_TOTAL_SALES ) {
			commission = MEDIAN_TOTAL_SALES*0.1 + 30000*0.15 + (calculateTotalSales() - HIGHER_TOTAL_SALES)*0.2;			
		}
		return commission;
	}


	public ReceiptFileUpdater getFileAppender() {
		return receiptFileUpdater;
	}


}
