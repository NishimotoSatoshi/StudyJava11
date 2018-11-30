package jp.co.opst.nishimoto_satoshi.practice_java11.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "指定されたIDに該当する情報がありません。")
public class IdNotFound extends RuntimeException {

}
