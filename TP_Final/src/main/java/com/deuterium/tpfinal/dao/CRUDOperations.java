package com.deuterium.tpfinal.dao;

import com.deuterium.tpfinal.utils.AuteurNotFoundException;
import com.deuterium.tpfinal.utils.LivreNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface CRUDOperations<entity, entityID> {
    // CREATE
    void insert(entity newEntity) throws SQLException;

    // READ
    entity getById(entityID entityId) throws SQLException, AuteurNotFoundException, LivreNotFoundException;

    List<entity> getAll() throws SQLException, AuteurNotFoundException;

    // UPDATE
    void update(entity entityToUpdate) throws SQLException;

    // DELETE
    void delete(entity entityToDelete) throws SQLException, AuteurNotFoundException, LivreNotFoundException;
}
