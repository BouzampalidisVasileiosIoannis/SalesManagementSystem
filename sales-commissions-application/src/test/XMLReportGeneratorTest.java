package test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import output.XMLReportGenerator;
import data.Receipt;
import data.SalesManager;

public class XMLReportGeneratorTest {

    private static final String TEST_FILE_PATH = "G:\\9th_semester\\SoftwareDevelopment2\\Project\\soft-devII-2024-project-material\\test_files\\xmlReportTest.xml";

    @Test
    public void testWriteSalesData() {

        SalesManager salesManager = new SalesManager();
        salesManager.setAfm("987654321");
		salesManager.setName("Bill");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setReceiptID(10);
		testReceipt.setDate("01/01/2023");
		testReceipt.setKind("Trouser");
		testReceipt.setSales(50);
		testReceipt.setItems(2);	
		
		
		Receipt testReceipt2 = new Receipt();
		testReceipt2.setReceiptID(11);
		testReceipt2.setDate("02/01/2023");
		testReceipt2.setKind("Shirt");
		testReceipt2.setSales(30);
		testReceipt2.setItems(3);
		
		Receipt testReceipt3 = new Receipt();
		testReceipt3.setReceiptID(12);
		testReceipt3.setDate("03/01/2023");
		testReceipt3.setKind("Coat");
		testReceipt3.setSales(120);
		testReceipt3.setItems(1);

        salesManager.getReceipts().add(testReceipt);
        salesManager.getReceipts().add(testReceipt2);
        salesManager.getReceipts().add(testReceipt3);

        // Create a TXTReportGenerator
        File testFile = new File(TEST_FILE_PATH);
        XMLReportGenerator reportGenerator = new XMLReportGenerator(salesManager, testFile);

        // Generate the report
        reportGenerator.openFile();
        reportGenerator.writeSalesData();
        reportGenerator.closeFile();

     // Read the generated XML and verify its contents
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.trim());
            }

            assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"+ "<Agent><Name>Bill</Name><AFM>987654321</AFM><TotalSales>200.0</TotalSales>" +
                    "<TrouserSales>2.0</TrouserSales><SkirtsSales>0.0</SkirtsSales><ShirtsSales>3.0</ShirtsSales>" +
                    "<CoatsSales>1.0</CoatsSales><Commission>0.0</Commission></Agent>", content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
