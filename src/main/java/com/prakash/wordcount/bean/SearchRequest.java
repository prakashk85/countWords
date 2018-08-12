package com.prakash.wordcount.bean;

import java.util.List;

public class SearchRequest {
	private List<Word> searchText;

	public SearchRequest() {
		super();
	}

	public SearchRequest(List<Word> searchText) {
		super();
		this.searchText = searchText;
	}

	public List<Word> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<Word> searchText) {
		this.searchText = searchText;
	}

}
