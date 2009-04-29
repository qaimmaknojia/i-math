package org.jerrymouse.web.bean;

import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;

import org.jerrymouse.util.ApplicationContextAwareImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GadgetTest {
	Gadget gadget;

	@Before
	public void setUp() throws Exception {
		// InputStream
		// in=this.getClass().getResourceAsStream("test-gadget.xml");
		// gadget = new Gadget(in);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetContent() {
		// String string = gadget.getContent();
	}

}
