package com.epam.atm.tests.runners;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"com.epam.atm.tests.maintests"})
@IncludeTags("regression")
public class RegressionTestRunner {
}
