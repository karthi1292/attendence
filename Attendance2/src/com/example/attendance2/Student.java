package com.example.attendance2;

public class Student {

	int id;
	String name;
	
	
	private boolean attend;
	
	public Student(String name) {
		super();
		
		this.name = name;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	



	public boolean isAttend() {
		return attend;
	}

	public void setAttend(boolean attend) {
		this.attend = attend;
	}


	

	
}
