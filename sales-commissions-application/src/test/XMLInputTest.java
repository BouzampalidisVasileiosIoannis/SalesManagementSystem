package test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import input.XMLInput;

public class XMLInputTest {

    private static final String TEST_FILE_PATH = "G:\\9th_semester\\SoftwareDevelopment2\\Project\\soft-devII-2024-project-material\\test_files\\xmlInputTest.xml";
    

    @Test
    public void testReadDataFromLines() {

        File testFile = new File(TEST_FILE_PATH);
        XMLInput xmlInput = new XMLInput(testFile);

        xmlInput.openFile();
        xmlInput.readDataFromLines();
        xmlInput.closeFile();

        assertEquals("Vasileios Bouzampalidis", xmlInput.getAgent().getName());
        assertEquals("785412369", xmlInput.getAgent().getAfm());

        assertEquals(1, xmlInput.getAgent().getReceipts().get(0).getReceiptID());
        assertEquals("3/3/2014", xmlInput.getAgent().getReceipts().get(0).getDate());
        assertEquals("Coat", xmlInput.getAgent().getReceipts().get(0).getKind());
        assertEquals(2000.0, xmlInput.getAgent().getReceipts().get(0).getSales(), 0.01);
        assertEquals(10, xmlInput.getAgent().getReceipts().get(0).getItems());

        assertEquals("Hand Made Clothes", xmlInput.getAgent().getReceipts().get(0).getCompany().getName());
        assertEquals("Greece", xmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCountry());
        assertEquals("Ioannina", xmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCity());
        assertEquals("Kaloudi", xmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreet());
        assertEquals(9, xmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreetNumber());
    }
}