package com.model.enums;

public enum Tipo {
	EQUIPABLE{
		public void saludar() {
			System.out.println("ola");
		}
	};

	public abstract void saludar();
}
