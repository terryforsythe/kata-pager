package pager;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PagerTest {

	Pager pager = new Pager(4680, 20, 100);

	@Test
	public void shouldReturnTotalNumberOfItems() {
		int result = pager.getTotalNumberOfItems();
		assertThat(result, is(4680));
	}

	@Test
	public void shouldReturnPageSize() {
		int result = pager.getPageSize();
		assertThat(result, is(20));
	}

	@Test
	public void shouldReturnCurrentPageNumber() {
		int result = pager.getCurrentPageNumber();
		assertThat(result, is(100));
	}

	@Test
	public void shouldReturnNumberOfPages() {
		int result = pager.calculateNumberOfPages();
		assertThat(result, is(234));
	}

	@Test
	public void shouldRoundUpNumberOfPagesIfCalculationHasRemainder() {
		this.pager = new Pager(653, 20, 30);
		int result = pager.calculateNumberOfPages();
		assertThat(result, is(33));
	}

	@Test
	public void shouldRecalculateNumberOfPagesWhenPageSizeIsChanged() {
		pager.setPageSize(40);
		int result = pager.calculateNumberOfPages();
		assertThat(result, is(117));
	}

	@Test
	public void shouldNotDisplayPreviousPageLinkWhenOnPage1() {
		int currentPageNumber = 1;
		boolean result = pager.displayPreviousPageLink(currentPageNumber);
		assertThat(result, is(false));
	}

	@Test
	public void shouldDisplayPreviousPageLinkWhenOnPage2() {
		int currentPageNumber = 2;
		boolean result = pager.displayPreviousPageLink(currentPageNumber);
		assertThat(result, is(true));
	}

	@Test
	public void shouldNotDisplayNextPageLinkWhenOnLastPage() {
		int currentPageNumber = pager.calculateNumberOfPages();
		boolean result = pager.displayNextPageLink(currentPageNumber);
		assertThat(result, is(false));
	}

	@Test
	public void shouldDisplayNextPageLinkWhenNotOnLastPage() {
		int currentPageNumber = pager.calculateNumberOfPages() - 1;
		boolean result = pager.displayNextPageLink(currentPageNumber);
		assertThat(result, is(true));

	}

}
