package com.sj.damai.util;

import com.sj.damai.biz.BizException;

public class Utils {
	/**
	 * 判断传入的值是否为空或者空字符串
	 * @throws Exception 
	 * 
	 * */
	public static void checkNull(Object value,String msg) throws BizException {
		if(value==null) {
			throw new BizException(msg);
		}
		if(value instanceof String ) {
			String svalue=(String)value;
			if(svalue.trim().isEmpty()) {
				throw new BizException(msg);
			}
		}
	}
}
