package it.zenovalle.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebServiceException;

@WebService(endpointInterface = "it.zenovalle.examples.ArchiveServer",
            serviceName = "ArchiveServer")
public class ArchiveServerImpl implements ArchiveServer{

	Map<String, File> files = new LinkedHashMap<String, File>();
	private File tmpdir = new File(System.getProperty("java.io.tmpdir"),"uploaded");

	@Override
	public String archiveFile(ArchiveRequest request) {

		tmpdir.mkdir();

		if(request==null){
			throw new WebServiceException("Upload Failed");
		}

		File file = new File(tmpdir, request.getFileName());

		try {
			InputStream is = request.getFileLoad().getInputStream();
			OutputStream os = new FileOutputStream(file);

			file.createNewFile();

			byte[] b = new byte[100000];
			int bytesRead = 0;
			while ((bytesRead = is.read(b)) != -1) {
				os.write(b, 0, bytesRead);
			}
			
			is.close();
			os.flush();
			os.close();

			files.put(request.getKey(), file);
			
			System.out.println("File "+ request.getFileType() +" archived in " + file.getPath() + " - " +request.getKey() +" "+request.getDescription());

		} catch (IOException e) {
			e.printStackTrace();
			return "Upload Failed";
		}

		return "Upload Complete";
	}

	@Override
	public 
	@XmlMimeType("application/octet-stream") DataHandler getFile(String key) {

		File file = files.get(key);
		DataSource dataSource = new FileDataSource(file);
		System.out.println("Returning " + key + " : "+ file.getPath());
		return new DataHandler(dataSource);
	}
}