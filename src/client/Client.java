package client;

import java.io.IOException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBException;

import modele.Artiste;
import clientrest.lastFM.LastFMRestService;


//insert into entite values ('ARTISTE',1,'Madonna','forte!',null,null)
//insert into entite values ('ARTISTE',2,'Wood Allen','fort!',null,null)


public class Client {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws IOException, JAXBException, NamingException {
		 Properties env = new Properties();  
		    env.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");  
		    env.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");  
		    env.setProperty("java.naming.provider.url", "jnp://localhost:1099");  
		InitialContext ic = new InitialContext(env);
		LastFMRestService lfm = (LastFMRestService) ic.lookup("LastFMRestSearch/remote");
		Artiste a = lfm.getDetailArtistInfo("eminem");
		System.out.println(a.toString());

	
	}

}
