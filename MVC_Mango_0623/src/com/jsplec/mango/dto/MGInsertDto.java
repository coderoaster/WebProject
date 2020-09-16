package com.jsplec.mango.dto;

public class MGInsertDto {
	
	String category;
	String R_name;
	String addr;
	String tel;
	String kind;
	String open_time;
	String holiday;
	String img;
	
	public MGInsertDto() {
		
	}

	public MGInsertDto(String category, String r_name, String addr, String tel, String kind, String open_time,
			String holiday, String img) {
		super();
		this.category = category;
		R_name = r_name;
		this.addr = addr;
		this.tel = tel;
		this.kind = kind;
		this.open_time = open_time;
		this.holiday = holiday;
		this.img = img;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getR_name() {
		return R_name;
	}

	public void setR_name(String r_name) {
		R_name = r_name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getOpen_time() {
		return open_time;
	}

	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
}
