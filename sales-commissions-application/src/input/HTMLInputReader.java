package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HTMLInputReader extends Input{
	
	private BufferedReader br = null;

	public HTMLInputReader(File recieptFileHTML) {
		this.inputFile = recieptFileHTML;
		inputFilePath = inputFile.getAbsolutePath();
	}

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
		try{
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains("<Name>")) {
                    name = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim();
                } else if (line.contains("<AFM>")) {
                    afm = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim();
                    addAgent();  // Assuming there's a method named addAgent() to handle agent data
                } else if (line.contains("<ReceiptID>")) {
                    receiptID = Integer.parseInt(line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim());
                } else if (line.contains("<Date>")) {
                    date = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim();
                } else if (line.contains("<Kind>")) {
                    kind = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim();
                } else if (line.contains("<Sales>")) {
                    sales = Double.parseDouble(line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim());
                } else if (line.contains("<Items>")) {
                    items = Integer.parseInt(line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim());
                } else if (line.contains("<Company>")) {
                    companyName = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim();
                } else if (line.contains("<Country>")) {
                    companyCountry = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim();
                } else if (line.contains("<City>")) {
                    companyCity = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim();
                } else if (line.contains("<Street>")) {
                    companyStreet = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim();
                } else if (line.contains("<Number>")) {
                    companyStreetNumber = Integer.parseInt(line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).trim());
                    addReceipt();  // Assuming there's a method named addReceipt() to handle receipt data
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void closeFile() {
	    if (br != null) {
	        try {
	            br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

}

