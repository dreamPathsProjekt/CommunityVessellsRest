package org.ffcc.CommunityVessellsRest.services;

public class StorageException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 675123563448699174L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
