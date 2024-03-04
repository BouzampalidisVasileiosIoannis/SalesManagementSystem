package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class TXTInput extends Input{

	private String line;
	
	private BufferedReader br = null;
	
	public TXTInput(File recieptFileTXT){
		this.inputFile = recieptFileTXT;
		inputFilePath =  inputFile.getAbsolutePath();
		
		
	}
	
	//IMPLEMENTATION OF THE ABSTRACT METHODS OF THE Input CLASS

	@Override
	public void openFile() {
	    try {
	            	
			br = new BufferedReader(new FileReader(inputFilePath));
		} catch (FileNotFoundException e1) {
				e1.printStackTrace();
		}
	}

	@Override
	public void readDataFromLines() {
		try {

	    	line = br.readLine();
				
			name = (line.substring(line.indexOf(":") + 1).trim());
					
			line = br.readLine();
		
			afm = (line.substring(line.indexOf(":") + 1).trim());
			addAgent();
				
			line = br.readLine();
			line = br.readLine();
			line = br.readLine();
			
			while ((line = br.readLine()) != null) {
	
				receiptID = (Integer.parseInt(line.substring
				(line.indexOf(":") + 1).trim()));	
			
				line = br.readLine();
							
				date = (line.substring(line.indexOf(":") + 1).trim());
				
				line = br.readLine();
							
				kind = (line.substring(line.indexOf(":") + 1).trim());
			
				line = br.readLine();
							
				sales = (Double.parseDouble(line.substring
				(line.indexOf(":") + 1).trim()));
						
				line = br.readLine();
							
				items = (Integer.parseInt(line.substring
				(line.indexOf(":") + 1).trim()));
						
				line = br.readLine();
				
				companyName = (line.substring
				(line.indexOf(":") + 1).trim());
			
				line = br.readLine();
				
				companyCountry =  (line.substring
				(line.indexOf(":") + 1).trim());
				
				line = br.readLine();
				
				companyCity =  (line.substring
				(line.indexOf(":") + 1).trim());
				
				line = br.readLine();
				
				companyStreet =  (line.substring
				(line.indexOf(":") + 1).trim());
					
				line = br.readLine();
				
				companyStreetNumber =  (Integer.parseInt
				(line.substring(line.indexOf(":") + 1).trim()));
				addReceipt();
			
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeFile() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
