package com.nazarov.shop.repository.mapper;

import com.nazarov.shop.entity.Product;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProductRowMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet resultSet, int numRow) throws SQLException {
        int id = resultSet.getInt("id");
        double price = resultSet.getDouble("price");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        Timestamp publishDateTimeStamp = resultSet.getTimestamp("date");

        Product product = Product.builder().

                id(id)
                .name(name)
                .price(price)
                .description(description)
                .publishDate(publishDateTimeStamp.toLocalDateTime())
                .build();

        return product;

    }

}
