package com.example.domain.user;

public interface UserRepository {
	
	
	/**
	 * ユーザー情報の新規保存・更新を行う。
	 */
	void save(User user);
	
	
	/**
	 * ユーザー情報の取得を行う。
	 * @return 該当するユーザー情報が見つからない場合は{@code null}を返す。
	 */
	User findByUserId(UserId userId);
	
	
}
