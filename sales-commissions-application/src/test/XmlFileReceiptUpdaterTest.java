package test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import data.Receipt;
import input.XMLInput;
import input.XmlFileReceiptUpdater;

public class XmlFileReceiptUpdaterTest {

    private static final String TEST_FILE_PATH = "G:\\9th_semester\\SoftwareDevelopment2\\Project\\soft-devII-2024-project-material\\test_files\\xmlInputTest.xml";

    
    private File test = new File(TEST_FILE_PATH);
    @Test
    public void testWriteDataFields() {

        Receipt receipt = new Receipt();
        receipt.setReceiptID(4);
        receipt.setDate("24/12/2023");
        receipt.setKind("Shirts");
        receipt.setSales(1200);
        receipt.setItems(3);

        receipt.getCompany().setName("TestCompany2");
        receipt.getCompany().getCompanyAddress().setCountry("TestCountry2");
        receipt.getCompany().getCompanyAddress().setCity("TestCity2");
        receipt.getCompany().getCompanyAddress().setStreet("TestStreet2");
        receipt.getCompany().getCompanyAddress().setStreetNumber(21); 

        XmlFileReceiptUpdater updater = new XmlFileReceiptUpdater();
        updater.setFileToAppend(test);
        updater.setReceiptInfo(receipt);

        updater.appendFile();

        XMLInput xmlInput = new XMLInput(test);
        xmlInput.openFile();
        xmlInput.readDataFromLines();
        xmlInput.closeFile();

        assertEquals(4, xmlInput.getAgent().getReceipts().get(2).getReceiptID());
        assertEquals("24/12/2023", xmlInput.getAgent().getReceipts().get(2).getDate());
        assertEquals("Shirt", xmlInput.getAgent().getReceipts().get(2).getKind());
        assertEquals(1200.0, xmlInput.getAgent().getReceipts().get(2).getSales(), 0.01);
        assertEquals(3, xmlInput.getAgent().getReceipts().get(2).getItems());

        assertEquals("TestCompany2", xmlInput.getAgent().getReceipts().get(2).getCompany().getName());
        assertEquals("TestCountry2", xmlInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getCountry());
        assertEquals("TestCity2", xmlInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getCity());
        assertEquals("TestStreet2", xmlInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getStreet());
        assertEquals(21, xmlInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getStreetNumber());
    }
}
