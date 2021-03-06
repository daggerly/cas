package org.apereo.cas;

import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;

/**
 * Responsible to define operation that deal with encryption, signing
 * and verification of a value.
 *
 * @author Misagh Moayyed
 * @param <I> the type parameter for the input
 * @param <O> the type parameter for the output
 * @since 4.1
 */
public interface CipherExecutor<I, O> {
    
    /**
     * Default content encryption algorithm.
     */
    String DEFAULT_CONTENT_ENCRYPTION_ALGORITHM =
            ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256;
    
    /**
     * Encrypt the value. Implementations may
     * choose to also sign the final value.
     *
     * @param value the value
     * @return the encrypted value or null
     */
    O encode(I value);

    /**
     * Decode the value. Signatures may also be verified.
     *
     * @param value encrypted value
     * @return the decoded value.
     */
    O decode(I value);

    /**
     * Supports encryption of values.
     *
     * @return true/false
     */
    default boolean isEnabled() {
        return true;
    }

    /**
     * The (component) name of this cipher.
     *
     * @return the name.
     */
    String getName();
}
