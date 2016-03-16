package com.pursuit.salesCommission.app.model;

public class Person {
	 
    private String name;
    private String age;
 
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	public Person() {
    }
 
    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
