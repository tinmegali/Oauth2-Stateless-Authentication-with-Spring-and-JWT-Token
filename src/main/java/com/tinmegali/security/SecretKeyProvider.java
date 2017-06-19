package com.tinmegali.security;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

/**
 * Based on http://www.java2s.com/Code/Java/Security/RetrievingaKeyPairfromaKeyStore.htm
 */
@Component
public class SecretKeyProvider {

    public String getKey() throws URISyntaxException,
            KeyStoreException, IOException,
            NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException{
        return new String( getKeyPair().getPublic().getEncoded(), "UTF-8" );
    }

    private KeyPair getKeyPair() throws
            KeyStoreException, IOException,
            NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {
        FileInputStream is = new FileInputStream("keys.jks");

        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(is, "abracadabra".toCharArray());

        String alias = "keys";

        Key key = keystore.getKey(alias, "abracadabra".toCharArray());
        if (key instanceof PrivateKey) {
            // Get certificate of public key
            Certificate cert = keystore.getCertificate(alias);

            // Get public key
            PublicKey publicKey = cert.getPublicKey();

            // Return a key pair
            return new KeyPair(publicKey, (PrivateKey) key);
        } else throw new UnrecoverableKeyException();
    }

}
