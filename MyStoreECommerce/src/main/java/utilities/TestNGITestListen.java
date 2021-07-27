package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGITestListen implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		Log.info("==============="+"Logging started for "+result.getMethod().getMethodName()+"===============");
		Log.info(result.getMethod().getMethodName()+":"+"STARTED");
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		Log.info(result.getMethod().getMethodName()+":"+"PASSED");
		Log.info("==============="+"Logging ended for"+" "+result.getMethod().getMethodName()+"==================");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		Log.info(result.getMethod().getMethodName()+":"+"FAILED");
		Log.error("Falied error thrown -> "+result.getThrowable());
		Log.info("==============="+"Logging ended for"+" "+result.getMethod().getMethodName()+"==================");
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		Log.info(result.getMethod().getMethodName()+":"+"SKIPPED");
		Log.info("==============="+"Logging ended for"+" "+result.getMethod().getMethodName()+"==================");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{
		Log.info("***********************************************************************************************");
		Log.info("**********************************Test Execution Started***************************************");
		
	}

	public void onFinish(ITestContext context) 
	{
		
		Log.info("**********************************Test Execution Ended*****************************************");
		Log.info("***********************************************************************************************");
		
	}

}
