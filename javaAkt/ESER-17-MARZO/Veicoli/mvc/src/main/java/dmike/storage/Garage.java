package dmike.storage;

import java.util.List;

import dmike.domain.Veicol;

public interface Garage {
	public void insert(Veicol v);
	public boolean isEmpty();
	public boolean remove(Veicol v);
	public boolean contains(Veicol v);
	public List<Veicol> get();
}
