package com.falcongames.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.falcongames.dao.IGenericDAO;
import com.falcongames.mapper.IRowMapper;



public class BaseDAO<T> implements IGenericDAO<T> {

	public Connection getConection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3307/book_meetingroom";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	private void setParameter(PreparedStatement preparedStatement, Object... parameters) {

		try {

			for (int i = 0; i < parameters.length; i++) {
				Object param = parameters[i];
				if (param instanceof Long) {
					preparedStatement.setLong(i + 1, (Long) param);
				} else if (param instanceof String) {
					preparedStatement.setString(i + 1, (String) param);
				} else if (param instanceof Integer) {
					preparedStatement.setInt(i + 1, (Integer) param);
				} else if (param instanceof Timestamp) {
					preparedStatement.setTimestamp(i + 1, (Timestamp) param);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public <K> List<K> query(String sql, IRowMapper<K> rowMapper, Object... parameters) {
		List<K> results = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}

			return results;

		} catch (SQLException e) {
			return null;
		} finally {

			try {
				// Close connection
				connection.close();
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();

				}

			} catch (SQLException e) {
				return null;
			}

		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				// Close connection
				connection.close();
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {

			}
		}

	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Long id = null;

		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();

			return id;

		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				// Close connection
				connection.close();
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();

				}

			} catch (SQLException e) {

				return null;

			}
		}
		return id;
	}

}
