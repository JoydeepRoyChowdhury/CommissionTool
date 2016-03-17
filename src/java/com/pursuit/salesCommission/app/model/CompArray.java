package com.pursuit.salesCommission.app.model;

import java.util.ArrayList;
//import java.util.List;

public class CompArray {
	public ArrayList<String> addRule(){
		ArrayList<String> a1= new ArrayList<String>();
		
		for(int i=1;i<=5;i++)
		{		
		a1.add("100"+i);
		}
		for(int j=0;j<a1.size();j++)
		{
			System.out.println(a1.get(j));
		}
	      return a1;
	}
	public static void main(String[] args) {
	CompArray obj = new CompArray();
	//obj.addRule();

}
	}
