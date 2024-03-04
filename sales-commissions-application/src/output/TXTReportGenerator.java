package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.ClothesKind;
import data.SalesManager;


public class TXTReportGenerator extends ReportGenerator{

	private BufferedWriter bufferedWriter = null;
	private File fileToSave;
	
	
	//UPDATED CONSTRUCTOR
	public TXTReportGenerator(SalesManager a,File file){
		agent = a;
		fileToSave = file;
	}


	//IMPLEMENTATION OF THE ABSTRACT METHODS OF THE Report CLASS
	@Override
	public void openFile() {
	    try {
	        bufferedWriter = new BufferedWriter(new FileWriter(fileToSave));
	    } catch (IOException ex) {
	        JOptionPane.showMessageDialog(null, "Error creating or writing to the file.");
	    }
	}

	
	@Override
	public void writeSalesData() {
		try {
			bufferedWriter.write("Name: " + agent.getName()); 
	        bufferedWriter.newLine();

	        bufferedWriter.write("AFM: " + agent.getAfm());
	        bufferedWriter.newLine();
	        bufferedWriter.newLine();
	        bufferedWriter.newLine();

	        
	        bufferedWriter.write("Total Sales: " + agent.calculateTotalSales());
	        bufferedWriter.newLine();

	        bufferedWriter.write("Trousers Sales: " + agent.calculateKindSales(ClothesKind.TROUSER.getValue()));
	        bufferedWriter.newLine();

	        bufferedWriter.write("Skirts Sales: " + agent.calculateKindSales(ClothesKind.SKIRT.getValue()));
	        bufferedWriter.newLine();

	        bufferedWriter.write("Shirts Sales: " + agent.calculateKindSales(ClothesKind.SHIRT.getValue()));
	        bufferedWriter.newLine();
	        
	        bufferedWriter.write("Coats Sales: " + agent.calculateKindSales(ClothesKind.COAT.getValue()));
	        bufferedWriter.newLine();

	        bufferedWriter.write("Commission: " + agent.calculateCommission());
		} catch (IOException ex){
			JOptionPane.showMessageDialog(null,"Report Not Generated");
		}
		
		
	}
	
	@Override
	public void closeFile() {
		try {
			bufferedWriter.close();
		} catch (IOException ex){
			JOptionPane.showMessageDialog(null,"Could Not Close File");
		}
		
	}


	


	

}
