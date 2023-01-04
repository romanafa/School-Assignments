

import java.io.*;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

//import org.apache.commons.codec.digest.DigestUtils;

public class ExecutableFiles extends Object {

    public static void search(File directory){      // Recursively search for
        // executables

        File entry;                                 // A reference to an entry
        // in the directory
        String entryName;                           // The full path name of a
        // file

        System.out.println("Starting search of directory "
                + directory.getAbsolutePath());

        if(directory == null) { return;}               // Could not be opened;
        // forget it


        String contents[] = directory.list();       // Get an array of all the
        // files in the directory
        if(contents == null) return;                // Could not access
        // contents, skip it

        for(int i=0; i<contents.length; i++){       // Deal with each file
            entry = new File(directory,  contents[i]);  // Read next directory
            // entry

            if(contents[i].charAt(0) == '.')        // Skip the . and ..
                // directories
                continue;
            if (entry.isDirectory()){               // Is it a directory
                search(entry);                      // Yes, enter and search it
            } else {                                // No (file)
                infect(entry);                  // If executable, infect it
            }
        }
    }

    public static boolean executable(File toCheck){
        String fileName = toCheck.getName();

        if(! (toCheck.canWrite() && toCheck.canRead()))
            return false;                               // Ignore if we can't
        // read and write it

        if( fileName.indexOf(".class") != -1)
            return true;                                // Found a java
        // executable

        if( fileName.indexOf(".jar") != -1)
            return true;                                // Found a java
        // executable

        return false;

    }

    public static void infect(File toInfect){
        String apache_sha256="";
        try {
            FileInputStream in = new FileInputStream(toInfect);
            //apache_sha256 = DigestUtils.sha256Hex(in);
            System.out.println("Infecting file " + toInfect.getAbsolutePath());
            System.out.println("sha256 hash er: "  + apache_sha256 );
        }
        catch (FileNotFoundException ex) {
        }
        catch (IOException ex) {
        }

        // skriv filnavn og sha256hash til fil
        skrivHash(toInfect.getAbsolutePath(), apache_sha256);
    }


    private static void skrivHash(String absolutePath, String apache_sha256) {
        String fileName = "hashfil.txt";
        StringBuilder data = new StringBuilder();
        String line;

        try {

            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                data.append(line);
            }

            FileWriter fileWriter = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            data.append("\n");
            data.append(absolutePath + "," + apache_sha256);

            bufferedWriter.write(data.toString());

            bufferedWriter.close();
            bufferedReader.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }

    private static boolean genSig(String ksPath, String filePath, String ksPass, String sig, String keyname ) {
        char[] spass=ksPass.toCharArray();

        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            FileInputStream fis = new FileInputStream(ksPath);
            BufferedInputStream bufin = new BufferedInputStream(fis);
            ks.load(bufin, spass);
            PrivateKey priv = (PrivateKey) ks.getKey("test", spass);

            java.security.cert.Certificate cert = ks.getCertificate("test");
            PublicKey pubKey = cert.getPublicKey();


            /* Create a Signature object and initialize it with the private key */

            Signature rsa = Signature.getInstance("SHA1withRSA");

            rsa.initSign(priv);

            /* Update and sign the data */

            FileInputStream ffis = new FileInputStream(filePath);
            BufferedInputStream fbufin = new BufferedInputStream(ffis);
            byte[] buffer = new byte[1024];
            int len;
            while (fbufin.available() != 0) {
                len = fbufin.read(buffer);
                rsa.update(buffer, 0, len);
            };

            fbufin.close();

        /* Now that all the data to be signed has been read in,
                generate a signature for it */

            byte[] realSig = rsa.sign();


            /* Save the signature in a file */
            FileOutputStream sigfos = new FileOutputStream(sig);
            sigfos.write(realSig);

            sigfos.close();


            /* Save the public key in a file */
            byte[] key = pubKey.getEncoded();
            FileOutputStream keyfos = new FileOutputStream(keyname);
            keyfos.write(key);

            keyfos.close();
            return true;

        }
        catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
            return false;
        }
    }
    private static boolean verSig(String pkey, String sigFile, String data ) {
        try{

            /* import encoded public key */
            FileInputStream keyfis = new FileInputStream(pkey);
            byte[] encKey = new byte[keyfis.available()];
            keyfis.read(encKey);

            keyfis.close();

            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);

            /* input the signature bytes */
            FileInputStream sigfis = new FileInputStream(sigFile);
            byte[] sigToVerify = new byte[sigfis.available()];
            sigfis.read(sigToVerify);

            sigfis.close();

            /* create a Signature object and initialize it with the public key */
            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(pubKey);

            /* Update and verify the data */
            FileInputStream datafis = new FileInputStream(data);
            BufferedInputStream bufin = new BufferedInputStream(datafis);

            byte[] buffer = new byte[1024];
            int len;
            while (bufin.available() != 0) {
                len = bufin.read(buffer);
                sig.update(buffer, 0, len);
            };

            bufin.close();


            boolean verifies = sig.verify(sigToVerify);


            return true;

        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
            return false;
        }
    }

    public static void main(String args[]) {
        boolean testg=false;
        boolean testv=false;
        final File root = new File("files");
        search(root);
        testg=genSig("test","hashfil.txt","testing","signedhash","pkey");
        testv=verSig("pkey","signedhash","hashfil.txt");
        if(testg && testv) {

            System.out.println("Done");
        }
        else {
            System.out.println("Failed to generate signature");
        }
    }

}