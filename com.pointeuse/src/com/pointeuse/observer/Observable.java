package com.pointeuse.observer;

public interface Observable {
	 public void addObserveur(Observeur obs);
	 public void removeObserveur(Observeur obs);
	 public void notifyObserveur(String str);
}
