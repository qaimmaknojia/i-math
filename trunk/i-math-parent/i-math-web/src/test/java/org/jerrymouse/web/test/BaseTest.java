package org.jerrymouse.web.test;

import com.google.appengine.tools.development.ApiProxyLocalImpl;
import com.google.apphosting.api.ApiProxy;
import junit.framework.TestCase;

import java.io.File;

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
	public void onSetUp() throws Exception {
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
	public void onTearDown() throws Exception {
		ApiProxy.setDelegate(null);
		ApiProxy.setEnvironmentForCurrentThread(null);
	}

}