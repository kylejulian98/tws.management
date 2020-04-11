package tws.management.data;

import org.apache.commons.dbcp2.BasicDataSource;

import tws.management.configuration.DatabaseConfigModel;

public class DatabaseConnectionManager {

	private final BasicDataSource connectionPool;

	public DatabaseConnectionManager(DatabaseConfigModel databaseConfig) {
		this.connectionPool = new BasicDataSource();
		this.connectionPool.setDriverClassName("org.postgresql.Driver");
		this.connectionPool.setUrl("jdbc:postgresql://" + databaseConfig.getHost() + ":" + databaseConfig.getPort() + "/" + databaseConfig.getDatabase());
		this.connectionPool.setUsername(databaseConfig.getUserName());
		this.connectionPool.setPassword(databaseConfig.getPassword());
		this.connectionPool.setInitialSize(1);
		this.connectionPool.setMaxTotal(databaseConfig.getMaxConcurrentConnections());
	}
	
	public BasicDataSource getConnectionPool() {
		return this.connectionPool;
	}
}
