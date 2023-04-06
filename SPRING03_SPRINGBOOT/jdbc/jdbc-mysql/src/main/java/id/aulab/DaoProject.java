package id.aulab;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import id.aulab.model.Restaurant;

@Component
public class DaoProject implements InterfaceDao<Restaurant>{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count(){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM restaurant", Integer.class);   
    }

    @Override
    public List<Restaurant> getData() {
        return jdbcTemplate.query("SELECT * FROM restaurant", new BeanPropertyRowMapper<Restaurant>(Restaurant.class));
    }

    @Override
    public Restaurant getOne(BigInteger id){

        return jdbcTemplate.queryForObject("SELECT * FROM restaurant WHERE id = ?", 
        new BeanPropertyRowMapper<Restaurant>(Restaurant.class), id);

    }


    @Override
    public boolean insert(Restaurant model) {
        int result = jdbcTemplate.update("INSERT into restaurant (name, description, number_clients) value (?, ?, ?)", model.getName(), model.getDescription(), model.getNumber_clients());

        return result > 0;
    }

    @Override
    public boolean update(BigInteger id, Restaurant model) {
        int result = jdbcTemplate.update("UPDATE restaurant SET name = ?, description = ?, number_clients = ? WHERE id = ?", model.getName(), model.getDescription(), model.getNumber_clients(), id);

        return result > 0;
    }

    @Override
    public boolean delete(BigInteger id) {
        int result = jdbcTemplate.update("DELETE FROM restaurant WHERE id = ? ", id);

        return result > 0;
    }

}
