package com.pursuit.salesCommission.app.model;

import java.util.List;

import com.pursuit.salesCommission.app.model.Result;

public class ResponseData {
	
	 private List<Result> results;

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public String toString() {
		return "Results[" + results + "]";
	}
}
