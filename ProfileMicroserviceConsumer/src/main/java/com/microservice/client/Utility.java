package com.microservice.client;

import com.google.gson.Gson;

/**
 * @author Administrator
 *
 */
public class Utility {

	static String convertIntoJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
}
