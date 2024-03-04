package test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import input.HTMLInputReader;

public class HTMLInputReaderTest {

    private static final String TEST_FILE_PATH = "G:\\9th_semester\\SoftwareDevelopment2\\Project\\soft-devII-2024-project-material\\test_files\\htmlInputTest.html";
    

    @Test
    public void testReadDataFromLines() {

        File testFile = new File(TEST_FILE_PATH);
        HTMLInputReader htmlInput = new HTMLInputReader(testFile);

        htmlInput.openFile();
        htmlInput.readDataFromLines();
        htmlInput.closeFile();

        assertEquals("John James", htmlInput.getAgent().getName());
        assertEquals("1357924680", htmlInput.getAgent().getAfm());

        assertEquals(1, htmlInput.getAgent().getReceipts().get(0).getReceiptID());
        assertEquals("10/10/23", htmlInput.getAgent().getReceipts().get(0).getDate());
        assertEquals("Coat", htmlInput.getAgent().getReceipts().get(0).getKind());
        assertEquals(1000.0, htmlInput.getAgent().getReceipts().get(0).getSales(), 0.01);
        assertEquals(5, htmlInput.getAgent().getReceipts().get(0).getItems());

        assertEquals("Company A", htmlInput.getAgent().getReceipts().get(0).getCompany().getName());
        assertEquals("Country A", htmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCountry());
        assertEquals("City A", htmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getCity());
        assertEquals("Street A", htmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreet());
        assertEquals(123, htmlInput.getAgent().getReceipts().get(0).getCompany().getCompanyAddress().getStreetNumber());
    }
}
