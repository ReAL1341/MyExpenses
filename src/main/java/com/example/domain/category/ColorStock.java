package com.example.domain.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorStock {
	
	
	private List<String> colorCodes;
	
	
	public ColorStock() {
		this.colorCodes = new ArrayList<>();
		String[] colors = {
				"#FF0000", //濃い赤
				"#FFFF00", //黄
				"#0000FF", //濃い青
				"#008000", //濃い緑
				"#FF00FF", //マゼンタ
				"#FFD700", //オレンジ
				"#00FFFF", //アクア
				"#00FF00", //ライム
				"#800080", //濃い紫
				"#A52A2A", //濃い茶
				"#3C3C3C", //薄い黒
				"#FA8072", //薄い赤
				"#FFD700", //金
				"#6495ED", //薄い青
				"#90EE90", //薄い緑
				"#FFC0CB", //ピンク
				"#87CEEB", //スカイブルー
				"#9370DB", //薄い紫
				"#B8860B", //薄い茶
				"#0F5474", //藍色
		};
		this.colorCodes.addAll(Arrays.asList(colors));
	}
	
	
	/**
	 * 既定の順番でカラーコードを出力する。
	 * @return String -「#FFFFFF」というフォーマットのカラーコード
	 */
	public String pop() {
		if(this.colorCodes.size() > 0) {
			String popedColorCode = this.colorCodes.get(0);
			this.colorCodes.remove(0);
			return popedColorCode;
		}else {
			throw new IllegalStateException("カラーコードが不足しています");
		}
	}
	
	
	/**
	 * 現在ストックされているカラーコードの個数を返す。
	 */
	public int getSize() {
		return this.colorCodes.size();
	}
	
	
}
