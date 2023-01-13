package com.example.application.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.application.UseCaseException;
import com.example.domain.user.UserId;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserUseCase {
	
	
	private final AuthRepository authRepository;
	
	
	/**
	 * 認証情報の登録とユーザーの初期情報の登録・取得を行う。
	 * 処理途中で問題が発生した場合は自動でロールバックを行う。
	 * @return String ユーザーID
	 * @throws UseCaseException 認証情報がすでに登録されていた場合
	 */
	@Transactional
	public String register(AuthToken authToken) throws UseCaseException {
		UserId userId = this.authRepository.findByAuthToken(authToken);
		if(userId == null) {
			userId = new UserId();
			this.authRepository.save(authToken, userId);
			
			return userId.getValue();
		}else {
			throw new UseCaseException("このユーザーはすでに登録されています");
		}
	}
	
	
	/**
	 * 認証情報からユーザーを取得する。
	 * @return String ユーザーID
	 * @throws UseCaseException 該当する認証情報が登録されていなかった場合
	 */
	public String authenticate(AuthToken authToken) throws UseCaseException {
		UserId userId = this.authRepository.findByAuthToken(authToken);
		if(userId != null) {
			return userId.getValue();
		}else {
			throw new UseCaseException("メールアドレス、またはパスワードが正しくありません");
		}
	}
	
	
}
