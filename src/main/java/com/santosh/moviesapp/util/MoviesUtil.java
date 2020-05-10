/**
 * 
 */
package com.santosh.moviesapp.util;

import org.springframework.util.StringUtils;

/**
 * @author santkamb
 *
 */
public class MoviesUtil {
	
	
	public static String getNumberFromString(String str) {
		
		if (StringUtils.hasLength(str)) {
			str = str.replaceAll("[^-?0-9]+", " ");
			String[] strArry = str.trim().split(" ");
			if (null != strArry && strArry.length != 0) {
				return strArry[0];
			}
		}
		return null;
	}

	public static String getSymbolFromString(String str) {

		if (StringUtils.hasLength(str)) {
			str = str.replaceAll("[^-?<>+-]+", " ");
			String[] strArry = str.trim().split(" ");
			if (null != strArry && strArry.length != 0) {
				System.out.println(strArry[0]);
			}
			return strArry[0];
		}
		return null;
	}

}
