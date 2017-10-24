package it.zenovalle.examples;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class ArchiveRequest {
	
	@XmlMimeType("application/octet-stream")
	protected DataHandler fileLoad;
	protected String fileName;
	protected String fileType;
	protected String key;
	protected String description;
	
	public DataHandler getFileLoad() {
		return fileLoad;
	}
	
	public void setFileLoad(DataHandler fileLoad) {
		this.fileLoad = fileLoad;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileType() {
		return fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
