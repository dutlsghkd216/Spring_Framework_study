package com.example.ex02.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ExampleController {
//	이름을 입력하고 출근 또는 퇴근 버튼 클릭한다.
//	출근 시간은 09:00이며, 퇴근시간 18:00이다.
//	출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//	퇴근 버튼 클릭시 18시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
	
//	모든 jsp는 work 경로 안에 생성하며 아래와 같이 분기별로 jsp문서 한 개씩 작성한다.
//	- getToWork.jsp
//	- leaveWork.jsp
//	- late.jsp
//	- work.jsp
	
	@GetMapping("/checkIn")
	public String checkIn() {
		return "work/checkIn";
	}
	
	@GetMapping("/getToWork")
	public String getToWork(@ModelAttribute("name") String name) {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		
		boolean lateCondition = hour >= 9 && minute >0;
		
		if(lateCondition) {
			return "work/late";
		}
		return "work/getToWork";
	}
	
	@GetMapping("/leaveWork")
	public String leaveWork(@ModelAttribute("name") String name) {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		
		boolean leaveWorkCondition = hour >= 18 && minute >0;
		
		if(leaveWorkCondition) {
			return "work/leaveWork";
		}
		return "work/work";
	}
	
// 상품의 바코드를 입력받고 해당 상품명을 출력한다.
//	오징어 땅콩 -438927
//	초코 우유 - 0832147
//	벌꿀 피자 - 9841631
//	샌드위치 - 5587578
	
	@GetMapping("market")
	public String goMarket() {
		return "market/market";
	}
	
	@PostMapping("/cashier")
	public String getProduct(String barcode, Model model) {
		String productName = null;
		
		switch(barcode) {
		case "4383927":
			productName="오징어 땅콩";
			break;
		case "0832147":
			productName="초코 우유";
			break;
		case "9841631":
			productName="벌꿀 피자";
			break;
		case "5587578":
			productName="샌드위치";
			break;
		default:
			productName="없는 상품";
			break;
		}
		model.addAttribute("productName", productName);
		return "/market/cashier";
	}
	
	
}
