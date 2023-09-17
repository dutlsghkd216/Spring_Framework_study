package com.example.ex00.dependency;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class Restaurant {
	
	private final Chef chef;

}
