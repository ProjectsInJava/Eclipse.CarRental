package System.Managers;

import System.Hardware.CPU;

public abstract class Manager {

	public CPU _cpu = CPU.Instance;
	
	protected abstract void init(Integer aValue);
	protected abstract void work();
	protected abstract Object cleanup();
	
	public Object Run(Integer aValue){
		init(aValue);
		for(int i = 0 ; i<aValue;i++){
			work();
		}
		return cleanup();
	}
}