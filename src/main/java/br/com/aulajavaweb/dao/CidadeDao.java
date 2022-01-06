package br.com.aulajavaweb.dao;
import java.util.List;
import br.com.aulajavaweb.model.Cidade;

public interface CidadeDao {
	List<Cidade> get();
	Cidade get(int id);
	boolean save(Cidade cidade);
	boolean delete(int id);
	boolean update(Cidade cidade);
}
