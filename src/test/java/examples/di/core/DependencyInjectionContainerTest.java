package examples.di.core;

import java.lang.reflect.InvocationTargetException;

import examples.di.core.annotations.DIInjection;
import examples.di.core.calculator.CalculatorView;

public class DependencyInjectionContainerTest {

	@DIInjection
	private CalculatorView view;

	public DependencyInjectionContainerTest() {
	}

	public CalculatorView getView() {
		return view;
	}

	public void setView(CalculatorView view) {
		this.view = view;
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		DependencyInjecter diContainer = new DependencyInjecter();
		DependencyInjectionContainerTest test = new DependencyInjectionContainerTest();

		diContainer.injectDependencies(test);
		
		System.out.println(test.getView().getCalculator().calculate(1, 1));
		System.out.println(test.getView().getProductCalculator().calculate(2, 3));
	}

}
