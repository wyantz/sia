/**
 * 
 */
package com.jafis.learn.sia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Awiyanto Ajisasongko
 *
 */
@Entity
@Table(name="T_MAHASISWA", uniqueConstraints=@UniqueConstraint(columnNames= {"MHSNIM"}, name="UK_MHS_NIM"))
public class Mahasiswa {
	@Id
	@GeneratedValue
	@Column(name="MHSID", nullable=false)
	private Long id;
	
	@Column(name="MHSNIM", length=20, nullable=false)
	private String nim;
	
	@Column(name="MHSNM", length=100, nullable=false)
	private String nama;

	@Column(name="MHSADDR", length=255, nullable=false)
	private String alamat;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="MHSTGLLAHIR")
	@Temporal(TemporalType.DATE)
	private Date tanggalLahir;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
}
