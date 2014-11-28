package es.codington.model.interfaces.daos;

public interface IIdentifiersDAO {

	public static final String CLASS_EVENTS_NAME = "events";
    public static final String CLASS_USERS_NAME = "user";
    public static final String CLASS_EVENTS_USERS_NAME = "events_users";

    /**
     * Method that returns the next id assigned to the table whose name is
     * passed as parameter
     * 
     * @param nameclass
     * @return nextId
     */
    public int getNextId(String classname);

    /**
     * Method that update the next id assigned to the table whose name is passed
     * as parameter
     * 
     * @param nameclass
     * @param nextId
     * @return affectedRows
     */
    public int updateNextId(String classname, int nextId);
    
}
