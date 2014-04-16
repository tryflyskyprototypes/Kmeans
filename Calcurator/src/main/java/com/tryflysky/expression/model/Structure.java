package com.tryflysky.expression.model;

import com.tryflysky.utils.DequeMapKey;



/**
 * 式の構成
 * 
 * @author admin
 *
 */
public enum Structure implements DequeMapKey {
	
	OPERATOR,	//演算子
	OPERAND,	//被演算子
}