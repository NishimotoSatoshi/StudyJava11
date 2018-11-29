package jp.co.opst.nishimoto_satoshi.practice_java11.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
