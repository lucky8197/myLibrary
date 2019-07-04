package tools;
/**
 * 定义一些HttpSession范围里的一些常量
 * @author lenovo
 *
 */
public interface WebConstant {
	//HttpSession里的管理员等级的属性值
	String MGR_LEVEL = "mgr"; 
	//HttpSession里的读者等级的属性值
	String RAD_LEVEL= "rad";
	//HttpSession里的用户（管理员/读者）等级的属性名
	String LEVEL = "level";
	//HttpSession里用户的用户名
	String USER ="user";
	
}
