package glaucus.service;

import java.util.List;

import glaucus.model.Number;

public interface NumberService {

	public void updateNumber(Number n);
	public String incrementAndUpdateNumber();
	public Number getById(int id);
}
