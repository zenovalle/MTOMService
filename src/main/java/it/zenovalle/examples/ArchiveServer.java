package it.zenovalle.examples;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ArchiveServer {

	public String archiveFile(@WebParam(name="request") ArchiveRequest request);
	
	public DataHandler getFile(@WebParam(name="key") String key);

}