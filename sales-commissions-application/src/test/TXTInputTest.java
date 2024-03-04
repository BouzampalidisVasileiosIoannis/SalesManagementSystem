package test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import input.TXTInput;

public class TXTInputTest {

    private static final String TEST_FILE_PATH = "G:\\9th_semester\\SoftwareDevelopment2\\Project\\soft-devII-2024-project-material\\test_files\\txtInputTest.txt";
    

    @Test
    public void testReadDataFromLines() {

        File testFile = new File(TEST_FILE_PATH);
        TXTInput txtInput = new TXTInput(testFile);

        txtInput.openFile();
        txtInput.readDataFromLines();
        txtInput.closeFile();

        assertEquals("Ioannis Fournaris", txtInput.getAgent().getName());
        assertEquals("548963217", txtInput.getAgent().getAfm());

        assertEquals(1, txtInput.getAgent().getReceipts().get(0).getReceiptID());
        assertEquals("23/4/2019", txtInput.getAgent().getReceipts().get(0).getDate());
        assertEquals("Shirt", txtInput.getAgent().getReceipts().get(0).getKind());
        assertEquals(4000.0, txtInput.getAgent().getReceipts().get(0).getSales(), 0.01);
        assertEquals(12, txtInput.getAgent().getReceipts().get(0).getItems());

        assertEquals("Hand Made Clothes", txtInput.getAgent().getReceipts().get(0).getCompany().getName());
        assertEquals("Greece", txtInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCountry());
        assertEquals("Ioannina", txtInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCity());
        assertEquals("Kaloudi", txtInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreet());
        assertEquals(12, txtInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreetNumber());
    }
}
