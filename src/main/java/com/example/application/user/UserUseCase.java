package com.example.application.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.application.UseCaseException;
import com.example.application.auth.AuthRepository;
import com.example.application.auth.AuthToken;
import com.example.domain.user.User;
import com.example.domain.user.UserId;
import com.example.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserUseCase {
	
	
	private final AuthRepository authRepository;
	private final UserRepository userRepository;
	
	
	/**
	 * 認証情報の登録とユーザーの初期情報の登録・取得を行う。
	 * 処理途中で問題が発生した場合は自動でロールバックを行う。
	 * @throws UseCaseException 認証情報がすでに登録されていた場合
	 */
	@Transactional
	public UserDto register(AuthToken authToken) throws UseCaseException {
		UserId userId = this.authRepository.findByAuthToken(authToken);
		if(userId == null) {
			userId = new UserId();
			User user = new User(userId);
			user.add("食費");
			user.add("交通費");
			user.add("光熱費");
			user.add("娯楽費");
			this.authRepository.save(authToken, userId);
			this.userRepository.save(user);
			
			return UserDto.of(user);
		}else {
			throw new UseCaseException("このユーザーはすでに登録されています");
		}
	}
	
	
	/**
	 * 認証情報からユーザーを取得する。
	 * @throws UseCaseException 該当する認証情報が登録されていなかった場合
	 */
	public UserDto login(AuthToken authToken) throws UseCaseException {
		UserId userId = this.authRepository.findByAuthToken(authToken);
		if(userId != null) {
			User user = this.userRepository.findByUserId(userId);
			return UserDto.of(user);
		}else {
			throw new UseCaseException("メールアドレス、またはパスワードが正しくありません");
		}
	}
	
	
}
