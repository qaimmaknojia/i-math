package org.jerrymouse.example;

import java.util.Date;

import javax.jws.WebService;

@WebService
public interface TimeService {
	Date getTime();
	
	
}
