package org.jerrymouse.web.test;

import java.io.File;

import com.google.appengine.tools.development.ApiProxyLocalImpl;
import com.google.apphosting.api.ApiProxy;

/**
 * local service test
 */
public class BaseTest extends SpringContextTests {

	/**
	 * setup env
	 * 
	 * @throws Exception
	 *             exception
	 */

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment());
		ApiProxy.setDelegate(new ApiProxyLocalImpl(new File(".")) {
		});
	}

	/**
	 * cleanup
	 * 
	 * @throws Exception
	 *             exception
	 */
	@Override
	protected void tearDown() throws Exception {
		ApiProxy.setDelegate(null);
		ApiProxy.setEnvironmentForCurrentThread(null);
		super.tearDown();

	}

}