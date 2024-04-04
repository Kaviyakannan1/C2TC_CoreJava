package com.tns.day;

public class Mi_Team {
		private String name;
		private int age;
		private int jersyNo;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name=name;
		}
		public int getage() {
			return age;
		}
		public void setage(int age) {
			this.age=age;
		}
		public int getjersyNo() {
			return jersyNo;
		}
		public void setjersyNo(int jersyNo) {
			this.jersyNo=jersyNo;
		}
		
		
	public static void main(String[] args) {
		Mi_Team obj=new Mi_Team();
		obj.setName("Hardik Pandya");
		obj.setjersyNo(33);
		obj.setage(32);
		System.out.println(obj.getName());
		System.out.println(obj.getage());
		System.out.println(obj.getjersyNo());
	}
	}


