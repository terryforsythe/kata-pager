package pager;

public class Pager {

	private int totalNumberOfItems;
	private int pageSize;
	private int currentPageNumber;

	public Pager(int totalNumberOfItems, int pageSize, int currentPageNumber) {
		this.totalNumberOfItems = totalNumberOfItems;
		this.pageSize = pageSize;
		this.currentPageNumber = currentPageNumber;
	}

	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int newPageSize) {
		pageSize = newPageSize;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int calculateNumberOfPages() {
		return (totalNumberOfItems + pageSize - 1) / pageSize;
	}

	public boolean displayPreviousPageLink(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;

		if (currentPageNumber == 1) {
			return false;
		}

		return true;
	}

	public boolean displayNextPageLink(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;

		if (currentPageNumber == calculateNumberOfPages()) {
			return false;
		}

		return true;
	}

}
