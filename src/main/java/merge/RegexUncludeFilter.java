package merge;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

//PathFilter��һ���ӿڣ�����ֻ��һ������accept(Path path)
public class RegexUncludeFilter implements PathFilter{
	private final String regex ;

	public RegexUncludeFilter(String regex){
		this.regex = regex ;
	}
	
	//���� regex ��ʽ���ļ�
	public boolean accept(Path path) {
		boolean flag = path.toString().matches(regex);
		//���ϵ��Ҿͽ��ܣ������ϵľ͹��ˣ������Ƿ�flag
		return !flag;
	}
	
	
}
