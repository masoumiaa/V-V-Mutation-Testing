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
		this.pathToClasses = "file://"+urlClasses+"target/test-classes/";
		this.pathToTests = "file://"+urlTests+"output/";
	}
	
	public String runTests(String testClass) throws ClassNotFoundException, MalformedURLException, NotFoundException{
		
		StringBuilder sb = new StringBuilder();
		URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] {
	       new URL(this.pathToTests),
	       new URL(this.pathToClasses)
	    });
		Class<?> clazz = urlClassLoader.loadClass("m2ila.vv.inputs."+testClass+"Test");
		sb.append("Loaded test class : "+ testClass +'\n');
		
		JUnitCore core = new JUnitCore();
        Result result = new Result();
        result = core.run(clazz);
        sb.append("TESTS FINISHED<br>\n");
        sb.append(String.format("| RUN: %d", result.getRunCount())+"<br>\n");
        if(result.wasSuccessful())
        	sb.append("| ALL TESTS SUCCEEDED ! <br>\n");
        else
        	sb.append("| FAILURE ! <br>\n");
        for (Failure failure : result.getFailures()){
        	sb.append("<font color=\"red\">"+failure.toString()+"</font><br>\n");
           // System.out.println(failure.getTrace()+'\n');
        }
        sb.append(String.format("| TIME: %dms", result.getRunTime())+"<br>\n");
        sb.append("********************************<br>\n");
        sb.append("********************************<br>\n");
        return sb.toString();
	}
}
