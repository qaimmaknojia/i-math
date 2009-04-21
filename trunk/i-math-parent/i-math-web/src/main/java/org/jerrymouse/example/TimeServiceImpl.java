package org.jerrymouse.example;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface = "org.jerrymouse.example.TimeService")
public class TimeServiceImpl implements TimeService {

	public Date getTime() {
		return new Date();
	}
}
