package org.db;

public class SQLStatements {

    public String selectActor() {
        String selectActor = "select * from actor where last_name like ? and first_name like ? order by last_name";
        return selectActor;
    }
    public String insertActor() {
        String insertActor = "insert into actor (last_name, first_name, last_update) values (?, ?, CURDATE())";
        return insertActor;
    }
    public String updateActor() {
        String updateActor = "update actor set last_name = ?, first_name = ? where last_name = ? and first_name = ?";
        return updateActor;
    }
    public String deleteActor() {
        String deleteActor = "delete from actor where last_name = ? and first_name = ?";
        return deleteActor;
    }
    public String selectFilmsFromActor() {
        String selectFilms = "select a.first_name, a.last_name, f.title, f. release_year from actor as a\n"
                + "left join film_actor as fa on a.actor_id = fa.actor_id\n"
                + "left join film as f on fa.film_id = f.film_id\n"
                + "where last_name like ? and first_name like ?" + "order by release_year desc;";
        return selectFilms;
    }
}