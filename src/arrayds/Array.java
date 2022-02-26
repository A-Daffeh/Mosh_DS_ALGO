package arrayds;

public class Array {
	private int[] array;
	private int count;

	public Array(int size) {
		array = new int[size];
		this.count = 0;
	}

	public void insert(int value) {
		if (array.length == count) 
			this.resize();
		
		array[count] = value;
		count++;
	}

	public int removeAt(int index) {
		if (index < 0 || index >= count)
			throw new IllegalArgumentException();
		int result = array[index];
		for (int i = index; i < count; i++)
			array[i] = array[i + 1];
		count--;
		return result;
	}

	public int indexOf(int value) {
		for (int i = 0; i < count; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public int max() {
		int max = array[0];
		for (int i = 1; i < count; i++) 
			if (max < array[i])
				max = array[i];
		return max;
	}
	
	public void reverse() {
		int[] newArray = new int[count];
		int track = 0;
		for (int i = count - 1; i >= 0; i--) {
			newArray[track++] = array[i];
		}
		array = newArray;
	}
	
	public void resize() {
		int[] newArray = new int[array.length * 2];
		System.arraycopy(array, 0, newArray, 0, this.count);
		this.array = newArray;
	}
	
	public void insertAt(int item, int index) {
		if (index < 0 || index > count)
			throw new IllegalArgumentException();
		if (index == count && array.length == count)
			this.resize();
		
		for(int i = count - 1; i >= index; i--) 
			array[i + 1] = array[i];
		array[index] = item;
		count++;
	}

	public void display() {
		for (int i = 0; i < count; i++)
			System.out.print(array[i] + " ");
	}
}
