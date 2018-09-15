package org.traintransfer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CoreDao {

	List<?> callTrainSearch();

}
