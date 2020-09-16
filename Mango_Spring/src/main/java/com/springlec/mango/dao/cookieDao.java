package com.springlec.mango.dao;

import java.util.ArrayList;
import java.util.List;

import com.springlec.mango.dto.RestaurantsDto;

public interface cookieDao {

	public ArrayList<RestaurantsDto> cookieListDao(List<String> seq_list);
}
