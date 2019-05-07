package com.niaobulashi.repository;

import com.niaobulashi.model.User;
import com.niaobulashi.repository.test1.UserTest1Repository;
import com.niaobulashi.repository.test2.UserTest2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
	@Resource
	private UserTest1Repository userTest1Repository;
	@Resource
	private UserTest2Repository userTest2Repository;

	@Test
	public void testSave() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

		userTest1Repository.save(new User("aa", "aa123456","aa@126.com", "aa",  "123123"));
		userTest1Repository.save(new User("bb", "bb123456","bb@126.com", "bb",  "123123"));
		userTest2Repository.save(new User("cc", "cc123456","cc@126.com", "cc",  "123123"));
	}


	@Test
	public void testDelete() throws Exception {
		userTest1Repository.deleteAll();
		userTest2Repository.deleteAll();
	}

	@Test
	public void testBaseQuery() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		User user=new User("ff", "ff123456","ff@126.com", "ff",  formattedDate);
		userTest1Repository.findAll();
		userTest2Repository.findById(3l);
		userTest2Repository.save(user);
		user.setId(2l);
		userTest1Repository.delete(user);
		userTest1Repository.count();
		userTest2Repository.findById(3l);
	}


}