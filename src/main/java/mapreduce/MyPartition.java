package mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartition extends Partitioner<Object, IntWritable>{

	//key��value�ֱ�ָ����Mapper����������numReduceTasksָ�������õ�Reducer��������
	@Override
	public int getPartition(Object key, IntWritable value, int numPartitions) {
		final String ke = key.toString();
		if("��".equals(ke)){
			return 0 ;//% numPartitions ;//��ʱnumPartitions =2����Ϊ����Ҫ����2������
			
		}else if("Ů".equals(ke)){
			return 1 ;//% numPartitions;
		}else {
			return 2 ;//% numPartitions;
		}		
	}	
}
