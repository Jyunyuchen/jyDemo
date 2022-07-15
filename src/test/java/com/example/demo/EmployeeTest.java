package com.example.demo;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.specifications.EmployeeSpecifications;

@SpringBootTest
public class EmployeeTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	void test01() {
		  List<Employee> employeeList = employeeRepository.findByAgeLessThanLeftJoinDepartment(20);
		  for (Employee employee : employeeList) {
			System.out.println("============>\n" + employee + employee.getDepartment());
			
		}
	}
	
	@Test
	void test02() {
		Employee employee = new Employee();
		employee.setEName("李四");
		employee.setAge(52);

		/*
		 * 若設定cascade會認為是要在插入一條Department資料，
		 * 而不是根據外鍵1004插入一筆關連到1004的資料，
		 * 所以不能設定cascade = CascadeType.PERSIST
		 * 
		 */
		Department department = new Department();
		department.setDeptNo(1004);
		//department.setName("人事部");
		
		employee.setDepartment(department);
		
		employeeRepository.save(employee);
		
	}
	

	@Test
	void test03() {
		  List<Employee> employeeList = employeeRepository.findByAgeAndDepartmentId(20,1001);
		  for (Employee employee : employeeList) {
			System.out.println("============>\n" + employee + employee.getDepartment());
		}
	}
	
	@Test
	void test04() {
		employeeRepository.updateNameById("漂亮的---阿紫", 4);
		
	}
	
	/**
	 * 物件為導向查詢1001部門的員工
	 */
	@Test
	void test05() {
		Department department = new Department();
		department.setDeptNo(1001);
		List<Employee> employeeList = employeeRepository.findByDepartmentObject(department);
		for(Employee employee : employeeList) {
			System.out.println("============>\n" + employee);
		}
		
	}
	
	/**
	 * 刪除員工
	 */
	@Test
	void test06() {
		//1.先透過姓名查詢出該員工(使用JPA命名查詢)
		List<Employee> employees = employeeRepository.findByeName("喬峰");
		for (Employee employee : employees) {
			System.out.println("=============>\n" + employee);
			//employeeRepository.deleteById(employee.getEId());
			//2.直接刪除該員工
			employeeRepository.delete(employee);
		}
		
		/*
		 * 注意:
		 * 若刪除失敗，則須注意是否在Employee類的Department屬性上的@ManyToOne
		 * 配置了fetch=FetchType.EAGER，會受到立即加載的影響而刪除不了
		 * 也要注意，Department類的toString方法是否有使用到Employee
		 * 
		 */
		
		
	}
	
	/**
	 * 根據ID查詢出員工，再修改員工的姓名
	 */
	@Test
	void test07() {
		Optional<Employee> employee = employeeRepository.findById(1);
		employee.get().setEName("我是喬鋒111");
		// 帶有ID執行save方法就是update
		employeeRepository.save(employee.get());
	}
	
	/**
	 * 查詢所有員工並根據主鍵排序
	 */
	@Test
	void test08() {
		// 填入的「eId」是類別的屬性名稱不是資料表的欄位名
		Sort sort = Sort.by(Sort.Order.desc("eId"));
		List<Employee> EmployeeList = employeeRepository.findAll(sort);
		for (Employee employee : EmployeeList) {
			System.out.println(employee);
		}
	}
	
	/**
	 * 查詢所有員工並分頁
	 */
	@Test
	void test09() {
		//查詢第1頁(從0開始)每頁2筆，並按照主鍵排序
		Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Order.desc("eId")));
		Page<Employee> page = employeeRepository.findAll(pageable);
		System.out.println("該頁內容===>" + page.getContent());
		System.out.println("總共有幾筆===>" + page.getTotalElements());
		System.out.println("總頁數===>" + page.getTotalPages());
		System.out.println("每頁多少===>" + page.getSize());
	}
	
	/**
	 * JPQL查詢員工，傳入的參數是個物件
	 */
	@Test
	void test10() {
		Employee employee = new Employee();
		employee.setEId(1);
		Employee dbEmployee = employeeRepository.findByEmployeeObject(employee);
		System.out.println(dbEmployee);
	}
	
	/**
	 * JPQL查詢，加分頁功能
	 */ 
	@Test
	void test11() {
		Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Order.desc("eId")));
		List<Employee> employeeList = employeeRepository.findByAgePageable(1, pageable);
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
	
	/**
	 * 新增一名員工
	 * 1.先知道該員工所屬的部門是什麼(先查詢部門的物件出來)
	 * 2.再新增該名員工，並設定他的所屬的相關資料以及部門
	 */
	@Test
	void test12() {
		// 先查詢該部門出來，好可以給新增員工時set部門
		Department department = departmentRepository.findOneByName("財務部");
		
		// 新增員工
		Employee employee = new Employee();
		employee.setAge(31);
		employee.setEName("陳俊宇-財務部");
		employee.setDepartment(department);
		
		employeeRepository.save(employee);
	}
	
	/**
	 * 查詢所有員工
	 */
	@Test
	void test13() {
		//List<Employee> employees = employeeRepository.findAll();
		System.out.println("=======> " + employeeRepository.findAll());
	}
	
	/**
	 * 查詢某部門年齡大於age的員工
	 */
	@Test
	void test14() {
		List<Employee> employees = employeeRepository
				.findAll(EmployeeSpecifications.innerJoinDept("銷售部", 50));
		
		System.out.println(employees);
		
	}
	
	/**
	 * 使用自定義Repository查詢員工(根據名字)
	 */
	@Test
	void test15() {
		List<Employee> employees = employeeRepository.customQuetyMethod("高駿生");
		System.out.println(employees);
		
	}
	
	/**
	 * 保存一名員工後立即取得id
	 */
	@Test
	void test16() {

		//先取得持久化狀態的部門
		Optional<Department> deptOptional = departmentRepository.findById(4);
		
		//新增一名員工(瞬時狀態)
		Employee employee = new Employee();
		employee.setAge(25);
		employee.setEName("行銷達人");
		employee.setDepartment(deptOptional.get());
		
		//保存員工(持久化狀態)
		employeeRepository.save(employee);
		
		//立即取得ID
		System.out.println("剛保存的員工ID===> " + employee.getEId());
		
	}
	
	/**
	 * 刪除游離物件的員工
	 */
	@Test
	void test17() {
		//新增一個游離物件
		Employee employee = new Employee();
		employee.setEId(6);
		
		//執行刪除
		employeeRepository.delete(employee);
	}

	/**
	 * 使用Example查詢
	 * 1.EmployeeRepository先繼承QueryByExampleExecutor<Employee>
	 * 2.根據flag(true或false)模擬前端的動態條件，查詢名字"Ab"開頭的員工
	 */
	@Test
	void test18() {

		boolean dynamicConditionsFlag = true;

		ExampleMatcher matcher = ExampleMatcher.matching();

		//新增一個游離物件
		Employee employee = new Employee();
		employee.setEName("Ab");

		// 如果條件成立，查詢姓名"Ab"開頭的員工
		if(dynamicConditionsFlag){
			matcher = matcher.withMatcher("eName", m -> m.startsWith());
		}

		Example example = Example.of(employee, matcher);

		List<Employee> employeeList = employeeRepository.findAll(example);

		System.out.println("-----------------------------------");
		System.out.println(employeeList);
		System.out.println("-----------------------------------");
	}

}
