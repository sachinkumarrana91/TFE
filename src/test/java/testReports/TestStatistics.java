package testReports;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestStatistics implements ITestListener {

static List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
static List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
static List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();


	public static long passedTestCount() {
		long passedCount = passedtests.size();
		return passedCount;
	}

	public static long failedTestCount() {
		long failedCount = failedtests.size();
		return failedCount;
	}

	public static long skippedTestCount() {
		long skippedCount = skippedtests.size();
		return skippedCount;
	}

	
    @Override

    //This method will automatically be called if a test runs successfully
    public void onTestSuccess(ITestResult result) {

       //add the passed tests to the passed list

        passedtests.add(result.getMethod());

    }

    @Override

    //This method will automatically be called if a test fails
    public void onTestFailure(ITestResult result) {

        //add the failed tests to the failed list
        failedtests.add(result.getMethod());

    }

    @Override

     //This method will automatically be called if a test is skipped
     public void onTestSkipped(ITestResult result) {

         //add the skipped tests to the skipped list
        skippedtests.add(result.getMethod());
    }

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		//TestStatistics.SuiteName = context.getSuite().getName();
		//System.out.println(SuiteName);
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}       
}