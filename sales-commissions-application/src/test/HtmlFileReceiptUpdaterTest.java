package test;

import static org.junit.Assert.assertEquals;


import java.io.File;

import org.junit.Test;

import data.Receipt;
import input.HTMLInputReader;
import input.HtmlFileReceiptUpdater;

public class HtmlFileReceiptUpdaterTest {

    private static final String TEST_FILE_PATH = "G:\\9th_semester\\SoftwareDevelopment2\\Project\\soft-devII-2024-project-material\\test_files\\htmlInputTest.html";

    private File test = new File(TEST_FILE_PATH);
    @Test
    public void testWriteDataFields() {

        Receipt receipt = new Receipt();
        receipt.setReceiptID(5);
        receipt.setDate("25/12/2023");
        receipt.setKind("Coat");
        receipt.setSales(800);
        receipt.setItems(2);

        receipt.getCompany().setName("TestCompany3");
        receipt.getCompany().getCompanyAddress().setCountry("TestCountry3");
        receipt.getCompany().getCompanyAddress().setCity("TestCity3");
        receipt.getCompany().getCompanyAddress().setStreet("TestStreet3");
        receipt.getCompany().getCompanyAddress().setStreetNumber(33);

        HtmlFileReceiptUpdater updater = new HtmlFileReceiptUpdater();
        updater.setFileToAppend(test);
        updater.setReceiptInfo(receipt);

        updater.appendFile();

        HTMLInputReader htmlInput = new HTMLInputReader(test);
        htmlInput.openFile();
        htmlInput.readDataFromLines();
        htmlInput.closeFile();

        assertEquals(5, htmlInput.getAgent().getReceipts().get(2).getReceiptID());
        assertEquals("25/12/2023", htmlInput.getAgent().getReceipts().get(2).getDate());
        assertEquals("Coat", htmlInput.getAgent().getReceipts().get(2).getKind());
        assertEquals(800.0, htmlInput.getAgent().getReceipts().get(2).getSales(), 0.01);
        assertEquals(2, htmlInput.getAgent().getReceipts().get(2).getItems());

        assertEquals("TestCompany3", htmlInput.getAgent().getReceipts().get(2).getCompany().getName());
        assertEquals("TestCountry3", htmlInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getCountry());
        assertEquals("TestCity3", htmlInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getCity());
        assertEquals("TestStreet3", htmlInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getStreet());
        assertEquals(33, htmlInput.getAgent().getReceipts().get(2).getCompany().getCompanyAddress().getStreetNumber());
    }
}
