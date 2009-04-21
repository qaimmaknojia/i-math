/*
 * $Id: HelloWorld.java 471756 2006-11-06 15:01:43Z husted $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jerrymouse.example;

import java.util.Calendar;

/**
 * <code>Set welcome message.</code>
 */
public class HelloWorldAction extends ExampleSupport {
	private int hour;
	private int minute;
	
	private TimeService timeService;

	public TimeService getTimeService() {
		return timeService;
	}

	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}

	public String execute() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timeService.getTime());
		hour = calendar.get(Calendar.HOUR);
		minute = calendar.get(Calendar.MINUTE);
		return SUCCESS;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getMinute() {
		return minute;
	}

}
