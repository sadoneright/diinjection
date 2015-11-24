package examples.di.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import examples.di.core.annotations.DIInjection;

public class DependencyInjecter {

	public DependencyInjecter() {
	}

	public void injectDependencies(Object application) {
		Field[] fields = application.getClass().getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(DIInjection.class)) {
				try {
					Object o = null;
					if (field.getType().isInterface()) {
						o = field.getDeclaredAnnotation(DIInjection.class).type().newInstance();
					} else {
						o = field.getType().newInstance();
					}
					Method method = application.getClass()
							.getMethod("set" + field.getName().substring(0, 1).toUpperCase()
									+ field.getName().substring(1, field.getName().length()), field.getType());
					method.invoke(application, o);
					injectDependencies(o);
				} catch (IllegalArgumentException | NoSuchMethodException | SecurityException | IllegalAccessException
						| InvocationTargetException | InstantiationException exception) {
					exception.printStackTrace(System.err);
				}
			}
		}
	}

}
