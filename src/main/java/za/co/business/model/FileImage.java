package za.co.business.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the file_image database table.
 * 
 */
@Entity
@Table(name = "file_image")
//@NamedQuery(name="FileImage.findAll", query="SELECT f FROM FileImage f")
public class FileImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_image_id")
	private Long FileImageId;

	@Column(name = "file_name", length=256)
	private String fileName;

	@Column(name = "date_uploaded")
	private Timestamp dateUploaded;

	@Column(name = "file_image_url", length=256)
	private String FileImageUrl;

	@Column(name = "file_image_path", length=256)
	private String FileImagePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Timestamp getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(Timestamp dateUploaded) {
		this.dateUploaded = dateUploaded;
	}

	public String getFileImageUrl() {
		return FileImageUrl;
	}

	public void setFileImageUrl(String fileImageUrl) {
		FileImageUrl = fileImageUrl;
	}

	public String getFileImagePath() {
		return FileImagePath;
	}

	public void setFileImagePath(String fileImagePath) {
		FileImagePath = fileImagePath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FileImage [FileImageId=" + FileImageId + ", fileName=" + fileName + ", dateUploaded=" + dateUploaded
				+ ", FileImageUrl=" + FileImageUrl + ", FileImagePath=" + FileImagePath + "]";
	}



}