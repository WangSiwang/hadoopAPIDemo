package merge;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

public class RegexAcceptFilter implements PathFilter{
	private final String regex ;
	
	public RegexAcceptFilter(String regex){
		this.regex = regex ;
	}

	//只接受符合regex的文件
	public boolean accept(Path path) {
		boolean flag = path.toString().matches(regex) ;
		return flag;
	}
	
}
