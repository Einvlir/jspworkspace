package site0621.board.model.domain;

import lombok.Data;

/*자바 또는 웹 개발을 하다 보면 @가 자주 등장
 * 이는 Annotation이라고 하며 jdk5버전 이후부터 등장했다..
 * 주 용도는 클래스 코드 안에서 부가적인 설정, 설명을 하기 위한 메타정보
 * 일종의 주석이라 할 수 있으나, 기존의 주석과 달리 프로그램에서 사용이 된다.
 * */ 

@Data
public class Board {

	private int board_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
}
