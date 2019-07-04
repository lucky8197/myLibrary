package tools;
/**
 * 检验敏感词汇
*@author luoliang		
*@version 创建时间：2019年4月13日上午10:03:29
*/
public class CheckSensititiveWords {

	public static char checkWords(char word) {
		switch(word) {
			case '日':
				return '日';
			case '干':
				return '干';
			case '艹':
				return '艹';
			case '肏':
				return '肏';
			case '逼':
				return '逼';
			case '屌':
				return '屌';
				
			default:	
			return 'Y';
				
		}
	
	}
}
