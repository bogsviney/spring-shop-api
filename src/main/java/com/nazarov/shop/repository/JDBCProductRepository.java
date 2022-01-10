package com.nazarov.shop.repository;

import com.nazarov.shop.entity.Product;
import com.nazarov.shop.repository.mapper.ProductRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class JDBCProductRepository implements ProductRepository {

    private static final ProductRowMapper PRODUCT_ROW_MAPPER = new ProductRowMapper();

    private static final String FIND_ALL_SQL = "SELECT id, name, price, description, date FROM products;";

    private final DataSource dataSource;

    @Override
    public List<Product> findAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = PRODUCT_ROW_MAPPER.mapRow(resultSet);
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
