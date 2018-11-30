package jp.co.opst.nishimoto_satoshi.practice_java11.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
