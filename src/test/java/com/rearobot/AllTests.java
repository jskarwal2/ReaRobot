package com.rearobot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RobotTestFirstNonPlaceCommand.class, RobotTestMove.class, RobotTestPlace.class, TestExampleA.class,
		TestExampleB.class, TestExampleC.class })
public class AllTests {

}
