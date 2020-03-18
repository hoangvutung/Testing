package testing.task2;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTest.class)
@SuiteClasses( {SecondTest.class,FirstTest.class,ThirdTest.class})

public class SmokeTestSuite {

}
