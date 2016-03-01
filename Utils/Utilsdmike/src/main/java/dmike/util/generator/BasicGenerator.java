package dmike.util.generator;

public class BasicGenerator<T> implements Generator<T> {
	public BasicGenerator(Class<T> kind){
		this.kind = kind;
	}
	@Override
	public T next(){
		try{
			return this.kind.newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	private final Class<T> kind;
}
