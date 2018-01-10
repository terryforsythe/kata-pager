package pager;

public class Pager {

	private int totalNumberOfItems;
	private int numberOfItemsOnPage;
	private int currentPageNumber;

	public Pager(int totalNumberOfItems, int numberOfItemsOnPage, int currentPageNumber) {
		this.totalNumberOfItems = totalNumberOfItems;
		this.numberOfItemsOnPage = numberOfItemsOnPage;
		this.currentPageNumber = currentPageNumber;
	}

	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}

	public int getPageSize() {
		return numberOfItemsOnPage;
	}

	public void setPageSize(int newPageSize) {
		numberOfItemsOnPage = newPageSize;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int calculateNumberOfPages() {
		return (totalNumberOfItems + numberOfItemsOnPage - 1) / numberOfItemsOnPage;
	}

	public boolean displayPreviousPageLink() {

		if (currentPageNumber == 1) {
			return false;
		}

		return true;
	}

	public boolean displayNextPageLink() { 

		if (currentPageNumber == calculateNumberOfPages()) {
			return false;
		}

		return true;
	}

}
