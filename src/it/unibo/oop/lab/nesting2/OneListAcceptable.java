package it.unibo.oop.lab.nesting2;

import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {
	
	private final List<T> list;
	private final int length;
	private int acceptedIndex = 0;
	
	public OneListAcceptable(List<T> list) {
		this.list = list;
		this.length = list.size();
	}

	public Acceptor<T> acceptor() {
		
		return new Acceptor<T>() {
			
			public void accept(T newElement) throws ElementNotAcceptedException {
			
				T elem;
			
				try {
					elem = OneListAcceptable.this.list.get(OneListAcceptable.this.acceptedIndex);
				} catch (IndexOutOfBoundsException e) {
					throw new ElementNotAcceptedException(this);
				}
			
				if(elem.toString().equals(newElement.toString())) {
					OneListAcceptable.this.acceptedIndex++;
				}
				else {
					throw new ElementNotAcceptedException(this);
				}
			}
		
			public void end() throws EndNotAcceptedException {
				
				if(OneListAcceptable.this.acceptedIndex != OneListAcceptable.this.length) {
					throw new EndNotAcceptedException();
				}
			}
			
		};
	}
}
