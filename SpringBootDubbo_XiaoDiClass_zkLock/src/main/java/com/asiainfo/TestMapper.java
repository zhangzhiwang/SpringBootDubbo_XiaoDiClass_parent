package com.asiainfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

//@Mapper
public interface TestMapper {
	void update(@Param("count") int count);
	int getCountById(@Param("id") int id);
}
