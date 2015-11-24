package examples.di.core.calculator;

import examples.di.core.annotations.DIInjection;

public class CalculatorView {

	@DIInjection(type = CalculatorBean.class)
	public ICalculator calculator;

	@DIInjection(type = ProductCalculatorBean.class)
	public ICalculator productCalculator;

	public ICalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(ICalculator calculator) {
		this.calculator = calculator;
	}

	public ICalculator getProductCalculator() {
		return productCalculator;
	}

	public void setProductCalculator(ICalculator productCalculator) {
		this.productCalculator = productCalculator;
	}

}
