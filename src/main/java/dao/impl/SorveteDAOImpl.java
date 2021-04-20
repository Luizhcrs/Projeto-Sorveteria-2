package dao.impl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.SorveteDAO;
import entidade.Sorvete;
import util.JpaUtil;

public class SorveteDAOImpl implements SorveteDAO {
	EntityManager incio = JpaUtil.getEntityManager();

	public void salvar(Sorvete sorvete) {
		EntityManager ent = JpaUtil.getEntityManager();
		Scanner ler = new Scanner(System.in);
		// System.out.println(ent.isOpen());
		try {

			Sorvete s = new Sorvete();
			System.out.println("Digite o nome do sorvete: ");
			s.setNome(ler.nextLine());
			System.out.println("Digite o sabor do Sorvete: ");
			s.setSabor(ler.nextLine());
			System.out.println("Digite o fabricante do Sorvete: ");
			s.setFabricante(ler.nextLine());
			EntityTransaction ts = ent.getTransaction();
			ts.begin();
			ent.persist(s);
			ts.commit();
			ent.close();
			System.out.println("Sorvete Adicionado.");
		} catch (Exception e) {
			System.out.println("Não foi possivel adicionar o sorvete.");
		}
	}

	@Override
	public void remover(Sorvete sorvete) {
		Scanner ler = new Scanner(System.in);
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		System.out.println("Digite o nome do sorvete que deseja remover: ");
		String ome;
		ome = ler.nextLine();
		Sorvete sorvetes = manager.find(Sorvete.class, ome);
		manager.remove(sorvetes);
		tx.commit();

		manager.close();
		System.out.println("Sorvete Removido.");
	}

	@Override
	public List<Sorvete> lista() {

		EntityManager manager = JpaUtil.getEntityManager();
		Query query = manager.createQuery("from Sorvete p");
		List<Sorvete> sorvetes = query.getResultList();
		for (Sorvete sorvete : sorvetes) {
			System.out.print("Nome: " + sorvete.getNome() + "| " + "Sabor: " + sorvete.getSabor() + "| "
					+ "Fabricante: " + sorvete.getFabricante() + "\n");

		}
		manager.close();

		return sorvetes;
	}

}
