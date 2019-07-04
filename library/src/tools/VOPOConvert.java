package tools;

import domain.Book;
import domain.Borrow;
import domain.Person;
import vo.BookBean;
import vo.BorrowBean;
import vo.PersonBean;

/**
 * 定义VOPO相互转换的方法。
*@author luoliang		
*@version 创建时间：2019年4月12日上午11:14:54
*/
public class VOPOConvert {

	/**
	 * personVO转换为PO
	 * @param person
	 * @return
	 */
	public static Person personVOToPO(PersonBean person) {
		if(person == null) {
			return null;
		}
		return new Person("否" , person.getId() ,  person.getUser() ,
				person.getPassword() , person.getName() , person.getBirthday() ,
				person.getSex() , person.getVocation() , person.getEmail()
				, person.getTel() , person.getCreate_date() , "无");
	}
	
	/**
	 * personVO转换为PO
	 * @param person
	 * @return
	 */
	public static PersonBean personPOToVO(Person person) {
		if(person == null) {
			return null;
		}
		return new PersonBean(person.getId() ,  person.getUser() ,
				person.getPassword() , person.getName() , person.getBirthday() ,
				person.getSex() , person.getVocation() , person.getEmail()
				, person.getTel() , person.getCreate_date() , "无");
	}
	
	/**
	 * bookPO转换为VO
	 * @param book
	 * @return
	 */
	public static Book bookVOToPO(BookBean book) {
		if(book == null) {
			return null;
		}
		return new Book(book.getId(), book.getBook_name(), book.getBook_type(), 
					book.getBook_case(), book.getAuthor(), book.getBook_concern(), book.getPrice(), 
					book.getCount(), book.getPage(), book.getInTime() , book.getBorrownum());
		
	}
	
	/**
	 * bookPO转换为VO
	 * @param book
	 * @return
	 */
	public static BookBean bookPOToVO(Book book) {
		if(book == null) {
			return null;
		}
		return new BookBean(book.getId(), book.getBook_name(), book.getBook_type(), 
					book.getBook_case(), book.getAuthor(), book.getBook_concern(), book.getPrice(), 
					book.getCount(), book.getPage(), book.getInTime() , book.getBorrownum());
		
	}
	
	/**
	 * borrowVO转换为PO
	 * @param borrow
	 * @return
	 */
	public static Borrow borrowVOToPO(BorrowBean borrow) {
		return new Borrow(borrow.getId(), borrow.getBorrow_time(), borrow.getBack_time(), 
					borrow.getBackTime(), borrow.getPerson(), borrow.getBook());
		
	} 
	
	/**
	 * borrowPO转换为VO
	 * @param borrow
	 * @return
	 */
	public static BorrowBean borrowPOToVO(Borrow borrow) {
		return new BorrowBean(borrow.getId(), borrow.getBorrow_time(), borrow.getBack_time(), 
					borrow.getBackTime(), borrow.getPerson(), borrow.getBook());
		
	} 
	
}
