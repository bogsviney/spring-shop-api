package com.nazarov.shop.repository;

import com.nazarov.shop.entity.Product;
import com.nazarov.shop.repository.mapper.ProductRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
@RequiredArgsConstructor
public class JDBCProductRepository implements ProductRepository {

    private static final ProductRowMapper PRODUCT_ROW_MAPPER = new ProductRowMapper();

    private static final String FIND_ALL_SQL = "SELECT id, name, price, description, date FROM products;";

    private static final String ADD_SQL = """
            INSERT INTO products (name, price, description,date)
            VALUES(:name, :price, :description, :date);
            """;

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, PRODUCT_ROW_MAPPER);
    }

    @Override
    public void addProduct(Product product) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", product.getName());
        parameters.put("price",product.getPrice());
        parameters.put("description", product.getDescription());
        parameters.put("date", product.getPublishDate());
        namedParameterJdbcTemplate.update(ADD_SQL, parameters);
    }
}
