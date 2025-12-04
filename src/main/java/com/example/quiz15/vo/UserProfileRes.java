package com.example.quiz15.vo;

public class UserProfileRes extends BasicRes{
	 private String name;
	    private String phone;
	    private String email;
	    private Integer age;

	    public UserProfileRes() {}

	    public UserProfileRes(int code, String message,
	                          String name, String phone, String email, Integer age) {
	        super(code, message);
	        this.name = name;
	        this.phone = phone;
	        this.email = email;
	        this.age = age;
	    }

	    public String getName()  { return name;  }
	    public String getPhone() { return phone; }
	    public String getEmail() { return email; }
	    public Integer getAge()  { return age;   }

	    public void setName(String name)   { this.name = name; }
	    public void setPhone(String phone) { this.phone = phone; }
	    public void setEmail(String email) { this.email = email; }
	    public void setAge(Integer age)    { this.age = age; }
	}

