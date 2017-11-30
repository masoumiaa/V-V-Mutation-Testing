package m2ila.vv.Mutation_Testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javassist.NotFoundException;

public class TestRunner {

	public String runTests(String testClass) throws ClassNotFoundException, MalformedURLException, NotFoundException{
		
		StringBuilder sb = new StringBuilder();
		URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] {
	       new URL("file:///home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/test-classes/"),
	       // TODO change this path to temp classes url
	       new URL("file:///home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/classes/")
	    });
		Class<?> clazz = urlClassLoader.loadClass("m2ila.vv.inputs."+testClass);
		sb.append("Loaded test class : "+ testClass +'\n');
		
		JUnitCore core = new JUnitCore();
        Result result = core.run(clazz);
        sb.append("TESTS FINISHED");
        sb.append(String.format("| RUN: %d", result.getRunCount())+'\n');
        if(result.wasSuccessful())
        	sb.append("| ALL TESTS SUCCEEDED !");
        else
        	sb.append("| FAILURE ! ");
        for (Failure failure : result.getFailures()){
            sb.append(failure.toString()+'\n');
            sb.append(failure.getTrace()+'\n');
        }
        sb.append(String.format("| TIME: %dms", result.getRunTime())+'\n');
        
        return sb.toString();
	}
}
