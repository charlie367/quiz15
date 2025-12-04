package com.example.quiz15;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/**
* @SpringBootTest: 有加上此註釋表示在執行測試方法之前，會先啟動整個專案，然後讓專案中
* 原本有被託管的物件建立起來，因此在測試方法時需要使用到被託管的物件時，可以正常被注入；
* 反之要求注入沒有被託管的物件，該物件就會是 null
*/
@SpringBootTest
class Quiz15ApplicationTests {

	@Test
	void contextLoads() {
	}

}
