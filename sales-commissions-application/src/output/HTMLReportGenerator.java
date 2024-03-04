package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.ClothesKind;
import data.SalesManager;

public class HTMLReportGenerator extends ReportGenerator{

	private BufferedWriter bufferedWriter = null;;
	private File fileToSave;
	
	//UPDATED CONSTRUCTOR
		public HTMLReportGenerator(SalesManager a,File file){
			agent = a;
			fileToSave = file;
		}
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
            bufferedWriter.write("<html>\n<head>\n<title>Sales Report</title>\n</head>\n<body>\n");

            bufferedWriter.write("<h1>Sales Report for " + agent.getName() + "</h1>\n");
            bufferedWriter.write("<p><strong>AFM:</strong> " + agent.getAfm() + "</p>\n");
            bufferedWriter.write("<br>\n");

            bufferedWriter.write("<p><strong>Total Sales:</strong> " + agent.calculateTotalSales() + "</p>\n");
            bufferedWriter.write("<p><strong>Trousers Sales:</strong> " + agent.calculateKindSales(ClothesKind.TROUSER.getValue()) + "</p>\n");
            bufferedWriter.write("<p><strong>Skirts Sales:</strong> " + agent.calculateKindSales(ClothesKind.SKIRT.getValue()) + "</p>\n");
            bufferedWriter.write("<p><strong>Shirts Sales:</strong> " + agent.calculateKindSales(ClothesKind.SHIRT.getValue()) + "</p>\n");
            bufferedWriter.write("<p><strong>Coats Sales:</strong> " + agent.calculateKindSales(ClothesKind.COAT.getValue()) + "</p>\n");
            bufferedWriter.write("<br>\n");

            bufferedWriter.write("<p><strong>Commission:</strong> " + agent.calculateCommission() + "</p>\n");

            bufferedWriter.write("</body>\n</html>\n");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error writing to the HTML file.");
        }
		
	}
	
	@Override
	public void closeFile() {
		try {
            bufferedWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error closing the HTML file.");
        }
		
	}
}
