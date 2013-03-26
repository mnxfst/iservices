/**
 * 
 */
package com.mnxfst.iservices.core.actors.base;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import akka.actor.UntypedActor;

/**
 * Provides a parent to all actors that wish to utilize the implemented convenience
 * methods for configuring actor instances
 * @author ckreutzfeldt
 *
 */
public abstract class AbstractConfigurableUntypedActor extends UntypedActor {

	/**
	 * Parses the provided configuration file into a {@link Document} representation 
	 * @param configuration
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	protected Document parseConfiguration(String configuration) throws SAXException, IOException, ParserConfigurationException {		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(false);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new ByteArrayInputStream(configuration.getBytes()));
		return document;		
	}
	
}
