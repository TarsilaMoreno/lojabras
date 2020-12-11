package br.lojabras.app.repository;

import static java.util.Optional.ofNullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.lojabras.app.model.VendasEntity;

@Repository
public class VendasRepositoryService {
	
	private static final String DD_MM_YYYY = "dd/MM/yyyy";

	@Autowired
	private EntityManager em;
	
	private final SimpleDateFormat formatter = new SimpleDateFormat(DD_MM_YYYY);
	
	public List<VendasEntity> geraRelatorio(String status, String condicao, String dataIni, String dataFim) throws ParseException {
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<VendasEntity> cq = cb.createQuery(VendasEntity.class);

	    Root<VendasEntity> vendas = cq.from(VendasEntity.class);
	    List<Predicate> predicates = new ArrayList<>();
	    
	    
	    if (!ofNullable(status).isEmpty()) {
	        predicates.add(cb.equal(vendas.get("status"), status));
	    }
	    if (!ofNullable(condicao).isEmpty()) {
	        predicates.add(cb.equal(vendas.get("condicao"), condicao));
	    }
	    if (!ofNullable(dataIni).isEmpty() && ofNullable(dataFim).isEmpty())  {
	    	predicates.add(cb.equal(vendas.get("data"), formatter.parse(dataIni)));
	    }
	    if (!ofNullable(dataIni).isEmpty() && !ofNullable(dataFim).isEmpty()) {
	    	predicates.add(cb.between(vendas.get("data"), formatter.parse(dataIni),formatter.parse(dataFim)));
	    }
	    cq.where(predicates.toArray(new Predicate[0]));

	    return em.createQuery(cq).getResultList();
	}
	
	
}

		
//		Date data = Date.from(LocalDate.parse("23/12/2020").atStartOfDay(ZoneId.systemDefault()).toInstant());
//		System.out.println(data);

