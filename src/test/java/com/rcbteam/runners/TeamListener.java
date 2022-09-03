package com.rcbteam.runners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TeamListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+" is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+" is successful");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+" is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+" is failed but within success percentage");
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println(context.getName()+" is started");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println(context.getName()+" is finished");
	}

}
