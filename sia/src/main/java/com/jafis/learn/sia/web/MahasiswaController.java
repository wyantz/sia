/**
 * 
 */
package com.jafis.learn.sia.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jafis.learn.sia.dao.MahasiswaDao;
import com.jafis.learn.sia.model.Mahasiswa;

/**
 * @author Awiyanto Ajisasongko
 *
 */
@RestController
@RequestMapping(value= {"/mahasiswa","/api/mahasiswa"})
public class MahasiswaController {
	@Autowired
	private MahasiswaDao mahasiswaDao;
	
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Mahasiswa> get(@PathVariable Long id) {
		try {
			Mahasiswa mhs = this.mahasiswaDao.findOne(id);
			return new ResponseEntity<>(mhs, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	@RequestMapping(value="search/{name}", method=RequestMethod.GET)
	public ResponseEntity<List<Mahasiswa>> search(@PathVariable String name) {
		try {
			List<Mahasiswa> mhsList = this.mahasiswaDao.findByNameContaining(name);
			return new ResponseEntity<>(mhsList, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}

	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Mahasiswa> delete(@PathVariable Long id) {
		try {
			this.mahasiswaDao.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Mahasiswa>> getAll() {
		try {
			List<Mahasiswa> mhs = this.mahasiswaDao.findAll();
			return new ResponseEntity<>(mhs, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Mahasiswa> insert(@RequestBody Mahasiswa mhs) {
		try {
			this.mahasiswaDao.save(mhs);
			return new ResponseEntity<>(mhs, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}	

	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<Mahasiswa> update(@RequestBody Mahasiswa mhs) {
		try {
			this.mahasiswaDao.save(mhs);
			return new ResponseEntity<>(mhs, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
}
