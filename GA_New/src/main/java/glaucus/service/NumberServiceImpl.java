package glaucus.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import glaucus.dao.NumberDao;
import glaucus.model.Number;

@Service
public class NumberServiceImpl implements NumberService {
	
	int number =0;

	private NumberDao numberDao;
	
	public NumberDao getNumberDao() {
		return numberDao;
	}

	public void setNumberDao(NumberDao numberDao) {
		this.numberDao = numberDao;
	}
	

	@Override
	@Transactional
	public void updateNumber(Number n) {
		this.numberDao.updateNumber(n);
	}
	
	@Override
	@Transactional
	public Number getById(int id) {
		return this.numberDao.getNumberById(id);
	}
	
	@Override
	@Transactional
	public String incrementAndUpdateNumber() {
		try {
			synchronized (this) {
				number+=1;
				//System.out.println("Before update :"+number);
							
			}
			if(number%100==0) {
				Number numberObj = this.numberDao.getNumberById(1);
				numberObj.setNumber(number);	
				updateNumber(numberObj);
			}
			return "success";
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
