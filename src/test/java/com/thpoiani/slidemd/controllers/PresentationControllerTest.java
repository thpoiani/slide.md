package com.thpoiani.slidemd.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PresentationControllerTest {

	@Test public void fakeTest() {
		assertNotNull("put something real.", new PresentationController(null, null, null, null, null));
 	}
}
