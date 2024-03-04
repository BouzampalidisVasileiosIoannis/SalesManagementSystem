package test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import data.Receipt;
import data.SalesManager;
import output.HTMLReportGenerator;

public class HTMLReportGeneratorTest {

    private static final String TEST_FILE_PATH = "G:\\9th_semester\\SoftwareDevelopment2\\Project\\soft-devII-2024-project-material\\test_files\\htmlReportTest.html";

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

        File testFile = new File(TEST_FILE_PATH);
        HTMLReportGenerator reportGenerator = new HTMLReportGenerator(salesManager, testFile);

        reportGenerator.openFile();
        reportGenerator.writeSalesData();
        reportGenerator.closeFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.trim());
            }

            assertEquals("<html><head><title>Sales Report</title></head><body><h1>Sales Report for Bill</h1>" +
                    "<p><strong>AFM:</strong> 987654321</p><br><p><strong>Total Sales:</strong> 200.0</p>" +
                    "<p><strong>Trousers Sales:</strong> 2.0</p><p><strong>Skirts Sales:</strong> 0.0</p>" +
                    "<p><strong>Shirts Sales:</strong> 3.0</p><p><strong>Coats Sales:</strong> 1.0</p><br>" +
                    "<p><strong>Commission:</strong> 0.0</p></body></html>", content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
