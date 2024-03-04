package test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import output.TXTReportGenerator;
import data.Receipt;
import data.SalesManager;

public class TXTReportGeneratorTest {

    private static final String TEST_FILE_PATH = "G:\\9th_semester\\SoftwareDevelopment2\\Project\\soft-devII-2024-project-material\\test_files\\txtReportTest.txt";

    @Test
    public void testWriteSalesData() {

        // Create a SalesManager with some data
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
        TXTReportGenerator reportGenerator = new TXTReportGenerator(salesManager, testFile);

        // Generate the report
        reportGenerator.openFile();
        reportGenerator.writeSalesData();
        reportGenerator.closeFile();

        // Read the generated report and verify its contents
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {

            assertEquals("Name: Bill", reader.readLine());
            assertEquals("AFM: 987654321", reader.readLine());
            assertEquals("", reader.readLine());
            assertEquals("", reader.readLine()); 

            assertEquals("Total Sales: 200.0", reader.readLine());
            assertEquals("Trousers Sales: 2.0", reader.readLine());
            assertEquals("Skirts Sales: 0.0", reader.readLine()); 
            assertEquals("Shirts Sales: 3.0", reader.readLine());
            assertEquals("Coats Sales: 1.0", reader.readLine());
            assertEquals("Commission: 0.0", reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
