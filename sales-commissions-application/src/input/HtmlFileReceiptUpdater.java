package input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlFileReceiptUpdater extends ReceiptFileUpdater {

	
	private FileWriter fileWriter;
	@Override
	public void setFileToAppend(File fileToAppend) {
		this.fileToAppend = fileToAppend;
		
	}

	@Override
	public void openFile() {
		System.out.println("Entered HTML file");
        System.out.println(fileToAppend.getAbsolutePath());

        try {
            fileWriter = new FileWriter(fileToAppend, true);
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void writeDataFields() {
		try {
            fileWriter.write("<Receipt>\n");

            fileWriter.write("\t<ReceiptID>");
            fileWriter.write(String.valueOf(receipt.getReceiptID()));
            fileWriter.write("</ReceiptID>\n");

            fileWriter.write("\t<Date>");
            fileWriter.write(receipt.getDate());
            fileWriter.write("</Date>\n");

            fileWriter.write("\t<Kind>");
            fileWriter.write(receipt.getKind());
            fileWriter.write("</Kind>\n");

            fileWriter.write("\t<Sales>");
            fileWriter.write(String.valueOf(receipt.getSales()));
            fileWriter.write("</Sales>\n");

            fileWriter.write("\t<Items>");
            fileWriter.write(String.valueOf(receipt.getItems()));
            fileWriter.write("</Items>\n");

            fileWriter.write("\t<Company>");
            fileWriter.write(receipt.getCompany().getName());
            fileWriter.write("</Company>\n");

            fileWriter.write("\t<Country>");
            fileWriter.write(receipt.getCompany().getCompanyAddress().getCountry());
            fileWriter.write("</Country>\n");

            fileWriter.write("\t<City>");
            fileWriter.write(receipt.getCompany().getCompanyAddress().getCity());
            fileWriter.write("</City>\n");

            fileWriter.write("\t<Street>");
            fileWriter.write(receipt.getCompany().getCompanyAddress().getStreet());
            fileWriter.write("</Street>\n");

            fileWriter.write("\t<Number>");
            fileWriter.write(String.valueOf(receipt.getCompany().getCompanyAddress().getStreetNumber()));
            fileWriter.write("</Number>\n");

            fileWriter.write("</Receipt>\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void closeFile() {
		try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
