/*******************************************************************************
 * Copyright (c) 2016 Sebastian Stenzel and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the accompanying LICENSE.txt.
 *
 * Contributors:
 *     Sebastian Stenzel - initial API and implementation
 *******************************************************************************/
package org.cryptomator.cryptolib.api;

import javax.security.auth.Destroyable;

public interface Cryptor extends Destroyable {

	FileContentCryptor fileContentCryptor();

	FileHeaderCryptor fileHeaderCryptor();

	FileNameCryptor fileNameCryptor();

	/**
	 * Shortcut for {@link #writeKeysToMasterkeyFile(CharSequence, byte[], int)} with en empty pepper.
	 * 
	 * @param passphrase The passphrase used to encrypt the key material.
	 * @param vaultVersion Will be checked upon decryption of this masterkey.
	 * @return Encrypted data that can be stored in insecure locations.
	 */
	KeyFile writeKeysToMasterkeyFile(CharSequence passphrase, int vaultVersion);

	/**
	 * @param passphrase The passphrase used to encrypt the key material.
	 * @param pepper An application-specific pepper added to the salt during key-derivation (if applicable)
	 * @param vaultVersion Will be checked upon decryption of this masterkey.
	 * @return Encrypted data that can be stored in insecure locations.
	 * @since 1.1.0
	 */
	KeyFile writeKeysToMasterkeyFile(CharSequence passphrase, byte[] pepper, int vaultVersion);

	@Override
	void destroy();

}
