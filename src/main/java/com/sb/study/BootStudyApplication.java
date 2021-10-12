package com.sb.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성이 모두 가능하다.
//해당 어노테이션이 있는 부분부터 설정을 읽어가기 때문에, 해당 어노테이션이 있는 클래스는 항상 프로젝트의 최상단에 위치해야한다.
@SpringBootApplication
public class BootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootStudyApplication.class, args);
		//run()메서드로 인하여 SpringBoot의 내장 WAS를 실행한다. (따로 톰캣설치할 필요가 없음)
	}

}
