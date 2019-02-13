package lk.ijse.dep.app.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAUtil {

    private static EntityManagerFactory emf=buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        try {
            File jpaPropFile = new File("settings/application.properties");
            Properties jpaProp = new Properties();
            FileInputStream fileInputStream = new FileInputStream(jpaPropFile);
            jpaProp.load(fileInputStream);
            fileInputStream.close();
            return Persistence.createEntityManagerFactory("unit1", jpaProp);
        }catch (Exception ex){
            Logger.getLogger("").log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

}
