package com.andy.merge;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

//PathFilter是一个接口，里面只有一个方法accept(Path path)
public class RegexUncludeFilter implements PathFilter{
	private final String regex ;

	public RegexUncludeFilter(String regex){
		this.regex = regex ;
	}
	
	//过滤 regex 格式的文件
	@Override
	public boolean accept(Path path) {
		boolean flag = path.toString().matches(regex);
		//符合得我就接受，不符合的就过滤，所以是非flag
		return !flag;
	}
	
	
}
