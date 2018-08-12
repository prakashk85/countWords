package com.prakash.wordcount.bean;

import java.util.Map.Entry;
import java.util.Set;

public class SearchResponse {
	private Set<Entry<String, Integer>> counts;

	public SearchResponse() {
		super();
	}

	public SearchResponse(Set<Entry<String, Integer>> counts) {
		super();
		this.counts = counts;
	}

	public Set<Entry<String, Integer>> getCounts() {
		return counts;
	}

	public void setCounts(Set<Entry<String, Integer>> counts) {
		this.counts = counts;
	}

}