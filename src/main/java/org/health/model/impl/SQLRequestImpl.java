package org.health.model.impl;

import org.health.model.SQLRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("sqlRequest")
public class SQLRequestImpl implements SQLRequest {
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getTableCreationStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS public.dogs");
            jdbcTemplate.execute("CREATE TABLE public.dogs\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    name character varying(255) collate pg_catalog.\"default\",\n" +
                    "    decription character varying(255) collate pg_catalog.\"default\",\n" +
                    "    color_id integer,\n" +
                    "    CONSTRAINT dpgs_key PRIMARY KEY (id)\n" +
                    ")");
            return "table created";
        } catch (Exception ex) {
            return "table creation failed" + ex.getMessage();
        }
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
