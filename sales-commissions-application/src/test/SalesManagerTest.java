package test;

import static org.junit.Assert.*;

import org.junit.Test;

import data.Receipt;
import data.SalesManager;
import input.HtmlFileReceiptUpdater;
import input.TextFileReceiptUpdater;
import input.XmlFileReceiptUpdater;

public class SalesManagerTest {
	
	// CalculateTotalSales

	@Test
	public void testCalculateTotalSalesWithNoReceipt() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		assertEquals(0.0, testManager.calculateTotalSales(), 0.01);
		
	}
	
	@Test
	public void testCalculateTotalSalesWithReceipt() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("987654321");
		testManager.setName("Bill");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setKind("Skirt");
		testReceipt.setSales(5000);
		testManager.getReceipts().add(testReceipt);
		assertEquals(5000.0, testManager.calculateTotalSales(), 0.01);
		
	}
	
	@Test
	public void testCalculateTotalSalesWithMultipleReceipts() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("987654321");
		testManager.setName("Bill");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setKind("Skirt");
		testReceipt.setSales(5000);
		testManager.getReceipts().add(testReceipt);
		
		Receipt testReceipt1 = new Receipt();
		testReceipt1.setKind("Shirt");
		testReceipt1.setSales(400);
		testManager.getReceipts().add(testReceipt1);
		
		Receipt testReceipt2 = new Receipt();
		testReceipt2.setKind("Coat");
		testReceipt2.setSales(2000);
		testManager.getReceipts().add(testReceipt2);
		
		assertEquals(7400.0, testManager.calculateTotalSales(), 0.01);
		
	}
	
	// CalculateTotalItems
	
	@Test
	public void testCalculateTotalItemsWithNoReceipt() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		assertEquals(0.0, testManager.calculateTotalItems(), 0.01);
		
	}
	
	@Test
	public void testCalculateTotalItemsWithReceipt() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("987654321");
		testManager.setName("Bill");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setKind("Skirt");
		testReceipt.setItems(10);
		testManager.getReceipts().add(testReceipt);
		assertEquals(10.0, testManager.calculateTotalItems(), 0.01);
		
	}
	
	@Test
	public void testCalculateTotalItemsWithMultipleReceipts() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("987654321");
		testManager.setName("Bill");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setKind("Coat");
		testReceipt.setItems(7);
		testManager.getReceipts().add(testReceipt);
		
		Receipt testReceipt1 = new Receipt();
		testReceipt1.setKind("Shirt");
		testReceipt1.setItems(12);
		testManager.getReceipts().add(testReceipt1);
		
		Receipt testReceipt2 = new Receipt();
		testReceipt2.setKind("Trousers");
		testReceipt2.setItems(2);
		testManager.getReceipts().add(testReceipt2);
		
		assertEquals(21.0, testManager.calculateTotalItems(), 0.01);
		
	}
	
	//CalculateKindSales
	
	@Test
	public void testCalculateKindSalesWithNoReceipt() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		assertEquals(0.0, testManager.calculateKindSales("Shirt"), 0.01);
		
	}
	
	@Test
	public void testCalculateKindSalesWithCorrectKind() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("987654321");
		testManager.setName("Bill");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setKind("Skirt");
		testReceipt.setItems(10);
		testManager.getReceipts().add(testReceipt);
		assertEquals(10.0, testManager.calculateKindSales("Skirt"), 0.01);
		
	}
	
	@Test
	public void testCalculateKindSalesWithWrongKind() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("987654321");
		testManager.setName("Bill");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setKind("Coat");
		testReceipt.setItems(3);
		testManager.getReceipts().add(testReceipt);
		assertEquals(0.0, testManager.calculateKindSales("Skirt"), 0.01);
		
	}
	
	
	@Test
	public void testCalculateKindSalesWithMultipleReceipts() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("987654321");
		testManager.setName("Bill");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setKind("Coat");
		testReceipt.setItems(7);
		testManager.getReceipts().add(testReceipt);
		
		Receipt testReceipt1 = new Receipt();
		testReceipt1.setKind("Shirt");
		testReceipt1.setItems(12);
		testManager.getReceipts().add(testReceipt1);
		
		Receipt testReceipt2 = new Receipt();
		testReceipt2.setKind("Shirt");
		testReceipt2.setItems(2);
		testManager.getReceipts().add(testReceipt2);
		
		assertEquals(14.0, testManager.calculateKindSales("Shirt"), 0.01);
		
	}
	
	
	//CalculateCommission
	
	@Test
	public void testCalculateCommissionWithNoReceipt() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		assertEquals(0.0, testManager.calculateCommission(), 0.01);
		
	}
	
	@Test
	public void testCalculateCommissionBelowLowerTotalSales() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setSales(5000);
		testManager.getReceipts().add(testReceipt);
		
		assertEquals(0.0, testManager.calculateCommission(), 0.01);
		
	}
	
	
	@Test
	public void testCalculateCommissionBetweenLowerAndMedianTotalSales() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setSales(8000);
		testManager.getReceipts().add(testReceipt);
		
		assertEquals(0.1 * (8000 - 6000), testManager.calculateCommission(), 0.01);
		
	}
	
	@Test
	public void testCalculateCommissionBetweenMedianAndHigherTotalSales() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setSales(20000);
		testManager.getReceipts().add(testReceipt);
		
		assertEquals(((20000 - 10000) * 0.15) + (10000 * 0.1), testManager.calculateCommission(), 0.01);
		
	}
	
	@Test
	public void testCalculateCommissionAboveHigherTotalSales() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setSales(45000);
		testManager.getReceipts().add(testReceipt);
		
		assertEquals(10000 * 0.1 + 30000 * 0.15 + (45000 - 40000) * 0.2, testManager.calculateCommission(), 0.01);
		
	}
	
	@Test
	public void testCalculateCommissionAtLowerTotalSales() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setSales(6000);
		testManager.getReceipts().add(testReceipt);
		
		assertEquals(0.0, testManager.calculateCommission(), 0.01);
		
	}
	
	@Test
	public void testCalculateCommissionAtMedianTotalSales() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setSales(10000);
		testManager.getReceipts().add(testReceipt);
		
		assertEquals(0.1 * (10000 - 6000), testManager.calculateCommission(), 0.01);
		
	}
	
	@Test
	public void testCalculateCommissionAtHigherTotalSales() {
		SalesManager testManager = new SalesManager();
		testManager.setAfm("123456789");
		testManager.setName("John");
		
		Receipt testReceipt = new Receipt();
		testReceipt.setSales(40000);
		testManager.getReceipts().add(testReceipt);
		
		assertEquals(((40000 - 10000) * 0.15) + (10000 * 0.1), testManager.calculateCommission(), 0.01);
		
	}
	
	
	//SetFileType
	
	 	@Test
	    public void testSetFileTypeTxt() {
	        SalesManager salesManager = new SalesManager();
	        salesManager.setFileType("TXT");

	        assertEquals(TextFileReceiptUpdater.class, salesManager.getFileAppender().getClass());
	    }

	    @Test
	    public void testSetFileTypeXml() {
	        SalesManager salesManager = new SalesManager();
	        salesManager.setFileType("XML");

	        assertEquals(XmlFileReceiptUpdater.class, salesManager.getFileAppender().getClass());
	    }

	    @Test
	    public void testSetFileTypeHtml() {
	        SalesManager salesManager = new SalesManager();
	        salesManager.setFileType("HTML");

	        assertEquals(HtmlFileReceiptUpdater.class, salesManager.getFileAppender().getClass());
	    }

	    @Test
	    public void testSetFileTypeInvalid() {
	        SalesManager salesManager = new SalesManager();
	        salesManager.setFileType("INVALID_TYPE");

	        assertEquals(null, salesManager.getFileAppender());
	    }

}
