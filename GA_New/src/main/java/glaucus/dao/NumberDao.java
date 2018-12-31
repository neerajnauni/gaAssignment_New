package glaucus.dao;

import java.util.List;

import glaucus.model.Number;

public interface NumberDao {

	public void updateNumber(Number n);
	public Number getNumberById(int id);
}
