package org.ffcc.CommunityVessellsRest.services;

public class StorageFileNotFoundException extends StorageException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8029997089922662805L;

	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}