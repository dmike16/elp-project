package dmike.util.web;

import java.util.List;

public interface Validator<T> {
	public List<String> validate(T obj); 
}
