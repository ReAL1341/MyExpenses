package com.example.application.user;

import com.example.domain.user.UserId;

public interface AuthRepository {
	
	
	/**
	 * 認証情報の新規保存・更新を行う。
	 */
	void save(AuthToken authToken, UserId userId);
	
	
	/**
	 * 認証情報の取得を行う。
	 * @return 該当する認証情報が見つからない場合は{@code null}を返す。
	 */
	UserId findByAuthToken(AuthToken authToken);
	
	
}
