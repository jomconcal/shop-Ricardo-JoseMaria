package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.generic;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.base.RepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.*;

//No entiendo por qué tengo que hacer extends e implements. Me parece redundante. ¿No funcionaría sólo con uno de los dos?
@Repository
public class CategoryRepositoryImpl extends RepositoryImpl<Category,Long> implements CategoryRepository {


}
