package dao;

import entidade.Sorvete;
import java.util.List;

public interface SorveteDAO {
	public void salvar(Sorvete sorvete);

	public void remover(Sorvete sorvete);

	public List<Sorvete> lista();
}
