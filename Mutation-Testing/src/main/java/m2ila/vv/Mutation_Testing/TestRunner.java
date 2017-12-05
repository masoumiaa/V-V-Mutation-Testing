package m2ila.vv.Mutation_Testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javassist.NotFoundException;

public class TestRunner {

	private String pathToClasses;
	private String pathToTests;
	
	public TestRunner(String urlClasses, String urlTests){
		this.pathToClasses = "file://"+urlClasses;
		this.pathToTests = "file://"+urlTests+"output/";
		System.out.println(this.pathToClasses);
		System.out.println(this.pathToTests);
	}
	
	public String runTests(String testClass) throws ClassNotFoundException, MalformedURLException, NotFoundException{
		
		StringBuilder sb = new StringBuilder();
		URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] {
	       new URL(this.pathToTests),
	       new URL(this.pathToClasses)
	    });
		Class<?> clazz = urlClassLoader.loadClass("m2ila.vv.inputs."+testClass+"Test");
		System.out.println("Loaded test class : "+ testClass +'\n');
		
		JUnitCore core = new JUnitCore();
        Result result = new Result();
        result = core.run(clazz);
        System.out.println("TESTS FINISHED");
        System.out.println(String.format("| RUN: %d", result.getRunCount())+'\n');
        if(result.wasSuccessful())
        	System.out.println("| ALL TESTS SUCCEEDED !");
        else
        	System.out.println("| FAILURE ! ");
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString()+'\n');
           // System.out.println(failure.getTrace()+'\n');
        }
        System.out.println(String.format("| TIME: %dms", result.getRunTime())+'\n');
        System.out.println("********************************");
        System.out.println("********************************");
        return sb.toString();
	}
}
