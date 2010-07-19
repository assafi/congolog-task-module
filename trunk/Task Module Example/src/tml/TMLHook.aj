package tml;

import taskmodule.ITaskModule;
import taskmodule.TaskModuleException;
import utils.JarClassLoader;

public aspect TMLHook {
	
	private static boolean tmlLoaded = false;
	private static ITaskModule tml;
	
	pointcut init() :
		call(public toybox.CarToy.new());
	
	pointcut beep() :
		call(public void toybox.CarToy.beep());
	
	pointcut accelerate() :
		call(public void toybox.CarToy.accelerate());
	
	pointcut startEngine() :
		call(public void toybox.CarToy.startEngine());
	
	pointcut speed(int speed) :
		set(private int toybox.CarToy.speed) && args(speed);
	
	before() : init() {
		if (tmlLoaded) {
			return;
		}
		loadTML();
		initTML();
	}

	after() : beep() {
		try {
			tml.activityOccured("beep");
		} catch (TaskModuleException e) {
			e.printStackTrace();
		}
	}
	
	after() : accelerate() {
		try {
			tml.activityOccured("accelerate");
		} catch (TaskModuleException e) {
			e.printStackTrace();
		}
	}
	
	after() : startEngine() {
		try {
			tml.activityOccured("startEngine");
		} catch (TaskModuleException e) {
			e.printStackTrace();
		}
	}
	
	after(int speed) : speed(speed) {
		try {
			tml.varChanged("speed", speed);
		} catch (TaskModuleException e) {
			e.printStackTrace();
		}
	}

	private void initTML() {
		try {
			tml.addActivitySupport("beep");
			tml.addActivitySupport("accelerate");
			tml.addActivitySupport("startEngine");
			tml.addVariableSupport("speed", 0);
		} catch (TaskModuleException e) {
			e.printStackTrace();
		}
	}
	
	private void loadTML() {
		try {
			JarClassLoader jarLoader = new JarClassLoader("C:/Users/Administrator/workspace/Task Module Example/lib/task-module-1.1/task-module-1.11.jar");
			Class<?> c = jarLoader.loadClass("taskmodule.TaskModule");
			tml = (ITaskModule) c.getMethod("getInstance", new Class<?>[] {})
				.invoke(c, new Object[] {});
		} catch (Exception e) {
			System.err.println("Error while trying to load TaskModule Jar");
			e.printStackTrace();
		}
	}
}
