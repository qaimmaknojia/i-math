package org.jerrymouse.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.jerrymouse.web.action.GetGreetingAction;
import org.jerrymouse.web.dao.GadgetDao;
import org.jerrymouse.web.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {
	@NotPersistent
	private UserDao userDao;
	@NotPersistent
	private GadgetDao gadgetDao;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;

	@Persistent
	private String nickName;

	@Persistent
	private String email;

	@Persistent
	private String password;

	@Persistent
	private List<GadgetContainer> gadgetContainers;

	public User() {
	}

	public User(String nickName, String email, String password) {
		super();
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static User getAdminUser() {
		User admin = new User().getUserDao().findUser("admin@imath.org",
				"admin");
		if (admin == null) {
			admin = buildAdminUser();
			UserDao userDao = admin.getUserDao();
			admin = userDao.save(admin);
		}
		System.err.println(admin.getGadgetContainers().size());
		return admin;
	}

	public static User buildAdminUser() {
		User user = new User("admin", "admin@imath.org", "admin");

		Gadget smartcalculator = new Gadget("smartcalculator", "计算器",
				"/gadgets/smartcalculator/smartcalculator.xml");
		Gadget jep = new Gadget("jep", "绘图器", "/gadgets/jep/jep.xml");
		Gadget eyes = new Gadget("eyes", "眼睛", "/gadgets/eyes/eyes.xml");
		Gadget sudoku = new Gadget("sudoku", "数独", "/gadgets/sudoku/sudoku.xml");
		Gadget calcll = new Gadget("calcll", "高级计算器",
				"/gadgets/calcll/calcll.xml");
		Gadget scale = new Gadget("scale", "平衡游戏", "/gadgets/scale/scale.xml");
		Gadget calculator = new Gadget("calculator", "轻型计算器",
				"/gadgets/calculator/calculator.xml");
		Gadget latex2image = new Gadget("latex2image", "latex图片转换器",
				"/gadgets/latex2image/latex2image.xml");
		Gadget univariateFunction = new Gadget("univariateFunction", "一元方程解",
				"/gadgets/univariateFunction/univariateFunction.xml");
		Gadget googleChart = new Gadget("google-chart", "图表绘制器",
				"/gadgets/google-chart/google-chart.xml");
		Gadget svgvml = new Gadget("svgvml", "3d绘图器",
				"/gadgets/svgvml/svgvml.xml");
		Gadget distribution = new Gadget("distribution", "3d绘图器",
				"/gadgets/distribution/distribution.xml");
		Gadget gadgetAdder = new Gadget("gadgetAdder", "Gadget添加器",
		"/gadgets/gadgetAdder/gadgetAdder.xml");
		
		GadgetDao gadgetDao = user.getGadgetDao();

		gadgetDao.save(latex2image);
		gadgetDao.save(smartcalculator);
		gadgetDao.save(jep);
		gadgetDao.save(sudoku);
		gadgetDao.save(calcll);
		gadgetDao.save(scale);
		gadgetDao.save(calculator);
		gadgetDao.save(univariateFunction);
		gadgetDao.save(googleChart);
		gadgetDao.save(distribution);
		gadgetDao.save(gadgetAdder);

		GadgetContainer container1 = new GadgetContainer("计算器");
		GadgetContainer container2 = new GadgetContainer("绘图");
		GadgetContainer container3 = new GadgetContainer("解方程");
		GadgetContainer container4 = new GadgetContainer("概率分布");
		GadgetContainer container5 = new GadgetContainer("游戏");
		GadgetContainer container6 = new GadgetContainer("系统工具");

		container1.addLeft(smartcalculator);
		container1.addMiddle(calcll);
		container1.addRight(calculator);

		container2.addLeft(jep);
		container2.addMiddle(latex2image);
		container2.addRight(googleChart);

		container3.addLeft(univariateFunction);
		
		container4.addLeft(distribution);

		container5.addLeft(sudoku);
		container5.addMiddle(scale);

		container6.addLeft(gadgetAdder);

		user.addGadgetContainer(container1);
		user.addGadgetContainer(container2);
		user.addGadgetContainer(container3);
		user.addGadgetContainer(container4);
		user.addGadgetContainer(container5);
		user.addGadgetContainer(container6);
		return user;
	}

	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = (UserDao) new ClassPathXmlApplicationContext(
					"classpath:/applicationContext.xml").getBean("userDao");
		}
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<GadgetContainer> getGadgetContainers() {
		if (gadgetContainers == null)
			gadgetContainers = new ArrayList<GadgetContainer>();
		return gadgetContainers;
	}

	public void setGadgetContainers(List<GadgetContainer> gadgetContainers) {
		this.gadgetContainers = gadgetContainers;
	}

	public void addGadgetContainer(GadgetContainer gadgetContainer) {
		getGadgetContainers().add(gadgetContainer);
	}

	public void setGadgetDao(GadgetDao gadgetDao) {
		this.gadgetDao = gadgetDao;
	}

	public GadgetDao getGadgetDao() {
		if (gadgetDao == null) {
			gadgetDao = (GadgetDao) new ClassPathXmlApplicationContext(
					"classpath:/applicationContext.xml").getBean("gadgetDao");
		}
		return gadgetDao;
	}
}
