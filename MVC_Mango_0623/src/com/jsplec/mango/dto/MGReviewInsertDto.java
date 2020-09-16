package com.jsplec.mango.dto;

public class MGReviewInsertDto {
	String member_id_user;
	String content;
	String image;
	int rating;
	int r_seq;
	
	public MGReviewInsertDto() {
		
	}

	public MGReviewInsertDto(String member_id_user, String content, String image, int rating, int r_seq) {
		super();
		this.member_id_user = member_id_user;
		this.content = content;
		this.image = image;
		this.rating = rating;
		this.r_seq = r_seq;
	}

	public String getMember_id_user() {
		return member_id_user;
	}

	public void setMember_id_user(String member_id_user) {
		this.member_id_user = member_id_user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getR_seq() {
		return r_seq;
	}

	public void setR_seq(int r_seq) {
		this.r_seq = r_seq;
	}
	
}