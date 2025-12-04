package com.example.quiz15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.quiz15.Service.ifs.Shapes;

public class LambdaTest {
	@Test
	public void lambdaTest() {
		List<Integer> list = new ArrayList<>(List.of(1, 3, 2, 4, 7));
		for(Integer item : list) {
			System.out.println(item);
		}
		list.forEach(item ->{
			System.out.println(item);
		});
		//map
		Map<Integer, String> map = new HashMap<>(Map.of(1,"A", 2, "B", 3, "c"));
		map.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v);
		});
	}
	
    @FunctionalInterface
    interface Shapes {
        void draw();
    }
	@Test
	public void lambdaTest1() {
		Shapes sh = new Shapes() {
		@Override
		public void draw() {
			System.out.println("繪圖");
		}
	};
	//執行方法
	sh.draw();
	System.out.println("==========");
	//使用 Lambda 表達式重新定義介面中的方法
	//因為方法 draw 不需要有參數，沒有參數的 Lambda 表達式必需要有小括號
	Shapes sh1 = () -> {
		System.out.println("繪圖123");
	};
	//執行方法
	 sh1.draw();
	System.out.println("==========");
	// 若方法 draw() 變成需要帶參數，例如 draw(String name)，Lambda 表達式如下
	// Shapes sh1 = ("ABC") -> {
	// System.out.println("繪圖123!!!");	
	// };
	}
	
}
