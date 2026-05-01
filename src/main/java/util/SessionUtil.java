package util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Utility class for managing HTTP sessions in the Airplane Management System.
 * This class is used to store, get, remove and clear session data.
 */
public class SessionUtil {
	
	/**
	 * Stores data in the current user session
	 * @param request the request object from servlet
	 * @param key the name used to store the values
	 * @param value the data to store in session
	 */
	public static void setAttribute(HttpServletRequest request, String key, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(key,  value);
	}
	
	/**
	 * Gets data from the current user session.
	 * 
	 * @param request the request object from servlet
	 * @param key the name of the stored value
	 * @return stored session value or null if not found
	 */
	public static Object getAttribute(HttpServletRequest request, String key) {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			return session.getAttribute(key);
		}
		
		return null;
	}
	
	/**
	 * Removes one value from the current user session.
	 * 
	 * @param request the request object from servlet
	 * @param key the name of the value to remove
	 */
	public static void removeAttribute(HttpServletRequest request, String key) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.removeAttribute(key);
		}
	}
	
	/**
	 * Ends the current user session
	 * This is mainly used during logout.
	 * 
	 * @param request the request object from servlet
	 */
	public static void invalidateSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.invalidate();
		}
	}

}
