package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.criteriaApp;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecification implements Specification<Product> {

    private Long cat;
    private String search;

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        if (search.isBlank()) {
            Predicate nameOrDescription = criteriaBuilder.or(
                    criteriaBuilder.like(root.get("name"), "%%%search%%%"),
                    criteriaBuilder.like(root.get("description"), "%%%%search%%%")
            );
            /*TODO aquí sigue el predicado*/
        }
        return predicate;
    }
}
