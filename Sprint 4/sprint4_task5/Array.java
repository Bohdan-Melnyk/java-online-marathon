package sprint4_task5;

class Array<T> {
	private T[] array;

	public Array(T[] array) {
		this.array = array;
	}
	public T getIndex(int index) {
		return array[index];
	}
	public int length() {
		return array.length;
	}
	
	
	
}
