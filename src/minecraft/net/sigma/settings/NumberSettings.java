package net.sigma.settings;

import net.sigma.module.Module;

public class NumberSettings extends Settings{
	public double def, min, max, increment;

	public NumberSettings(String name, String desc, double def, double min, double max, Module parent) {
		this.name = name;
		this.desc = desc;
		this.def = def;
		this.min = min;
		this.max = max;
		this.increment = 0.1;
		this.parent = parent;
	}

	public NumberSettings(String name, String desc, double def, double min, double max, double increment, Module parent) {
		this.name = name;
		this.desc = desc;
		this.def = def;
		this.min = min;
		this.max = max;
		this.increment = increment;
		this.parent = parent;
	}

	public double getDef() {
		return def;
	}

	public void setDef(double def) {
		this.def = def;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getIncrement() {
		return increment;
	}

	public void setIncrement(double increment) {
		this.increment = increment;
	}
	
	public void increment(boolean increment) {
		setValue(this.getDef() + (increment ? 1 : -1) * this.increment);
	}
	public void setValue(double value) {
		double val = 1.0D / this.increment;
		this.def = Math.round(Math.max(this.min, Math.min(this.max, value)) * val) / val;
	}
	
	
	@Override
	public Double getVar() {
		return def;
	}

	@Override
	public void setVar(Object value) {
		if (value instanceof Double) {
			if ((double)value < this.min || (double)value > this.max) {
				return;
			}
			this.def = (Double) value;
		}
	}
	
	public int getIntValue() {
		return (int) def;
	}

	public float getFloatValue() {
		return (float) def;
	}

	public long getLongValue() {
		return (long) def;
	}
	
}
