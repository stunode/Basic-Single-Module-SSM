package com.youmeek.ssm.module.user.controller;

import com.youmeek.ssm.module.user.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


//@SessionAttributes(value={"user"}, types={String.class})
@RequestMapping("/Basic-Single-Module-SSM")
@Controller
public class SpringMVCTest {

	private static final String SUCCESS = "success";
	
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println("testRedirect");
		return "redirect:/index.jsp";
	}
//
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView");
		return "helloView";
	}

	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver(){
		System.out.println("testViewAndViewResolver");
		return SUCCESS;
	}
//
	/**
	 * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!
	 * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
	 * 1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
	 * 2). SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中.
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,
						Map<String, Object> map){
		System.out.println("modelAttribute method");
		if(id != null){
			//模拟从数据库中获取对象
			User user = new User(1, "Tom", "123456", "tom@atguigu.com", 12);

			System.out.println("从数据库中获取一个对象: " + user);

			map.put("user", user);
		}
	}

	@RequestMapping("/testModelAttribute")
	public String testModelAttribute( User user){
		System.out.println("修改: "+ user);
		return SUCCESS;
	}
//
//	/**
//	 * @SessionAttributes ���˿���ͨ��������ָ����Ҫ�ŵ��Ự�е�������(ʵ����ʹ�õ��� value ����ֵ),
//	 * ������ͨ��ģ�����ԵĶ�������ָ����Щģ��������Ҫ�ŵ��Ự��(ʵ����ʹ�õ��� types ����ֵ)
//	 *
//	 * ע��: ��ע��ֻ�ܷ����������. ���������ηŷ���.
//	 */
//	@RequestMapping("/testSessionAttributes")
//	public String testSessionAttributes(Map<String, Object> map){
//		User user = new User("Tom", "123456", "tom@atguigu.com", 15);
//		map.put("user", user);
//		map.put("school", "atguigu");
//		return SUCCESS;
//	}
//
//	/**
//	 * Ŀ�귽��������� Map ����(ʵ����Ҳ������ Model ���ͻ� ModelMap ����)�Ĳ���.
//	 * @param map
//	 * @return
//	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map){
		System.out.println(map.getClass().getName());
		map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
		return SUCCESS;
	}
//
//	/**
//	 * Ŀ�귽���ķ���ֵ������ ModelAndView ���͡�
//	 * ���п��԰�����ͼ��ģ����Ϣ
//	 * SpringMVC ��� ModelAndView �� model �����ݷ��뵽 request �������.
//	 * @return
//	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);

		//���ģ�����ݵ� ModelAndView ��.
		modelAndView.addObject("time", new Date());
		modelAndView.addObject("location", "shanghai");

		return modelAndView;
	}
//
//	/**
//	 * ����ʹ�� Serlvet ԭ���� API ��ΪĿ�귽���Ĳ��� ����֧����������
//	 *
//	 * HttpServletRequest
//	 * HttpServletResponse
//	 * HttpSession
//	 * java.security.Principal
//	 * Locale InputStream
//	 * OutputStream
//	 * Reader
//	 * Writer
//	 * @throws IOException
//	 */
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request,
			HttpServletResponse response, Writer out) throws IOException {
		System.out.println("testServletAPI, " + request + ", " + response);
		out.write("hello springmvc");
//		return SUCCESS;
	}
//
//	/**
//	 * Spring MVC �ᰴ����������� POJO �����������Զ�ƥ�䣬 �Զ�Ϊ�ö����������ֵ��֧�ּ������ԡ�
//	 * �磺dept.deptId��dept.address.tel ��
//	 */
//	@RequestMapping("/testPojo")
//	public String testPojo(User user) {
//		System.out.println("testPojo: " + user);
//		return SUCCESS;
//	}
//
//	/**
//	 * �˽�:
//	 *
//	 * @CookieValue: ӳ��һ�� Cookie ֵ. ����ͬ @RequestParam
//	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("testCookieValue: sessionId: " + sessionId);
		return SUCCESS;
	}
//
//	/**
//	 * �˽�: ӳ������ͷ��Ϣ �÷�ͬ @RequestParam
//	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(
			@RequestHeader(value = "Accept-Language") String al) {
		System.out.println("testRequestHeader, Accept-Language: " + al);
		return SUCCESS;
	}
//
//	/**
//	 * @RequestParam ��ӳ���������. value ֵ����������Ĳ����� required �ò����Ƿ����. Ĭ��Ϊ true
//	 *               defaultValue ���������Ĭ��ֵ
//	 */
	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(
			@RequestParam(value = "username") String un,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("testRequestParam, username: " + un + ", age: "
				+ age);
		return SUCCESS;
	}
//
//	/**
//	 * Rest ���� URL. �� CRUD Ϊ��: ����: /order POST �޸�: /order/1 PUT update?id=1 ��ȡ:
//	 * /order/1 GET get?id=1 ɾ��: /order/1 DELETE delete?id=1
//	 *
//	 * ��η��� PUT ����� DELETE ������ ? 1. ��Ҫ���� HiddenHttpMethodFilter 2. ��Ҫ���� POST ����
//	 * 3. ��Ҫ�ڷ��� POST ����ʱЯ��һ�� name="_method" ��������, ֵΪ DELETE �� PUT
//	 *
//	 * �� SpringMVC ��Ŀ�귽������εõ� id ��? ʹ�� @PathVariable ע��
//	 *
//	 */
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id) {
		System.out.println("testRest Put: " + id);
		return SUCCESS;
	}
//
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id) {
		System.out.println("testRest Delete: " + id);
		return SUCCESS;
	}
//
	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest POST");
		return SUCCESS;
	}
//
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRest(@PathVariable Integer id) {
		System.out.println("testRest GET: " + id);
		return SUCCESS;
	}
//
	/**
	 * @PathVariable ������ӳ�� URL �е�ռλ����Ŀ�귽���Ĳ�����.
	 * @param id
	 * @return
	 */
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("testPathVariable: " + id);
		return SUCCESS;
	}
//
	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath() {
		System.out.println("testAntPath");
		return SUCCESS;
	}
//
//	/**
//	 * �˽�: ����ʹ�� params �� headers �����Ӿ�ȷ��ӳ������. params �� headers ֧�ּ򵥵ı��ʽ.
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = "testParamsAndHeaders", params = { "username",
//			"age!=10" }, headers = { "Accept-Language=en-US,zh;q=0.8" })
//	public String testParamsAndHeaders() {
//		System.out.println("testParamsAndHeaders");
//		return SUCCESS;
//	}

	/**
	 * ����: ʹ�� method ������ָ������ʽ
	 */
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {
		System.out.println("postTestMethod");
		return SUCCESS;
	}

	/**
	 * 1. @RequestMapping �������η���, ������������ 2. 1). �ඨ�崦: �ṩ����������ӳ����Ϣ������� WEB Ӧ�õĸ�Ŀ¼
	 * 2). ������: �ṩ��һ����ϸ��ӳ����Ϣ�� ������ඨ�崦�� URL�����ඨ�崦δ��ע @RequestMapping���򷽷�����ǵ� URL
	 * ����� WEB Ӧ�õĸ�Ŀ¼
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}

}
