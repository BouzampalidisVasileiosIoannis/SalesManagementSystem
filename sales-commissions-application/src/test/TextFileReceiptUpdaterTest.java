package test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import data.Receipt;
import input.TXTInput;
import input.TextFileReceiptUpdater;

public class TextFileReceiptUpdaterTest {

    private static final String TEST_FILE_PATH = "G:\\9th_semester\\SoftwareDevelopment2\\Project\\soft-devII-2024-project-material\\test_files\\txtInputTest.txt";
    
    private File test = new File(TEST_FILE_PATH);

    @Test
    public void testWriteDataFields() {

        Receipt receipt = new Receipt();
        receipt.setReceiptID(3);
        receipt.setDate("23/12/2023"); 
        receipt.setKind("Coat");
        receipt.setSales(1500);
        receipt.setItems(5);

        receipt.getCompany().setName("TestCompany");
        receipt.getCompany().getCompanyAddress().setCountry("TestCountry");
        receipt.getCompany().getCompanyAddress().setCity("TestCity");
        receipt.getCompany().getCompanyAddress().setStreet("TestStreet");
        receipt.getCompany().getCompanyAddress().setStreetNumber(42);

        
        TextFileReceiptUpdater updater = new TextFileReceiptUpdater();
        updater.setFileToAppend(test);
        updater.setReceiptInfo(receipt);

        updater.appendFile();

        TXTInput txtInput = new TXTInput(test);
        txtInput.openFile();
        txtInput.readDataFromLines();
        txtInput.closeFile();


        assertEquals(3, txtInput.getAgent().getReceipts().get(2).getReceiptID());
        assertEquals("23/12/2023", txtInput.getAgent().getReceipts().get(2).getDate());
        assertEquals("Coat", txtInput.getAgent().getReceipts().get(2).getKind());
        assertEquals(1500.0, txtInput.getAgent().getReceipts().get(2).getSales(), 0.01); 
        assertEquals(5, txtInput.getAgent().getReceipts().get(2).getItems());

        assertEquals("TestCompany", txtInput.getAgent().getReceipts().get(2).getCompany().getName());
        assertEquals("TestCountry", txtInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getCountry());
        assertEquals("TestCity", txtInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getCity());
        assertEquals("TestStreet", txtInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getStreet());
        assertEquals(42, txtInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getStreetNumber());

    }
}
