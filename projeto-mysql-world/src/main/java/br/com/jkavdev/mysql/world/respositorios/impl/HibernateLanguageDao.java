package br.com.jkavdev.mysql.world.respositorios.impl;

import java.util.List;

import br.com.jkavdev.mysql.world.modelos.language.Language;
import br.com.jkavdev.mysql.world.modelos.language.LanguagePK;
import br.com.jkavdev.mysql.world.respositorios.LanguageDao;

public class HibernateLanguageDao extends HibernateGenericDao<Language, LanguagePK> implements LanguageDao {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Language> buscarTodos() {

		String jpql = "select l from Language l join l.countryCode";

		return getManager().createQuery(jpql, Language.class).getResultList();
	}

}
