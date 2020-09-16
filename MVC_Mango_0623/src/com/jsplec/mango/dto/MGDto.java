package com.jsplec.mango.dto;

public class MGDto {
	
	int kakaoId;
	String kakaoName;
	String kakaoImage;
	int id_store;
	String store_name;
	Double rating;
	String address;
	String tel;
	String kind;
	String open_time;
	String holiday;
	String menu;
	String category_food;
	String image_food;
	String r_gu;
	String r_dong;
	int r_seq;
	
	int id_review;
	String date;
	String evaluation;
	String contents;
	String img;
	
	String review_contents;
	String review_evaluation;
	String review_image;
	String member_name;
	String member_image;
	
	
	public MGDto() {
		// TODO Auto-generated constructor stub
	}
//	카카오 로그인 정보
	public MGDto(int kakaoId, String kakaoName, String kakaoImage) {
		super();
		this.kakaoId = kakaoId;
		this.kakaoName = kakaoName;
		this.kakaoImage = kakaoImage;
	}

	public MGDto(int id_store, String store_name, Double rating, String R_gu, String address, String tel, String kind,
			String open_time, String holiday, String menu, String category_food, String image_food) {
		super();
		this.id_store = id_store;
		this.store_name = store_name;
		this.rating = rating;
		this.r_gu = r_gu;
		this.address = address;
		this.tel = tel;
		this.kind = kind;
		this.open_time = open_time;
		this.holiday = holiday;
		this.menu = menu;
		this.category_food = category_food;
		this.image_food = image_food;
	}
	// search 음식점 리스트
	public MGDto(int id_store, String store_name, Double rating, String image_food, String category_food, String kind, String r_gu, String r_dong) {
		super();
		this.id_store = id_store;
		this.store_name = store_name;
		this.image_food = image_food;
		this.category_food = category_food;
		this.kind = kind;
		this.rating = rating;
		this.r_gu = r_gu;
		this.r_dong = r_dong;
	}

	public MGDto(String kakaoName, String kakaoImage, int id_store, int id_review, String date, String evaluation,
			String contents) {
		super();
		this.kakaoName = kakaoName;
		this.kakaoImage = kakaoImage;
		this.id_store = id_store;
		this.id_review = id_review;
		this.date = date;
		this.evaluation = evaluation;
		this.contents = contents;
	}
	
	public MGDto(int id_store, String store_name, Double rating, String image_food, String address) {
		super();
		this.id_store = id_store;
		this.store_name = store_name;
		this.image_food = image_food;
		this.address = address;
		this.rating = rating;
	}
	
	public MGDto(String review_contents, String date, String review_evaluation, String review_image, String member_name,
			String member_image) {
		super();
		this.review_contents = review_contents;
		this.date = date;
		this.review_evaluation = review_evaluation;
		this.review_image = review_image;
		this.member_name = member_name;
		this.member_image = member_image;
	}
	
//	리뷰 클릭시 해당 리뷰 정보
	public MGDto(String store_name, String review_contents, String date, String review_evaluation, String review_image, String member_name,
			String member_image, int r_seq) {
		super();
		this.store_name = store_name;
		this.review_contents = review_contents;
		this.date = date;
		this.review_evaluation = review_evaluation;
		this.review_image = review_image;
		this.member_name = member_name;
		this.member_image = member_image;
		this.r_seq = r_seq;
	}

//	리뷰 리스트
	public MGDto(int kakaoId, String kakaoName, String kakaoImage, int id_store, int id_review, String date,
			String evaluation, String contents, String review_image) {
		super();
		this.kakaoId = kakaoId;
		this.kakaoName = kakaoName;
		this.kakaoImage = kakaoImage;
		this.id_store = id_store;
		this.id_review = id_review;
		this.date = date;
		this.evaluation = evaluation;
		this.contents = contents;
		this.review_image = review_image;
	}
	public int getR_seq() {
		return r_seq;
	}

	public void setR_seq(int r_seq) {
		this.r_seq = r_seq;
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getReview_contents() {
		return review_contents;
	}

	public void setReview_contents(String review_contents) {
		this.review_contents = review_contents;
	}

	public void setReview_evaluation(String review_evaluation) {
		this.review_evaluation = review_evaluation;
	}

	public String getReview_evaluation() {
		return review_evaluation;
	}

	public void setReview_rating(String review_evaluation) {
		this.review_evaluation = review_evaluation;
	}

	public String getReview_image() {
		return review_image;
	}

	public void setReview_image(String review_image) {
		this.review_image = review_image;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_image() {
		return member_image;
	}

	public void setMember_image(String member_image) {
		this.member_image = member_image;
	}

	public int getId_review() {
		return id_review;
	}

	public void setId_review(int id_review) {
		this.id_review = id_review;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getR_gu() {
		return r_gu;
	}

	public void setR_gu(String r_gu) {
		this.r_gu = r_gu;
	}

	public String getR_dong() {
		return r_dong;
	}

	public void setR_dong(String r_dong) {
		this.r_dong = r_dong;
	}

	public int getId_store() {
		return id_store;
	}

	public void setId_store(int id_store) {
		this.id_store = id_store;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getCategory_food() {
		return category_food;
	}

	public void setCategory_food(String category_food) {
		this.category_food = category_food;
	}

	public String getImage_food() {
		return image_food;
	}

	public void setImage_food(String image_food) {
		this.image_food = image_food;
	}

	public int getKakaoId() {
		return kakaoId;
	}

	public void setKakaoId(int kakaoId) {
		this.kakaoId = kakaoId;
	}

	public String getKakaoName() {
		return kakaoName;
	}

	public void setKakaoName(String kakaoName) {
		this.kakaoName = kakaoName;
	}

	public String getKakaoImage() {
		return kakaoImage;
	}

	public void setKakaoImage(String kakaoImage) {
		this.kakaoImage = kakaoImage;
	}
	
}


//package com.jsplec.mango.dto;
//
//public class MGDto {
//	
//	int kakaoId;
//	String kakaoName;
//	String kakaoImage;
//	int id_store;
//	String store_name;
//	Double rating;
//	String address;
//	String tel;
//	String kind;
//	String open_time;
//	String holiday;
//	String menu;
//	String category_food;
//	String image_food;
//	String r_gu;
//	String r_dong;
//	
//	int id_review;
//	String date;
//	String evaluation;
//	String contents;
//	
//	String img;
//	
//	
//	
//	public MGDto() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public MGDto(int kakaoId, String kakaoName, String kakaoImage) {
//		super();
//		this.kakaoId = kakaoId;
//		this.kakaoName = kakaoName;
//		this.kakaoImage = kakaoImage;
//	}
//
//	public MGDto(int id_store, String store_name, Double rating, String address, String tel, String kind,
//			String open_time, String holiday, String menu, String category_food, String image_food) {
//		super();
//		this.id_store = id_store;
//		this.store_name = store_name;
//		this.rating = rating;
//		this.address = address;
//		this.tel = tel;
//		this.kind = kind;
//		this.open_time = open_time;
//		this.holiday = holiday;
//		this.menu = menu;
//		this.category_food = category_food;
//		this.image_food = image_food;
//	}
//	
//
//	public MGDto(int id_store, String store_name, Double rating, String image_food, String category_food, String kind, String r_dong) {
//		super();
//		this.id_store = id_store;
//		this.store_name = store_name;
//		this.image_food = image_food;
//		this.category_food = category_food;
//		this.kind = kind;
//		this.rating = rating;
//		this.r_dong = r_dong;
//	}
//
//	public MGDto(String kakaoName, String kakaoImage, int id_store, int id_review, String date, String evaluation,
//			String contents) {
//		super();
//		this.kakaoName = kakaoName;
//		this.kakaoImage = kakaoImage;
//		this.id_store = id_store;
//		this.id_review = id_review;
//		this.date = date;
//		this.evaluation = evaluation;
//		this.contents = contents;
//	}
//	
//	public MGDto(int id_store, String store_name, Double rating, String image_food, String address) {
//		super();
//		this.id_store = id_store;
//		this.store_name = store_name;
//		this.image_food = image_food;
//		this.address = address;
//		this.rating = rating;
//	}
//	
//	public int getId_review() {
//		return id_review;
//	}
//
//	public void setId_review(int id_review) {
//		this.id_review = id_review;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//	public String getEvaluation() {
//		return evaluation;
//	}
//
//	public void setEvaluation(String evaluation) {
//		this.evaluation = evaluation;
//	}
//
//	public String getContents() {
//		return contents;
//	}
//
//	public void setContents(String contents) {
//		this.contents = contents;
//	}
//
//	public String getR_gu() {
//		return r_gu;
//	}
//
//	public void setR_gu(String r_gu) {
//		this.r_gu = r_gu;
//	}
//
//	public String getR_dong() {
//		return r_dong;
//	}
//
//	public void setR_dong(String r_dong) {
//		this.r_dong = r_dong;
//	}
//
//	public int getId_store() {
//		return id_store;
//	}
//
//	public void setId_store(int id_store) {
//		this.id_store = id_store;
//	}
//
//	public String getStore_name() {
//		return store_name;
//	}
//
//	public void setStore_name(String store_name) {
//		this.store_name = store_name;
//	}
//
//	public Double getRating() {
//		return rating;
//	}
//
//	public void setRating(Double rating) {
//		this.rating = rating;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getTel() {
//		return tel;
//	}
//
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//
//	public String getKind() {
//		return kind;
//	}
//
//	public void setKind(String kind) {
//		this.kind = kind;
//	}
//
//	public String getOpen_time() {
//		return open_time;
//	}
//
//	public void setOpen_time(String open_time) {
//		this.open_time = open_time;
//	}
//
//	public String getHoliday() {
//		return holiday;
//	}
//
//	public void setHoliday(String holiday) {
//		this.holiday = holiday;
//	}
//
//	public String getMenu() {
//		return menu;
//	}
//
//	public void setMenu(String menu) {
//		this.menu = menu;
//	}
//
//	public String getCategory_food() {
//		return category_food;
//	}
//
//	public void setCategory_food(String category_food) {
//		this.category_food = category_food;
//	}
//
//	public String getImage_food() {
//		return image_food;
//	}
//
//	public void setImage_food(String image_food) {
//		this.image_food = image_food;
//	}
//
//	public int getKakaoId() {
//		return kakaoId;
//	}
//
//	public void setKakaoId(int kakaoId) {
//		this.kakaoId = kakaoId;
//	}
//
//	public String getKakaoName() {
//		return kakaoName;
//	}
//
//	public void setKakaoName(String kakaoName) {
//		this.kakaoName = kakaoName;
//	}
//
//	public String getKakaoImage() {
//		return kakaoImage;
//	}
//
//	public void setKakaoImage(String kakaoImage) {
//		this.kakaoImage = kakaoImage;
//	}
//	
//}


//package com.jsplec.mango.dto;
//
//public class MGDto {
//	
//	int kakaoId;
//	String kakaoName;
//	String kakaoImage;
//	int id_store;
//	String store_name;
//	Double rating;
//	String address;
//	String tel;
//	String kind;
//	String open_time;
//	String holiday;
//	String menu;
//	String category_food;
//	String image_food;
//	String r_gu;
//	String r_dong;
//
//	int id_review;
//	String date;
//	String evaluation;
//	String contents;
//	
//	String img;
//	
//
////리뷰 리스트 불러오
//	public MGDto(int kakaoId, String kakaoName, String kakaoImage, int id_store, int id_review, String date,
//			String evaluation, String contents) {
//		super();
//		this.kakaoId = kakaoId;
//		this.kakaoName = kakaoName;
//		this.kakaoImage = kakaoImage;
//		this.id_store = id_store;
//		this.id_review = id_review;
//		this.date = date;
//		this.evaluation = evaluation;
//		this.contents = contents;
//	}
//
//	
//	
//	public MGDto() {
//		// TODO Auto-generated constructor stub
//	}
//	//회원 데이
//	public MGDto(int kakaoId, String kakaoName, String kakaoImage) {
//		super();
//		this.kakaoId = kakaoId;
//		this.kakaoName = kakaoName;
//		this.kakaoImage = kakaoImage;
//	}
//	//
//	public MGDto(int id_store, String store_name, Double rating, String address, String tel, String kind,
//			String open_time, String holiday, String menu, String category_food, String image_food) {
//		super();
//		this.id_store = id_store;
//		this.store_name = store_name;
//		this.rating = rating;
//		this.address = address;
//		this.tel = tel;
//		this.kind = kind;
//		this.open_time = open_time;
//		this.holiday = holiday;
//		this.menu = menu;
//		this.category_food = category_food;
//		this.image_food = image_food;
//	}
//	
//	//
//	public MGDto(int id_store, String store_name, Double rating, String image_food, String category_food, String kind, String r_dong) {
//		super();
//		this.id_store = id_store;
//		this.store_name = store_name;
//		this.image_food = image_food;
//		this.category_food = category_food;
//		this.kind = kind;
//		this.rating = rating;
//		this.r_dong = r_dong;
//	}
//	//
//	public MGDto(String kakaoName, String kakaoImage, int id_store, int id_review, String date, String evaluation,
//			String contents) {
//		super();
//		this.kakaoName = kakaoName;
//		this.kakaoImage = kakaoImage;
//		this.id_store = id_store;
//		this.id_review = id_review;
//		this.date = date;
//		this.evaluation = evaluation;
//		this.contents = contents;
//	}
//	//
//	public MGDto(int id_store, String store_name, Double rating, String image_food, String address) {
//		super();
//		this.id_store = id_store;
//		this.store_name = store_name;
//		this.image_food = image_food;
//		this.address = address;
//		this.rating = rating;
//	}
//	
//	public int getId_review() {
//		return id_review;
//	}
//
//	public void setId_review(int id_review) {
//		this.id_review = id_review;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//	public String getEvaluation() {
//		return evaluation;
//	}
//
//	public void setEvaluation(String evaluation) {
//		this.evaluation = evaluation;
//	}
//
//	public String getContents() {
//		return contents;
//	}
//
//	public void setContents(String contents) {
//		this.contents = contents;
//	}
//
//	public String getR_gu() {
//		return r_gu;
//	}
//
//	public void setR_gu(String r_gu) {
//		this.r_gu = r_gu;
//	}
//
//	public String getR_dong() {
//		return r_dong;
//	}
//
//	public void setR_dong(String r_dong) {
//		this.r_dong = r_dong;
//	}
//
//	public int getId_store() {
//		return id_store;
//	}
//
//	public void setId_store(int id_store) {
//		this.id_store = id_store;
//	}
//
//	public String getStore_name() {
//		return store_name;
//	}
//
//	public void setStore_name(String store_name) {
//		this.store_name = store_name;
//	}
//
//	public Double getRating() {
//		return rating;
//	}
//
//	public void setRating(Double rating) {
//		this.rating = rating;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getTel() {
//		return tel;
//	}
//
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//
//	public String getKind() {
//		return kind;
//	}
//
//	public void setKind(String kind) {
//		this.kind = kind;
//	}
//
//	public String getOpen_time() {
//		return open_time;
//	}
//
//	public void setOpen_time(String open_time) {
//		this.open_time = open_time;
//	}
//
//	public String getHoliday() {
//		return holiday;
//	}
//
//	public void setHoliday(String holiday) {
//		this.holiday = holiday;
//	}
//
//	public String getMenu() {
//		return menu;
//	}
//
//	public void setMenu(String menu) {
//		this.menu = menu;
//	}
//
//	public String getCategory_food() {
//		return category_food;
//	}
//
//	public void setCategory_food(String category_food) {
//		this.category_food = category_food;
//	}
//
//	public String getImage_food() {
//		return image_food;
//	}
//
//	public void setImage_food(String image_food) {
//		this.image_food = image_food;
//	}
//
//	public int getKakaoId() {
//		return kakaoId;
//	}
//
//	public void setKakaoId(int kakaoId) {
//		this.kakaoId = kakaoId;
//	}
//
//	public String getKakaoName() {
//		return kakaoName;
//	}
//
//	public void setKakaoName(String kakaoName) {
//		this.kakaoName = kakaoName;
//	}
//
//	public String getKakaoImage() {
//		return kakaoImage;
//	}
//
//	public void setKakaoImage(String kakaoImage) {
//		this.kakaoImage = kakaoImage;
//	}
//	public String getImg() {
//		return img;
//	}
//
//	public void setImg(String img) {
//		this.img = img;
//	}
//	
//}
