package com.falcongames.dao;

import java.util.List;

import com.falcongames.mapper.IRowMapper;

public interface IGenericDAO<T> {
	
	public <K> List<K> query(String sql, IRowMapper<K> rowMapper, Object... parameters);

	// delete and update
	public void update(String sql, Object... parameters);

	// insert data
	public Long insert(String sql, Object... parameters);
}
