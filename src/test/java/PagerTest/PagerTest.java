package PagerTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Pager.Pager;

public class PagerTest {

	Pager pager = new Pager(4680, 20, 100);

	@Test
	public void shouldReturnTotalNumberOfItems() {
		int result = pager.getTotalNumberOfItems();
		assertEquals(4680, result);
	}

	@Test
	public void shouldReturnPageSize() {
		int result = pager.getPageSize();
		assertEquals(20, result);
	}

	@Test
	public void shouldReturnCurrentPageNumber() {
		int result = pager.getCurrentPageNumber();
		assertEquals(100, result);
	}

	@Test
	public void shouldReturnNumberOfPages() {
		int result = pager.calculateNumberOfPages();
		assertEquals(234, result);
	}

	@Test
	public void shouldRoundUpNumberOfPagesIfCalculationHasRemainder() {
		this.pager = new Pager(653, 20, 30);
		int result = pager.calculateNumberOfPages();
		assertEquals(33, result);
	}

	@Test
	public void shouldRecalculateNumberOfPagesWhenPageSizeIsChanged() {
		pager.setPageSize(40);
		int result = pager.calculateNumberOfPages();
		assertEquals(117, result);
	}
	
	@Test
	public void shouldNotDisplayPreviousPageLinkWhenOnPage1() {
		int currentPageNumber = 1;
		boolean result = pager.displayPreviousPageLink(currentPageNumber); 
		assertEquals(false, result);
	}
	
	@Test
	public void shouldDisplayPreviousPageLinkWhenOnPage2() {
		int currentPageNumber = 2;
		boolean result = pager.displayPreviousPageLink(currentPageNumber);
		assertEquals(true, result);
	}
	
	@Test
	public void shouldNotDisplayNextPageLinkWhenOnLastPage() {
		int currentPageNumber = pager.calculateNumberOfPages();
		boolean result = pager.displayNextPageLink(currentPageNumber);
		assertEquals(false, result);
	}
	
	@Test
	public void shouldDisplayNextPageLinkWhenNotOnLastPage() {
		int currentPageNumber = pager.calculateNumberOfPages() - 1;
		boolean result = pager.displayNextPageLink(currentPageNumber);
		assertEquals(true, result);
		
	}

}
