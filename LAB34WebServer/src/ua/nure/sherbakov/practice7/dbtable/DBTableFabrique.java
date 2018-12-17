package ua.nure.sherbakov.practice7.dbtable;

public abstract class DBTableFabrique {

	private static DBTable<?> instance;

	public static <T> DBTable<T> instance() {
		if (instance == null) {
			instance = new DBTableInMemory<T>();
		}
		return (DBTable<T>) instance;
	}
}
